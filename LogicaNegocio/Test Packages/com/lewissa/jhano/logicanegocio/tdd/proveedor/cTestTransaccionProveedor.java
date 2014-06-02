/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.proveedor;

import com.lewissa.jhano.logicanegocio.proveedor.cProveedor;
import com.lewissa.jhano.logicanegocio.proveedor.cTransaccionProveedor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionProveedor extends TestCase{
    
    public void testModificarProveedor()
    {
        cProveedor oProveedor = new cProveedor();
        cTransaccionProveedor oTransaccionProveedor = new cTransaccionProveedor();
        oProveedor.setId("1723834931");
        oProveedor.setNombreFiscal("FreduCorop");
        oProveedor.setNombreComercial("Freducito");
        oProveedor.setDireccion("PIPO");
        oProveedor.setConvencional("2380277");
        oProveedor.setCelular("0981403881");
        oProveedor.setCorreo("fredd_dimitri@hotmail.com");
        assertTrue(oTransaccionProveedor.modificarProveedor(oProveedor));
    }
    
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionProveedor.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
