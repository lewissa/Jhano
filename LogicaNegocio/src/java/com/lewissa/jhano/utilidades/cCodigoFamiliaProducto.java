/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fredy Janeta
 * @version
 */
public class cCodigoFamiliaProducto {

    private String strCodigo;

    public cCodigoFamiliaProducto(String strId) {
        strCodigo = strId;
    }
    public cCodigoFamiliaProducto() {
    }

    public String getStrCodigo() {
        return strCodigo;
    }

    public void setStrCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public Boolean validarCodigo() {
        Boolean resultado = false;
        String strPatronCodigo = "^fm[0-9]{3}";
        Pattern patronCodigo = Pattern.compile(strPatronCodigo);
        Matcher matcherCodigo = patronCodigo.matcher(strCodigo);
        if (matcherCodigo.matches()) {
            resultado = true;
        }

        return resultado;
    }

}
