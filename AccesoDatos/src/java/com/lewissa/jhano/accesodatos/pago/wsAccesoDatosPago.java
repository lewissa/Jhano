/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.pago;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * <<<<<<< HEAD
 * @a
 *
 * uthor Fredy Janeta =======
 * @author Usuario >>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
 */
@WebService(serviceName = "wsAccesoDatosPago")
public class wsAccesoDatosPago {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexion")
    public String getErrorConexion() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPagosPendientes")
    public String getPagosPendientes() {
        String strResultado = null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        strResultado = oTransaccionPago.getPagosPendientes();
        return strResultado;

    }

    @WebMethod(operationName = "cargarPago")
    public String cargarPago() {
        //TODO write your implementation code here:
        String strResultado = null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResultado = oTransaccionPago.cargarPagos();
        }
        return strResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarDataBasePago")
    public Boolean modificarDataBasePago(@WebParam(name = "strPago") java.lang.String[] strPago) {
        //TODO write your implementation code here:
        Boolean booFlag1 = false; // revisa la respuesta de la base
        Boolean booFlag2 = false; // revisa la conexion
        cTransaccionPago traPago = new cTransaccionPago();
        if (!cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booFlag2 = false; //error en la conexion
        } else {
            booFlag2 = true; // conexion correcta
            booFlag1 = traPago.modificarPago(strPago);
            if (booFlag1 == null) {
                booFlag1 = false;
            }
        }
        booFlag1 = (booFlag1.equals(true)) && (booFlag2.equals(true));
        return booFlag1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostrarDatosPagos")
    public String mostrarDatosPagos(@WebParam(name = "strIdPago") String strIdPago) {
        //TODO write your implementation code here:
        String pago = null;
        cTransaccionPago traPago = new cTransaccionPago();
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            pago = traPago.mostrarDatosPago(strIdPago);
        }
        return pago;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTotalPagosPendientes")
    public String getTotalPagosPendientes() {
        //TODO write your implementation code here:
        String strResultado=null;
        cTransaccionPago oTransaccionPago = new cTransaccionPago();
        strResultado = oTransaccionPago.getTotalPagosPendientes();
        return strResultado;
    }
}
