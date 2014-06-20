<%-- 
    Document   : interfazCargaFactura
    Created on : 13/06/2014, 05:09:25 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Factura </title>
        <link href="SpryAssets/estilo.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="functions.js"></script>
        <script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="../SpryAssets/SpryMenuBarHorizontalw.css" rel="stylesheet" type="text/css" />
        <link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <table style="background-color: #002a80; border: #f9f9f9" bgcolor="#192B75" width="100%" height="50%" border="1">
            <tr>
                <td>
                    <a href="../index.jsp">
                        <img src="Image/computech.jpg" alt="espoch" />
                    </a>
                </td>
                <td width="780">
                    <center>
                        <font color="#FFFFFF" size="+6" face="Arial, Helvetica, sans-serif">
                            Computech
                        </font><br/>
                        <h3>
                            <font color="#FFFFFF" face="Arial">
                                Soluciones en Tecnología Computacional
                            </font>
                        </h3>
                    </center></td>
                <td align="center" rowspan="2">
                    <table style="border: #f9f9f9"  border="1" width="90%" height="90%">
                        <tr>
                            <td width="50%" height="10%">
                                <center>
                                    <font color="#FFFFFF" face="Arial">
                                        Nombre de usuario
                                    </font>
                                </center>
                            </td>
                            <td width="50%" height="10%">
                                <center>
                                    <font color="#FFFFFF" face="Arial">
                                        Hora de inicio de sesión
                                    </font>
                                </center>
                            </td>
                        </tr>
                        <tr>
                            <td height="55%" colspan="2">
                                <center>
                                    <img src="Image/lewis.jpg" alt="espoch" width="60px" height="62px" align="middle" />
                                </center>
                            </td>
                        </tr>
                        <tr>
                            <td width="50%" height="10%">
                                <center>
                                    <font color="#FFFFFF" face="Arial">
                                        Perfil
                                    </font>
                                </center>
                            </td>
                            <td width="50%" height="10%">
                                <center>
                                    <font color="#FFFFFF" face="Arial">
                                        Cerrar Sesión
                                    </font>
                                </center>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="41" colspan="2"><div align="center">
                        <ul id="MenuBar2" class="MenuBarHorizontal">
                            <li>
                                <font face="Arial">
                                    <a href="../interfacesJhano/interfazCargaCliente.jsp"><center>Clientes</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="../interfacesJhano/interfazCargaProveedor.jsp"><center>Proveedores</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="../interfacesJhano/interfazCargaProducto.jsp"><center>Productos</center></a>
                                </font>
                                <ul>
                                    <font face="Arial">
                                        <a href="../interfacesJhano/interfazCargaFamiliaProducto.jsp"><center>Familias</center></a>
                                    </font>
                                </ul>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="../interfacesJhano/interfazCargaFactura.jsp"><center>Facturas</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="#"><center>Proformas</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="#"><center>Usuarios</center></a>
                                </font>
                            </li>
                        </ul>
                    </div>
                </td>
            </tr>
        </table>

        <table style="background-color: #999999; border-color: #f9f9f9" bgcolor="#C0C0C0" width="100%" height="100%" border="1">
            <tr>
                <td width="12%">

                    <table style="background-color: #999999; border-color: #f9f9f9">                             
                        <tr>
                            <th><div>                         
                                    <ul id="MenuBar2" class="MenuBarHorizontalw">
                                        <li>
                                            <font face="Arial">
                                                <a href="../interfacesJhano/interfazIngresoFactura.jsp">Ingreso</center></a>
                                            </font>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <font face="Arial">
                                                    Consulta
                                                </font>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="../index.jsp">
                                                <font face="Arial">
                                                    Regresar
                                                </font>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="../controladoresJhano/controladorReportePago.jsp">
                                                <font face="Arial">
                                                    Pagos Pendientes
                                                </font>
                                            </a>
                                        </li>
                                    </ul>                               
                            </th>
                        </tr>                     
                    </table>
                    <td width="88%">
                        <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Factura</font></center></h3>
                        <form name="frmCargarFacturas" action="../controladoresJhano/controladorInterfazCargarFactura.jsp" method="post" >
                            <table width="1000" align="center" border="1" bgcolor="white">
                                <tr>
                                    <td width="150" align="center" bgcolor="#C0C0C0">Número de Factura</td>
                                    <td width="100" align="center" bgcolor="#C0C0C0">Fecha</td>
                                    <td width="400" align="center" bgcolor="#C0C0C0">Cliente</td>
                                    <td width="100" align="center" bgcolor="#C0C0C0">Valor Total</td>
                                    <td width="150" align="center" colspan="2" bgcolor="#C0C0C0">Acciones</td>

                                </tr>
                                <%
                                    String strCarga = (request.getParameter("car") != null) ? "true" : "false";
                                    if (strCarga.equals("false")) {
                                        response.sendRedirect("../controladoresJhano/controladorInterfazCargarFactura.jsp");
                                    }
                                    List<com.lewissa.jhano.logicanegocio.factura.CFactura> factura = (List<com.lewissa.jhano.logicanegocio.factura.CFactura>) request.getSession().getAttribute("facturas");
                                    if (factura != null) {
                                        for (com.lewissa.jhano.logicanegocio.factura.CFactura oFact : factura) {
                                            out.print("<tr>");
                                            out.print("  <td bgcolor=\"#FFF\">" + oFact.getStrIdFactura() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">" + oFact.getStrFechaFactura() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">" + oFact.getStrClienteFactura() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\" align=\"right\" >" + oFact.getDouTotalFactura() + "</td>");
                                            out.print("  <td width=\"75\" >Modificar</td>");
                                            out.print("  <td bgcolor=\"#FFF\"><a href=\".../interfacesJhano/interfazCargaPagos.jsp\">Pago<a></th>");
                                            //out.print("  <td><a href='../controladoresJhano/controladorEliminarCliente.jsp?accion=delete&id=" + cliente.getStrIdCliente() + "'>Eliminar</a></td>");
                                            out.print("</tr>");
                                        }
                                    } else {
                                        out.print("<tr>");
                                        out.print("  <td></td>");
                                        out.print("  <td></td>");
                                        out.print("  <td></td>");
                                        out.print("  <td></td>");
                                        out.print("  <td></td>");
                                        out.print("  <td></td>");
                                        out.print("</tr>");
                                    }
                                %>

                            </table>

                    </td>
                    <%

                    %>

                </td>
            </tr>
        </table>

        <script type="text/javascript">
            var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
            var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
        </script>
    </body>
</html>