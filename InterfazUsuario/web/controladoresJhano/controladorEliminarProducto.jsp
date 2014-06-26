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
                java.lang.Integer intTipoEliminacion = Integer.valueOf(1);
                String strCodigo = null;
                if ((request.getParameter("accion") != null) && (request.getParameter("accion").equals("Cancelar"))) {
                    request.getSession().setAttribute("errorEliminacionProducto", null);
                    response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                }
                if ((request.getParameter("accion") != null)&&(request.getParameter("accion").equals("Aceptar"))) {
                    intTipoEliminacion = 0;
                    request.getSession().setAttribute("errorEliminacionProducto", null);
                    strCodigo = (String) request.getParameter("id");
                } else {
                    strCodigo = (String) request.getParameter("id");
                }

                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();

                Boolean booResultadoEliminacion = port.eliminarProducto(strCodigo, intTipoEliminacion);
                if (port.getErrorConexionProducto() != null) {
                    String strError = port.getErrorConexionProducto();
                    request.getSession().setAttribute("errorProducto", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                }

                if (booResultadoEliminacion == true) {
                    response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                } else {
                    request.getSession().setAttribute("errorEliminacionProducto", booResultadoEliminacion);
                    request.getSession().setAttribute("codigoElimandoProducto", strCodigo);
                    response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                }

            } catch (Exception ex) {

            }
        %>

    </body>
</html>
