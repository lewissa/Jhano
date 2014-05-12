/*
 *Esta clae permite realizar las transacciones(Inserta, modificar, eliminar y 
 *consultar) de la familia de producto
 */

package com.lewissa.jhano.familiaproducto;
import com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service;

/**
 *
 * @author Fredy Janeta
 * @version 2.0 09-05-2014
 */
public class cTransaccionFamiliaProducto {
    
    /**
     * Este metodo que permite Insertar un Objeto Familia de Producto
     * @param familiaProducto, Objeto que represnta a la tabla Familia Producto
     * @return booResultado, Boolean que retorna la confimacion de la 
     * realizacion del metodos
     */
    
    public Boolean insertarFamiliaProducto(cFamiliaProducto familiaProducto){
        Boolean booResultado=false;
        String strQuery;
        com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service serviceAD = new WsAccesoDatos_Service();
        com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos  serviceADPort = serviceAD.getWsAccesoDatosPort();
        strQuery = "INSERT INTO familia VALUES ('" + familiaProducto.getStrId()+ "', '" + familiaProducto.getStrDescripcion()+ "')";
        booResultado= serviceADPort.actualizarDataBase(strQuery);
        return booResultado;
    
    }
    
}
