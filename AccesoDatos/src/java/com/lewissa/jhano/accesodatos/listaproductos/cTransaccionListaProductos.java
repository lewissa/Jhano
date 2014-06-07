/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.listaproductos;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Usuario
 */
public class cTransaccionListaProductos {

    public Boolean ingresarListaProductos(String[] strListaProductos) {
        Boolean booResultado = false;
        String strQuery;
        strQuery = "INSERT INTO lista_productos VALUES ('" + strListaProductos[0] 
                + "',"+strListaProductos[1]+",'"+strListaProductos[2]+"');";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            booResultado=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }
     
        return booResultado;
    }

}
