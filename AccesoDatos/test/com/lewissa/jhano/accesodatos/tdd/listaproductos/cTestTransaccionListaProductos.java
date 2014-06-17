/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.listaproductos;

import com.lewissa.jhano.accesodatos.listaproductos.cTransaccionListaProductos;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Fredy Janeta
 */
public class cTestTransaccionListaProductos extends TestCase{
    
    public void testIngresarListProductos()
    {
        cTransaccionListaProductos oTransaccionListaProductos = new cTransaccionListaProductos();
        String [] strListaProductos= new String[3];
        strListaProductos[0]="128";//id factura
        strListaProductos[1]="1";//id producto
        strListaProductos[2]="5";//cantidad
        assertTrue(oTransaccionListaProductos.ingresarListaProductos(strListaProductos));;
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionListaProductos.class);
    }
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
