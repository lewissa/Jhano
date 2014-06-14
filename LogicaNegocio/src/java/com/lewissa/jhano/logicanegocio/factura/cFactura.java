/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.factura;

import java.io.Serializable;

/**
 *
 * @author Fredy Janeta - Juan Moyano
 * @version 1.0 29-05-2014
 */
public class cFactura  implements Serializable{
    private String strIdFactura;
    private String strFechaFactura;
    private String strClienteFactura;
    private Double douTotalFactura;
    private Boolean booEstadoFactura;
    private String strDatosEmpresaFactura;

    public String getStrIdFactura() {
        return strIdFactura;
    }

    public void setStrIdFactura(String strIdFactura) {
        this.strIdFactura = strIdFactura;
    }

    public String getStrFechaFactura() {
        return strFechaFactura;
    }

    public void setStrFechaFactura(String strFechaFactura) {
        this.strFechaFactura = strFechaFactura;
    }

    public String getStrClienteFactura() {
        return strClienteFactura;
    }

    public void setStrClienteFactura(String strClienteFactura) {
        this.strClienteFactura = strClienteFactura;
    }

    public Double getDouTotalFactura() {
        return douTotalFactura;
    }

    public void setDouTotalFactura(Double douTotalFactura) {
        this.douTotalFactura = douTotalFactura;
    }

    public Boolean isBooEstadoFactura() {
        return booEstadoFactura;
    }

    public void setBooEstadoFactura(Boolean booEstadoFactura) {
        this.booEstadoFactura = booEstadoFactura;
    }

    public String getStrDatosEmpresaFactura() {
        return strDatosEmpresaFactura;
    }

    public void setStrDatosEmpresaFactura(String strDatosEmpresaFactura) {
        this.strDatosEmpresaFactura = strDatosEmpresaFactura;
    }
    
}
