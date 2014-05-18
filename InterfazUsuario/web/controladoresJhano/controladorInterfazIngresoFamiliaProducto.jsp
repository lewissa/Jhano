<%-- 
    Document   : controladorInterfazIngresoFamiliaProducto
    Created on : 09-may-2014, 1:11:34
    Author     : Fredy Janeta
--%>


<%@page import="com.lewissa.jhano.familiaproducto.CCodigoFamiliaProducto"%>
<%@page import="com.lewissa.jhano.familiaproducto.CFamiliaProducto"%>
<%@page import="com.lewissa.jhano.familiaproducto.ValidarCodigo" %>
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
                com.lewissa.jhano.familiaproducto.CFamiliaProducto oFamiliaProdcuto = new CFamiliaProducto();
                com.lewissa.jhano.familiaproducto.CCodigoFamiliaProducto oCodigoFamilia = new CCodigoFamiliaProducto();
                java.lang.Boolean booCodigo;
                try {
                    
                    oCodigoFamilia.setStrCodigo(strCodigo);
                     booCodigo = port.validarCodigo(oCodigoFamilia);
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
                oFamiliaProdcuto.setStrId(strCodigo);
                oFamiliaProdcuto.setStrDescripcion(strDescripcion);
                java.lang.Boolean booresult = port.insertarFamiliaProducto(oFamiliaProdcuto);

                request.getSession().setAttribute("familia", booresult);
               // request.getSession().setAttribute("codigo", booCodigo);
                request.getSession().setAttribute("codigoVacio", strCodigo);
                request.getSession().setAttribute("descripcionVacio", strDescripcion);

                response.sendRedirect("../interfacesJhano/interfazIngresoFamiliaProducto.jsp");

                if (port.getErrorConexionFamiliaProducto() != null) {
                    String resultError = port.getErrorConexionFamiliaProducto();
                    response.sendRedirect("../erroresJhano/errorConexionDataBase.jsp?" + resultError);
                } else {
                    response.sendRedirect("../interfacesJhano/interfazIngresoCliente.jsp");
                }

            } catch (Exception e) {
                out.print("ERROR: " + e.getMessage());
            }
        %>
    </body>
</html>
