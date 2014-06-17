/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.tdd.listaproductos;

import com.lewissa.jhano.logicanegocio.cliente.cTransaccionCliente;
import com.lewissa.jhano.logicanegocio.listaproductos.cListaProductos;
import com.lewissa.jhano.logicanegocio.listaproductos.cTransaccionListaProdcutos;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;
/**
 *
 * @author Usuario
 */
public class cTestTransaccionListaProducto extends TestCase{
    
    public void testIngresarListaProductos()
    {
        cTransaccionListaProdcutos oTransaccionListaProdcutos = new cTransaccionListaProdcutos();
        cListaProductos oListaProductos = new cListaProductos();
        oListaProductos.setStrListaFactura("1");
        oListaProductos.setIntListaProducto(1);
        oListaProductos.setIntCantidad(5);
        assertTrue(oTransaccionListaProdcutos.ingresarListaProductos(oListaProductos));
    }
    
    
    public static Test suite()
    {
      return new TestSuite(cTestTransaccionListaProducto.class);
    }
    
    public static void main (String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
