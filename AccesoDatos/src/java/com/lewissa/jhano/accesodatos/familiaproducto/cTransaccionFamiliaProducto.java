/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Usuario
 */
public class cTransaccionFamiliaProducto {

    public Boolean ingresarFamiliaProducto(String strFamiliaProducto[]) {
        String strSqlIngresoFamilia;
        Boolean booResultado = false;
        strSqlIngresoFamilia = "INSERT INTO familia VALUES ('" + strFamiliaProducto[0] + "','" + strFamiliaProducto[1] + "')";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngresoFamilia);
        }

        return booResultado;
    }
}
