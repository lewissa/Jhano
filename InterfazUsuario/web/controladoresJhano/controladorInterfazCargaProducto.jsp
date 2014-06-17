<%-- 
    Document   : controladorInterfazCargaProducto
    Created on : 24/05/2014, 04:55:19 PM
    Author     : eborja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%
            try {
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();
                
            } catch (Exception ex) {
            }
        %>
    </body>
</html>
