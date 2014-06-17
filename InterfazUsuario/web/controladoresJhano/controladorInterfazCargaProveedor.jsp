<%-- 
    Document   : controladorInterfazCargaProveedor
    Created on : 26-may-2014, 22:14:43
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service service = new com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service();
	com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor port = service.getWsLogicaNegocioProveedorPort();
	// TODO process result here
	java.util.List<com.lewissa.jhano.logicanegocio.proveedor.CProveedor> listProveedores = port.cargaProveedor();
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
