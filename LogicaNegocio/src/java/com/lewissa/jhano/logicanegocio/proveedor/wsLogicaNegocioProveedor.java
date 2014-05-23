/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.proveedor;

import com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service;
import com.lewissa.jhano.logicanegocio.utilidades.cCedula;
import com.lewissa.jhano.logicanegocio.utilidades.cCorreo;
import com.lewissa.jhano.logicanegocio.utilidades.cRuc;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioProveedor")
public class wsLogicaNegocioProveedor {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizaDataBaseProveedor")
    public Boolean actualizaDataBaseProveedor(@WebParam(name = "proProveedor") cProveedor proProveedor) {
        //TODO write your implementation code here:
        cTransaccionProveedor traProveedor = new cTransaccionProveedor();
        return traProveedor.ingresarProveedor(proProveedor);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validaCedula")
    public Boolean validaCedula(@WebParam(name = "cedCedula") String cedCedula) {
        //TODO write your implementation code here:
        cCedula oCedula = new cCedula(cedCedula);
        return oCedula.validaCedula();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validaRuc")
    public Boolean validaRuc(@WebParam(name = "rucRuc") String rucRuc) {
        //TODO write your implementation code here:
        cRuc oRuc = new cRuc(rucRuc);
        return oRuc.validaRuc();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validaCorreo")
    public Boolean validaCorreo(@WebParam(name = "corCorreo") String corCorreo) {
        //TODO write your implementation code here:
        cCorreo oCorreo = new cCorreo(corCorreo);
        return oCorreo.validaEmail();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionProveedor")
    public String getErrorConexionProveedor() {
        //TODO write your implementation code here:
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        String strResul;
        strResul = port.getErrorConexion();
        return strResul;
    }

    /**
     * Web service operation
     *
     * @author Fredy Janeta Pemite poner en servio las lista de los proveedores
     */
    @WebMethod(operationName = "cargaProveedor")
    public List<cProveedor> cargaProveedor() {
        cTransaccionProveedor oTransaccionesProveedor = new cTransaccionProveedor();
        List<cProveedor> lisProveedores = new ArrayList<>();
        lisProveedores = oTransaccionesProveedor.cargarProveedor();
        return lisProveedores;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarProveedor")
    public Boolean eliminarProveedor(@WebParam(name = "oProveedor") cProveedor oProveedor) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        if (oProveedor != null) {
            booResultado = oTransaccionProveedor.eliminarProveedor(oProveedor);
        }
        return booResultado;
    }
}
