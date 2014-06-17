<%-- 
    Document   : controladorInterfazCargarFactura
    Created on : 13/06/2014, 05:24:02 PM
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
        <%
            try {
                com.lewissa.jhano.logicanegocio.factura.WsLogicaNegocioFactura_Service service = new com.lewissa.jhano.logicanegocio.factura.WsLogicaNegocioFactura_Service();
                com.lewissa.jhano.logicanegocio.factura.WsLogicaNegocioFactura port = service.getWsLogicaNegocioFacturaPort();
                // TODO process result here
                java.util.List<com.lewissa.jhano.logicanegocio.factura.CFactura> result = port.obtenerFacturas();
                
                request.getSession().setAttribute("facturas", result);
                response.sendRedirect("../interfacesJhano/interfazCargaFactura.jsp?car=true");
                //out.println("Result = " + result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                out.print("Error: " + ex.getMessage() );
            }
        %>
    </body>
</html>
