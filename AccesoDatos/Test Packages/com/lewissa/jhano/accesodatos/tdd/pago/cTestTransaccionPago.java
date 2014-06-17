/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.pago;
import com.lewissa.jhano.accesodatos.pago.cTransaccionPago;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;
/**
 *
 * @author Usuario
 */
public class cTestTransaccionPago  extends TestCase{
    
    
    public void testGetPagosPendientes()
    {
        cTransaccionPago oTransaccionPago= new cTransaccionPago();
        assertNotNull(oTransaccionPago.getPagosPendientes());
   }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionPago.class);
    }
    
    public static void main(String [] arg)
    {
        junit.textui.TestRunner.run(suite());
    }
}
