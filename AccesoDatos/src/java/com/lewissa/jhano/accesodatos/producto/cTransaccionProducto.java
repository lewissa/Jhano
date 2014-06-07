/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.producto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author eborja
 */
public class cTransaccionProducto {

    public Boolean ingresarProdcuto(String strPro[]) {
        String strSqlIngreso;
        Boolean booFlag = false;
        String strDescripcionGeneral = null;
        String strEan=null;
        String strFabricante=null;
        if (strPro[2].equals("")) {
            strDescripcionGeneral = "null";
        } else {
            strDescripcionGeneral = "'" + strPro[2] + "'";
        }
        if (strPro[0].equals("")) {
            strEan = "null";
        } else {
            strEan = "'" + strPro[0] + "'";
        }
        if (strPro[1].equals("")) {
            strFabricante = "null";
        } else {
            strFabricante = "'" + strPro[1] + "'";
        }
        strSqlIngreso = "INSERT INTO producto ("
                + "\"Ean\", \"Fabricante\", \"Descripcion_general\", \"Margen_ganancia\","
                + "\"Cantidad\", \"Precio_costo\", \"Margen_venta\", \"Precio_dos\", proveedor_produ,"
                + "\"Stock_maximo\", \"Stock_minimo\", familia_produ) VALUES (" + strEan + ""
                + "," + strFabricante + "," + strDescripcionGeneral + "," + strPro[3] + "," + strPro[4] + "," + strPro[5] + ""
                + "," + strPro[6] + "," + strPro[7] + ",'" + strPro[8] + "'," + strPro[9] + ""
                + "," + strPro[10] + ",'" + strPro[11] + "')";
        booFlag = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        return booFlag;

    }

    public String getNombreProducto() {
        return cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase("SELECT \"Id_prove\",\"Nombre_fiscal\" FROM proveedor");
    }
    
    public String buscarProducto(String strParametroBusqueda)
    {
        String strResultado=null;
        String strQuery="SELECT * FROM producto WHERE \"Ean\" like '"+strParametroBusqueda
                +"%' OR \"Fabricante\" like '"+strParametroBusqueda+"%' OR \"Descripcion_general\" like '"
                +strParametroBusqueda+"%';";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            strResultado=cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }
        return strResultado;
    }

}
