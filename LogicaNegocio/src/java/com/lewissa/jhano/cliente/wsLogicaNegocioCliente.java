/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.cliente;

import com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente;
import com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service;
import com.lewissa.jhano.utilidades.cCedula;
import com.lewissa.jhano.utilidades.cCorreo;
import com.lewissa.jhano.utilidades.cRuc;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsLogicaNegocioCliente")
public class wsLogicaNegocioCliente {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatos.wsdl")
   /**
    * 
    * @param cliCliente
    * @return 
    */
    @WebMethod(operationName = "actualizaDataBaseCliente")
    public Boolean actualizaDataBaseCliente(@WebParam(name = "cliCliente") cCliente cliCliente) {
        cTransaccionCliente traTransaccion= new cTransaccionCliente();
        return traTransaccion.ingresarCliente(cliCliente);
    }

    /**
     * Web service operation
     * @param cedCedula
     * @return 
     */
    @WebMethod(operationName = "validaCedula")
    public Boolean validaCedula(@WebParam(name = "cedCedula") String cedCedula) {
        cCedula cedCed=new cCedula(cedCedula);
        return cedCed.validaCedula();
    }
    /**
     * 
     * @param rucRu
     * @return 
     */
    @WebMethod(operationName = "validaRuc")
    public Boolean validaRuc(@WebParam(name = "rucRu") String rucRu) {
        cRuc rucRuc=new cRuc(rucRu);
        return rucRuc.validaRuc();
    }
    /**
     * Web service operation
     * @param corEmail
     * @return 
     */
    @WebMethod(operationName = "validaEmail")
    public Boolean validaEmail(@WebParam(name = "corEmail") String corEmail) {
        cCorreo  corCorreo=new cCorreo(corEmail);
        return corCorreo.validaEmail();
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getErrorConexionCliente")
    public String getErrorConexionCliente() {
        String strResultado;
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service service = new WsAccesoDatosCliente_Service();
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        strResultado=port.getErrorConexion();
        return strResultado;
        
    }
}
