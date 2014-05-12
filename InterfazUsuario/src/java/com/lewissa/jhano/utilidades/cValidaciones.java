/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class cValidaciones {

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
/**
 * Método que peermite validad que un correo electronico utiliza las parametro correctos.
 *
 * @author Wilmer Moina, Esteban Borja
 * @param strEmail, Strinque que posee el correo electronico a verificar.
 * @return Booleano, contiene la verificacion del metodo.
 */
    public Boolean validaEmail(String strEmail) {

        // Compila la expresión regular dada en un patrón.
        
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
     
        Matcher matcher = pattern.matcher(strEmail);
        return matcher.matches();

    }

}
