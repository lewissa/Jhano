/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.empresa;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsLogicaNegocioEmpresa")
public class wsLogicaNegocioEmpresa {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarEmpresa")
    public java.util.List<cEmpresa> buscarEmpresa(@WebParam(name = "strParametro") String strParametro) {
        List<cEmpresa> lisEmpresas = new ArrayList<cEmpresa>();
        cTransaccionEmpresa oTransaccionEmpresa = new cTransaccionEmpresa();
        lisEmpresas= oTransaccionEmpresa.buscarEmpresa(strParametro);
        return lisEmpresas;
    }
}
