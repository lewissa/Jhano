<%-- 
    Document   : controladorAjaxFamiliaProducto
    Created on : 02/06/2014, 07:55:32 PM
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.factura.WsLogicaNegocioFactura_Service"%>
<%@page import="com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador Ajax Cargar</title>
    </head>
    <body>
        <%
            try {                                
                // TODO process result here
                
                com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service service = new WsLogicaNegocioFamiliaProducto_Service();
                com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto port = service.getWsLogicaNegocioFamiliaProductoPort();
                                
                java.util.List<com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto> result = port.getFamiliaProductos();
                
                request.getSession().setAttribute("familiaproductos", result);
                response.sendRedirect("../interfacesJhano/interfazAjaxCargarFamiliaProducto.jsp?car=true");
                //out.println("Result = " + result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                out.print("Error: " + ex.getMessage());
            }
        %>
    </body>
</html>
