/*
 * Pruebas Unitaria
 * Esta clase me permite verificar el comportamiento de los metodos de la clase cAccesoDatos
 * 
 */
package com.lewissa.jhano.accesodatos.tdd;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;
import static org.junit.Assert.*;
import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 * Verificacion de los metodos del la cAccesoDatos
 *
 * @author Fredy Janeta
 * @version 1.0 05-05-2014
 */
public class cTestAccesoDatos extends TestCase {

    /**
     * Este metodo permite verificar si el metodo conectarDataBase() permite
     * conectar la DB
     */
    public void testConectarDataBase() {

        assertTrue(cAccesoDatos.getInstanciaAccesoDatos().conectarDataBase());
    }

    /**
     * Este metodo me permite verificar si el metodo desconectarDataBase()
     * permite desconectar la DB
     */
//    public void testDesconectarDataBase()
//    {
//        assertTrue(cAccesoDatos.getInstanciaAccesoDatos().desconectarDataBase());
//    }
//    /**
//     * Este metodo me permite virificar que el resultado de la consulta no sea NULL
//     * NOTA: para que esta prueba se a exitosa debe de existir elementos la tabla Cliente de la DB
//     */
//    public void testConsultarDataBase()
//    {
//        String strQuery = "SELECT * FROM cliente";
//        String strResultado = null;
//        strResultado = cAccesoDatos.getInstanciaAccesoDatos().consultarDataBase(strQuery);
//        assertNotNull(strResultado);
//        
//    }
//    /**
//     * Este metodo me permite verificar que la sentencia sql (strQuery) se ejecuta coorrectamente
//     * y me devovera un True en caso de ser exitosa la ejecucion de dicha consulta
//     */
//    public void testActualizarDataBase()
//    {
//        String strQuery = "INSERT INTO familia VALUES('fm583','LAPTOP')";
//        Boolean booResultado = false;
//        booResultado = cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
//        assertTrue(booResultado);
//    }
//    
    public static Test suite() {
        return new TestSuite(cTestAccesoDatos.class);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
