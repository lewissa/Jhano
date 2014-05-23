/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.proveedor;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Usuario
 */
public class cTransaccionProveedor {

    public Boolean ingresarProveedor(String strProveedor[]) {
        Boolean booResultado = false;
        
        String strQuery;
        strQuery = "INSERT INTO proveedor VALUES ('" + strProveedor[0] + "','" + strProveedor[1] + "',"
                 +"'" + strProveedor[2] + "','" + strProveedor[2] + "','" + strProveedor[3] + "',"
                + "'" + strProveedor[4] + "','" + strProveedor[5] + "','" + strProveedor[6] + "')";
        booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        if (booResultado == null) {
            booResultado = false;
        }
        return booResultado;
    }
/**
 * Metod que me permite cargar los datos de los proveedores
 * @author Fredy Janeta
 * @return strProveedor, el cual es un archivo XML que contiene a todos los prveedores
 */
    public String cargarProveedor() {
        Boolean booResultado = false;
        String strProveedor = null;
        String strQuery = "SELECT * FROM proveedor";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strProveedor = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }

        return strProveedor;
    }
/**
 * Metod permite elinar un proveedor especifico segun su codigo
 * @param strCodigoProveedor, contiene el codgo del proveedor a eliminar
 * @return booResultado, Boolean que contiene la confimacion de la eliminacion
 */
    public Boolean emilinarProveedor(String strCodigoProveedor) {
        Boolean booResultado = false;
        String strQuery;
        strQuery = "DELETE FROM estudiante WHERE Id_prove=" + strCodigoProveedor + ")";
        if (cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery)) {
            booResultado = true;
        }

        return booResultado;
    }

    /**
     * Metod que me permite cargar los datos de los proveedores
     *
     * @author Fredy Janeta
     * @return strProveedor, el cual es un archivo XML que contiene a todos los
     * prveedores
     */
 

    /**
     * Metod permite elinar un proveedor especifico segun su codigo
     *
     * @param strCodigoProveedor, contiene el codgo del proveedor a eliminar
     * @return booResultado, Boolean que contiene la confimacion de la
     * eliminacion
     */
 

}
