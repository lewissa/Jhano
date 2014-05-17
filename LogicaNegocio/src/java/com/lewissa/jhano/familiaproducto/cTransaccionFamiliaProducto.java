/*
 *Esta clae permite realizar las transacciones(Inserta, modificar, eliminar y 
 *consultar) de la familia de producto
 */

package com.lewissa.jhano.familiaproducto;
import javax.xml.ws.WebServiceRef;
import java.util.List;
import com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service;
import com.lewissa.jhano.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.utilidades.cCodigoFamiliaProducto;
import java.util.ArrayList;




/**
 *
 * @author Fredy Janeta
 * @version 2.0 09-05-2014
 */
public class cTransaccionFamiliaProducto {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosFamiliaProducto.wsdl")
    private com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service service;
    
    /**
     * Este metodo que permite Insertar un Objeto Familia de Producto
     * @param familiaProducto, Objeto que represnta a la tabla Familia Producto
     * @return booResultado, Boolean que retorna la confimacion de la 
     * realizacion del metodos
     */
    
    public Boolean insertarFamiliaProducto(cFamiliaProducto oFamiliaProducto){
        Boolean booResultado=false;
        String strQuery;
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service serviceAD = new WsAccesoDatosFamiliaProducto_Service();
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto  serviceADPort = serviceAD.getWsAccesoDatosFamiliaProductoPort();
        
        cCodigoFamiliaProducto oCodigo = new cCodigoFamiliaProducto(oFamiliaProducto.getStrId());
        List<String> strFamiliaProducto = new ArrayList<String>();
        if(oCodigo.validarCodigo())
        {
            strFamiliaProducto.add(0, oFamiliaProducto.getStrId());
            strFamiliaProducto.add(1, oFamiliaProducto.getStrDescripcion());
            booResultado = serviceADPort.ingresarFamiliaProducto(strFamiliaProducto);
        }
        
        
        
        //strQuery = "INSERT INTO familia VALUES ('" + familiaProducto.getStrId()+ "', '" + familiaProducto.getStrDescripcion()+ "')";
       
        return booResultado;
        
    }

   
}
