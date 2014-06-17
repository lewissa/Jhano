/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
/**
 *
 * @author Fredy  Janeta
 */
@WebService(serviceName = "wsLogicaNegocioPago")
public class wsLogicaNegocioPago {

   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPagosPendientes")
    public String getPagosPendientes() {
        //TODO write your implementation code here:
        String strListaPagosPendientes=null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        strListaPagosPendientes = oTransaccionPago.getPagosPendientes();
        return strListaPagosPendientes;
    }
}
