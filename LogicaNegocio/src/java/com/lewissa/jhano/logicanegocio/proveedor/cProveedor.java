/*
 * Esta clase represnta al objeto(tabla) Proveedor
 */
package com.lewissa.jhano.logicanegocio.proveedor;

/**
 *
 * Clase cProveedor
 * @author Miguel Mejía, Juan Moyano
 * @version 1.0 06/05/2014 
 */
public class cProveedor {

    private String strIdProveedor;
    private String strNombreFiscal;
    private String strNombreComercial;
    private String strDireccion;
    private String strConvencional;
    private String strCelular;
    private String strCorreo;

    public void setId(String strId) {
        strIdProveedor = strId;
    }

    public void setNombreFiscal(String strNombre) {
        strNombreFiscal = strNombre;
    }

    public void setNombreComercial(String strComercial) {
        strNombreComercial = strComercial;
    }

    public void setDireccion(String strDir) {
        strDireccion = strDir;
    }

    public void setConvencional(String strNumero) {
        strConvencional = strNumero;
    }

    public void setCelular(String strNumero) {
        strCelular = strNumero;
    }

    public void setCorreo(String strEmail) {
        strCorreo = strEmail;
    }

    public String getId() {
        return strIdProveedor;
    }

    public String getNombreFiscal() {
        return strNombreFiscal;
    }

    public String getNombreComercial() {
        return strNombreComercial;
    }

    public String getDireccion() {
        return strDireccion;
    }

    public String getConvencional() {
        return strConvencional;
    }

    public String getCelular() {
        return strCelular;
    }

    public String getCorreo() {
        return strCorreo;
    }

}
