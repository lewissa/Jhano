<%-- 
    Document   : controladorEliminarCliente
    Created on : 29/05/2014, 02:02:58 PM
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador Eliminar</title>
    </head>
    <body>
        <%
            String strParametro = (request.getParameter("accion") != null) ? request.getParameter("accion") : "void";
            if (strParametro.equals("delete")) {
                try {
                    com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service service = new WsLogicaNegocioCliente_Service();
                    com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente port = service.getWsLogicaNegocioClientePort();
                    String strIdCliente = request.getParameter("id");
                    Boolean booResultado = port.eliminarCliente(strIdCliente);
                    if (port.getErrorConexionCliente() != null) {
                        String strError = port.getErrorConexionCliente();
                        request.getSession().setAttribute("errorCliente", strError);
                        response.sendRedirect("../interfacesJhano/interfazCargaCliente.jsp");
                    } else {
                        response.sendRedirect("../controladoresJhano/controladorInterfazCargarCliente.jsp");
                    }                    
                } catch (Exception e) {
                    out.print("Error: " + e.getMessage());
                }
            }
        %>
    </body>
</html>
