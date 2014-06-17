<<<<<<< HEAD
=======

>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.accesodatos.pago;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
<<<<<<< HEAD
 * @author Fredy Janeta
 */
public class cTransaccionPago {

    public String getPagosPendientes() {
        String strResultado = null;
        String strQuery = "SELECT \"Id_cliente\",\"Nombre_fiscal\",\"Convencional\",\"Celular\",\"Correo\",\"Direccion\", monto,fecha_pago "
                + "FROM (cliente INNER JOIN factura ON cliente.\"Id_cliente\" like "
                + " factura.\"cliente_factu\" )INNER JOIN pago ON factura.\"Id_factu\" like pago.factura_pago WHERE estado=FALSE "
                + "AND fecha_pago < current_date + 1";
        if (cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase()) {
            strResultado = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
        }

        return strResultado;
    }

=======
 * @author Usuario
 */
public class cTransaccionPago {

>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
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

    public String mostrarDatosPago(String idPago) {
        String strSqlConsulta, strPago;
        strSqlConsulta = "SELECT * FROM \"pago\" WHERE \"Id_pago\" = '" + idPago + "'";
        strPago = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strSqlConsulta);
        return strPago;
    }
}
