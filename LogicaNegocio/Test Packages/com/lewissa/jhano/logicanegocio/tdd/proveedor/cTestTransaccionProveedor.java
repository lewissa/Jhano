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
        oProveedor.setNombreFiscal(null);
        oProveedor.setNombreComercial(null);
        oProveedor.setDireccion(null);
        oProveedor.setConvencional(null);
        oProveedor.setCelular(null);
        oProveedor.setCorreo(null);
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
