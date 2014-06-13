/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.pago;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Usuario
 */
public class cTransaccionPago {

    public String cargarPagos() {
        String strPago = null;
        String strQuery = "SELECT * FROM \"Pago\" WHERE \"estado\"=TRUE; ";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strPago = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }
        return strPago;
    }

    public Boolean modificarPago(String strPago[]) {
        String strSqlIngreso;
        Boolean booFlag = false;
        strSqlIngreso = "UPDATE \"Pago\"\n"
                + "SET \"Id_pago\"='" + strPago[0] + "', monto='" + strPago[1] + "', fecha_pago='" + strPago[2] + "', forma_pago='" + strPago[3] + "', factura_pago='" + strPago[4] + "', estado=TRUE\n"
                + "WHERE \"Id_pago\"='" + strPago[0] + "'";
        booFlag = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        return booFlag;

    }
}
