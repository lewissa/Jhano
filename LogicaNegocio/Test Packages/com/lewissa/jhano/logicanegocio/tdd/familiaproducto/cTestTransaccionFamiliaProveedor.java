<<<<<<< HEAD
package com.lewissa.jhano.logicanegocio.tdd.familiaproducto;


import com.lewissa.jhano.logicanegocio.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.logicanegocio.familiaproducto.cTransaccionFamiliaProducto;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class cTestTransaccionFamiliaProveedor extends TestCase{
  /*  
    public void testEliminar(){
        cFamiliaProducto oFamiliaP = new cFamiliaProducto();
        cTransaccionFamiliaProducto oTransaccionFp = new cTransaccionFamiliaProducto();
        oFamiliaP.setStrId("fm236");
        oFamiliaP.setStrDescripcion("ESPOCH");
        assertEquals(oTransaccionFp.insertarFamiliaProducto(oFamiliaP), "SELECT * FROM ");
    }
   */
    
    public void testGetFamilia()
    {
        cTransaccionFamiliaProducto oTransaccionFamiliaProducto = new cTransaccionFamiliaProducto();
        assertNotNull(oTransaccionFamiliaProducto.getFamiliaProducto());
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionFamiliaProveedor.class);
    }
            
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
=======
package com.lewissa.jhano.logicanegocio.tdd.familiaproducto;


import com.lewissa.jhano.logicanegocio.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.logicanegocio.familiaproducto.cTransaccionFamiliaProducto;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class cTestTransaccionFamiliaProveedor extends TestCase{
    
    public void testEliminar(){
        cFamiliaProducto oFamiliaP = new cFamiliaProducto();
        cTransaccionFamiliaProducto oTransaccionFp = new cTransaccionFamiliaProducto();
        oFamiliaP.setStrId("fm236");
        oFamiliaP.setStrDescripcion("ESPOCH");
        assertEquals(oTransaccionFp.insertarFamiliaProducto(oFamiliaP), "SELECT * FROM ");
    }
    
    public static Test suite()
    {
        return new TestSuite(cTestTransaccionFamiliaProveedor.class);
    }
            
    public static void main(String [] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
}
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
