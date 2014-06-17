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
    
    private static String cargaProducto() {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.cargaProducto();
    }
    
    public List<cProducto> cargarProducto() {
        List<cProducto> lisProducto = new ArrayList<cProducto>();
        try {
            StringReader sr = new StringReader(cargaProducto());
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cProducto producto = new cProducto();
                producto.setStrIdProdu(wrs.getString("Id_produ"));
                producto.setStrEan(wrs.getString("Ean"));
                producto.setStrFabricante(wrs.getString("Fabricante"));
                producto.setStrDescripcionGeneral(wrs.getString("Descripcion_general"));
                producto.setDouMargenGanancia(wrs.getDouble("Margen_ganancia"));
                producto.setIntCantidad(wrs.getInt("Cantidad"));
                producto.setDouPrecioCosto(wrs.getDouble("Precio_costo"));
                producto.setDouMargenVenta(wrs.getDouble("Margen_venta"));
                producto.setDouPrecioDos(wrs.getDouble("Precio_dos"));
                producto.setStrProveedorProdu(wrs.getString("proveedor_produ"));
                producto.setIntStockMaximo(wrs.getInt("Stock_maximo"));
                producto.setIntStockMinimo(wrs.getInt("Stock_minimo"));
                producto.setStrFamiliaProdu(wrs.getString("familia_produ"));
                producto.setStrEstado(wrs.getString("estado"));
                lisProducto.add(producto);
            }
        } catch (Exception ex) {
        }

        return lisProducto;
    }
    
    public Boolean eliminarProducto(String strCodigoProducto, Integer intTipoEliminacion) {
        Boolean booResulado = false;
        if(strCodigoProducto != null)
        {
            if(intTipoEliminacion == 1) //Realiza eliminacion FISICA
            {
              booResulado=eliminarFisicoProducto(strCodigoProducto);
            }
            else
            {
              if(intTipoEliminacion == 0) //Realiza eliminacion LOGICA 
              {
                  booResulado=eliminarLogicoProducto(strCodigoProducto);
              }
            }
        }
        return booResulado;
    }
    
    private static Boolean eliminarFisicoProducto(java.lang.String strCodigoProducto) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.eliminarFisicoProducto(strCodigoProducto);
    }

    private static Boolean eliminarLogicoProducto(java.lang.String strCodigoProducto) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.eliminarLogicoProducto(strCodigoProducto);
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
    
    public List<cProducto> buscarProducto(String strParametro)
    {
        List<cProducto> lisProductos = new ArrayList<cProducto>();
        try {
            cProducto oProducto;
            WebRowSetImpl wrsImplement = new WebRowSetImpl();
            StringReader strReader = new StringReader(buscarProducto_1(strParametro));
            wrsImplement.readXml(strReader);
            while (wrsImplement.next()) {                
                oProducto= new cProducto();
                oProducto.setStrEan(wrsImplement.getString("Ean"));
                oProducto.setStrFabricante(wrsImplement.getString("Fabricante"));
                oProducto.setStrDescripcionGeneral(wrsImplement.getString("Descripcion_general"));
                oProducto.setDouMargenGanancia(wrsImplement.getDouble("Margen_ganancia"));
                oProducto.setIntCantidad(wrsImplement.getInt("Cantidad"));
                oProducto.setDouPrecioCosto(wrsImplement.getDouble("Precio_costo"));
                oProducto.setDouMargenVenta(wrsImplement.getDouble("Margen_venta"));
                oProducto.setDouPrecioDos(wrsImplement.getDouble("Precio_dos"));
                oProducto.setStrProveedorProdu(wrsImplement.getString("proveedor_produ"));
                oProducto.setIntStockMaximo(wrsImplement.getInt("Stock_maximo"));
                oProducto.setIntStockMinimo(wrsImplement.getInt("Stock_minimo"));
                oProducto.setStrFamiliaProdu(wrsImplement.getString("familia_produ"));
                lisProductos.add(oProducto);               
            }
        } catch (Exception e) {
        }
        return lisProductos;
    }

    private static String buscarProducto_1(java.lang.String strParametro) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.buscarProducto(strParametro);
    }

    public Boolean modificaProducto(cProducto datDatos) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        Boolean booFlag = false;
    
        List<String> strProducto = new ArrayList<String>();
        strProducto.add(0, datDatos.getStrSn());
        strProducto.add(1, datDatos.getStrEan());
        strProducto.add(2, datDatos.getStrFabricante());
        strProducto.add(3, datDatos.getStrDescripcionGeneral());
        if (datDatos.getDouMargenGanancia() != null) {
            strProducto.add(4, (datDatos.getDouMargenGanancia().toString()));
        } else {
            strProducto.add(4, null);
        }
        if (datDatos.getIntCantidad() != null) {
            strProducto.add(5, datDatos.getIntCantidad().toString());
        } else {
            strProducto.add(5, null);
        }
        if (datDatos.getDouPrecioCosto() != null) {
            strProducto.add(6, datDatos.getDouPrecioCosto().toString());
        } else {
            strProducto.add(6, null);
        }
        if (datDatos.getDouMargenVenta() != null) {
            strProducto.add(7, datDatos.getDouMargenVenta().toString());
        } else {
            strProducto.add(7, null);
        }
        try {
            strProducto.add(8, calculoSumaPrecioDos(datDatos).toString());
        } catch (Exception excError) {
            strProducto.add(8, null);
        }
        strProducto.add(9, datDatos.getStrProveedorProdu());
        if (datDatos.getIntStockMaximo() != null) {
            strProducto.add(10, datDatos.getIntStockMaximo().toString());
        } else {
            strProducto.add(10, null);
        }
        if (datDatos.getIntStockMinimo() != null) {
            strProducto.add(11, datDatos.getIntStockMinimo().toString());
        } else {
            strProducto.add(11, null);
        }
        strProducto.add(12, datDatos.getStrFamiliaProdu().toString());
        booFlag = port.modificarDataBaseProducto(strProducto);
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;

    }
    
    public List<cProducto> consultarProductoPorFamilia(String strIdFamilia)
    {

        List<cProducto> lisProductos = new ArrayList<cProducto>();
        try {
            cProducto oProducto;
            WebRowSetImpl wrsImplement = new WebRowSetImpl();
            StringReader strReader = new StringReader(consultarProductoPorFamilia_1(strIdFamilia));
            wrsImplement.readXml(strReader);
            while (wrsImplement.next()) {                
                oProducto= new cProducto();
                oProducto.setStrEan(wrsImplement.getString("Ean"));
                oProducto.setStrFabricante(wrsImplement.getString("Fabricante"));
                oProducto.setStrDescripcionGeneral(wrsImplement.getString("Descripcion_general"));
                oProducto.setDouMargenGanancia(wrsImplement.getDouble("Margen_ganancia"));
                oProducto.setIntCantidad(wrsImplement.getInt("Cantidad"));
                oProducto.setDouPrecioCosto(wrsImplement.getDouble("Precio_costo"));
                oProducto.setDouMargenVenta(wrsImplement.getDouble("Margen_venta"));
                oProducto.setDouPrecioDos(wrsImplement.getDouble("Precio_dos"));
                oProducto.setStrProveedorProdu(wrsImplement.getString("proveedor_produ"));
                oProducto.setIntStockMaximo(wrsImplement.getInt("Stock_maximo"));
                oProducto.setIntStockMinimo(wrsImplement.getInt("Stock_minimo"));
                oProducto.setStrFamiliaProdu(wrsImplement.getString("familia_produ"));
                lisProductos.add(oProducto);               
            }
        } catch (Exception e) {
        }
        return lisProductos;

    }

    private static String consultarProductoPorFamilia_1(java.lang.String strIdFamilia) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.consultarProductoPorFamilia(strIdFamilia);
    }
    

}
