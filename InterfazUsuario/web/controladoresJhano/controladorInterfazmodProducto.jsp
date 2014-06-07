<%-- 
    Document   : controladorInterfazmodProducto
    Created on : 01/06/2014, 09:33:58 PM
    Author     : wmoina
--%>
<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador</title>
    </head>
    <body>
        <%
            try {
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();
                String strSn = (String) request.getSession().getAttribute("idProducto");
                String strEan = (request.getParameter("ean").equals("")) ? "0" : request.getParameter("ean");
                String strFabricacion = (request.getParameter("fabricacion").equals("")) ? "0" : request.getParameter("fabricacion");
                String strDescripcionGeneral = (request.getParameter("descripcionGeneral").equals("")) ? "0" : request.getParameter("descripcionGeneral");
                String strMargenGanancia = (request.getParameter("margenGanancia").equals("")) ? "0" : request.getParameter("margenGanancia");
                String strCantidad = (request.getParameter("cantidad").equals("")) ? "0" : request.getParameter("cantidad");
                String strPrecioCosto = (request.getParameter("precioCosto").equals("")) ? "0" : request.getParameter("precioCosto");
                String strMargenVenta = (request.getParameter("margenVenta").equals("")) ? "0" : request.getParameter("margenVenta");
                String strProveedor = (request.getParameter("proveedor").equals("")) ? "0" : request.getParameter("proveedor");
                String strStockMax = (request.getParameter("stockMax").equals("")) ? "0" : request.getParameter("stockMax");
                String strStockMin = (request.getParameter("stockMin").equals("")) ? "0" : request.getParameter("stockMin");
                String strFamiliaProducto = (request.getParameter("familiaProducto").equals("")) ? "0" : request.getParameter("familiaProducto");
                CProducto proProducto = new CProducto();
                Boolean booResultado = null;

                proProducto.setStrSn(strSn);

                if (strEan.equals("0")) {
                    proProducto.setStrEan("");
                } else {
                    proProducto.setStrEan(strEan);
                }

                if (strFabricacion.equals("0")) {
                    proProducto.setStrFabricante("");
                } else {
                    proProducto.setStrFabricante(strFabricacion);
                }

                if (strDescripcionGeneral.equals("0")) {
                    proProducto.setStrDescripcionGeneral("");
                } else {
                    proProducto.setStrDescripcionGeneral(strDescripcionGeneral);
                }
                if (strMargenGanancia.equals("0")) {
                    proProducto.setDouMargenGanancia(null);
                } else {
                    try {
                        proProducto.setDouMargenGanancia(Double.parseDouble(strMargenGanancia));
                    } catch (Exception excError) {
                        strMargenGanancia = "err0r";
                    }
                }
                if (strCantidad.equals("0")) {
                    proProducto.setIntCantidad(null);
                } else {
                    try {
                        proProducto.setIntCantidad(Integer.parseInt(strCantidad));
                    } catch (Exception excError) {
                        strCantidad = "err0r";
                    }
                }
                if (strPrecioCosto.equals("0")) {
                    proProducto.setDouPrecioCosto(null);
                } else {
                    try {
                        proProducto.setDouPrecioCosto(Double.parseDouble(strPrecioCosto));
                    } catch (Exception excError) {
                        strPrecioCosto = "err0r";
                    }
                }
                if (strMargenVenta.equals("0")) {
                    proProducto.setDouMargenVenta(null);
                } else {
                    try {
                        proProducto.setDouMargenVenta(Double.parseDouble(strMargenVenta));
                    } catch (Exception excError) {
                        strMargenVenta = "err0r";
                    }
                }
                proProducto.setStrProveedorProdu(strProveedor);
                if (strStockMax.equals("0")) {
                    proProducto.setIntStockMaximo(null);
                } else {
                    try {
                        proProducto.setIntStockMaximo(Integer.parseInt(strStockMax));
                    } catch (Exception excError) {
                        strStockMax = "err0r";
                    }
                }
                if (strStockMin.equals("0")) {
                    proProducto.setIntStockMinimo(null);
                } else {
                    try {
                        proProducto.setIntStockMinimo(Integer.parseInt(strStockMin));
                    } catch (Exception excError) {
                        strStockMin = "err0r";
                    }
                }
                proProducto.setStrFamiliaProdu(strFamiliaProducto);
                if (!(strDescripcionGeneral.equals("0") || strPrecioCosto.equals("0") || strMargenVenta.equals("0"))) {
                    booResultado = port.actualizaModificarDataBaseProducto(proProducto);
                }
                request.getSession().setAttribute("producto", booResultado);
                request.getSession().setAttribute("eanProductoVacio", strEan);
                request.getSession().setAttribute("fabricacionProductoVacio", strFabricacion);
                request.getSession().setAttribute("descripcionGeneralProductoVacio", strDescripcionGeneral);
                try {
                    Boolean booMargenGanancia = Boolean.parseBoolean(strMargenGanancia);
                    request.getSession().setAttribute("margenGananciaProductoVacio", strMargenGanancia);
                } catch (Exception excError) {
                    request.getSession().setAttribute("margenGananciaProductoVacio", "err0r");
                }
                try {
                    Integer intCantidad = Integer.parseInt(strCantidad);
                    request.getSession().setAttribute("cantidadProductoVacio", strCantidad);
                } catch (Exception excError) {
                    request.getSession().setAttribute("cantidadProductoVacio", "err0r");
                }
                try {
                    Boolean booPrecioCosto = Boolean.parseBoolean(strPrecioCosto);
                    request.getSession().setAttribute("precioCostoProductoVacio", strPrecioCosto);
                } catch (Exception excError) {
                    request.getSession().setAttribute("precioCostoProductoVacio", "err0r");
                }
                try {
                    Boolean booMargenVenta = Boolean.parseBoolean(strMargenVenta);
                    request.getSession().setAttribute("margenVentaProductoVacio", strMargenVenta);
                } catch (Exception excError) {
                    request.getSession().setAttribute("margenVentaProductoVacio", "err0r");
                }
                try {
                    Boolean booStockMaximo = Boolean.parseBoolean(strStockMax);
                    request.getSession().setAttribute("stockMaximoProductoVacio", strStockMax);
                } catch (Exception excError) {
                    request.getSession().setAttribute("stockMaximoProductoVacio", "err0r");
                }
                try {
                    Boolean booStockMinimo = Boolean.parseBoolean(strStockMin);
                    request.getSession().setAttribute("stockMinimoProductoVacio", strStockMin);
                } catch (Exception excError) {
                    request.getSession().setAttribute("stockMinimoProductoVacio", "err0r");
                }
                if (port.getErrorConexionProducto() != null) {
                    String strError = port.getErrorConexionProducto();
                    request.getSession().setAttribute("errorProducto", strError);
                    response.sendRedirect("../interfacesJhano/interfazModificarProducto.jsp");
                } else {
                   
                        request.getSession().setAttribute("modProducto", null);
                        response.sendRedirect("../interfacesJhano/interfazModificarProducto.jsp");
                }
            } catch (Exception e) {
                out.print("ERROR:" + e.getMessage());
            }
        %>
    </body>
</html>



