/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.listaproductos;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosListaProductos")
public class wsAccesoDatosListaProductos {


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
     */
    @WebMethod(operationName = "ingresarListaProductos")
    public Boolean ingresarListaProductos(@WebParam(name = "strListaProductos") java.lang.String[] strListaProductos) {
        //TODO write your implementation code here:
        Boolean booResultao=false;
        cTransaccionListaProductos oTransaccionListaProductos =  new cTransaccionListaProductos();
        booResultao = oTransaccionListaProductos.ingresarListaProductos(strListaProductos);
        return booResultao;
    }
}
