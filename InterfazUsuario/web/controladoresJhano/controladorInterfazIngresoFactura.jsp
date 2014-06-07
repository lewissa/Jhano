<%-- 
    Document   : controladorInterfazIngresoFactura
    Created on : 06-jun-2014, 2:42:26
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.cliente.CCliente"%>
<%@page import="com.lewissa.jhano.logicanegocio.empresa.CEmpresa"%>
<%@page import="java.util.List" %>
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
          List<CProducto> lisProductos = new ArrayList<CProducto>();
        if(request.getParameter("boton").equals("Buscar"))
        {
            if(request.getParameter("ciruc") != null)
            {
                String strCiRuc = request.getParameter("ciruc");
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service service = new com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service();
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente port = service.getWsLogicaNegocioClientePort();
                java.util.List<com.lewissa.jhano.logicanegocio.cliente.CCliente> lisClientes =  port.buscarCliente(strCiRuc);
                request.getSession().setAttribute("lisClientes", lisClientes);
                response.sendRedirect("../InterfacesJhano/interfazIngresoFactura.jsp");
                
            }
            else
            {
                if(request.getParameter("boton") != null)
                {
                    if(request.getParameter("boton").equals("Agregar"))
                    {
                        
                    }
                } 
            }
            
        }
        
       
        }catch (Exception ex)
        {
            out.print(ex.getMessage());
        }
        
    

    %>




    </body>
</html>
