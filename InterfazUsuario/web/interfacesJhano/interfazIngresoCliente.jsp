<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingresar Cliente </title>
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
                    <table border="0.1" align="left">
                        <tr>
                            <td>
                                <a href="">
                                    <font face="Arial">
                                        Ingreso
                                    </font>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="">
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
                        <h3><center>Ingreso de Cliente</center></h3>
                        <form id="formCli" name="formCliente" method="post" action="../controladoresJhano/controladorInterfazIngresoCliente.jsp">
                            <%
                                Boolean booResult = (Boolean) request.getSession().getAttribute("cliente");
                                Boolean booCedula = (Boolean) request.getSession().getAttribute("cedula");
                                Boolean booRuc = (Boolean) request.getSession().getAttribute("ruc");
                                Boolean booCorreo = (Boolean) request.getSession().getAttribute("correo");
                                String strNombreFiscalVacio = null;
                                String strDireccionVacio = null;
                                String strNombreComercialVacio = null;
                                String strTelefonoVacio = null;
                                String strCelularVacio = null;
                                try {
                                    strNombreFiscalVacio = (String) request.getSession().getAttribute("nombreFiscalVacio");
                                } catch (Exception e) {
                                    strNombreFiscalVacio = null;
                                }
                                try {
                                    strDireccionVacio = (String) request.getSession().getAttribute("direccionVacio");
                                } catch (Exception e) {
                                    strDireccionVacio = null;
                                }
                                try {
                                    strNombreComercialVacio = (String) request.getSession().getAttribute("nombreComercialVacio");
                                } catch (Exception e) {
                                    strNombreComercialVacio = null;
                                }
                                try {
                                    strCelularVacio = (String) request.getSession().getAttribute("celularVacio");
                                } catch (Exception e) {
                                    strCelularVacio = null;
                                }
                                try {
                                    strTelefonoVacio = (String) request.getSession().getAttribute("telefonoVacio");
                                } catch (Exception e) {
                                    strTelefonoVacio = null;
                                }

                                if (((booCedula != null) && (booRuc != null)) && (booCorreo != null) && (booResult != null)) {
                                    if (((booCedula == true) || (booRuc == true)) && (booCorreo == true) && (booResult == true)) {
                                        strDireccionVacio = null;
                                        strNombreFiscalVacio = null;
                                        booCedula = null;
                                        booCorreo = null;
                                        strNombreComercialVacio = null;
                                        booResult = null;
                                        session.setAttribute("cliente", false);
                                        request.getSession().setAttribute("correo", null);
                                        request.getSession().setAttribute("cedula", null);
                                        request.getSession().setAttribute("ruc", null);
                                        request.getSession().setAttribute("correoVacio", 0);
                                        request.getSession().setAttribute("cedulaVacio", 0);
                                        request.getSession().setAttribute("rucVacio",0);
                                        request.getSession().setAttribute("nombreComercialVacio", 0);
                                        request.getSession().setAttribute("nombreFiscalVacio", 0);
                                        request.getSession().setAttribute("celularVacio", 0);
                                        request.getSession().setAttribute("telefonoVacio", 0);
                                        request.getSession().setAttribute("direccionVacio", 0);
                                        response.sendRedirect("../interfacesJhano/interfazCargaCliente.jsp");
                                    }
                                }
                                out.print("<table border=\"0\" align=\"center\">");
                                out.print("<tr>");
                                out.print("<td><label>CI / RUC:</label></td>");
                                if ((booCedula != null) && (booRuc != null)) {
                                    if ((booCedula == false) && (booRuc == false)) {
                                        if (request.getSession().getAttribute("cedulaVacio").equals("0")) {
                                            out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\"  /><label ><font color=\"red\">* Se requiere que el campo este lleno </font></label> </td>");
                                        } else {
                                            out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\" value=\"" + request.getSession().getAttribute("cedulaVacio") + "\" /><label ><font color=\"red\">* Dato mal ingresado</font></label> </td>");
                                        }
                                    } else {
                                        if (booResult!=null) {
                                            if (((booCedula == true) || (booRuc == true)) && (booCorreo == true) && (booResult == false)) {
                                                out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\" value=\"" + request.getSession().getAttribute("cedulaVacio") + "\"/><font color=\"red\">* La cedula esta repetida</font></td>");
                                            } else {
                                                out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\" value=\"" + request.getSession().getAttribute("cedulaVacio") + "\"/></td>");
                                            }
                                        } else {
                                            out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\" value=\"" + request.getSession().getAttribute("cedulaVacio") + "\"/></td>");
                                        }
                                    }
                                } else {
                                    out.print("<td><input name=\"ciruc\" type=\"text\" size=\"13\" maxlength=\"13\"/></td>");
                                }
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Nombre Fiscal:</label></td>");
                                if (strNombreFiscalVacio != null) {
                                    if (strNombreFiscalVacio.equals("0")) {
                                        out.print("<td><input name=\"nombrefiscal\" type=\"text\" size=\"50\" maxlength=\"50\"  /><label ><font color=\"red\">* Se requiere que el campo este lleno </font></label> </td>");
                                    } else {
                                        out.print("<td><input name=\"nombrefiscal\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("nombreFiscalVacio") + "\" /></td>");

                                    }
                                } else {
                                    out.print("<td><input name=\"nombrefiscal\" type=\"text\" size=\"50\" maxlength=\"50\"  /></td>");
                                }
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Nombre Comercial:</label></td>");
                                if (strNombreComercialVacio != null) {
                                    if (request.getSession().getAttribute("nombreComercialVacio").equals("0")) {
                                        out.print("<td><input name=\"nombrecomer\" type=\"text\" size=\"50\" maxlength=\"50\" /></td>");
                                    } else {
                                        out.print("<td><input name=\"nombrecomer\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("nombreComercialVacio") + "\"/></td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"nombrecomer\" type=\"text\" size=\"50\" maxlength=\"50\" /></td>");
                                }

                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Dirección:</label></td>");
                                if (strDireccionVacio != null) {
                                    if (strDireccionVacio.equals("0")) {
                                        out.print("<td><input name=\"direccion\" type=\"text\" size=\"50\" maxlength=\"50\"/><label ><font color=\"red\">* Se requiere que el campo este lleno </font></label> </td>");
                                    } else {
                                        out.print("<td><input name=\"direccion\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("direccionVacio") + "\" /></td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"direccion\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                }
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Teléfono Convencional:</label></td>");
                                if (strTelefonoVacio != null) {
                                    if (request.getSession().getAttribute("telefonoVacio").equals("err0r")) {
                                        out.print("<td><input name=\"convencional\" type=\"text\" size=\"7\" maxlength=\"7\" /><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                    } else {
                                        out.print("<td><input name=\"convencional\" type=\"text\" size=\"7\" maxlength=\"7\" /></td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"convencional\" type=\"text\" size=\"7\" maxlength=\"7\"/></td>");
                                }
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Celular:</label></td>");
                                if (strCelularVacio != null) {
                                    if (request.getSession().getAttribute("celularVacio").equals("err0r")) {
                                        out.print("<td><input name=\"celular\" type=\"text\" size=\"10\" maxlength=\"10\" /><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                    } else {
                                        out.print("<td><input name=\"celular\" type=\"text\" size=\"10\" maxlength=\"10\" /></td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"celular\" type=\"text\" size=\"10\" maxlength=\"10\"/></td>");
                                }
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Correo Electrónico:</label></td>");
                                if (booCorreo != null) {
                                    if (booCorreo == false) {
                                        if (request.getSession().getAttribute("correoVacio").equals("0")) {
                                            out.print("<td><input name=\"correo\" type=\"text\" size=\"50\" maxlength=\"50\"  /><label ><font color=\"red\">* Se requiere que el campo este lleno </font></label> </td>");
                                        } else {
                                            out.print("<td><input name=\"correo\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("correoVacio") + "\" /><label ><font color=\"red\">* Dato mal ingresado</font></label> </td>");
                                        }
                                    } else {
                                        out.print("<td><input name=\"correo\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + request.getSession().getAttribute("correoVacio") + "\"/> </td>");
                                    }
                                } else {
                                    out.print("<td><input name=\"correo\" type=\"text\" size=\"50\" maxlength=\"50\" /> </td>");
                                }

                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td><label>Tipo de Cliente:</label></td>");
                                out.print("<td>");
                                out.print("<select name=\"tipocliente\" size=\"1\">");
                                out.print("<option value=\"1\">Frecuente</option>");
                                out.print("<option value=\"2\">Ocacional</option>");
                                out.print("<option value=\"3\">Institución</option>");
                                out.print("</select>");
                                out.print("</td>");
                                out.print("</tr>");
                                out.print("<tr>");
                                out.print("<td colspan=\"2\" align=\"right\">");
                                out.print("<input name=\"guardar\" type=\"submit\" value=\"Guardar\" />");
                                out.print("<input name=\"cancelar\" type=\"button\" value=\"Cancelar\" onclick=\"location.href='../interfacesJhano/interfazCargaCliente.jsp?can=true'\" />");
                                out.print("</td>");
                                out.print("</tr>");
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