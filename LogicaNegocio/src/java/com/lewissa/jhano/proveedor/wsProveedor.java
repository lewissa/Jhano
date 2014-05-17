/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.proveedor;

import com.lewissa.jhano.utilidades.cCedula;
import com.lewissa.jhano.utilidades.cCorreo;
import com.lewissa.jhano.utilidades.cRuc;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Miguel Mejía y Juan Moyano
 */
@WebService(serviceName = "wsProveedor")
public class wsProveedor {

    /**
     * Web service operation
     *
     * @param prove
     * @return
     */
    @WebMethod(operationName = "insertaProveedor")
    public Boolean insertaProveedor(@WebParam(name = "prove") cProveedor prove) {
        Boolean booRes = false;
        cCedula cedVal = new cCedula(prove.getId());
        cRuc rucVal = new cRuc(prove.getId());
        cCorreo corVal = new cCorreo(prove.getCorreo());
        if ((cedVal.validaCedula()) || (rucVal.validaRuc())) {
            if (corVal.validaEmail()) {
                cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
                booRes = oTransaccionProveedor.ingresarProveedor(prove);
            }

        }
        return booRes;
    }
}
