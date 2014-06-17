/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.factura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fredy Janeta
 * @version 1.0 27-05-2014
 */
public class cTransaccionFactura {
    
    public Boolean ingresarFactura(cFactura oFactura)
    {
        Boolean booResultado = false;
        List<String> strFactura = new ArrayList<String>();
        strFactura.add(0, oFactura.getStrIdFactura());
        strFactura.add(1, oFactura.getStrFechaFactura());
        strFactura.add(2, oFactura.getStrClienteFactura());
        strFactura.add(3, oFactura.getDouTotalFactura().toString());
        strFactura.add(4, oFactura.isBooEstadoFactura().toString());
        strFactura.add(5, oFactura.getStrDatosEmpresaFactura());
        booResultado=ingresarFactura_1(strFactura);       
        return booResultado;
    }

    private static Boolean ingresarFactura_1(java.util.List<java.lang.String> strFactura) {
        com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura_Service service = new com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura_Service();
        com.lewissa.jhano.accesodatos.factura.WsAccesoDatosFactura port = service.getWsAccesoDatosFacturaPort();
        return port.ingresarFactura(strFactura);
    }
    
    
}
