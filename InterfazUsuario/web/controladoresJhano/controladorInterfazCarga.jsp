<%-- 
    Document   : controladorInterfazCarga.jsp
    Created on : 25/06/2014, 11:26:27 PM
    Author     : eborja
--%>

<%@page import="com.lewissa.jhano.logicanegocio.pago.CPago"%>
<%@page import="java.util.Date"%>
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
                // TODO initialize WS operation arguments here
                com.lewissa.jhano.logicanegocio.pago.CPago strPago = new CPago();
                String strValor = (request.getParameter("valor").equals("")) ? "0" : request.getParameter("valor");
                String strFecha = (request.getParameter("fecha").equals("")) ? "0" : request.getParameter("fecha");
                String strTipo = (request.getParameter("tipo").equals("")) ? "0" : request.getParameter("tipo");
                String strPag = (request.getParameter("pagado").equals("")) ? "0" : request.getParameter("pagado");
                strPago.setDouMonto(Double.parseDouble(strValor));
                strPago.setStrFechaPago(strFecha);
                if (strTipo.equals("Cheque")) {
                    strPago.setIntFormaPago(1);
                }
                if (strTipo.equals("Efectivo")) {
                    strPago.setIntFormaPago(2);
                }
                if(strPag.equals("Pendiente"))
                    strPago.setBooEstado(false);
                if(strPag.equals("Pagado"))
                    strPago.setBooEstado(true);
                strPago.setStrFacturaPago(request.getParameter("idF"));
                java.lang.Boolean result = port.ingresaDataBasePago(strPago);
                response.sendRedirect("../interfacesJhano/interfazCargaPagos.jsp?idF="+request.getParameter("idF")+"");
            } catch (Exception ex) {
                out.print(ex);
            }
        %>    
</html>

