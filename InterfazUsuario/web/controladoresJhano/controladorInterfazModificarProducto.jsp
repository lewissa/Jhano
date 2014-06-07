<%-- 
    Document   : ControladorElimiarProveedor
    Created on : 20-may-2014, 6:18:31
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.cliente.CCliente"%>
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
                String strid = (String) request.getParameter("id");
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port= service.getWsLogicaNegocioProductoPort();
                com.lewissa.jhano.logicanegocio.producto.CProducto oProducto= new CProducto();
                oProducto=port.obtieneProducto(strid);
                request.getSession().setAttribute("modProducto", oProducto);
                response.sendRedirect("../interfacesJhano/interfazModificarProducto.jsp?car=true");
            } catch (Exception e) {

            }

        %>        
    </body>
</html>
