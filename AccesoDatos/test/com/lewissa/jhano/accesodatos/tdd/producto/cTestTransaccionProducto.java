/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.tdd.producto;

import com.lewissa.jhano.accesodatos.producto.cTransaccionProducto;
import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;
/**
 *
 * @author Fredy Janeta
 * esta clase ocntiene las pruebas unitarias de los metodos 
 * de la clase que oermite realizar las transaciones de los productos
 */
public class cTestTransaccionProducto  extends TestCase{
    
    public void testBuscarProducto()
    {
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        String strParametro ="nuev";
        assertNotNull(oTransaccionProducto.buscarProducto(strParametro));
    }
    
    public void testConsultarProdwcutosPorFamilia()
    {
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        assertNotNull(oTransaccionProducto.consultarProductosPorFamilias("fm123"));
    }
    
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionProducto.class);
    }
    
    
    
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    
}
