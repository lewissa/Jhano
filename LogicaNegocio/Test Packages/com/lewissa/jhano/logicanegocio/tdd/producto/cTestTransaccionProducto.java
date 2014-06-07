/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.producto;

import com.lewissa.jhano.logicanegocio.producto.cTransaccionProducto;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
/**
 *
 * @author Usuario
 */
public class cTestTransaccionProducto extends TestCase {

    public void testBuscarProducto()
    {
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        assertNotNull(oTransaccionProducto.buscarProducto("nue"));
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionProducto.class);
    }
    public static void main(String [] args)    
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
