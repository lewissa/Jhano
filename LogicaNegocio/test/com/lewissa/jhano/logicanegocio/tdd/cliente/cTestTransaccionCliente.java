/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.cliente;

import com.lewissa.jhano.logicanegocio.cliente.cTransaccionCliente;
import java.io.Serializable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 *
 * @author Usuario
 */
public class cTestTransaccionCliente extends  TestCase{

    public void testBuscarCliente()
    {
        cTransaccionCliente oTransaccionCliente = new cTransaccionCliente();
        assertNotNull(oTransaccionCliente.buscarCliente("w"));
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionCliente.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    
    
}
