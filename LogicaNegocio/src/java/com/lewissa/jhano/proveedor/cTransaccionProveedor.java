/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.proveedor;

/**
 *Clase Transección de Proveedor
 * Gestiona el comportamiento de la clase cCliente, mediante los métodos creados
 * 
 * @author Miguel Mejía, Juan Moyano
 * @version 1.0 06/05/2014
 */
public class cTransaccionProveedor {

    /**
     * Ingresar Proveedor
     * Método que construye y envia la sentecia SQL para el ingreso de proveedores
     * 
     * @param datDatos, Objeto que represnta a la tabla Proveedor
     * @return flag.actualizarDataBase, Boolean que retorna la confimacion de la realizacion del metodo
     */
    public Boolean ingresarProveedor(cProveedor datDatos) {
        //cAccesoDatos accEjecutaQry=new cAccesoDatos();
        com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service service = new com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service();
        com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos flag = service.getWsAccesoDatosPort();
        String strSqlIngreso;
        strSqlIngreso = "INSERT INTO proveedor VALUES ('"+datDatos.getId()+"', '"+datDatos.getNombreFiscal()+"'"
                + ", '"+datDatos.getNombreComercial()+"', '"+datDatos.getDireccion()+"', '"+datDatos.getConvencional()+"'"
                + ", '"+datDatos.getCelular()+"', '"+datDatos.getCorreo()+"')";
        return flag.actualizarDataBase(strSqlIngreso);
    }  
}
