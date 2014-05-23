package com.lewissa.jhano.logicanegocio.cliente;

import java.beans.*;
import java.io.Serializable;

/*
 * Esta clase represnta al objeto(tabla) Cliente
 */
/**
 * Clase cCliente
 *
 * @author Estaban Borjas, Wilmer Moina.
 * @version 1.0 06-05-2014
 */
public class cCliente implements Serializable {

    private String strIdCliente;
    private String strNombreFiscal;
    private String strNombreComercial;
    private String strDireccion;
    private String strConvencional;
    private String strCelular;
    private String strCorreo;
    private String strTipoCliente;

    /**
     * @return the strIdCliente
     */
    public String getStrIdCliente() {
        return strIdCliente;
    }

    /**
     * @param strIdCliente the strIdCliente to set
     */
    public void setStrIdCliente(String strIdCliente) {
        this.strIdCliente = strIdCliente;
    }

    /**
     * @return the strNombreFiscal
     */
    public String getStrNombreFiscal() {
        return strNombreFiscal;
    }

    /**
     * @param strNombreFiscal the strNombreFiscal to set
     */
    public void setStrNombreFiscal(String strNombreFiscal) {
        this.strNombreFiscal = strNombreFiscal;
    }

    /**
     * @return the strNombreComercial
     */
    public String getStrNombreComercial() {
        return strNombreComercial;
    }

    /**
     * @param strNombreComercial the strNombreComercial to set
     */
    public void setStrNombreComercial(String strNombreComercial) {
        this.strNombreComercial = strNombreComercial;
    }

    /**
     * @return the strDireccion
     */
    public String getStrDireccion() {
        return strDireccion;
    }

    /**
     * @param strDireccion the strDireccion to set
     */
    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    /**
     * @return the strConvencional
     */
    public String getStrConvencional() {
        return strConvencional;
    }

    /**
     * @param strConvencional the strConvencional to set
     */
    public void setStrConvencional(String strConvencional) {
        this.strConvencional = strConvencional;
    }

    /**
     * @return the strCelular
     */
    public String getStrCelular() {
        return strCelular;
    }

    /**
     * @param strCelular the strCelular to set
     */
    public void setStrCelular(String strCelular) {
        this.strCelular = strCelular;
    }

    /**
     * @return the strCorreo
     */
    public String getStrCorreo() {
        return strCorreo;
    }

    /**
     * @param strCorreo the strCorreo to set
     */
    public void setStrCorreo(String strCorreo) {
        this.strCorreo = strCorreo;
    }

    /**
     * @return the strTipoCliente
     */
    public String getStrTipoCliente() {
        return strTipoCliente;
    }

    /**
     * @param strTipoCliente the strTipoCliente to set
     */
    public void setStrTipoCliente(String strTipoCliente) {
        this.strTipoCliente = strTipoCliente;
    }
    private final PropertyChangeSupport propertySupport;

    public cCliente() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }


    public String obtenerCliente_1() {
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service service = new com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service();
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        return port.obtenerCliente();
    }

    
    
}
