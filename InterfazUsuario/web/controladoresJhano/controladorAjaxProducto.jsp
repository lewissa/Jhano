<%-- 
    Document   : controladorAjaxProducto
    Created on : 09/06/2014, 08:21:35 PM
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service"%>
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
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();
                String strProducto = request.getParameter("cod");
                java.util.List<com.lewissa.jhano.logicanegocio.producto.CProducto> result = port.consultarProductoPorFamilia(strProducto);
                request.getSession().setAttribute("producto", result);
                response.sendRedirect("../interfacesJhano/interfazAjaxCargarFamiliaProducto.jsp?cod="+strProducto+"&car=true");
            } catch (Exception ex) {
                out.print("Error: " + ex.getMessage());
            }
        %>
    </body>
</html>
