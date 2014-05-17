<%-- 
    Document   : controladorInterfazIngresoFamiliaProducto
    Created on : 09-may-2014, 1:11:34
    Author     : Fredy Janeta
--%>


<%@page import="com.lewissa.jhano.familiaproducto.CCodigoFamiliaProducto"%>
<%@page import="com.lewissa.jhano.familiaproducto.CFamiliaProducto"%>
<%@page import="com.lewissa.jhano.familiaproducto.GetErrorConexionFamiliaProducto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            try {
                String strCodigo = (request.getParameter("codigo").equals("")) ? "0" : request.getParameter("codigo");
                String strDescripcion = (request.getParameter("descripcion").equals("")) ? "0" : request.getParameter("descripcion");
                com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto_Service service = new com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto_Service();
                com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto port = service.getWsLogicaNegocioFamiliaProdcutoPort();
                CFamiliaProducto oFamiliaProdcuto = new CFamiliaProducto();
                CCodigoFamiliaProducto oCodigoFamilia = new CCodigoFamiliaProducto();
                oCodigoFamilia.setStrCodigo(strCodigo);
                java.lang.Boolean booCodigo = port.validarCodigo(oCodigoFamilia);
                oFamiliaProdcuto.setStrId(strCodigo);
                oFamiliaProdcuto.setStrDescripcion(strDescripcion);
                java.lang.Boolean booresult = port.insertarFamiliaProducto(oFamiliaProdcuto);
                
                request.getSession().setAttribute("familia", booresult);
                request.getSession().setAttribute("codigo", booCodigo);
                request.getSession().setAttribute("codigoVacio", strCodigo);
                request.getSession().setAttribute("descripcionVacio", strDescripcion);
                
            if (port.getErrorConexionFamiliaProducto() != null) {
                    String strError = port.getErrorConexionFamiliaProducto();
                    request.getSession().setAttribute("errorFamiliaProducto", strError);
                    response.sendRedirect("../interfacesJhano/interfazConsultaFamiliaProducto.jsp");
                } else {
                    response.sendRedirect("../interfacesJhano/interfazIngresoFamiliaProducto.jsp");
                }

            } catch (Exception e) {
                out.print("ERROR: " + e.getMessage());
            }
        %>
    </body>
</html>
