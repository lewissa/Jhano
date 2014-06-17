<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
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
        Boolean booresulatdo = false;
        booresulatdo = oTransaccionF.ingresarFamiliaProducto(srtFamiliaProducto);
        return booresulatdo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getErrorConexionFamiliaProducto")
    public String getErrorConexionFamiliaProducto() {
        //TODO write your implementation code here:
        return cAccesoDatos.getInstanciaAccesoDatos().getExcErrorAcessoDatos();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFamiliaProductos")
    public String getFamiliaProductos() {
        //TODO write your implementation code here:
        String strResultado=null;
        cTransaccionFamiliaProducto oTransaccionFamiliaProducto = new cTransaccionFamiliaProducto();
        strResultado = oTransaccionFamiliaProducto.getFamilaProducto();
        return strResultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumerodeProductosPorFamilia")
    public String getNumerodeProductosPorFamilia(@WebParam(name = "strIdFamilia") String strIdFamilia) {
        //TODO write your implementation code here:
        String strResultrado = null;
        cTransaccionFamiliaProducto oTransaccionFamiliaProducto = new cTransaccionFamiliaProducto();
        strResultrado = oTransaccionFamiliaProducto.getNumeroDeProductosPorFamilia(strIdFamilia);
        return strResultrado;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
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
        Boolean booresulatdo = false;
        booresulatdo = oTransaccionF.ingresarFamiliaProducto(srtFamiliaProducto);
        return booresulatdo;
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
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
