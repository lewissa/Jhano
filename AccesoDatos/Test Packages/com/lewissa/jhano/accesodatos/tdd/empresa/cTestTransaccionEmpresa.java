/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.empresa;
import com.lewissa.jhano.accesodatos.empresa.cTransaccionEmpresa;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
/**
 *
 * @author Juan Moyano - fredy Janeta
 * estea clase contiene los test de los metodos de la clase cTransaccionEmpresa
 */
public class cTestTransaccionEmpresa extends TestCase{
    
    
    public void testBuscar()
    {
       String strRuc="1723834931001";
        cTransaccionEmpresa oTransaccionEmpresa = new cTransaccionEmpresa();
        assertNotNull(oTransaccionEmpresa.buscarEmpresa(strRuc));
        
    }
    
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionEmpresa.class);
    }
    public static void main(String [] agrs)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
