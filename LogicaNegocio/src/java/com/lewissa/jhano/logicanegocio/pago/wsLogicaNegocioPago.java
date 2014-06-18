/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;

import com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import javax.xml.ws.WebServiceRef;
/**
 *
 * @author Fredy  Janeta
=======
package com.lewissa.jhano.logicanegocio.pago;

import com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago_Service;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Usuario

 */

    

@WebService(serviceName = "wsLogicaNegocioPago")
public class wsLogicaNegocioPago {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosPago.wsdl")
    WsAccesoDatosPago_Service service;




   
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarDataBasePago")
    public Boolean modificarDataBasePago(@WebParam(name = "strPago") cPago strPago) {
        //TODO write your implementation code here:
        cTransaccionPago traPago = new cTransaccionPago();
        return traPago.modificaPago(strPago);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostrarDatosPagos")
    public cPago mostrarDatosPagos(@WebParam(name = "strId") String strId) {
        //TODO write your implementation code here:
        com.lewissa.jhano.logicanegocio.pago.cPago pPago = new cPago();
        try {
            StringReader sr = new StringReader(mostrarDatosPagos_1(strId));
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                pPago.setIntIdPago(wrs.getInt("Id_pago"));
                pPago.setDouMonto(wrs.getDouble("monto"));
                pPago.setStrFechaPago(wrs.getString("fecha_pago"));
                pPago.setIntFormaPago(wrs.getInt("forma_pago"));
                pPago.setStrFacturaPago(wrs.getString("factura_pago"));

            }
        } catch (Exception ex) {
        }
        return pPago;
    }

    private String mostrarDatosPagos_1(java.lang.String strIdPago) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.

        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.mostrarDatosPagos(strIdPago);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTotalPagosPendientes")
    public String getTotalPagosPendientes() {
        String strResultado=null;
        strResultado = getTotalPagosPendientes_1();
        return strResultado;
    }

    private String getTotalPagosPendientes_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.lewissa.jhano.accesodatos.pago.WsAccesoDatosPago port = service.getWsAccesoDatosPagoPort();
        return port.getTotalPagosPendientes();
    }
}
