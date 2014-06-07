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
public class cNumeroConvencional {
    private String strNumeroConvencional;

    public String getStrNumeroConvencional() {
        return strNumeroConvencional;
    }

    public void setStrNumeroConvencional(String strNumeroConvencional) {
        this.strNumeroConvencional = strNumeroConvencional;
    }
    
    public Boolean validarNumeroConvencional()
    {
        Boolean booResultado=false;
        String strPatron = "^[0-9]{7}";
        Pattern patronNumConvencional = Pattern.compile(strPatron);
        Matcher matcherNumConvecional = patronNumConvencional.matcher(strNumeroConvencional);
        if(matcherNumConvecional.matches())
        {
            booResultado = true;
        }
        return booResultado;
    }
}
