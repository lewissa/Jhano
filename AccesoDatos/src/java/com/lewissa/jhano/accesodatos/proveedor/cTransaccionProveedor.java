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

    public Boolean ingresarProveedor(java.lang.String[] strProveedor) {
        Boolean booResultado = false;
        String strQuery;
        String strNombreComercial = null;
        String strDireccion = null;
        String strConvencional = null;
        String strCelular = null;
        if (strProveedor[2].equals("")) {
            strNombreComercial = "null";
        } else {
            strNombreComercial = "'" + strProveedor[2] + "'";
        }
        if (strProveedor[4].equals("")) {
            strConvencional = "null";
        } else {
            strConvencional = "'" + strProveedor[4] + "'";
        }
        if (strProveedor[3].equals("")) {
            strDireccion = "null";
        } else {
            strDireccion = "'" + strProveedor[3] + "'";
        }
        if (strProveedor[5].equals("")) {
            strCelular = "null";
        } else {
            strCelular = "'" + strProveedor[5] + "'";
        }
        strQuery = "INSERT INTO proveedor VALUES ('" + strProveedor[0] + "','" + strProveedor[1] + "',"
                + "" + strNombreComercial + "," + strDireccion + ","
                + "" + strConvencional + "," + strCelular + ",'" + strProveedor[6] + "')";
        booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        if (booResultado == null) {
            booResultado = false;
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
    public String cargarProveedor() {
        String strProveedor = null;
        String strQuery = "SELECT * FROM proveedor WHERE eliminado=false";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strProveedor = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }

        return strProveedor;
    }

    /**
     * Metod permite eliminar un proveedor especifico segun su codigo
     *
     * @param strCodigoProveedor, contiene el codgo del proveedor a eliminar
     * @return booResultado, Boolean que contiene la confimacion de la
     * eliminacion
     */
    public Boolean eliminarFisicoProveedor(String strCodigoProveedor) {
        Boolean booResultado = false;
        String strQuery;
        strQuery = "DELETE FROM proveedor WHERE \"Id_prove\" like '" + strCodigoProveedor + "'";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }

        return booResultado;
    }

    /**
     *
     * metodo que oelrmite eliminar los datos de un proveedor LPGICAMENTE
     *
     * @author Fredy Janeta
     * @param strCodigoProveedor
     * @return Boolean, booResultdo contiene la confirmacion de la aplicacion
     * del metodo
     */
    public Boolean eliminarLogicoProveedor(String strCodigoProveedor) {
        Boolean booResultado = false;
        String strQuery;
        strQuery = "UPDATE proveedor SET eliminado=true WHERE \"Id_prove\"='" + strCodigoProveedor + "'";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }
        return booResultado;
    }

    /**
     * @author Fredy Janeta Metodo que permite modificar los datos de un
     * proveedor
     * @param strProveedor
     * @return Boolean , boo Resulatdo que contiene la confirmacion de la
     * aplicacion del metodo
     */
    public Boolean modificarProveedor(String strProveedor[]) {
        Boolean booResultado = false;
        String strQuery;
//        strQuery="UPDATE proveedor SET \"Nombre_fiscal\"='"+strProveedor[1]+
//                "', \"Nombre_comercial\"='"+strProveedor[2]+"', \"Direccion\"='"+
//                strProveedor[3]+"',\"Convencional\"='"+strProveedor[4]+"',\"Celular\"='"+
//                strProveedor[5]+"', \"Correo\"='"+strProveedor[6]+"' WHERE \"Id_prove\"='"+
//                strProveedor[0]+"'";
//        
        
        strQuery="UPDATE proveedor SET \"Nombre_fiscal\""+verificarNull(strProveedor[1])+
           ",\"Nombre_comercial\""+verificarNull(strProveedor[2])+", \"Direccion\""+verificarNull(strProveedor[3])+
           ",\"Convencional\""+verificarNull(strProveedor[4])+",\"Celular\""+verificarNull(strProveedor[5])+
                ", \"Correo\""+verificarNull(strProveedor[6])+" WHERE \"Id_prove\"='"+strProveedor[0]+"'";
  
        
        
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }   
        
        return booResultado;
    }
/**
 * Este metod permite almacenar valores nulos evitando que en la base d edatos se gurarde "null" como un string
 * @param strParametro, parametro a ser agreago en la sentecia sql
 * @return me devuelve el fragmento de la sentencia qsl, que permite almacenar correctamentos los datos
 */
    public String verificarNull (String strParametro)
    {
        String cadena = null;
        
        if(strParametro == null)
        {
            cadena=" = "+strParametro+" ";
        }
        else
        {
            cadena=" = '"+strParametro+"' ";
        }
        return cadena;
    }
}
