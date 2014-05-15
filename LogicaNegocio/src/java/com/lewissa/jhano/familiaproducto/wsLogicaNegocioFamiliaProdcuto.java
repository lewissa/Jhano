/*
 * Esta clase define las opreciones del servicio web swTransaccionFamiliaProducto
 */
package com.lewissa.jhano.familiaproducto;

import com.lewissa.jhano.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.familiaproducto.cTransaccionFamiliaProducto;
import com.lewissa.jhano.utilidades.cCodigoFamiliaProducto;
import com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Fredy Janeta
 * @version 09-05-2014
 */
@WebService(serviceName = "wsLogicaNegocioFamiliaProdcuto")
public class wsLogicaNegocioFamiliaProdcuto {

    private WsAccesoDatos_Service service;

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
    public com.lewissa.jhano.wscAccesoDatos.Exception getErrorConexionFamiliaProducto() {
        com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos port = service.getWsAccesoDatosPort();
        return port.getErrorConexion();
    }
}
