/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.proveedor;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.proveedor.cTransaccionProveedor;
import com.lewissa.jhano.accesodatos.tdd.cTestAccesoDatos;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionProveedor extends TestCase{
    
    public void testEliminarFisicoProveedor()
    {
        Boolean booResult = false;
        cTransaccionProveedor oTranscaciones = new cTransaccionProveedor();
        booResult=oTranscaciones.eliminarFisicoProveedor("88888");
        assertTrue(booResult);
    }
    
    public  void testEliminarLogicoProveedor()
    {
     Boolean booResultado = false;
     cTransaccionProveedor oTransaccion = new cTransaccionProveedor();
     if(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase())
     {
         booResultado= oTransaccion.eliminarLogicoProveedor("4444444444");
     }
         assertTrue(booResultado);
    }
    
    public void testCargaProveedor(){
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        assertNotNull(oTransaccionProveedor.cargarProveedor());
    } 
    
    public void testModificarProveedor(){
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        String strQuery[]= new String[7];
        strQuery[0]="1723834931";
        strQuery[1]="1";
        strQuery[2]="1";
        strQuery[3]="1";
        strQuery[4]="1111110";
        strQuery[5]="1111111111";
        strQuery[6]="1";
        assertTrue(oTransaccionProveedor.modificarProveedor(strQuery));    
        
    }
    
    public static Test suite(){
        return new TestSuite(cTestTransaccionProveedor.class);
    }
    
    
        
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
