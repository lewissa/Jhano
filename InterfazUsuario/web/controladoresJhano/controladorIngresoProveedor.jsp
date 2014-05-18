<%-- 
    Document   : controladorIngresoProveedor
    Created on : 09/05/2014, 05:37:57 PM
    Author     : Usuario
--%>

<%@page import="com.lewissa.jhano.utilidades.cCorreo"%>
<%@page import="com.lewissa.jhano.utilidades.cRuc"%>
<%@page import="com.lewissa.jhano.utilidades.cCedula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //String strId, strNombFisc, strNombComer, strDireccion, strConvencional, strCeular, strCorreo;
            try
            {
            com.lewissa.jhano.proveedor.CProveedor provProve=new com.lewissa.jhano.proveedor.CProveedor();
            if (request.getParameter("submit")!= null) {
                provProve.setId(request.getParameter("ciruc"));
                provProve.setNombreFiscal(request.getParameter("nombrefiscal"));
                provProve.setNombreComercial(request.getParameter("nombrecomer"));
                provProve.setDireccion(request.getParameter("direccion"));
                provProve.setConvencional(request.getParameter("convencional"));
                provProve.setCelular(request.getParameter("celular"));
                provProve.setCorreo(request.getParameter("correo"));
                cCedula cedVal = new cCedula(provProve.getId());
                cRuc rucVal = new cRuc(provProve.getId());
                cCorreo corVal = new cCorreo(provProve.getCorreo());
                if ((cedVal.validaCedula()) || (rucVal.validaRuc())) {
                    if (corVal.validaEmail()) {
                        if(!provProve.getNombreFiscal().equals("")){
                        request.getSession().setAttribute("sesprov", null);
                        com.lewissa.jhano.proveedor.WsProveedor_Service service = new com.lewissa.jhano.proveedor.WsProveedor_Service();
                        com.lewissa.jhano.proveedor.WsProveedor port = service.getWsProveedorPort();
                        if(port.insertaProveedor(provProve))
                        {
                            %>
                            <script language="javascript"> 
                                allert("Proveedor Ingresado Correctamente");
                                location.href ="../interfacesJhano/interfazIngresoProveedor.jsp";
                            </script>
                            <%
                        }
                        else
                        {
                             %>
                            <script language="javascript"> 
                                allert("ERROR desconocido ggg");
                                location.href ="../interfacesJhano/interfazIngresoProveedor.jsp";
                            </script>
                            <%
                        }
                        }
                        else
                        {
                            request.getSession().setAttribute("sesprov", provProve);
                            //response.sendRedirect("../interfacesJhano/interfazIngresoProveedor.jsp");
                            %>
                            <script languaje="javascript">
                                alert("Nombre Fiscal Obligatorio");
                                location.href ="../interfacesJhano/interfazIngresoProveedor.jsp";
                            </script>
                            <%
                            //out.println("Nombre Fiscal Obligatorio");
                            
                        }
                    } else {
                        request.getSession().setAttribute("sesprov", provProve);
                            //response.sendRedirect("../interfacesJhano/interfazIngresoProveedor.jsp");
                            %>
                            <script languaje="javascript">
                                alert("Correo Incorrecto");
                                location.href ="../interfacesJhano/interfazIngresoProveedor.jsp";
                            </script>
                            <%
                            //out.println("Correo Incorrecto");
                            
                    }
                } else {
                    request.getSession().setAttribute("sesprov", provProve);
                            //response.sendRedirect("../interfacesJhano/interfazIngresoProveedor.jsp");
                            %>
                            <script languaje="javascript">
                                alert("Cedula o RUC incorrecto");
                                location.href ="../interfacesJhano/interfazIngresoProveedor.jsp";
                            </script>
                            <%
                            //out.println("Cedula o RUC incorrecto");
                }
            }
            else
            {
                out.print("no he llegado");
            }
            }catch (Exception e) {
                out.print("ERROR: " + e.getMessage());
            }
        %>
    </body>
</html>
