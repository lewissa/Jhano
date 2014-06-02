/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.familiaproducto;

import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.familiaproducto.cTransaccionFamiliaProducto;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionFamiliaProducto extends TestCase{
    cTransaccionFamiliaProducto oFamilia;
    
    public void testInsertarFamiliaProducto(){
     oFamilia = new cTransaccionFamiliaProducto();
     String [] strFamilia = new String[2];
     strFamilia[0]="fm199";
     strFamilia[1]="Helados";
        assertTrue(oFamilia.ingresarFamiliaProducto(strFamilia));
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionFamiliaProducto.class);
    }
    public static void main(String [] srgs)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    
    
}
