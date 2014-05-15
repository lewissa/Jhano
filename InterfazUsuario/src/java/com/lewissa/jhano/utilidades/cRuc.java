package com.lewissa.jhano.utilidades;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cRuc {

    String strRuc;

    /**
     * Método que permite validar que un RUC sea correcto.
     *
     * @author Wilmer Moina, Esteban Borja
     * @strRuc strRuc, String que contiene el ruc a verificar.
     * @return Booleano, Retorna si el correo verificado es o no correcto.
     */
    public Boolean validaRuc() {
        String PATTERN_RUC = "([0-9]{10})*[0]*[0]*[1]";
        Pattern pattern = Pattern.compile(PATTERN_RUC);
        Matcher matcher = pattern.matcher(strRuc);
        return matcher.matches();
    }

    /**
     *
     * @param strRc
     */
    public cRuc(String strRc) {
        strRuc = strRc;
    }
}
