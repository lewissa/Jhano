/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.cliente;
import com.lewissa.jhano.accesodatos.cliente.cTransaccionCliente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionCliente extends TestCase{
    
    
    public void testBuscar()
    {
        String strId="0604949891";
        cTransaccionCliente oTransaccionCliente= new cTransaccionCliente();
        assertNotNull(oTransaccionCliente.buscarCliente(strId));
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
