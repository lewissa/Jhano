<%-- 
    Document   : controladorInterfazIngresoFamiliaProducto
    Created on : 09-may-2014, 1:11:34
    Author     : Fredy Janeta
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.lewissa.jhano.familiaproducto.CFamiliaProducto" %>
<%@page import="com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto_Service" %>
<%@page import="com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto" %>
<%@page import="com.lewissa.jhano.familiaproducto.InsertarFamiliaProducto" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
              <%-- start web service invocation --%><hr/>
    <%
    try {
	com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto_Service service = new com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto_Service();
	com.lewissa.jhano.familiaproducto.WsLogicaNegocioFamiliaProdcuto port = service.getWsLogicaNegocioFamiliaProdcutoPort();
	 // TODO initialize WS operation arguments here
	com.lewissa.jhano.familiaproducto.CFamiliaProducto oFamiliaProducto = new CFamiliaProducto();
	// TODO process result here
        String strId=request.getParameter("codigo");
        String strDes=request.getParameter("descripcion");
        oFamiliaProducto.setStrId(strId);
        oFamiliaProducto.setStrDescripcion(strDes);
	java.lang.Boolean result = port.insertarFamiliaProducto(oFamiliaProducto);
        if(result)
            response.sendRedirect("../controladoresJhano/controladorInterfazIngresoFamiliaProducto.jsp");
	
    } catch (Exception ex) {
	
    }
    %>
    <%-- end web service invocation --%><hr/>


    </body>
</html>
