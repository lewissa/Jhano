/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.pago;

import com.lewissa.jhano.logicanegocio.factura.cFactura;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class cTransaccionPago {

    public String getPagosPendientes() {
        String strListaPagosPendientes = null;
        strListaPagosPendientes = getPagosPendientes_1();
        return strListaPagosPendientes;
    }

    private static String getPagosPendientes_1() {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.getPagosPendientes();
    }

    private static String cargarPago(String strId) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.cargarPago(strId);
    }

    public List<cPago> cargarPagos(String strId) {
        List<cPago> lisPago = new ArrayList<cPago>();
        try {
            StringReader sr = new StringReader(cargarPago(strId));
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cPago oPago = new cPago();
                oPago.setIntIdPago(wrs.getInt("Id_pago"));
                oPago.setDouMonto(wrs.getDouble("monto"));
                if (wrs.getString("fecha_pago") == null) {
                    oPago.setStrFechaPago("No se ha asignado una fecha");
                } else {
                    oPago.setStrFechaPago(wrs.getString("fecha_pago"));
                }
                oPago.setIntFormaPago(wrs.getInt("forma_pago"));
                oPago.setStrFacturaPago(wrs.getString("factura_pago"));
                oPago.setBooEstado(wrs.getBoolean("estado"));
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
        strPago.add(1, datPagos.getDouMonto().toString());
        strPago.add(2, datPagos.getStrFechaPago());
        strPago.add(3, datPagos.getIntFormaPago().toString());
        strPago.add(4, datPagos.getStrFacturaPago());
        strPago.add(5, datPagos.isBooEstado().toString());

        booFlag = port.modificarDataBasePago(strPago);
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    public Boolean ingresaPago(cPago datPagos) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        Boolean booFlag = false;

        List<String> strPago = new ArrayList<String>();
        strPago.add(0, datPagos.getDouMonto().toString());
        strPago.add(1, datPagos.getStrFechaPago());
        strPago.add(2, datPagos.getIntFormaPago().toString());
        strPago.add(3, datPagos.getStrFacturaPago());
        strPago.add(4, datPagos.isBooEstado().toString());

        booFlag = port.ingresaDataBasePago(strPago);
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

    public Boolean eliminarPago(String strCodigoPago, Integer intTipoEliminacion) {
        Boolean booResulado = false;
        if (strCodigoPago != null) {
            if (intTipoEliminacion == 1) //Realiza eliminacion FISICA
            {
                booResulado = eliminarFisicoPago(strCodigoPago);
            } else {
                if (intTipoEliminacion == 0) //Realiza eliminacion LOGICA 
                {
                    booResulado = eliminarLogicoPago(strCodigoPago);
                }
            }
        }
        return booResulado;
    }

    private static Boolean eliminarFisicoPago(java.lang.String strCodigoPago) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.eliminarFisicoPago(strCodigoPago);
    }

    private static Boolean eliminarLogicoPago(java.lang.String strCodigoPago) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.eliminarLogicoPago(strCodigoPago);
    }

    public String getPagoFactura(String strId) {
        String strValor = null;
        try {
            StringReader sr = new StringReader(getPagoFactura_1(strId));
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            cFactura facFac = new cFactura();
            facFac.setDouTotalFactura(wrs.getDouble("Valor_total"));
            strValor=facFac.getDouTotalFactura().toString();
        } catch (SQLException ex) {
        }
        return strValor;
    }

    private static String getPagoFactura_1(java.lang.String strId) {
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service service = new com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service();
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.getPagoFactura(strId);
    }

}
