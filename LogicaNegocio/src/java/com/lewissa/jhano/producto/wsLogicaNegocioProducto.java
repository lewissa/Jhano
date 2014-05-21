/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.producto;

import com.lewissa.jhano.utilidades.cRuc;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsLogicaNegocioProducto")
public class wsLogicaNegocioProducto {
    
    @WebMethod(operationName = "actualizaDataBaseProducto")
    public Boolean actualizaDataBaseProducto(@WebParam(name = "proProducto") cProducto proProducto) {
        cTransaccionProducto traTransaccion= new cTransaccionProducto();
        return traTransaccion.ingresarProducto(proProducto);
    }
    
    @WebMethod(operationName = "getErrorConexionProducto")
    public String getErrorConexionProducto() {
        String strResultado;
         com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        strResultado = port.getErrorConexion();
        return strResultado;
    }

    @WebMethod(operationName = "validaRuc")
    public Boolean validaRuc(@WebParam(name = "rucRu") String rucRu) {
        cRuc rucRuc = new cRuc(rucRu);
        return rucRuc.validaRuc();
    }
}
