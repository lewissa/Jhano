/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.familiaproducto;

import com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service;
import com.lewissa.jhano.logicanegocio.utilidades.cCodigoFamiliaProducto;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioFamiliaProducto")
public class wsLogicaNegocioFamiliaProducto {
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
        cTransaccionFamiliaProducto oTransaccionesFamiliaPrducto = new cTransaccionFamiliaProducto();
        strError = oTransaccionesFamiliaPrducto.getErrorConexionFamiliaProducto();
        return strError;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFamiliaProductos")
    public List<cFamiliaProducto> getFamiliaProductos() {
        //TODO write your implementation code here:
        List<cFamiliaProducto> lisFamiliaProductos= new ArrayList<cFamiliaProducto>();
        cTransaccionFamiliaProducto oTransaccionFamiliaProducto = new cTransaccionFamiliaProducto();
        lisFamiliaProductos = oTransaccionFamiliaProducto.getFamiliaProducto();
        return lisFamiliaProductos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumeroDeProductosPorFamilia")
    public String getNumeroDeProductosPorFamilia(@WebParam(name = "strIdFamilia") String strIdFamilia) {
        String strResultado = null;
        strResultado = getNumerodeProductosPorFamilia(strIdFamilia);
        return strResultado;
    }

    private String getNumerodeProductosPorFamilia(String strIdFamilia) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto port = service.getWsAccesoDatosFamiliaProductoPort();
        return port.getNumerodeProductosPorFamilia(strIdFamilia);
    }
    
    

}