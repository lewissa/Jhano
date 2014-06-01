/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.factura;
import com.lewissa.jhano.logicanegocio.cliente.cTransaccionCliente;
import com.lewissa.jhano.logicanegocio.factura.cFactura;
import com.lewissa.jhano.logicanegocio.factura.cTransaccionFactura;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 *
 * @author Usuario
 */
public class cTestTransaccionFactura extends TestCase{
    
    
    public void testInresarFactura()
    {
        cTransaccionFactura oTransaccionFactura = new cTransaccionFactura();
        cFactura oFactura = new cFactura();
        oFactura.setStrIdFactura("128");
        oFactura.setDouTotalFactura(252.20);
        oFactura.setStrDatosEmpresaFactura("1723834931001");
        oFactura.setBooEstadoFactura(true);
        oFactura.setStrClienteFactura("0601504582");
        oFactura.setStrFechaFactura("02-02-02 02:02:02");
        assertTrue(oTransaccionFactura.ingresarFactura(oFactura));
    }
       
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionFactura.class);
    }
    
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
