/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.cliente.cTransaccionCliente;
import com.lewissa.jhano.accesodatos.familiaproducto.cTransaccionFamiliaProducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosFamiliaProducto")
public class wsAccesoDatosFamiliaProducto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarFamiliaProducto")
    public Boolean ingresarFamiliaProducto(@WebParam(name = "srtFamiliaProducto") String srtFamiliaProducto[]) {
        cTransaccionFamiliaProducto oTransaccionF = new cTransaccionFamiliaProducto();
        Boolean booflag1 = false; // revisa la respuesta de la base
        Boolean booflag2 = false; // revisa la conexion
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booflag2 = false; //error en la conexion
        } else {
            booflag2 = true; // conexion correcta
            booflag1 = oTransaccionF.ingresarFamiliaProducto(srtFamiliaProducto);
            if (booflag1 == null) {
                booflag1 = false;
            }
        }
        booflag1 = (booflag1.equals(true)) && (booflag2.equals(true));
        return booflag1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFamiliaProducto")
    public String getErrorConexionFamiliaProducto() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }
}
