/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.pago;
import java.util.Date;
/**
 *
 * @author Usuario
 */
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

    public String getStrFacturaPago() {
        return strFacturaPago;
    }

    public void setStrFacturaPago(String strFacturaPago) {
        this.strFacturaPago = strFacturaPago;
    }

    public Boolean isBooEstado() {
        return booEstado;
    }

    public void setBooEstado(Boolean booEstado) {
        this.booEstado = booEstado;
    }

    
}
