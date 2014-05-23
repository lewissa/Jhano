/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.proveedor;

import com.lewissa.jhano.accesodatos.proveedor.cTransaccionProveedor;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionProveedor extends TestCase{
    
    public void testCargaProveedor(){
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        assertNotNull(oTransaccionProveedor.cargarProveedor());
    }   
    
    public static Test suite(){
        return new TestSuite(cTestTransaccionProveedor.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
