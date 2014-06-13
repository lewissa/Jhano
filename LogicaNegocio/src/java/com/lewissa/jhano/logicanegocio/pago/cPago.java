/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
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
    public String getStrFacturaPago() {
        return strFacturaPago;
    }

    /**
     * @param strFacturaPago the strFacturaPago to set
     */
    public void setStrFacturaPago(String strFacturaPago) {
        this.strFacturaPago = strFacturaPago;
    }

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
    
    
}
