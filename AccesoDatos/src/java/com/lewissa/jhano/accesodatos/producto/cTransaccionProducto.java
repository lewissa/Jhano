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
        String strEan = null;
        String strFabricante = null;
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
        return cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase("SELECT \"Id_prove\",\"Nombre_fiscal\" FROM proveedor WHERE eliminado=false");
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

    public String cargarProducto() {
        String strProducto = null;
        String strQuery = "SELECT * FROM producto WHERE estado=true";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strProducto = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }


      return strProducto;
    }
    
    public Boolean eliminarFisicoProducto(String strCodigoProducto) {
        Boolean booResultado = false;
        String strQuery;
        strQuery = "DELETE FROM producto WHERE \"Id_produ\" = '"+ strCodigoProducto+"'";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }

        return booResultado;
    }
    /**
     
     * metodo que oelrmite eliminar los datos de un proveedor LPGICAMENTE
     * @author Fredy Janeta
     * @param strCodigoProveedor
     * @return Boolean, booResultdo contiene la confirmacion de la aplicacion del metodo
     */
    public Boolean eliminarLogicoProducto(String strCodigoProducto){
        Boolean booResultado=false;
        String strQuery;
        strQuery="UPDATE producto SET estado=false WHERE \"Id_produ\"='"+strCodigoProducto+"'";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()){
            booResultado=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
        }
        return booResultado;
    }
    
     public Boolean modificarProdcuto(String strPro[]) {
        String strSqlIngreso;
        Boolean booFlag = false;
        String strDescripcionGeneral = null;
        String strEan = null;
        String strFabricante = null;
        if (strPro[3].equals("")) {
            strDescripcionGeneral = "null";
        } else {
            strDescripcionGeneral = "'" + strPro[3] + "'";
        }
        if (strPro[1].equals("")) {
            strEan = "null";
        } else {
            strEan = "'" + strPro[1] + "'";
        }
        if (strPro[2].equals("")) {
            strFabricante = "null";
        } else {
            strFabricante = "'" + strPro[2] + "'";
        }
        strSqlIngreso = "UPDATE producto SET "
                + "\"Ean\"=" + strEan + ", \"Fabricante\"=" + strFabricante + ", \"Descripcion_general\"=" + strDescripcionGeneral + ", \"Margen_ganancia\"='" + strPro[4] + "',"
                + "\"Cantidad\"='" + strPro[5] + "', \"Precio_costo\"='" + strPro[6] + "', \"Margen_venta\"='" + strPro[7] + "', \"Precio_dos\"='" + strPro[8] + "', proveedor_produ='" + strPro[9] + "',"
                + "\"Stock_maximo\"='" + strPro[10] + "', \"Stock_minimo\"='" + strPro[11] + "', familia_produ='" + strPro[12] + " 'WHERE \"Id_produ\"='" + strPro[0] + "'";
        booFlag = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        return booFlag;
    }
     
     public String consultarProducto(String id) {

        String strSqlConsulta, strPoducto;
        strSqlConsulta = "SELECT * FROM producto WHERE \"Id_produ\" = '" + id + "'";
        strPoducto = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strSqlConsulta);
        return strPoducto;
    }
<<<<<<< HEAD
     
     /**
      * @author Fredy Janeta
      * Este metodo me permite sinsultar los datos de los produtos por la familia a la que pertenecen
      * @param strIdFamilia, codigo del la familia abuscar
      * @return un String que contine los datos de la consulta
      */
     public String consultarProductosPorFamilias(String strIdFamilia)
     {
         String strResultado=null;
         String strQuery="SELECT * FROM producto WHERE familia_produ like '"+strIdFamilia+"'";
         if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
         {
             strResultado=cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
         }
         
         return strResultado;
     }
=======
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
}
