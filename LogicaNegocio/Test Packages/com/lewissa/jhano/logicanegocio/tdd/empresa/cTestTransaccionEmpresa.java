/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.empresa;

import com.lewissa.jhano.logicanegocio.empresa.cTransaccionEmpresa;
import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;
/**
 *
 * @author Fredy Janeta , Juan Moyano
 */
public class cTestTransaccionEmpresa extends TestCase {
    
    public void testTransaccionEmpresa()
    {
        cTransaccionEmpresa oTransaccionEmpresa = new cTransaccionEmpresa();
        assertNotNull(oTransaccionEmpresa.buscarEmpresa("1723834931001"));
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionEmpresa.class);
    }
    
    public static void main (String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
