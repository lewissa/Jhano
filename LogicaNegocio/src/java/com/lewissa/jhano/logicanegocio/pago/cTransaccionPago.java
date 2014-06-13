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

    private static String cargarPago() {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.cargarPago();
    }
    
    public List<cPago> cargarPagos() {
        List<cPago> lisPago = new ArrayList<cPago>();
        try {
            StringReader sr = new StringReader(cargarPago());
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cPago oPago = new cPago();
                oPago.setIntIdPago(wrs.getInt("Id_pago"));
                oPago.setDouMontoReal(wrs.getDouble("monto"));
                oPago.setStrFechaPago(wrs.getString("fecha_pago"));
                oPago.setIntFormaPago(wrs.getInt("forma_pago"));
                oPago.setStrFacturaPago(wrs.getString("factura_pago"));
                
                lisPago.add(oPago);
            }
        } catch (Exception ex) {
        }
        return lisPago;
    }
}
