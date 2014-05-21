/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.producto;

import com.lewissa.jhano.utilidades.cRuc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eborja
 */
public class cTransaccionProducto {

    public Boolean ingresarProducto(cProducto datDatos) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        
        Boolean booFlag = false;
        cRuc rucRuc= new cRuc(datDatos.getStrProveedorProdu());
       List<String> strProducto = new ArrayList<String>();
        if (rucRuc.validaRuc()) {
            strProducto.add(0, datDatos.getStrEan());
            strProducto.add(1, datDatos.getStrFabricante());
            strProducto.add(2, datDatos.getStrDescripcionGeneral());
            strProducto.add(3, (datDatos.getDouMargenGanancia().toString()));
            strProducto.add(4, datDatos.getIntCantidad().toString());
            strProducto.add(5, datDatos.getDouPrecioCosto().toString());
            strProducto.add(6, datDatos.getDouMargenVenta().toString());
            strProducto.add(7, calculoSumaPrecioDos(datDatos).toString());
            strProducto.add(8, datDatos.getStrProveedorProdu());
            strProducto.add(9, datDatos.getIntStockMaximo().toString());
            strProducto.add(10, datDatos.getIntStockMinimo().toString());
            strProducto.add(11, datDatos.getStrFamiliaProdu().toString());
            strProducto.add(12, datDatos.getStrSn().toString());
            booFlag = port.actualizarDataBaseProducto(strProducto);
        }
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }
    
  public Double calculoSumaPrecioDos (cProducto datDatos){
      Double douPrecioDos;
      douPrecioDos=datDatos.getDouPrecioCosto()+datDatos.getDouMargenVenta();
      return douPrecioDos;
  }
    
}
