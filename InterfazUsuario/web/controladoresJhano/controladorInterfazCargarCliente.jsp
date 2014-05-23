<%-- 
    Document   : controladorInterfazCargarCliente
    Created on : 19/05/2014, 08:22:58 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador Cargar</title>
    </head>
    <body>
        <%-- start web service invocation --%><hr/>
        <%
            try {
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service service = new com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service();
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente port = service.getWsLogicaNegocioClientePort();
                // TODO process result here
                java.util.List<com.lewissa.jhano.logicanegocio.cliente.CCliente> result = port.obtenCliente();
                
                request.getSession().setAttribute("clientes", result);
                response.sendRedirect("../interfacesJhano/interfazCargaCliente.jsp?car=true");
                //out.println("Result = " + result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                out.print("Error: " + ex.getMessage() );
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
