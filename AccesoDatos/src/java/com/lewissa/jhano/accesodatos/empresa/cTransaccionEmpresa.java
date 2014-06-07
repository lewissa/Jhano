/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.empresa;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 * Este metodo permite obtener los datos de la empresa
 *
 * @author Fredy Janeta
 */
public class cTransaccionEmpresa {

    public String buscarEmpresa(String strRuc) {
        String strQuery;
        String strResulatdo = null;
        strQuery = "SELECT * FROM empresa WHERE \"RUC\"='" + strRuc + "';";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResulatdo = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }
        return strResulatdo;
    }

}
