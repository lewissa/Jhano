<%-- 
    Document   : controladorModificarProveedor
    Created on : 29-may-2014, 14:50:15
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
            try{
              com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service service = new com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service();
              com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor port = service.getWsLogicaNegocioProveedorPort();
              
            
              String strId= request.getParameter("id").equals("") ? "0" : request.getParameter("id");
              String strnomnreF= request.getParameter("nombreF").equals("") ? "0" : request.getParameter("nombreF");
              String strnombreC= request.getParameter("nombreC").equals("") ? "0" : request.getParameter("nombreC");
              String strDireccion= request.getParameter("direccion").equals("") ? "0" : request.getParameter("direccion");
              String strConvencional= request.getParameter("telefonoCon").equals("") ? "0" : request.getParameter("telefonoCon");
              String strCelular= request.getParameter("telefonoCel").equals("") ? "0" : request.getParameter("telefonoCel");
              String strCorreo= request.getParameter("correo").equals("") ? "0" : request.getParameter("correo"); 
              
              CProveedor oProveedor = new CProveedor();              
              oProveedor.setId(strId);
              oProveedor.setNombreFiscal(strnomnreF);
              oProveedor.setNombreComercial(strnombreC);
              oProveedor.setDireccion(strDireccion);
              oProveedor.setConvencional(strConvencional);
              oProveedor.setCelular(strCelular);
              oProveedor.setCorreo(strCorreo);
                          
              request.getSession().setAttribute("oProveedor", oProveedor);
              
              if(strnomnreF.equals("0") || strCorreo.equals("0"))
              {
                 response.sendRedirect("../interfacesJhano/interfazModificarProveedor.jsp");
              }
              
              
              
              if(port.getErrorConexionProveedor() != null)
              {
                  String strError = port.getErrorConexionProveedor();
                  request.getSession().setAttribute("errorProveedor", strError);
                  response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
              }   
                            
              java.lang.Boolean booCorreo = port.validaCorreo(oProveedor.getCorreo());
              
              if(booCorreo == true)
              {
                  java.lang.Boolean booResultadoModificarcion = port.modificarProveedor(oProveedor);
                  response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
              }
              else
              {
                  if(booCorreo == false)
                  {
                     request.getSession().setAttribute("errorCorreo", booCorreo);
                     response.sendRedirect("../interfacesJhano/interfazModificarProveedor.jsp");
                  }
              }
              
              }catch(Exception ex)
              {
                  ex.getMessage();
              }
        %>
    </body>
</html>
