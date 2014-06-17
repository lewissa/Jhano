/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class cNumeroCelular {
    private String strNumeroCelular;

    public String getStrNumeroCelular() {
        return strNumeroCelular;
    }

    public void setStrNumeroCelular(String strNumeroCelular) {
        this.strNumeroCelular = strNumeroCelular;
    }
    
    public Boolean validarNumeroCelular()
    {
        Boolean booResultado=false;
        String strPatronNumCelular = "^[0-9]{10}";
        Pattern patronNumCelular = Pattern.compile(strPatronNumCelular);
        Matcher matcherNumCelular = patronNumCelular.matcher(strNumeroCelular);
        if (matcherNumCelular.matches()) {
            booResultado = true;
        }
        return booResultado;
    }
    
}
