/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class cTransaccionPago {
    
    public String getPagosPendientes()
    {
        String strListaPagosPendientes= null;
        strListaPagosPendientes = getPagosPendientes_1();
        return strListaPagosPendientes;
    }

    private static String getPagosPendientes_1() {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.getPagosPendientes();
    }
    
    
}
