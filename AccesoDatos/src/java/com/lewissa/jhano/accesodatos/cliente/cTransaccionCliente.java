package com.lewissa.jhano.accesodatos.cliente;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clase Transacción de Clientes
 *
 * Gestiona el comportamiento de la clase cCliente, mediante los métodos creados
 *
 * @version 1.0 03/05/2014
 * @author
 */
public class cTransaccionCliente {

    private Connection cnn = null;

    /**
     * Método que permite ingresar un cliente.
     *
     * @param strCli
     * @return Booleano, que contine la verificacion de si ingreso o no el
     * cleinte.
     */
    public Boolean ingresarCliente(String strCli[]) {
        String strSqlIngreso = null;
        Boolean booBandera = true;
        Boolean booFlag = false;
        if (strCli[2].equals("") && strCli[4].equals("") && strCli[5].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ",null, '" + strCli[3] + "', null"
                    + ", null,'" + strCli[6] + "','" + strCli[7] + "')";
            booBandera = false;
        }
        if (strCli[2].equals("") && strCli[5].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", null, '" + strCli[3] + "', '" + strCli[4] + "'"
                    + ", null, '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        if (strCli[2].equals("") && strCli[4].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", null, '" + strCli[3] + "', null"
                    + ", '" + strCli[5] + "','" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        if (strCli[4].equals("") && strCli[5].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", '" + strCli[2] + "', '" + strCli[3] + "', null"
                    + ", null, '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        if (strCli[4].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", '" + strCli[2] + "', '" + strCli[3] + "', null"
                    + ", '" + strCli[5] + "', '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }

        if (strCli[5].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", '" + strCli[2] + "', '" + strCli[3] + "', '" + strCli[4] + "'"
                    + ", null, '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        if (strCli[2].equals("") && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", null, '" + strCli[3] + "', '" + strCli[4] + "'"
                    + ", '" + strCli[5] + "', '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        if (!(strCli[2].equals("") && strCli[4].equals("") && strCli[5].equals("")) && booBandera.equals(true)) {
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", '" + strCli[2] + "', '" + strCli[3] + "', '" + strCli[4] + "'"
                    + ", '" + strCli[5] + "', '" + strCli[6] + "', '" + strCli[7] + "')";
            booBandera = false;
        }
        booFlag = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    public String cargarCliente() {
        String strSqlConsulta, strCliente;
        //strSqlConsulta = "SELECT \"Id_cliente\", \"Nombre_fiscal\", \"Direccion\", \"Convencional\" FROM cliente"
                //+ "WHERE \"Estado\" = TRUE;";
        strSqlConsulta = "SELECT \"Id_cliente\", \"Nombre_fiscal\", \"Direccion\", \"Convencional\" FROM cliente WHERE \"Estado\" = TRUE;";
        strCliente = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strSqlConsulta);
        return strCliente;
    }
    
    public String buscarCliente(String strParametro) {
        String strSqlConsulta, strCliente=null;
        strSqlConsulta = "SELECT * FROM cliente WHERE \"Id_cliente\" like '"+strParametro+"%' OR \"Nombre_fiscal\"='"
                +strParametro+"%' OR \"Nombre_ccomercial\" like '"+strParametro+"%';";// OR \"Correo\" like '"+strParametro+"%';";
        if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
        {
            strCliente = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strSqlConsulta);
        }
        return strCliente;
    }

    public Boolean eliminarCliente(String strCli) {
        String strSqlEliminar;
        Boolean booFlag;
        strSqlEliminar = "UPDATE cliente SET \"Estado\"=FALSE WHERE \"Id_cliente\" = ('" + strCli + "');";
        booFlag=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlEliminar);
        if (booFlag ==null){
            booFlag=false;
        }
        return booFlag;
    }

}
