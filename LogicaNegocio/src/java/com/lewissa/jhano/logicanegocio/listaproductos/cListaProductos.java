/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.listaproductos;

import java.io.Serializable;

/**
 *
 * @author Juan Moyano
 */
public class cListaProductos implements Serializable{
    private String strListaFactura;
    private Integer intListaProducto;
    private Integer intCantidad;

    public String getStrListaFactura() {
        return strListaFactura;
    }

    public void setStrListaFactura(String strListaFactura) {
        this.strListaFactura = strListaFactura;
    }

    public Integer getIntListaProducto() {
        return intListaProducto;
    }

    public void setIntListaProducto(Integer intListaProducto) {
        this.intListaProducto = intListaProducto;
    }

    public Integer getIntCantidad() {
        return intCantidad;
    }

    public void setIntCantidad(Integer intCantidad) {
        this.intCantidad = intCantidad;
    }
}
