/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.listaproductos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioListaProductos")
public class wsLogicaNegocioListaProductos {



    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarListaProductos")
    public Boolean insertarListaProductos(@WebParam(name = "oListaProductos") cListaProductos oListaProductos) {
        //TODO write your implementation code here:
        cTransaccionListaProdcutos oTransaccionListaProdcutos = new cTransaccionListaProdcutos();
        Boolean booResultado = false;
        booResultado = oTransaccionListaProdcutos.ingresarListaProductos(oListaProductos);
        return booResultado;
    }
}
