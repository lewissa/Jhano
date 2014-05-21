/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.producto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsAccesoDatosProducto")
public class wsAccesoDatosProducto {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarDataBaseProducto")
    public Boolean actualizarDataBaseProducto(@WebParam(name = "strPro") String[] strPro) {
        Boolean booFlag1 = false; // revisa la respuesta de la base
        Boolean booFlag2 = false; // revisa la conexion
        cTransaccionProducto traProducto= new cTransaccionProducto();
        if(!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()){
            booFlag2= false; //error en la conexion
        }else{
            booFlag2=true; // conexion correcta
            booFlag1= traProducto.ingresarProdcuto(strPro);
            if(booFlag1==null){
                booFlag1=false;
            }
        }
        booFlag1= (booFlag1.equals(true))&&(booFlag2.equals(true));
        return booFlag1;
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
