/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.proveedor;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosProveedor")
public class wsAccesoDatosProveedor {

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarProveedor")
    public Boolean insertarProveedor(@WebParam(name = "strProveedor") java.lang.String[] strProveedor) {
        cTransaccionProveedor oTransaccion = new cTransaccionProveedor();
        Boolean booflag1 = false; // revisa la respuesta de la base
        Boolean booflag2 = false; // revisa la conexion
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booflag2 = false; //error en la conexion
        } else {
            booflag2 = true; // conexion correcta
            booflag1 = oTransaccion.ingresarProveedor(strProveedor);
            if (booflag1 == null) {
                booflag1 = false;
            }
        }
        booflag1 = (booflag1.equals(true)) && (booflag2.equals(true));
        return booflag1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cargaProveedor")
    public String cargaProveedor() {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResultado = oTransaccionProveedor.cargarProveedor();
        }

        return strResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarFisicoProveedor")
    public Boolean eliminarFisicoProveedor(@WebParam(name = "strCodigoProveedor") String strCodigoProveedor) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = oTransaccionProveedor.eliminarFisicoProveedor(strCodigoProveedor);
        }
        return booResultado;
    }
    
    @WebMethod(operationName = "eliminarLogicoProveedor")
    public Boolean eliminarLogicoProveedor(@WebParam(name = "strCodigoProveedor") String strCodigoProveedor) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = oTransaccionProveedor.eliminarLogicoProveedor(strCodigoProveedor);
        }
        return booResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarProveedor")
    public Boolean modificarProveedor(@WebParam(name = "strProveedor") java.lang.String[] strProveedor) {
        Boolean booResultado= false;
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            booResultado=oTransaccionProveedor.modificarProveedor(strProveedor);
        }
        
        return booResultado;
    }

}
