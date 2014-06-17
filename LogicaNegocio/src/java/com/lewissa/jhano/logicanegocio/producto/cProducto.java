/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.producto;

import java.io.Serializable;

/**
 *
 * @author eborja
 */
public class cProducto implements Serializable {

    private String strIdProdu;
    private String strEan;
    private String strFabricante;
    private String strDescripcionGeneral;
    private Double douMargenGanancia;
    private Integer intCantidad;
    private Double douPrecioCosto;
    private Double douMargenVenta;
    private Double douPrecioDos;
    private String strProveedorProdu;
    private Integer intStockMaximo;
    private Integer intStockMinimo;
    private String strFamiliaProdu;
    private String strSn;
    private String strEstado;

    public String getStrEan() {
        return strEan;
    }

    public void setStrEan(String strEan) {
        this.strEan = strEan;
    }
    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }
    public String getStrIdProdu() {
        return strIdProdu;
    }

    public void setStrIdProdu(String strId) {
        this.strIdProdu = strId;
    }
    public String getStrFabricante() {
        return strFabricante;
    }

    public void setStrFabricante(String strFabricante) {
        this.strFabricante = strFabricante;
    }

    public String getStrDescripcionGeneral() {
        return strDescripcionGeneral;
    }

    public void setStrDescripcionGeneral(String strDescripcionGeneral) {
        this.strDescripcionGeneral = strDescripcionGeneral;
    }

    public Double getDouMargenGanancia() {
        return douMargenGanancia;
    }

    public void setDouMargenGanancia(Double douMargenGanancia) {
        this.douMargenGanancia = douMargenGanancia;
    }

    public Integer getIntCantidad() {
        return intCantidad;
    }

    public void setIntCantidad(Integer intCantidad) {
        this.intCantidad = intCantidad;
    }

    public Double getDouPrecioCosto() {
        return douPrecioCosto;
    }

    public void setDouPrecioCosto(Double douPrecioCosto) {
        this.douPrecioCosto = douPrecioCosto;
    }

    public Double getDouMargenVenta() {
        return douMargenVenta;
    }

    public void setDouMargenVenta(Double douMargenVenta) {
        this.douMargenVenta = douMargenVenta;
    }

    public Double getDouPrecioDos() {
        return douPrecioDos;
    }

    public void setDouPrecioDos(Double douPrecioDos) {
        this.douPrecioDos = douPrecioDos;
    }

    public String getStrProveedorProdu() {
        return strProveedorProdu;
    }

    public void setStrProveedorProdu(String strProveedorProdu) {
        this.strProveedorProdu = strProveedorProdu;
    }

    public Integer getIntStockMaximo() {
        return intStockMaximo;
    }

    public void setIntStockMaximo(Integer intStockMaximo) {
        this.intStockMaximo = intStockMaximo;
    }

    public Integer getIntStockMinimo() {
        return intStockMinimo;
    }

    public void setIntStockMinimo(Integer intStockMinimo) {
        this.intStockMinimo = intStockMinimo;
    }

    public String getStrFamiliaProdu() {
        return strFamiliaProdu;
    }

    public void setStrFamiliaProdu(String strFamiliaProdu) {
        this.strFamiliaProdu = strFamiliaProdu;
    }

    public String getStrSn() {
        return strSn;
    }

    public void setStrSn(String strSn) {
        this.strSn = strSn;
    }

}
