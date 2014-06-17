<%-- 
    Document   : ControladorElimiarProveedor
    Created on : 20-may-2014, 6:18:31
    Author     : Usuario
--%>

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
                String strCodigo=null;
                if((request.getParameter("accion") != null) && (request.getParameter("accion").equals("Cancelar")))
                {
                    request.getSession().setAttribute("errorEliminacion", null);
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                }
                
                if((request.getParameter("accion") != null)&&(request.getParameter("accion").equals("Aceptar")))
                {
                    intTipoEliminacion=0;
                    request.getSession().setAttribute("errorEliminacion", null);
                    strCodigo=(String)request.getSession().getAttribute("id");
                }else
                {
                    strCodigo = request.getParameter("id");
                }
                
                com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service service = new com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service();
                com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor port = service.getWsLogicaNegocioProveedorPort();
                
                com.lewissa.jhano.logicanegocio.proveedor.CProveedor oProveedor = new CProveedor();
                
                oProveedor.setId(strCodigo);
                
               
                java.lang.Boolean booResultadoEliminacion = port.eliminarProveedor(oProveedor, intTipoEliminacion);
                if(port.getErrorConexionProveedor() != null)
                {
                    String strError = port.getErrorConexionProveedor();
                    request.getSession().setAttribute("errorProveedor", strError);
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                }
                
                if(booResultadoEliminacion == true)
                {
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                }
                else
                {
                    request.getSession().setAttribute("errorEliminacion", booResultadoEliminacion);
                    request.getSession().setAttribute("codigoElimando",strCodigo );
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                }
                
            } catch (Exception ex) {
                
            }
        %>

    </body>
</html>
