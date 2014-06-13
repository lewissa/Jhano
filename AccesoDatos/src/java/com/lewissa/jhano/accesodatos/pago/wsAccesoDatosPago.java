/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.pago;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosPago")
public class wsAccesoDatosPago {

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
    @WebMethod(operationName = "cargarPago")
    public String cargarPago() {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResultado = oTransaccionPago.cargarPagos();
        }
        return strResultado;
    }
    
    
}
