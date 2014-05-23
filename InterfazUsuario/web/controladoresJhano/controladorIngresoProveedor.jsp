<%-- 
    Document   : controlador.jsp
    Created on : 09/04/2014, 04:47:58 AM
    Author     : ECORAE
--%>

<%@page import="com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service"%>
<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CProveedor"%>
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
                com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service service = new WsLogicaNegocioProveedor_Service();
                com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor port = service.getWsLogicaNegocioProveedorPort();// TODO initialize WS operation arguments here
                CProveedor proProveedor = new CProveedor();
                if (strCelular.equals("0")) {
                   proProveedor.setCelular("");
                } else {
                    proProveedor.setCelular(strCelular);
                }
                if (strConvencional.equals("0")) {
                    proProveedor.setConvencional("");
                } else {
                    proProveedor.setConvencional(strConvencional);
                }
                proProveedor.setCorreo(strCorreo);
                proProveedor.setDireccion(strDireccion);
                if (strNombrecomer.equals("0")) {
                    proProveedor.setNombreComercial("");
                } else {
                    proProveedor.setNombreComercial(strNombrecomer);
                }
                proProveedor.setNombreFiscal(strNombrefiscal);
                proProveedor.setId(strCiruc);
                // TODO process result here
                java.lang.Boolean booresult = port.actualizaDataBaseProveedor(proProveedor);
                java.lang.Boolean booCorreo = port.validaCorreo(request.getParameter("correo"));
                java.lang.Boolean booCedula = port.validaCedula(request.getParameter("ciruc"));
                java.lang.Boolean booRuc = port.validaRuc(request.getParameter("ciruc"));

                request.getSession().setAttribute("proveedor", booresult);
<<<<<<< HEAD
                request.getSession().setAttribute("correoProveedor", booCorreo);
                request.getSession().setAttribute("cedulaProveedor", booCedula);
                request.getSession().setAttribute("rucProveedor", booRuc);
                request.getSession().setAttribute("correoVacioProveedor", strCorreo);
                request.getSession().setAttribute("cedulaVacioProveedor", strCiruc);
                request.getSession().setAttribute("rucVacioProveedor", strCiruc);
                request.getSession().setAttribute("nombreComercialVacioProveedor", strNombrecomer);
                request.getSession().setAttribute("nombreFiscalVacioProveedor", strNombrefiscal);
                try {
                    Integer intControl = Integer.parseInt(strCelular);
                    request.getSession().setAttribute("celularVacioProveedor", strCelular);
                } catch (Exception e) {
                    request.getSession().setAttribute("celularVacioProveedor", "err0r");
                }
                try {
                    Integer intControl = Integer.parseInt(strConvencional);
                    request.getSession().setAttribute("telefonoVacioProveedor", strConvencional);
                } catch (Exception e) {
                    request.getSession().setAttribute("telefonoVacioProveedor", "err0r");
=======
                request.getSession().setAttribute("correo", booCorreo);
                request.getSession().setAttribute("cedula", booCedula);
                request.getSession().setAttribute("ruc", booRuc);
                request.getSession().setAttribute("correoVacio", strCorreo);
                request.getSession().setAttribute("cedulaVacio", strCiruc);
                request.getSession().setAttribute("rucVacio", strCiruc);
                request.getSession().setAttribute("nombreComercialVacio", strNombrecomer);
                request.getSession().setAttribute("nombreFiscalVacio", strNombrefiscal);
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
>>>>>>> 0603c79e9ac0eb544a069588d3157d129ddce80b
                }
                if (port.getErrorConexionProveedor()!= null) {
                    String strError = port.getErrorConexionProveedor();  
                    request.getSession().setAttribute("errorProveedor", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                } else {
                    request.getSession().setAttribute("direccionVacio", strDireccion);
                    response.sendRedirect("../interfacesJhano/interfazIngresoProveedor.jsp");
                }

            } catch (Exception e) {
                out.print("ERROR: " + e.getMessage());
            }
        %>
    </body>
</html>


  
