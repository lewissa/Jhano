<%-- 
    Document   : controladorInterfazCargaPago
    Created on : 12/06/2014, 07:40:11 PM
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service"%>
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
                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service service = new WsLogicaNegocioPago_Service();
                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago port = service.getWsLogicaNegocioPagoPort();
                // TODO process result here
                java.util.List<com.lewissa.jhano.logicanegocio.pago.CPago> result = port.cargaPago();

                request.getSession().setAttribute("pagos", result);
                response.sendRedirect("../interfacesJhano/interfazCargaPagos.jsp?car=true");
                //out.println("Result = " + result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                out.print("Error: " + ex.getMessage());
            }
        %>

    </body>
</html>
