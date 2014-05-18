/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.lewissa.jhano.familiaproducto.cCodigoFamiliaProducto;

/**
 *
 * @author Usuario
 */
public class cTestCodigo extends TestCase{
    
    public void testValidarCodigo()
    {
        cCodigoFamiliaProducto oCodigo = new cCodigoFamiliaProducto();
        oCodigo.setStrCodigo("fm88");
        assertTrue(oCodigo.validarCodigo());
    }
    
    
    public static Test suite()
    {
        return new TestSuite(cTestCodigo.class);
    }
    
    public static void main (String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
}
