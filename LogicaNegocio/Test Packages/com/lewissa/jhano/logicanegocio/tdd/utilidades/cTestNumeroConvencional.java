/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.utilidades;

import com.lewissa.jhano.logicanegocio.utilidades.cNumeroConvencional;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestNumeroConvencional  extends TestCase{
    
    public void testValidarNuemroConvencional()
    {
        cNumeroConvencional oNumeroConvencional = new cNumeroConvencional();
        oNumeroConvencional.setStrNumeroConvencional("1111111");
        assertTrue(oNumeroConvencional.validarNumeroConvencional());
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestNumeroConvencional.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
