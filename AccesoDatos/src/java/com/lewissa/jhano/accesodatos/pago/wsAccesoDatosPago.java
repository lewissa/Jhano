/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.pago;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fredy Janeta
 */
@WebService(serviceName = "wsAccesoDatosPago")
public class wsAccesoDatosPago {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPagosPendientes")
    public String getPagosPendientes() {
        String strResultado=null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        strResultado=oTransaccionPago.getPagosPendientes();
        return strResultado;
        
    }
}
