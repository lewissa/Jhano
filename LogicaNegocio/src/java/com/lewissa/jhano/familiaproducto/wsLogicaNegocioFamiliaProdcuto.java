/*
 * Esta clase define las opreciones del servicio web swTransaccionFamiliaProducto
 */
package com.lewissa.jhano.familiaproducto;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service;
import com.lewissa.jhano.familiaproducto.cCodigoFamiliaProducto;

/**
 *
 * @author Fredy Janeta
 * @version 09-05-2014
 */
@WebService(serviceName = "wsLogicaNegocioFamiliaProdcuto")
public class wsLogicaNegocioFamiliaProdcuto {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosFamiliaProducto.wsdl")
    private WsAccesoDatosFamiliaProducto_Service service;

    /**
     * Este metodo permite invocar la metodo de insercion del objeto
     * oFamiliaPrdocuto
     *
     * @param oFamiliaProducto, cFamiliaProducto contiene al objeto a ingresar
     * @return booResulta, Booolean que contiena la confirmacion de la
     * aplicaciono del metodo
     */
    @WebMethod(operationName = "insertarFamiliaProducto")
    public Boolean insertarFamiliaProducto(@WebParam(name = "oFamiliaProducto") cFamiliaProducto oFamiliaProducto) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionFamiliaProducto oTransaccionesFamilia = new cTransaccionFamiliaProducto();
        booResultado = oTransaccionesFamilia.insertarFamiliaProducto(oFamiliaProducto);
        return booResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarCodigo")
    public Boolean validarCodigo(@WebParam(name = "oCodigo") cCodigoFamiliaProducto oCodigo) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        booResultado = oCodigo.validarCodigo();
        return booResultado;
    }

    @WebMethod(operationName = "getErrorConexionFamiliaProducto")
    public String getErrorConexionFamiliaProducto() {
        String strError;
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto port = service.getWsAccesoDatosFamiliaProductoPort();
        strError=port.getErrorConexionFamiliaProducto();
        return strError;
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        //com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto port = service_1.getWsAccesoDatosFamiliaProductoPort();
        //return port.getErrorConexionFamiliaProducto();
    }

}
