/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.factura;

import com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura_Service;
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
@WebService(serviceName = "wsLogicaNegocioFactura")
public class wsLogicaNegocioFactura {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosFactura.wsdl")
    private WsAccesoDatosFactura_Service service;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFactura")
    public String getErrorConexionFactura() {
        com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura port = service.getWsAccesoDatosFacturaPort();
        return port.getErrorConexionFactura();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarFactura")
    public Boolean ingresarFactura(@WebParam(name = "oFactura") cFactura oFactura) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionFactura oTansaccionFactura = new cTransaccionFactura();
        booResultado = oTansaccionFactura.ingresarFactura(oFactura);
        return booResultado;
    }

    private String cargarFacturas_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura port = service.getWsAccesoDatosFacturaPort();
        return port.cargarFacturas();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerFacturas")
    public java.util.List<com.lewissa.jhano.logicanegocio.factura.cFactura> obtenerFacturas() {
        //TODO write your implementation code here:
        cFactura oFac = new cFactura();
        List<com.lewissa.jhano.logicanegocio.factura.cFactura> factura = new ArrayList<>();
        try {
            StringReader sr = new StringReader(cargarFacturas_1());
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cFactura oFact = new cFactura();
                oFact.setStrIdFactura(wrs.getString("Id_factu"));
                oFact.setStrFechaFactura(wrs.getString("Fecha"));
                oFact.setStrClienteFactura(wrs.getString("cliente_factu"));
                oFact.setDouTotalFactura(wrs.getDouble("Valor_total"));

                factura.add(oFact);
            }
        } catch (Exception ex) {
        }
        return factura;
    }
}
