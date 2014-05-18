/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.proveedor;

import com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service;
import com.lewissa.jhano.utilidades.cCedula;
import com.lewissa.jhano.utilidades.cCorreo;
import com.lewissa.jhano.utilidades.cRuc;
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

}
