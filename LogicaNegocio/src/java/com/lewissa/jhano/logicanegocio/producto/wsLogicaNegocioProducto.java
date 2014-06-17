/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewissa.jhano.logicanegocio.producto;

import com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service;
import com.lewissa.jhano.logicanegocio.familiaproducto.cFamiliaProducto;
import com.lewissa.jhano.logicanegocio.proveedor.cProveedor;
import com.lewissa.jhano.logicanegocio.utilidades.cRuc;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;


/**
 *
 * @author eborja
 */
@WebService(serviceName = "wsLogicaNegocioProducto")
public class wsLogicaNegocioProducto {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatosProducto.wsdl")
    private WsAccesoDatosProducto_Service service;

    @WebMethod(operationName = "actualizaDataBaseProducto")
    public Boolean actualizaDataBaseProducto(@WebParam(name = "proProducto") cProducto proProducto) {
        cTransaccionProducto traTransaccion = new cTransaccionProducto();
        return traTransaccion.ingresarProducto(proProducto);
    }

    @WebMethod(operationName = "getErrorConexionProducto")
    public String getErrorConexionProducto() {
        String strResultado;
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service service = new com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto_Service();
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        strResultado = port.getErrorConexion();
        return strResultado;
    }

    @WebMethod(operationName = "validaRuc")
    public Boolean validaRuc(@WebParam(name = "rucRu") String rucRu) {
        cRuc rucRuc = new cRuc(rucRu);
        return rucRuc.validaRuc();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNombreProveedor")
    public java.util.List<cProveedor> getNombreProveedor()  {
        cTransaccionProducto traProducto = new cTransaccionProducto();
        return traProducto.getNombreProvedor();
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getDescripcionFamiliaProducto")
    public java.util.List<cFamiliaProducto> getDescripcionFamiliaProducto(){
        cTransaccionProducto traProducto=new cTransaccionProducto();
        return traProducto.getDescripcionFamiliaProducto();
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarProducto")
    public java.util.List<cProducto> buscarProducto(@WebParam(name = "strParametro") String strParametro) {
        //TODO write your implementation code here:
        List<cProducto> lisProductos = new ArrayList<cProducto>();
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        lisProductos = oTransaccionProducto.buscarProducto(strParametro);
        return lisProductos;
    }

    
    @WebMethod(operationName = "cargaProducto")
    public List<cProducto> cargaProducto() {
        cTransaccionProducto oTransaccionesProducto = new cTransaccionProducto();
        List<cProducto> lisProductos = new ArrayList<>();
        lisProductos = oTransaccionesProducto.cargarProducto();
        return lisProductos;
    }
    
    @WebMethod(operationName = "eliminarProducto")
    public Boolean eliminarProducto(@WebParam(name = "strId") String strId, Integer intTipoEliminacion) {
        //TODO write your implementation code here:
        Boolean booResultado = false;
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
        if (strId != null) {
            booResultado = oTransaccionProducto.eliminarProducto(strId, intTipoEliminacion);
        }
        return booResultado;
    }
    
     @WebMethod(operationName = "actualizaModificarDataBaseProducto")
    public Boolean actualizaModificarDataBaseProducto(@WebParam(name = "proProducto") cProducto proProducto) {
        cTransaccionProducto traTransaccion = new cTransaccionProducto();
        return traTransaccion.modificaProducto(proProducto);
    }
    
     @WebMethod(operationName = "obtieneProducto")
    public com.lewissa.jhano.logicanegocio.producto.cProducto obtieneProducto(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        com.lewissa.jhano.logicanegocio.producto.cProducto proProducto = new com.lewissa.jhano.logicanegocio.producto.cProducto();
        try {
            StringReader sr = new StringReader(this.consultarProducto(id));
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                proProducto.setStrSn(wrs.getString("Id_produ"));
                try {
                    String strControl = wrs.getString("Ean").toString();
                    proProducto.setStrEan(wrs.getString("Ean"));
                } catch (Exception excError) {
                    proProducto.setStrEan("");
                }
                try {
                    String strControl = wrs.getString("Fabricante").toString();
                    proProducto.setStrFabricante(wrs.getString("Fabricante"));
                } catch (Exception excError) {
                    proProducto.setStrFabricante("");
                }
                proProducto.setStrDescripcionGeneral(wrs.getString("Descripcion_general"));
                try {
                    String strControl = wrs.getString("Margen_ganancia").toString();
                    proProducto.setDouMargenGanancia(wrs.getDouble("Margen_ganancia"));
                } catch (Exception excError) {
                    proProducto.setDouMargenGanancia(0.0);
                }
                try {
                    String strControl = wrs.getString("Cantidad").toString();
                    proProducto.setIntCantidad(wrs.getInt("Cantidad"));
                } catch (Exception excError) {
                    proProducto.setIntCantidad(0);
                }
                try {
                    String strControl = wrs.getString("Precio_costo").toString();
                    proProducto.setDouPrecioCosto(wrs.getDouble("Precio_costo"));
                } catch (Exception excError) {
                    proProducto.setDouPrecioCosto(0.0);
                }
                try {
                    String strControl = wrs.getString("Margen_venta").toString();
                    proProducto.setDouMargenVenta(wrs.getDouble("Margen_venta"));
                } catch (Exception excError) {
                    proProducto.setDouMargenVenta(0.0);
                }
                proProducto.setDouPrecioDos(wrs.getDouble("Precio_dos"));
                proProducto.setStrProveedorProdu(wrs.getString("proveedor_produ"));

                try {
                    String strControl = wrs.getString("Stock_maximo").toString();
                    proProducto.setIntStockMaximo(wrs.getInt("Stock_maximo"));
                } catch (Exception excError) {
                    proProducto.setIntStockMaximo(0);
                }

                try {
                    String strControl = wrs.getString("Stock_minimo").toString();
                    proProducto.setIntStockMinimo(wrs.getInt("Stock_minimo"));
                } catch (Exception excError) {
                    proProducto.setIntStockMinimo(0);
                }
                proProducto.setStrFamiliaProdu(wrs.getString("familia_produ"));
            }
        } catch (Exception ex) {
        }
        return proProducto;
    }
    
     private String consultarProducto(java.lang.String arg0) {
        com.lewissa.jhano.accesodatos.producto.WsAccesoDatosProducto port = service.getWsAccesoDatosProductoPort();
        return port.consultarProducto(arg0);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarProductoPorFamilia")
    public List<cProducto> consultarProductoPorFamilia(@WebParam(name = "strIdFamilia") String strIdFamilia) {
        //TODO write your implementation code here:
        List<cProducto> lisProducto = new ArrayList<>();
        cTransaccionProducto oTransaccionProducto = new cTransaccionProducto();
         lisProducto = oTransaccionProducto.consultarProductoPorFamilia(strIdFamilia);
        return lisProducto;
    }

}
