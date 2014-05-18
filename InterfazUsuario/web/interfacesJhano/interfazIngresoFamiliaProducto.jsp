<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingresar Familia de Productos </title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../javascript/validacionFrmIngresarFamiliaProducto.js"></script>
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

        <table bgcolor="#C0C0C0" width="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="1" align="left">
                        <tr>
                            <td>
                                <a href="../interfacesJhano/interfazConsultaFamiliaProducto.jsp">
                                    <font face="Arial">
                                        Consulta
                                    </font>
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="88%">
                    <font face="Arial">
                        <h3><center>Ingreso de Familia de Productos</center></h3>
                        <form id="frmIngresoFamiliaProducto" name="form1" method="post" action="../controladoresJhano/controladorInterfazIngresoFamiliaProducto.jsp" onsubmit="return validar_datos(this)">
                            <%
                                Boolean booResul = (Boolean) request.getSession().getAttribute("familia");
                                Boolean booCodigo = (Boolean) request.getSession().getAttribute("codigo");
                                Boolean booDescripcion = (Boolean) request.getSession().getAttribute("descripcion");
                                String strDescripcionVacio = null;
                                String strCodigoVacio = null;
                                try {
                                    strDescripcionVacio = (String) request.getSession().getAttribute("descripcionVacio");
                                } catch (Exception e) {
                                    strDescripcionVacio = null;
                                }
                                try {
                                    strCodigoVacio = (String) request.getSession().getAttribute("codigoVacio");
                                } catch (Exception e) {
                                    strCodigoVacio = null;
                                }

                                if ((booCodigo != null) && (booResul != null)) {
                                    if ((booCodigo == true) && (booResul == true)) {
<<<<<<< HEAD
                                        
                                        response.sendRedirect("../interfacesJhano/interfazConsultaFamiliaProducto.jsp");
=======

                                        String strConfirmacion = "Guardado Exitoso";
>>>>>>> b5682558c950c63b701cd56b02842853774b9d85
                                        strDescripcionVacio = null;
                                        strCodigoVacio = null;
                                        booCodigo = null;
                                        booResul = null;
                                        request.getSession().setAttribute("familia", null);
                                        request.getSession().setAttribute("codigo", null);
                                        request.getSession().setAttribute("codigoVacio", 0);
                                        request.getSession().setAttribute("descripcionVacio", 0);
                                        response.sendRedirect("../interfacesJhano/interfazConsultaFamiliaProducto.jsp");
                                    }
                                }

                                out.print("<table border=\"0\"  align=\"center\">");
                                out.print("<tr>");
                                out.print("<td><label> Codigo: </label></td>");
                                if (booCodigo != null) {
                                    if (booCodigo == false) {
                                        if (strCodigoVacio.equals("0")) {
                                            out.print("<td><input name=\"codigo\" type=\"text\" size=\"5\" maxlength=\"5\" placeholder=\"fm###\" /><label><font color=\"red\">Se requiere que el campo este lleno </font></label> </td>");
                                        } else {
                                            out.print("<td><input name=\"codigo\" type=\"text\" size=\"5\" maxlength=\"5\" value=\"" + request.getSession().getAttribute("codigoVacio") + "\" /><label ><font color=\"red\">Dato mal ingresado</font></label> </td>");
                                        }
                                    } else {
                                        out.print("<td><input name=\"codigo\" type=\"text\" size=\"5\" maxlength=\"5\" value=\"" + request.getSession().getAttribute("codigoVacio") + "\"/> </td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"codigo\" type=\"text\" size=\"5\" maxlength=\"5\" placeholder=\"fm###\"/></td>");
                                }

                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Descripcion:</label></td>");
                                if (strDescripcionVacio != null) {
                                    if (strDescripcionVacio.equals("0")) {
                                        out.print("<td><input name=\"descripcion\" type=\"text\" size=\"50\" maxlength=\"50\" /><label ><font color=\"red\">Se requiere que el campo este lleno </font></label> </td>");
                                    } else {
                                        out.print("<td><input name=\"descripcion\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("descripcionVacio") + "\" /></td>");

                                    }
                                } else {
                                    out.print("<td><input name=\"descripcion\" type=\"text\" size=\"50\" maxlength=\"50\"  /></td>");
                                }
                                out.print("</td>");
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td colspan=\"2\" align=\"center\">");
                                out.print("<input name=\"guardar\" type=\"submit\" value=\"Guardar\" />");
                                out.print("<input name=\"cancelar\" type=\"button\" value=\"Cancelar\" />");
                                out.print("</td>");
                                out.print("<td>");
                                out.print("</td>");
                                out.print("</tr>");
                                out.print("</table>");

                            %>
                        </form>
                    </font>
                </td>
            </tr>
        </table>

        <script type="text/javascript">
            var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
            var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
        </script>
    </body>
</html>