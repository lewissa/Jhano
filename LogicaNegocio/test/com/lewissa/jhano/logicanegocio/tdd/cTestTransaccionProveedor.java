/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd;

import com.lewissa.jhano.proveedor.cProveedor;
import com.lewissa.jhano.proveedor.cTransaccionProveedor;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 *
 * @author Usuario
 */

public class cTestTransaccionProveedor extends TestCase{

   // Este test prueba el ingreso de un proveedor
    public void testIngresarProveedor() {
        cProveedor datDatos= new cProveedor();
        cTransaccionProveedor proProveedor = new cTransaccionProveedor();
        //cProveedor datDatosProveedor = new cProveedor();
        //Boolean flag;
        //INSERT INTO proveedor VALUES ('pv003', 'asdfg', 'jhbsdcbhd', 'kjdbkhbd', '2378628', '0984486880', 'agshdc@sjgdv.com')
        datDatos.setId("pv020");
        datDatos.setNombreFiscal("Prueba");
        datDatos.setNombreComercial("Comercial");
        datDatos.setDireccion("Direccion");
        datDatos.setConvencional("2968473");
        datDatos.setCelular("0987777283");
        datDatos.setCorreo("asdfg@kk.com");
        //flag = proProveedor.ingresarProveedor(datDatosProveedor);
        String strSqlIngreso;
        
//        strSqlIngreso = "INSERT INTO proveedor VALUES ('"+datDatos.getId()+"', '"+datDatos.getNombreFiscal()+"'"
//                + ", '"+datDatos.getNombreComercial()+"', '"+datDatos.getDireccion()+"', '"+datDatos.getConvencional()+"'"
//                + ", '"+datDatos.getCelular()+"', '"+datDatos.getCorreo()+"')";
        //System.out.println(strSqlIngreso);
//        String resA = "INSERT INTO proveedor VALUES ('pv020', 'Prueba', 'Comercial', 'Direccion', '2968473', '0987777283', 'asdfg@kk.com')";
//        assertTrue(strSqlIngreso.equals(resA));//strSqlIngreso,         
    }
    
    
     public static Test suite() {

        return new TestSuite(cTestTransaccionProveedor.class);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    
}
