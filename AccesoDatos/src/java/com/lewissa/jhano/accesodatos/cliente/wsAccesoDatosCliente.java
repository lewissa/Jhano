/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.cliente;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.cliente.cTransaccionCliente;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsAccesoDatosCliente")
public class wsAccesoDatosCliente {

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
    @WebMethod(operationName = "actualizarDataBaseCliente")
    public Boolean actualizarDataBaseCliente(@WebParam(name = "strCli") String[] strCli) {
        Boolean booFlag1 = false; // revisa la respuesta de la base
        Boolean booFlag2 = false; // revisa la conexion
        cTransaccionCliente traCliente = new cTransaccionCliente();
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booFlag2 = false; //error en la conexion
        } else {
            booFlag2 = true; // conexion correcta
            booFlag1 = traCliente.ingresarCliente(strCli);
            if (booFlag1 == null) {
                booFlag1 = false;
            }
        }
        booFlag1 = (booFlag1.equals(true)) && (booFlag2.equals(true));
        return booFlag1;
    }

    /**
     * Web service operation
     *
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
    @WebMethod(operationName = "obtenerCliente")
    public String obtenerCliente() {
        //TODO write your implementation code here:
        String cli = null;
        cTransaccionCliente traCliente = new cTransaccionCliente();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()){
            cli = traCliente.cargarCliente();
        }
        return cli;
    }
}
