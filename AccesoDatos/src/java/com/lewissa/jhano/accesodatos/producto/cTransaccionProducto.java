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
        strSqlIngreso = "INSERT INTO producto (\n" +
"            \"Ean\", \"Fabricante\", \"Descripcion_general\", \"Margen_ganancia\", \n" +
"            \"Cantidad\", \"Precio_costo\", \"Margen_venta\", \"Precio_dos\", proveedor_produ, \n" +
"            \"Stock_maximo\", \"Stock_minimo\", familia_produ, \"Sn\") VALUES ('"+ strPro[0]+"','"+ strPro[1]+"','"+ strPro[2]+"','"+ strPro[3]+"','"+ strPro[4]+"','"+ strPro[5]+"','"+ strPro[6]+"','"+ strPro[7]+"','"+ strPro[8]+"','"+ strPro[9]+"','"+ strPro[10]+"','"+ strPro[11]+"','"+ strPro[12]+"')";
        booFlag=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        return booFlag;

    }

}
