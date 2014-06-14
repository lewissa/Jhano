<%-- 
    Document   : controladorInterfazIngresoFamiliaProducto
    Created on : 09-may-2014, 1:11:34
    Author     : Fredy Janeta
--%>


<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.portComponentRefType"%>
<%@page import="com.lewissa.jhano.logicanegocio.familiaproducto.CCodigoFamiliaProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service"%>
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
                com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service service = new com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service();
                com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto port = service.getWsLogicaNegocioFamiliaProductoPort();
                com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto oFamiliaProducto = new com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto();
                com.lewissa.jhano.logicanegocio.familiaproducto.CCodigoFamiliaProducto oCodigoFamilia = new com.lewissa.jhano.logicanegocio.familiaproducto.CCodigoFamiliaProducto();
                oCodigoFamilia.setStrCodigo(strCodigo);
                java.lang.Boolean booCodigo = port.validarCodigo(oCodigoFamilia);
                oFamiliaProducto.setStrId(strCodigo);
                oFamiliaProducto.setStrDescripcion(strDescripcion);
                java.lang.Boolean booresult = port.insertarFamiliaProducto(oFamiliaProducto);
                request.getSession().setAttribute("familia", booresult);
                request.getSession().setAttribute("codigo", booCodigo);
                request.getSession().setAttribute("codigoVacio", strCodigo);
                request.getSession().setAttribute("descripcionVacio", strDescripcion);

                if (port.getErrorConexionFamiliaProducto() != null) {
                    java.lang.String strError = port.getErrorConexionFamiliaProducto();
                    request.getSession().setAttribute("errorFamiliaProducto", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaFamiliaProducto.jsp");

                } else {
                    if(booresult == true)
                    {
                        response.sendRedirect("../interfacesJhano/interfazCargaFamiliaProducto.jsp");
                    }
                    else{
                        response.sendRedirect("../interfacesJhano/interfazIngresoFamiliaProducto.jsp");
                    }
                }

            } catch (Exception e) {
                out.println(e.getMessage());
                
            }
        %>
    </body>
</html>
