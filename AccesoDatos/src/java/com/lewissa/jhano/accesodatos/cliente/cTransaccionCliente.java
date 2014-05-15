package com.lewissa.jhano.accesodatos.cliente;

import com.lewissa.jhano.accesodatos.cAccesoDatos;



/**
 * Clase Transacción de Clientes
 *
 * Gestiona el comportamiento de la clase cCliente, mediante los métodos creados
 *
 * @version 1.0 03/05/2014
 * @author
 */
public class cTransaccionCliente {

    /**
     * Método que permite ingresar un cliente.
     *
     * @param strCli
     * @param datDatos, contiene objeto tipo cliente a ser ingresado.
     * @return Booleano, que contine la verificacion de si ingreso o no el
     * cleinte.
     */
    public Boolean ingresarCliente(String strCli[]) {  
        String strSqlIngreso;
        Boolean booFlag = false;
            strSqlIngreso = "INSERT INTO cliente VALUES ('" + strCli[0] + "', '" + strCli[1] + "'"
                    + ", '" + strCli[2] + "', '" + strCli[3] + "', '" + strCli[4] + "'"
                    + ", '" + strCli[5] + "', '" + strCli[6] + "', '" + strCli[7] + "')";
            booFlag = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strSqlIngreso);
        if(booFlag==null)
            booFlag=false;
        return booFlag;
    }

}
