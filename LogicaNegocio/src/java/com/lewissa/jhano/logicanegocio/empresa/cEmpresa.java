/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.empresa;

import java.io.Serializable;

/**
 *
 * @author Fredy Janeta
 */
public class cEmpresa implements Serializable{
    private String strRuc;
    private String strNombreFiscal;
    private String strDirecccion;

    public String getStrRuc() {
        return strRuc;
    }

    public void setStrRuc(String strRuc) {
        this.strRuc = strRuc;
    }

    public String getStrNombreFiscal() {
        return strNombreFiscal;
    }

    public void setStrNombreFiscal(String strNombreFiscal) {
        this.strNombreFiscal = strNombreFiscal;
    }

    public String getStrDirecccion() {
        return strDirecccion;
    }

    public void setStrDirecccion(String strDirecccion) {
        this.strDirecccion = strDirecccion;
    }

    public String getStrTelefono() {
        return strTelefono;
    }

    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }
    private String strTelefono;
    
}
