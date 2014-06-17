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
                 
       CCliente oClienteSeleccionado = new CCliente();
       List<CProducto> listProductosSeleccionados = new ArrayList<CProducto>();
       
       if(request.getParameter("cirucC") != null)
                {
                    oClienteSeleccionado.setStrIdCliente(request.getParameter("cirucC"));
                    oClienteSeleccionado.setStrNombreFiscal(request.getParameter("nombreC"));
                    oClienteSeleccionado.setStrCelular(request.getParameter("telefonoC"));
                    oClienteSeleccionado.setStrDireccion(request.getParameter("direccionC"));
                    request.getSession().setAttribute("clienteSeleccionado", oClienteSeleccionado);
                    
                    if(request.getParameter("fechaC")  != null)
                    request.getSession().setAttribute("fechaC", request.getParameter("fechaC"));
                    
                    if(request.getParameter("idFactura") != null)
                    request.getSession().setAttribute("idFactura", request.getParameter("idFactura"));
                }
       if(request.getParameter("boton") != null)
       {
           if(request.getParameter("boton").equals("Agregar")){
           CProducto oProducto = new CProducto();
           oProducto.setStrDescripcionGeneral(request.getParameter("descripcion"));
           oProducto.setStrEan(request.getParameter("codigoean"));
           oProducto.setIntCantidad(Integer.parseInt(request.getParameter("cantidad")));
           oProducto.setDouPrecioCosto(Double.parseDouble(request.getParameter("vunitario")));
           
           if(request.getParameter("cirucC") != null)
                {

                    oClienteSeleccionado.setStrIdCliente(request.getParameter("cirucC"));
                    oClienteSeleccionado.setStrNombreFiscal(request.getParameter("nombreC"));
                    oClienteSeleccionado.setStrCelular(request.getParameter("telefonoC"));
                    oClienteSeleccionado.setStrDireccion(request.getParameter("direccionC"));
                    request.getSession().setAttribute("clienteSeleccionado", oClienteSeleccionado);
                    
                    if(request.getParameter("fechaC")  != null)
                    request.getSession().setAttribute("fechaC", request.getParameter("fechaC"));
                    
                    if(request.getParameter("idFactura") != null)
                    request.getSession().setAttribute("idFactura", request.getParameter("idFactura"));
                }
                    
           if(request.getSession().getAttribute("listaProductos") != null)
           {
               listProductosSeleccionados = (List<CProducto>) request.getSession().getAttribute("listaProductos");
               //int pos = listProductosSeleccionados.size();
               //listProductosSeleccionados.add(pos, oProducto);
               listProductosSeleccionados.add(oProducto);
           }
           else
           {
               listProductosSeleccionados.add(oProducto);
           }

           
           request.getSession().setAttribute("listaProductos", listProductosSeleccionados);
           
           
           response.sendRedirect("../interfacesJhano/interfazIngresoFactura.jsp");
           }
           
       }
       
       if(request.getParameter("boton") != null)
       {
           if(request.getParameter("boton").equals("Guardar"))
           {
               response.sendRedirect("../interfacesJhano/interfazCargaFactura.jsp");
           }
       }
          
        if(request.getParameter("accion").equals("BuscarCliente"))
        {
            if(request.getParameter("parametroCliente") != null)
            {
                String strParametro = request.getParameter("parametroCliente");
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service service = new com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente_Service();
                com.lewissa.jhano.logicanegocio.cliente.WsLogicaNegocioCliente port = service.getWsLogicaNegocioClientePort();
                java.util.List<com.lewissa.jhano.logicanegocio.cliente.CCliente> lisClientes =  port.buscarCliente(strParametro);
                request.getSession().setAttribute("lisClientes", lisClientes);
                request.getSession().setAttribute("parametroCliente", strParametro);
                response.sendRedirect("../interfacesJhano/interfazIngresoFactura.jsp");
                
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
            
            
       if(request.getParameter("accion").equals("BuscarProducto"))
        {
            if(request.getParameter("parametroProducto") != null)
            {
                String strParametroProducto = request.getParameter("parametroProducto");

                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();

                java.util.List<com.lewissa.jhano.logicanegocio.producto.CProducto> lisProductos = port.buscarProducto(strParametroProducto);
  
                
                request.getSession().setAttribute("lisProductos", lisProductos);
                request.getSession().setAttribute("parametroProducto", strParametroProducto);
                
                if(request.getParameter("cirucC") != null)
                {

                    oClienteSeleccionado.setStrIdCliente(request.getParameter("cirucC"));
                    oClienteSeleccionado.setStrNombreFiscal(request.getParameter("nombreC"));
                    oClienteSeleccionado.setStrCelular(request.getParameter("telefonoC"));
                    oClienteSeleccionado.setStrDireccion(request.getParameter("direccionC"));
                    request.getSession().setAttribute("clienteSeleccionado", oClienteSeleccionado);
                    
                    if(request.getParameter("fechaC")  != null)
                    request.getSession().setAttribute("fechaC", request.getParameter("fechaC"));
                    
                    if(request.getParameter("idFactura") != null)
                    request.getSession().setAttribute("idFactura", request.getParameter("idFactura"));
                }
                response.sendRedirect("../interfacesJhano/interfazIngresoFactura.jsp");
                
                
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
            
        
        
        if(request.getParameter("accion").equals("SeleccionCliente"))
        {
            if(request.getParameter("parametroIdCliente") != null)
            {
                String strParametroProducto = request.getParameter("parametroIdCliente");

                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();

                java.util.List<com.lewissa.jhano.logicanegocio.producto.CProducto> lisProductos = port.buscarProducto(strParametroProducto);
           
                request.getSession().setAttribute("lisProductos", lisProductos);
                request.getSession().setAttribute("parametroProducto", strParametroProducto);
                response.sendRedirect("../interfacesJhano/interfazIngresoFactura.jsp");
                
            }
            
            
        }
        

        

       
       
        
        
       
        }catch (Exception ex)
        {
            out.print(ex.getMessage());
        }
        
    

    %>




    </body>
</html>
