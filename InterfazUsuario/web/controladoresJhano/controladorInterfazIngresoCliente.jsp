<%-- 
    Document   : controlador.jsp
    Created on : 09/04/2014, 04:47:58 AM
    Author     : ECORAE
--%>

<%@page import="com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service"%>
<%@page import="com.lewissa.jhano.logicanegocio.cliente.CCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador</title>
    </head>
    <body>
        <%
            try {
                String strNombrecomer = (request.getParameter("nombrecomer").equals("")) ? "0" : request.getParameter("nombrecomer");
                String strCiruc = (request.getParameter("ciruc").equals("")) ? "0" : request.getParameter("ciruc");
                String strNombrefiscal = (request.getParameter("nombrefiscal").equals("")) ? "0" : request.getParameter("nombrefiscal");
                String strDireccion = (request.getParameter("direccion").equals("")) ? "0" : request.getParameter("direccion");
                String strConvencional = (request.getParameter("convencional").equals("")) ? "0" : request.getParameter("convencional");
                String strCelular = (request.getParameter("celular").equals("")) ? "0" : request.getParameter("celular");
                String strCorreo = (request.getParameter("correo").equals("")) ? "0" : request.getParameter("correo");
                String strTipocliente = (request.getParameter("tipocliente").equals("")) ? "0" : request.getParameter("tipocliente");
                switch (Integer.parseInt(request.getParameter("tipocliente"))) {
                    case 1: {
                        strTipocliente = "tc001";
                        break;
                    }
                    case 2: {
                        strTipocliente = "tc002";
                        break;
                    }
                    case 3: {
                        strTipocliente = "tc003";
                        break;
                    }
                }
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service service = new WsLogicaNegocioCliente_Service();
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente port = service.getWsLogicaNegocioClientePort();// TODO initialize WS operation arguments here
                CCliente cliCliente = new CCliente();
                if (strCelular.equals("0")) {
                    cliCliente.setStrCelular("");
                } else {
                    cliCliente.setStrCelular(strCelular);
                }
                if (strConvencional.equals("0")) {
                    cliCliente.setStrConvencional("");
                } else {
                    cliCliente.setStrConvencional(strConvencional);
                }
                cliCliente.setStrCorreo(strCorreo);
                cliCliente.setStrDireccion(strDireccion);
                if (strNombrecomer.equals("0")) {
                    cliCliente.setStrNombreComercial("");
                } else {
                    cliCliente.setStrNombreComercial(strNombrecomer);
                }
                cliCliente.setStrNombreFiscal(strNombrefiscal);
                cliCliente.setStrTipoCliente(strTipocliente);
                cliCliente.setStrIdCliente(strCiruc);
                // TODO process result here
                Boolean booResult=null;
                if(!(strNombrefiscal.equals("0")||strDireccion.equals("0"))){
                 booResult = port.actualizaDataBaseCliente(cliCliente);
                }
                java.lang.Boolean booCorreo = port.validaEmail(request.getParameter("correo"));
                java.lang.Boolean booCedula = port.validaCedula(request.getParameter("ciruc"));
                java.lang.Boolean booRuc = port.validaRuc(request.getParameter("ciruc"));
                request.getSession().setAttribute("cliente", booResult);
                request.getSession().setAttribute("cliente", booResult);
                request.getSession().setAttribute("correo", booCorreo);
                request.getSession().setAttribute("cedula", booCedula);
                request.getSession().setAttribute("ruc", booRuc);
                request.getSession().setAttribute("correoVacio", strCorreo);
                request.getSession().setAttribute("cedulaVacio", strCiruc);
                request.getSession().setAttribute("rucVacio", strCiruc);
                request.getSession().setAttribute("nombreComercialVacio", strNombrecomer);
                request.getSession().setAttribute("nombreFiscalVacio", strNombrefiscal);
                request.getSession().setAttribute("direccionVacio", strDireccion);
                try {
                    Integer intControl = Integer.parseInt(strCelular);
                    request.getSession().setAttribute("celularVacio", strCelular);
                } catch (Exception e) {
                    request.getSession().setAttribute("celularVacio", "err0r");
                }
                try {
                    Integer intControl = Integer.parseInt(strConvencional);
                    request.getSession().setAttribute("telefonoVacio", strConvencional);
                } catch (Exception e) {
                    request.getSession().setAttribute("telefonoVacio", "err0r");
                }
                if (port.getErrorConexionCliente() != null) {
                    String strError = port.getErrorConexionCliente();
                    request.getSession().setAttribute("errorCliente", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaCliente.jsp");
                } else {
                    request.getSession().setAttribute("direccionVacio", strDireccion);
                    response.sendRedirect("../interfacesJhano/interfazIngresoCliente.jsp");
                }

            } catch (Exception e) {
                out.print("ERROR: " + e.getMessage());
            }
        %>
    </body>
</html>



