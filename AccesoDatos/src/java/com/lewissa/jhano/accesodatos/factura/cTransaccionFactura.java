/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.factura;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *Esta clase permite realizar las transacionnes contra la base de datos sobre la tabla de facturas
 * @author Fredy Janeta, Juan Moyano
 * @version 1.0 28-05-2014
 */
public class cTransaccionFactura {
    /**
     * Estemetod permite registrar/ingresar una factura  
     * @param strFactura, con tiene los parametros a ser ingrsado en los capos de la tabla factura
     * @return Boolean, booResultado contiene el resultado de la aplicacion del metodo
     */
    public Boolean ingresarFactura(String strFactura[])
    {
        Boolean booResultado=false;
        String strQuery;
        strQuery="INSERT INTO factura(\"Id_factu\", \"Fecha\", cliente_factu, \"Valor_total\", \"Estado\", datos_empresa_factu) VALUES ('"+strFactura[0]
                +"','"+strFactura[1]+"', '"+strFactura[2]+"',"+strFactura[3]
                +", '"+strFactura[4]+"','"+strFactura[5]+"');";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            booResultado=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }
        return booResultado;
    }
    
    
    
}
