/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.listaproductos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class cTransaccionListaProdcutos {
    public Boolean ingresarListaProductos(cListaProductos oListaProductos)
    {
        Boolean booResultado=false;
        List<String> strProducto = new ArrayList<String>();
        strProducto.add(0, oListaProductos.getStrListaFactura());
        strProducto.add(1, oListaProductos.getIntListaProducto().toString());
        strProducto.add(2, oListaProductos.getIntCantidad().toString());
        booResultado = ingresarListaProductos_1(strProducto);        
        return booResultado;
    }

    private static Boolean ingresarListaProductos_1(java.util.List<java.lang.String> strListaProductos) {
        com.lewissa.jhano.accesodatos.listaproductos.WsAccesoDatosListaProductos_Service service = new com.lewissa.jhano.accesodatos.listaproductos.WsAccesoDatosListaProductos_Service();
        com.lewissa.jhano.accesodatos.listaproductos.WsAccesoDatosListaProductos port = service.getWsAccesoDatosListaProductosPort();
        return port.ingresarListaProductos(strListaProductos);
    }
}
