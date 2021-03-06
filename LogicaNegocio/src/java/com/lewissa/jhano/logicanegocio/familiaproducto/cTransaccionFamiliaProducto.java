
/*
 *Esta clae permite realizar las transacciones(Inserta, modificar, eliminar y 
 *consultar) de la familia de producto
 */

package com.lewissa.jhano.logicanegocio.familiaproducto;
import com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service;
import com.lewissa.jhano.logicanegocio.producto.cProducto;
import com.lewissa.jhano.logicanegocio.utilidades.cCodigoFamiliaProducto;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import javax.xml.ws.WebServiceRef;
import java.util.List;
import java.util.ArrayList;




/**
 *
 * @author Fredy Janeta
 * @version 2.0 09-05-2014
 */
public class cTransaccionFamiliaProducto {
    private com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service service = new WsAccesoDatosFamiliaProducto_Service();
    private com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto port = service.getWsAccesoDatosFamiliaProductoPort();
    
    /**
     * Este metodo que permite Insertar un Objeto Familia de Producto
     * @param familiaProducto, Objeto que represnta a la tabla Familia Producto
     * @return booResultado, Boolean que retorna la confimacion de la 
     * realizacion del metodos
     */
    
    public Boolean insertarFamiliaProducto(cFamiliaProducto oFamiliaProducto){
        Boolean booResultado=false;
        cCodigoFamiliaProducto oCodigo = new cCodigoFamiliaProducto();
        oCodigo.setStrCodigo(oFamiliaProducto.getStrId());
        List<String> strFamiliaProducto = new ArrayList<String>();
        
        if(oCodigo.validarCodigo())
        {
            strFamiliaProducto.add(0, oFamiliaProducto.getStrId());
            strFamiliaProducto.add(1, oFamiliaProducto.getStrDescripcion());
            booResultado = port.ingresarFamiliaProducto(strFamiliaProducto);
        }
        return booResultado;
        
    }
    
    
    
    public String getErrorConexionFamiliaProducto()
    {
        String strResultado;
        strResultado = port.getErrorConexionFamiliaProducto();
        return strResultado;
    }
    
    public List<cFamiliaProducto> getFamiliaProducto()
    {
        List<cFamiliaProducto> listProductos = new ArrayList<cFamiliaProducto>();
        try {
            StringReader strReader =  new StringReader(getFamiliaProductos_1());
            WebRowSetImpl wrsImplement = new WebRowSetImpl();
            wrsImplement.readXml(strReader);
            while (wrsImplement.next()) {
                cFamiliaProducto oFamiliaProducto = new cFamiliaProducto();
                oFamiliaProducto.setStrId(wrsImplement.getString("Id_fami"));
                oFamiliaProducto.setStrDescripcion(wrsImplement.getString("Descripcion"));
                listProductos.add(oFamiliaProducto);
            }
            
        } catch (Exception e) {
        }
        return listProductos;
    }

    private static String getFamiliaProductos_1() {
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service service = new com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto_Service();
        com.lewissa.jhano.accesodatos.familiaproducto.WsAccesoDatosFamiliaProducto port = service.getWsAccesoDatosFamiliaProductoPort();
        return port.getFamiliaProductos();
    }
   
}
