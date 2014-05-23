/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.familiaproducto;

import com.lewissa.jhano.logicanegocio.utilidades.cCodigoFamiliaProducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioFamiliaProducto")
public class wsLogicaNegocioFamiliaProducto {

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

}
