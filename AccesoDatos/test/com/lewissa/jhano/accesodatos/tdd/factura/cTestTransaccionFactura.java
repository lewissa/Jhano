/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.factura;
import com.lewissa.jhano.accesodatos.cAccesoDatos;
import com.lewissa.jhano.accesodatos.cliente.cTransaccionCliente;
import com.lewissa.jhano.accesodatos.factura.cTransaccionFactura;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;
/**
 *
 * @author Usuario
 */
public class cTestTransaccionFactura extends TestCase{
    
    public void testIngresarFactura()
    {
        cTransaccionFactura oTransaccionFactura = new cTransaccionFactura();
        String[] strFactura = new String[6];
        strFactura[0]="55";
        strFactura[1]="01-05-17 14:14:50" ;
        strFactura[2]="0601504582";
        strFactura[3]="1598.50";
        strFactura[4]="true";
        strFactura[5]="1723834931001";
        assertTrue(oTransaccionFactura.ingresarFactura(strFactura));      
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionFactura.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
