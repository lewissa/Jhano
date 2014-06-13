/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioPago")
public class wsLogicaNegocioPago {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        String strResultado;
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        strResultado = port.getErrorConexion();
        return strResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cargaPago")
    public java.util.List<com.lewissa.jhano.logicanegocio.pago.cPago> cargaPago() {
        //TODO write your implementation code here:
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        List<cPago> lisPagos = new ArrayList<>();
        lisPagos = oTransaccionPago.cargarPagos();
        return lisPagos;
    }
}
