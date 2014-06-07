/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.empresa;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosEmpresa")
public class wsAccesoDatosEmpresa {

     /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarEmpresa")
    public String buscarEmpresa(@WebParam(name = "strIdEmpresa") String strIdEmpresa) {
        //TODO write your implementation code here:
        String strResultado= null;
        cTransaccionEmpresa oTransaccionEmpresa = new cTransaccionEmpresa();
        strResultado = oTransaccionEmpresa.buscarEmpresa(strIdEmpresa);
        return strResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }
}
