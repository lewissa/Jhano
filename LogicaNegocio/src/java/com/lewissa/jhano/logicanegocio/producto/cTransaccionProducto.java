/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.producto;

import com.lewissa.jhano.logicanegocio.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.logicanegocio.proveedor.cProveedor;
import com.lewissa.jhano.logicanegocio.utilidades.cRuc;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.sql.SQLException;
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
        cRuc rucRuc = new cRuc(datDatos.getStrProveedorProdu());
        List<String> strProducto = new ArrayList<String>();
        strProducto.add(0, datDatos.getStrEan());
        strProducto.add(1, datDatos.getStrFabricante());
        strProducto.add(2, datDatos.getStrDescripcionGeneral());
        if (datDatos.getDouMargenGanancia() != null) {
            strProducto.add(3, (datDatos.getDouMargenGanancia().toString()));
        } else {
            strProducto.add(3, null);
        }
        if (datDatos.getIntCantidad() != null) {
            strProducto.add(4, datDatos.getIntCantidad().toString());
        } else {
            strProducto.add(4, null);
        }
        if (datDatos.getDouPrecioCosto() != null) {
            strProducto.add(5, datDatos.getDouPrecioCosto().toString());
        } else {
            strProducto.add(5, null);
        }
        if (datDatos.getDouMargenVenta() != null) {
            strProducto.add(6, datDatos.getDouMargenVenta().toString());
        } else {
            strProducto.add(6, null);
        }
        try {
            strProducto.add(7, calculoSumaPrecioDos(datDatos).toString());
        } catch (Exception excError) {
            strProducto.add(7, null);
        }
        strProducto.add(8, datDatos.getStrProveedorProdu());
        if (datDatos.getIntStockMaximo() != null) {
            strProducto.add(9, datDatos.getIntStockMaximo().toString());
        } else {
            strProducto.add(9, null);
        }
        if (datDatos.getIntStockMinimo() != null) {
            strProducto.add(10, datDatos.getIntStockMinimo().toString());
        } else {
            strProducto.add(10, null);
        }
        strProducto.add(11, datDatos.getStrFamiliaProdu().toString());
        booFlag = port.actualizarDataBaseProducto(strProducto);
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    public Double calculoSumaPrecioDos(cProducto datDatos) {
        Double douPrecioDos = null;
        if (datDatos.getDouPrecioCosto() != null && datDatos.getDouMargenVenta() != null) {
            douPrecioDos = datDatos.getDouPrecioCosto() + datDatos.getDouMargenVenta();
        }
        return douPrecioDos;
    }

    List<cProveedor> getNombreProvedor() {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        String strError = null;
        List<cProveedor> lisNombreProveedor = null;
        try {
            strError = port.getNombreProveedor();
        
         lisNombreProveedor= new ArrayList<>();
        if (!strError.equals("err0r")) {
            StringReader strLista = new StringReader(port.getNombreProveedor());
            WebRowSetImpl webLista = new WebRowSetImpl();
            webLista.readXml(strLista);
            while (webLista.next()) {
                cProveedor proProveedor = new cProveedor();
                proProveedor.setId(webLista.getString("Id_prove"));
                proProveedor.setNombreFiscal(webLista.getString("Nombre_fiscal"));
                lisNombreProveedor.add(proProveedor);
            }
        } else {
            lisNombreProveedor = null;
        }
        } catch (Exception excError) {
        }
        return lisNombreProveedor;
    }

    List<cFamiliaProducto> getDescripcionFamiliaProducto()  {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        String strError = null;
        List<cFamiliaProducto> lisFamiliaProducto=null;
        try {
            strError = port.getDescripcionFamilaProducto();
       
         lisFamiliaProducto= new ArrayList<>();
        StringReader strLista = new StringReader(port.getDescripcionFamilaProducto());
        if (!strError.equals("err0r")) {
            WebRowSetImpl webLista = new WebRowSetImpl();
            webLista.readXml(strLista);
            while (webLista.next()) {
                cFamiliaProducto famFamilia = new cFamiliaProducto();
                famFamilia.setStrId(webLista.getString("Id_fami"));
                famFamilia.setStrDescripcion(webLista.getString("Descripcion"));
                lisFamiliaProducto.add(famFamilia);
            }
        } else {
            lisFamiliaProducto = null;
        }
         } catch (Exception excError) {
        }
        return lisFamiliaProducto;
    }

}
