<%-- 
    Document   : interfazCargaPagos
    Created on : 12/06/2014, 07:28:24 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Pagos </title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <table bgcolor="#192B75" width="100%" height="50%" border="1">
            <tr>
                <td>
                    <img src="Image/computech.jpg" alt="espoch" />
                </td>
                <td width="780">
                    <center>
                        <font color="#FFFFFF" size="+6" face="Arial, Helvetica, sans-serif">
                            Computech
                        </font><br/>
                        <h3>
                            <font color="#FFFFFF" face="Arial">
                                Soluciones en Tecnolog�a Computacional
                            </font>
                        </h3>
                    </center></td>
                <td align="center" rowspan="2">
                    <table border="1" width="90%" height="90%">
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
                                        Hora de inicio de sesi�n
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
                                        Cerrar Sesi�n
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
                                    <a href="#"><center>Productos</center></a>
                                </font>
                                <ul>
                                    <font face="Arial">
                                        <a href="../interfacesJhano/interfazCargaFamiliaProducto.jsp"><center>Familias</center></a>
                                    </font>
                                </ul>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="#"><center>Facturas</center></a>
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

        <table bgcolor="#C0C0C0" width="100%" height="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="0,1" align="left">
                        <tr>
                            <td>
                                <a href="#">
                                    <font face="Arial">
                                        Ingreso
                                    </font>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#">
                                    <font face="Arial">
                                        Consulta
                                    </font>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="../index.jsp">
                                    <a href="../index.jsp">
                                        <font face="Arial">
                                            Regresar
                                        </font>
                                    </a>
                            </td>
                        </tr>
                    </table>

                    <td width="88%">
                        <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Pago de Facturas</font></center></h3>
                        <form name="frmCargarPagos" action="../controladoresJhano/controladorInterfazCargaPago.jsp" method="post" >
                            <table width="700" align="center" border="1" bgcolor="white">
                                <tr>
                                    <td width="100" align="center">Identificador</td>
                                    <td width="100" align="center">Monto</td>
                                    <td width="100" align="center">Fecha de Pago</td>
                                    <td width="100" align="center">Forma de Pago</td>
                                    <td width="100" align="center">Factura</td>
                                    <td width="150" align="center" colspan="2">Acciones</td>

                                </tr>
                                <%
                                    String strCarga = (request.getParameter("car") != null) ? "true" : "false";
                                    if (strCarga.equals("false")) {
                                        response.sendRedirect("../controladoresJhano/controladorInterfazCargaPago.jsp");
                                    }
                                    List<com.lewissa.jhano.logicanegocio.pago.CPago> lispagos = (List<com.lewissa.jhano.logicanegocio.pago.CPago>) request.getSession().getAttribute("pagos");
                                    if (lispagos != null) {
                                        for (com.lewissa.jhano.logicanegocio.pago.CPago pago : lispagos) {
                                            out.print("<tr>");
                                            out.print("  <td>" + pago.getIntIdPago() + "</td>");
                                            out.print("  <td align=\"right\">" + pago.getDouMontoReal() + "</td>");
                                            out.print("  <td>" + pago.getStrFechaPago() + "</td>");
                                            out.print("  <td>" + pago.getIntFormaPago() + "</td>");
                                            out.print("  <td>" + pago.getStrFacturaPago() + "</td>");
                                            out.print("  <td>Modificar</td>");
                                            out.print("  <td>Eliminar</td>");
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
                                        out.print("  <td></td>");
                                        out.print("</tr>");
                                    }
                                %>

                            </table>

                    </td>
                    <%
                        //}
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

