/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;
<<<<<<< HEAD
import java.util.Date;
=======

import java.io.Serializable;

>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
/**
 *
 * @author Usuario
 */
<<<<<<< HEAD
public class cPago {
    private Integer intIdPago;
    private Double douMonto;
    private String strFechaPago;
    private Integer intFormaPago;
    private String strFacturaPago;
    private Boolean booEstado;

    public Integer getIntIdPago() {
        return intIdPago;
    }

    public void setIntIdPago(Integer intIdPago) {
        this.intIdPago = intIdPago;
    }

    public Double getDouMonto() {
        return douMonto;
    }

    public void setDouMonto(Double douMonto) {
        this.douMonto = douMonto;
    }

    public String getStrFechaPago() {
        return strFechaPago;
    }

    public void setStrFechaPago(String strFechaPago) {
        this.strFechaPago = strFechaPago;
    }

    public Integer getIntFormaPago() {
        return intFormaPago;
    }

    public void setIntFormaPago(Integer intFormaPago) {
        this.intFormaPago = intFormaPago;
    }

=======
public class cPago implements Serializable{
    private Integer intFormaPago;
    private Integer intIdPago;
    private Double douMontoReal;
    private String strFacturaPago;
    private String strFechaPago;

    /**
     * @return the intFormaPago
     */
    public Integer getIntFormaPago() {
        return intFormaPago;
    }

    /**
     * @param intFormaPago the intFormaPago to set
     */
    public void setIntFormaPago(Integer intFormaPago) {
        this.intFormaPago = intFormaPago;
    }

    /**
     * @return the intIdPago
     */
    public Integer getIntIdPago() {
        return intIdPago;
    }

    /**
     * @param intIdPago the intIdPago to set
     */
    public void setIntIdPago(Integer intIdPago) {
        this.intIdPago = intIdPago;
    }

    /**
     * @return the douMontoReal
     */
    public Double getDouMontoReal() {
        return douMontoReal;
    }

    /**
     * @param douMontoReal the douMontoReal to set
     */
    public void setDouMontoReal(Double douMontoReal) {
        this.douMontoReal = douMontoReal;
    }

    /**
     * @return the strFacturaPago
     */
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
    public String getStrFacturaPago() {
        return strFacturaPago;
    }

<<<<<<< HEAD
=======
    /**
     * @param strFacturaPago the strFacturaPago to set
     */
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
    public void setStrFacturaPago(String strFacturaPago) {
        this.strFacturaPago = strFacturaPago;
    }

<<<<<<< HEAD
    public Boolean isBooEstado() {
        return booEstado;
    }

    public void setBooEstado(Boolean booEstado) {
        this.booEstado = booEstado;
    }

=======
    /**
     * @return the strFechaPago
     */
    public String getStrFechaPago() {
        return strFechaPago;
    }

    /**
     * @param strFechaPago the strFechaPago to set
     */
    public void setStrFechaPago(String strFechaPago) {
        this.strFechaPago = strFechaPago;
    }
    
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
    
}
