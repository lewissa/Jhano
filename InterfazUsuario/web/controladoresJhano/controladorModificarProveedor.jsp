<%-- 
    Document   : controladorModificarProveedor
    Created on : 29-may-2014, 14:50:15
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CNumeroCelular"%>
<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CNumeroConvencional"%>
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
              java.lang.Boolean booResultadoModificarcion=null;
            
              String strId= request.getParameter("id");
              String strnomnreF= request.getParameter("nombreF").equals("") ? null : request.getParameter("nombreF");
              String strnombreC= request.getParameter("nombreC").equals("") ? null : request.getParameter("nombreC");
              String strDireccion= request.getParameter("direccion").equals("") ? null : request.getParameter("direccion");
              String strConvencional= request.getParameter("telefonoCon").equals("") ? null : request.getParameter("telefonoCon");
              String strCelular= request.getParameter("telefonoCel").equals("") ? null : request.getParameter("telefonoCel");
              String strCorreo= request.getParameter("correo").equals("") ? null : request.getParameter("correo"); 
              
              java.lang.Boolean booCorreo = null;
              java.lang.Boolean booConvencional=null;
              java.lang.Boolean booCelular=null;              
              
              CProveedor oProveedor = new CProveedor();              
              oProveedor.setId(strId);
              oProveedor.setNombreFiscal(strnomnreF);
              oProveedor.setNombreComercial(strnombreC);
              oProveedor.setDireccion(strDireccion);
              oProveedor.setConvencional(strConvencional);
              oProveedor.setCelular(strCelular);
              oProveedor.setCorreo(strCorreo);
                          
              request.getSession().setAttribute("oProveedor", oProveedor);
              
         
              if(port.getErrorConexionProveedor() != null)
             {
                  String strError = port.getErrorConexionProveedor();
                  request.getSession().setAttribute("errorProveedor", strError);
                  response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
              }
              
              if((strConvencional != null))
              {
                  CNumeroConvencional oNumeroConvencional = new CNumeroConvencional();
                  oNumeroConvencional.setStrNumeroConvencional(strConvencional);
                  booConvencional = port.validarNumeroConvencional(oNumeroConvencional);
              }
              
              if((strCelular != null))
              {
                  CNumeroCelular oNumeroCelular = new CNumeroCelular();
                  oNumeroCelular.setStrNumeroCelular(strCelular);
                  booCelular = port.validarNumeroCelular(oNumeroCelular);
              }
              
                           
              if((strCorreo != null))
              {
                  booCorreo = port.validaCorreo(oProveedor.getCorreo()); 
              }             

              request.getSession().setAttribute("errorCorreo", booCorreo);
              request.getSession().setAttribute("errorCelular", booCelular);
              request.getSession().setAttribute("errorConvencional", booConvencional);
              
              if(strCorreo == null)
              {
                booResultadoModificarcion = port.modificarProveedor(oProveedor);
              }
              else
              {
                  if(booCorreo == true)
                  {
                      booResultadoModificarcion = port.modificarProveedor(oProveedor);
                  }else
                  {
                      response.sendRedirect("../interfacesJhano/interfazModificarProveedor.jsp");
                  }
              }
              
                  if(booResultadoModificarcion == true)
                  {
                    response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                  }
                  else
                  {
                    response.sendRedirect("../interfacesJhano/interfazModificarProveedor.jsp");
                  }
              
              
              
              }catch(Exception ex)
              {
                  System.out.print(ex.getMessage());
              }
        %>
    </body>
</html>
