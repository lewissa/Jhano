/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.producto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.familiaproducto.cTransaccionFamiliaProducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsAccesoDatosProducto")
public class wsAccesoDatosProducto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarDataBaseProducto")
    public Boolean actualizarDataBaseProducto(@WebParam(name = "strPro") String[] strPro) {
        Boolean booFlag1 = false; // revisa la respuesta de la base
        Boolean booFlag2 = false; // revisa la conexion
        cTransaccionProducto traProducto = new cTransaccionProducto();
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booFlag2 = false; //error en la conexion
        } else {
            booFlag2 = true; // conexion correcta
            booFlag1 = traProducto.ingresarProdcuto(strPro);
            if (booFlag1 == null) {
                booFlag1 = false;
            }
        }
        booFlag1 = (booFlag1.equals(true)) && (booFlag2.equals(true));
        return booFlag1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getNombreProveedor")
    public String getNombreProveedor() {
        cTransaccionProducto traProducto = new cTransaccionProducto();
        String strProveedor = null;
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strProveedor = traProducto.getNombreProducto();
        } else {
            strProveedor = "err0r";
        }
        return strProveedor;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDescripcionFamilaProducto")
    public String getDescripcionFamilaProducto() {
        cTransaccionFamiliaProducto traFamilia = new cTransaccionFamiliaProducto();
        String strFamilia = null;
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strFamilia = traFamilia.getDescripcionFamilaProducto();
        } else {
            strFamilia = "err0r";
        }
        return strFamilia;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarProducto")
    public String buscarProducto(@WebParam(name = "strParametro") String strParametro) {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        strResultado = oTransaccionProducto.buscarProducto(strParametro);
        return strResultado;

    }

    @WebMethod(operationName = "cargaProducto")
    public String cargaProducto() {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResultado = oTransaccionProducto.cargarProducto();
        }

        return strResultado;
    }

    @WebMethod(operationName = "eliminarFisicoProducto")
    public Boolean eliminarFisicoProducto(@WebParam(name = "strCodigoProducto") String strCodigoProducto) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = oTransaccionProducto.eliminarFisicoProducto(strCodigoProducto);
        }
        return booResultado;
    }

    @WebMethod(operationName = "eliminarLogicoProducto")
    public Boolean eliminarLogicoProducto(@WebParam(name = "strCodigoProducto") String strCodigoProducto) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = oTransaccionProducto.eliminarLogicoProducto(strCodigoProducto);
        }
        return booResultado;
    }

    @WebMethod(operationName = "modificarDataBaseProducto")
    public Boolean modificaDataBaseProducto(@WebParam(name = "strPro") String[] strPro) {
        Boolean booFlag1 = false; // revisa la respuesta de la base
        Boolean booFlag2 = false; // revisa la conexion
        cTransaccionProducto traProducto = new cTransaccionProducto();
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booFlag2 = false; //error en la conexion
        } else {
            booFlag2 = true; // conexion correcta
            booFlag1 = traProducto.modificarProdcuto(strPro);
            if (booFlag1 == null) {
                booFlag1 = false;
            }
        }
        booFlag1 = (booFlag1.equals(true)) && (booFlag2.equals(true));
        return booFlag1;
    }

    @WebMethod(operationName = "consultarProducto")
    public String consultarProducto(String id) {
        //TODO write your implementation code here:
        String pro = null;
        cTransaccionProducto traProducto = new cTransaccionProducto();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            pro = traProducto.consultarProducto(id);
        }
        return pro;
    }
}
