/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD

package com.lewissa.jhano.logicanegocio.pago;
=======
package com.lewissa.jhano.logicanegocio.pago;

>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
/**
 *
 * @author Usuario
 */
public class cTransaccionPago {
<<<<<<< HEAD
    
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
    
    
=======

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

    public Boolean modificaPago(cPago datPagos) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        Boolean booFlag = false;

        List<String> strPago = new ArrayList<String>();
        strPago.add(0, datPagos.getIntIdPago().toString());
        strPago.add(1, datPagos.getDouMontoReal().toString());
        strPago.add(2, datPagos.getStrFechaPago());
        strPago.add(3, datPagos.getIntFormaPago().toString());
        strPago.add(4, datPagos.getStrFacturaPago());

        booFlag = port.modificarDataBasePago(strPago);
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    private static String mostrarDatosPagos_1(java.lang.String strIdPago) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.mostrarDatosPagos(strIdPago);
    }
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
}
