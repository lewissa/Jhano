/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.factura;

import com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura_Service;
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
        cTransaccionFactura oTansaccionFactura= new cTransaccionFactura();
        booResultado=oTansaccionFactura.ingresarFactura(oFactura);
        return booResultado;
    }



    
}
