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
            com.lewissa.jhano.proveedor.ws.CProveedor provProve=new com.lewissa.jhano.proveedor.ws.CProveedor();
            if (request.getParameter("submit")!= null) {
                //out.print("he llegado");}
                provProve.setId(request.getParameter("ciruc"));
                provProve.setNombreFiscal(request.getParameter("nombrefiscal"));
                provProve.setNombreComercial(request.getParameter("nombrecomer"));
                provProve.setDireccion(request.getParameter("direccion"));
                provProve.setConvencional(request.getParameter("convencional"));
                provProve.setCelular(request.getParameter("celular"));
                provProve.setCorreo(request.getParameter("correo"));
                //out.print(provProve.getId());
                cCedula cedVal = new cCedula(provProve.getId());
                cRuc rucVal = new cRuc(provProve.getId());
                cCorreo corVal = new cCorreo(provProve.getCorreo());
                if ((cedVal.validaCedula()) || (rucVal.validaRuc())) {
                    if (corVal.validaEmail()) {
                        com.lewissa.jhano.proveedor.ws.WsProveedor_Service service = new com.lewissa.jhano.proveedor.ws.WsProveedor_Service();
                        com.lewissa.jhano.proveedor.ws.WsProveedor port = service.getWsProveedorPort();
                        port.insertaProveedor(provProve);
                        request.getSession().setAttribute("sesprov", null);
                        //response.sendRedirect("interfazIngresoProveedor.jsp");
                    } else {
                        out.println("Correo Incorrecto");
                        request.getSession().setAttribute("sesprov", provProve);
                        //response.sendRedirect("interfazIngresoProveedor.jsp");
                    }
                } else {
                    out.println("Cédula o RUC Incorrectos");
                    request.getSession().setAttribute("sesprov", provProve);
                    //response.sendRedirect("interfazIngresoProveedor.jsp");
                }
            }
            else
            {
                out.print("no he llegado");
            }
        %>
    </body>
</html>
