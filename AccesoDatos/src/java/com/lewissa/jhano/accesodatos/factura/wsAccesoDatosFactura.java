<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.factura;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosFactura")
public class wsAccesoDatosFactura {

   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarFactura")
    public Boolean ingresarFactura(@WebParam(name = "strFactura") java.lang.String strFactura[]) {
        Boolean booresulatdo=false;
        cTransaccionFactura oTransaccionFactura = new cTransaccionFactura();
        booresulatdo=oTransaccionFactura.ingresarFactura(strFactura);
        return booresulatdo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFactura")
    public String getErrorConexionFactura() {
        //TODO write your implementation code here:
        String strError;
        strError=cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
        return strError;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFacturas")
    public String getFacturas(@WebParam(name = "strParametro") String strParametro) {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionFactura oTransaccionFactura = new cTransaccionFactura();
        strResultado=oTransaccionFactura.getFacturas(strParametro);        
        return strResultado;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.factura;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "wsAccesoDatosFactura")
public class wsAccesoDatosFactura {

   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarFactura")
    public Boolean ingresarFactura(@WebParam(name = "strFactura") java.lang.String strFactura[]) {
        Boolean booresulatdo=false;
        cTransaccionFactura oTransaccionFactura = new cTransaccionFactura();
        booresulatdo=oTransaccionFactura.ingresarFactura(strFactura);
        return booresulatdo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFactura")
    public String getErrorConexionFactura() {
        //TODO write your implementation code here:
        String strError;
        strError=cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
        return strError;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cargarFacturas")
    public String cargarFacturas() {
        //TODO write your implementation code here:
        String strFact = null;
        cTransaccionFactura traFactura = new cTransaccionFactura();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()){
            strFact = traFactura.cargarFactura();
        }
        return strFact;        
    }
}
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
