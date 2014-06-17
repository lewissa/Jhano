package com.lewissa.jhano.logicanegocio.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cCedula {

    private String strCedula;

    /**
     * Método que permite validar que una cédula sea correcta.
     *
     * @author Wilmer Moina, Esteban Borja
     * @strCedula string, que es el atributo de cCedula que contiene la cedula
     * @return Booleano, Booleano que contiene verificación de si la cédula
     * cumple con las requisitos correspondientes.
     */
    public Boolean validaCedula() {
        String PATTERN_EMAIL = "([0-9]{10})";
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(strCedula);
        Boolean booFlag = false;
        if (matcher.matches()) {
            Integer intCedula = Integer.parseInt(strCedula);
            Integer vecCedula[] = new Integer[10];
            for (int i = 9; i >= 0; i--) {
                vecCedula[i] = intCedula % 10;
                intCedula /= 10;
            }
            booFlag = validaCedulaDigitoVerificador(vecCedula, 2, 0, 0);
        }
        return booFlag;
    }

    /**
     * Método que comprueba la cédula, utilizando el dígito verificar.
     *
     * @author Wilmer Moina, Esteban Borja
     * @param vecCedula, Vector que contendra la cédula.
     * @param intMul, Integer que permite calcular el dígito verificador.
     * @param intControl, Integer de control que llevara el número de veces que
     * se realizo la recursividad, controla que se haya recorrido todo elvector.
     * @param intVerificador, Integer de contendra el digito verificar,
     * utilizado para la comparacion con el ultimo dígito de la cédula.
     * @return Booleano, Retorna si el dígito verificador encontrado es o no
     * correcto.
     */
    private Boolean validaCedulaDigitoVerificador(Integer[] vecCedula, Integer intMul,
            Integer intControl, Integer intVerificador) {
        Integer intMulti;
        if (intControl == 9) {
            while (intVerificador >= 0) {
                intVerificador -= 10;
            }
            intVerificador *= -1;
            return intVerificador == vecCedula[intControl];
        } else {
            intMulti = intMul * vecCedula[intControl];
            if (intMulti >= 10) {
                intMulti -= 9;
            }
            intVerificador += intMulti;
            if (intMul == 2) {
                return validaCedulaDigitoVerificador(vecCedula, 1, ++intControl, intVerificador);
            } else {
                return validaCedulaDigitoVerificador(vecCedula, 2, ++intControl, intVerificador);
            }
        }
    }

    /**
     * Constructor de la clase cCedula que setea el valor de cedula
     *
     * @param strCed parametro de ingreso de la cedula para ser seteado en el
     * atributo strCedula
     */
    public cCedula(String strCed) {
        if (strCed == null) {
            strCedula = "";
        } else {
            strCedula = strCed;
        }
    }

}
