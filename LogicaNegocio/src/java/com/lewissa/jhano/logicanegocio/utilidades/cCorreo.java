package com.lewissa.jhano.logicanegocio.utilidades;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cCorreo {

    String strCorreo;

    /**
     * Método que peermite validar que el correo electronico utiliza los
     * parametro correctos.
     *
     * @author Wilmer Moina, Esteban Borja
     * @param strCorreo, Strinque que posee el correo electronico a verificar.
     * @return Booleano, contiene la verificacion del metodo. PATTERN_EMAIL,
     * Variable que poosee, restricciones del correo.
     */
    public Boolean validaEmail() {

        String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(strCorreo);
        return matcher.matches();
    }

    public cCorreo(String strEmail) {
        if (strEmail == null) {
            strCorreo = "";
        } else {
            strCorreo = strEmail;
        }
    }
}
