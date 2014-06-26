<%-- 
    Document   : ControladorElimiarProveedor
    Created on : 20-may-2014, 6:18:31
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CProveedor"%>
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
                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service service = new com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service();
                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago port = service.getWsLogicaNegocioPagoPort();

                Boolean booResultadoEliminacion = port.eliminarPago(request.getParameter("id"),1);
                if (port.getErrorConexion() != null) {
                    String strError = port.getErrorConexion();
                    request.getSession().setAttribute("errorPago", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaPagos.jsp");
                }
                    response.sendRedirect("../interfacesJhano/interfazCargaPagos.jsp?idF=" + request.getParameter("idF") + "");

            } catch (Exception ex) {

            }
        %>

    </body>
</html>
