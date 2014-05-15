/*
 * Esta clase define las opreciones del servicio web swTransaccionFamiliaProducto
 */
package com.lewissa.jhano.familiaproducto;

import com.lewissa.jhano.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.familiaproducto.cTransaccionFamiliaProducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fredy Janeta
 * @version 09-05-2014
 */
@WebService(serviceName = "wsLogicaNegocioFamiliaProdcuto")
public class wsLogicaNegocioFamiliaProdcuto {

    
    /**
     * Este metodo permite invocar la metodo de insercion del objeto oFamiliaPrdocuto
     * @param oFamiliaProducto, cFamiliaProducto contiene al objeto a ingresar
     * @return booResulta, Booolean que contiena la confirmacion de la aplicaciono 
     * del metodo 
     */
    @WebMethod(operationName = "insertarFamiliaProducto")
    public Boolean insertarFamiliaProducto(@WebParam(name = "oFamiliaProducto") 
            cFamiliaProducto oFamiliaProducto) {
        //TODO write your implementation code here:
        Boolean booResultado=false;
        cTransaccionFamiliaProducto oTransaccionesFamilia = new cTransaccionFamiliaProducto();
        booResultado=oTransaccionesFamilia.insertarFamiliaProducto(oFamiliaProducto);
        return booResultado;
    }
}
