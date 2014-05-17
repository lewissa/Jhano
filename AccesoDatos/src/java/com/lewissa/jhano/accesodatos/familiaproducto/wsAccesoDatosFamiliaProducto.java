/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.familiaproducto.cTransaccionFamiliaProducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosFamiliaProducto")
public class wsAccesoDatosFamiliaProducto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarFamiliaProducto")
    public Boolean ingresarFamiliaProducto(@WebParam(name = "srtFamiliaProducto") String srtFamiliaProducto[]) {
        Boolean booResultado = false;
        cTransaccionFamiliaProducto oTransaccionF = new cTransaccionFamiliaProducto();
        booResultado = oTransaccionF.ingresarFamiliaProducto(srtFamiliaProducto);
        return booResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFamiliaProducto")
    public String getErrorConexionFamiliaProducto() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }
}
