/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.utilidades;

import com.lewissa.jhano.logicanegocio.utilidades.cNumeroCelular;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
/**
 *
 * @author Usuario
 */
public class cTestNumeroCelular extends TestCase{
    
    public void testValidarCelular()
    {
        cNumeroCelular oNumeroCelular = new cNumeroCelular();
        oNumeroCelular.setStrNumeroCelular("7777777777");
        assertTrue(oNumeroCelular.validarNumeroCelular());
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestNumeroCelular.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
