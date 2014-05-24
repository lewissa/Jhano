<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Menú Producto </title>
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
                                Soluciones en Tecnología Computacional
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
                                    <a href="#"><center>Clientes</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="#"><center>Proveedores</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="#"><center>Productos</center></a>
                                </font>
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
                <td border="0.1"width="12%">
                    <table align="left">
                        <tr> 
                            <td>
                                <a href="../interfacesJhano/interfazIngresoProducto.jsp">
                                    <label>
                                        <font face="Arial">
                                            Ingreso
                                        </font>
                                    </label>
                                </a> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="">
                                    <label>
                                        <font face="Arial">
                                            Consulta
                                        </font>
                                    </label>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="">
                                    <label>
                                        <font face="Arial">
                                            Inicio
                                        </font>
                                    </label>
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <%
                        String strCancelar;
                        try {
                            strCancelar = (request.getParameter("can") != null) ? "true" : "false";
                        } catch (Exception excError) {
                            strCancelar = "false";
                        }
                        if (strCancelar.equals("true")) {
                            request.getSession().setAttribute("producto", false);
                            request.getSession().setAttribute("eanProductoVacio", null);
                            request.getSession().setAttribute("fabricacionProductoVacio", null);
                            request.getSession().setAttribute("descripcionGeneralProductoVacio", null);
                            request.getSession().setAttribute("margenGananciaProductoVacio", null);
                            request.getSession().setAttribute("cantidadProductoVacio", null);
                            request.getSession().setAttribute("precioCostoProductoVacio", null);
                            request.getSession().setAttribute("margenVentaProductoVacio", null);
                            request.getSession().setAttribute("stockMaximoProductoVacio", null);
                            request.getSession().setAttribute("stockMinimoProductoVacio", null);
                        }
                        String strErrorConexionProducto;
                        try {
                            strErrorConexionProducto = (String) request.getSession().getAttribute("errorProducto");
                        } catch (Exception excE) {
                            strErrorConexionProducto = null;
                        }
                        if (strErrorConexionProducto != null) {
                            out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + request.getSession().getAttribute("errorProducto") + "</font><a href=\"../interfacesJhano/interfazCargaProducto.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorProducto", null);
                        } else {
                    %>
                    <font face="Arial">
                        <h3><center>Producto</center></h3>
                    </font>
                    <%
                        }
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
