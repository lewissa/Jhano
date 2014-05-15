/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.tdd;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.lewissa.jhano.familiaproducto.cTransaccionFamiliaProducto;
import com.lewissa.jhano.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.logicanegocio.tdd.cTestTransaccionCliente;

/**
 *
 * @author Usuario
 */
public class cTestTransaccionFamiliaProducto extends TestCase {

    public void testInsertarFmiliaProducto() {
        cTransaccionFamiliaProducto oTFC = new cTransaccionFamiliaProducto();
        cFamiliaProducto oFamiliaProducto = new cFamiliaProducto();
        oFamiliaProducto.setStrId("fm333");
        oFamiliaProducto.setStrDescripcion("LAPTOP");
        assertTrue(oTFC.insertarFamiliaProducto(oFamiliaProducto));
        
    }

    public static Test suite() {

        return new TestSuite(cTestTransaccionCliente.class);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
