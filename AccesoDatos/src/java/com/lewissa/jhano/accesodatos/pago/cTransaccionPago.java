/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.pago;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Fredy Janeta
 */
public class cTransaccionPago {
    
    public String getPagosPendientes()
    {
        String strResultado=null;
        String strQuery="SELECT \"Id_cliente\",\"Nombre_fiscal\",\"Convencional\",\"Celular\",\"Correo\",\"Direccion\", monto,fecha_pago "+
                "FROM (cliente INNER JOIN factura ON cliente.\"Id_cliente\" like "+
                " factura.\"cliente_factu\" )INNER JOIN pago ON factura.\"Id_factu\" like pago.factura_pago WHERE estado=FALSE "+
                "AND fecha_pago < current_date + 1";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            strResultado=cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }
        
       return strResultado;
    }
    
}
