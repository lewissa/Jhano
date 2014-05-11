/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.ws;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.sun.tools.ws.wsdl.document.jaxws.Exception;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsAccesoDatos")
public class wsAccesoDatos {

    /**
     * Actualizar Base de Datos Servicio Web
     *
     * @author Wilmer Moina, Esteban Borja
     * @version 1.0 06-05-2014
     *
     * Servicio web que llama a la conexion de base de datos y resliza una
     * actualizacion en la base y retorna un bolleano.
     *
     * @param strSql, String que contiene la sentencia SQL a ejecutar.
     * @return flag1, Booleano que retorna confirmacion de ingreso de los datos.
     */
    @WebMethod(operationName = "actualizarDataBase")
    public Boolean actualizarDataBase(@WebParam(name = "strSql") String strSql) {
        Boolean booflag1 = false; // revisa la respuesta de la base
        Boolean booflag2 = false; // revisa la conexion
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booflag2 = false; //error en la conexion
        } else {
            booflag2 = true; // conexion correcta
            booflag1 = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSql);
            if (booflag1 == null) {
                booflag1 = false;
            }
        }
        booflag1 = (booflag1.equals(true)) && (booflag2.equals(true));
        return booflag1;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getErrorConexion")
    public java.lang.Exception getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }
}
