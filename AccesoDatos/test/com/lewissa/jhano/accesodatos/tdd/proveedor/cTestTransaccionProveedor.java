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
        strQuery[0]="1111111111";
        strQuery[1]="88888";
        strQuery[2]=null;
        strQuery[3]=null;
        strQuery[4]=null;
        strQuery[5]=null;
        strQuery[6]=null;
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
