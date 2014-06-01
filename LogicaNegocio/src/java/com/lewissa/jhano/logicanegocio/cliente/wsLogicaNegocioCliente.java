/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.cliente;

import com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service;
import com.lewissa.jhano.logicanegocio.utilidades.cCedula;
import com.lewissa.jhano.logicanegocio.utilidades.cCorreo;
import com.lewissa.jhano.logicanegocio.utilidades.cRuc;
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
@WebService(serviceName = "wsLogicaNegocioCliente")
public class wsLogicaNegocioCliente {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosCliente.wsdl")
    private WsAccesoDatosCliente_Service service;

    /**
     *
     * @param cliCliente
     * @return
     */
    @WebMethod(operationName = "actualizaDataBaseCliente")
    public Boolean actualizaDataBaseCliente(@WebParam(name = "cliCliente") cCliente cliCliente) {
        cTransaccionCliente traTransaccion = new cTransaccionCliente();
        return traTransaccion.ingresarCliente(cliCliente);
    }

    /**
     * Web service operation
     *
     * @param cedCedula
     * @return
     */
    @WebMethod(operationName = "validaCedula")
    public Boolean validaCedula(@WebParam(name = "cedCedula") String cedCedula) {
        cCedula cedCed = new cCedula(cedCedula);
        return cedCed.validaCedula();
    }

    /**
     *
     * @param rucRu
     * @return
     */
    @WebMethod(operationName = "validaRuc")
    public Boolean validaRuc(@WebParam(name = "rucRu") String rucRu) {
        cRuc rucRuc = new cRuc(rucRu);
        return rucRuc.validaRuc();
    }

    /**
     * Web service operation
     *
     * @param corEmail
     * @return
     */
    @WebMethod(operationName = "validaEmail")
    public Boolean validaEmail(@WebParam(name = "corEmail") String corEmail) {
        cCorreo corCorreo = new cCorreo(corEmail);
        return corCorreo.validaEmail();
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getErrorConexionCliente")
    public String getErrorConexionCliente() {
        String strResultado;
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service service = new WsAccesoDatosCliente_Service();
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        strResultado = port.getErrorConexion();
        return strResultado;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenCliente")
    public java.util.List<com.lewissa.jhano.logicanegocio.cliente.cCliente> obtenCliente() {
        //TODO write your implementation code here:
        cCliente oCli = new cCliente();
        List<com.lewissa.jhano.logicanegocio.cliente.cCliente> clientes = new ArrayList<com.lewissa.jhano.logicanegocio.cliente.cCliente>();

        try {
            StringReader sr = new StringReader(obtenerCliente());
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cCliente c = new cCliente();
                c.setStrIdCliente(wrs.getString("Id_cliente"));
                c.setStrNombreFiscal(wrs.getString("Nombre_fiscal"));
                c.setStrDireccion(wrs.getString("Direccion"));
                c.setStrConvencional(wrs.getString("Convencional"));
                clientes.add(c);
            }
        } catch (Exception ex) {
        }

        return clientes;
    }

    private String obtenerCliente() {
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        return port.obtenerCliente();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarCliente")
    public Boolean eliminarCliente(@WebParam(name = "strId") String strId) {
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        return port.eliminarCliente(strId);
    }

    
}
