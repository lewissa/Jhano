/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.proveedor;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosProveedor")
public class wsAccesoDatosProveedor {

     /**
     * Web service operation
     * @return 
     */
    
    
    
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    } 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarProveedor")
    public Boolean insertarProveedor(@WebParam(name = "strProveedor") java.lang.String[] strProveedor) {
        //TODO write your implementation code here:
        Boolean booResultado=false;
        cTransaccionProveedor oTransaccion = new cTransaccionProveedor();
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) 
        {
            booResultado=oTransaccion.ingresarProveedor(strProveedor);
        }
        return booResultado;
    }
}
