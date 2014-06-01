<%@page import="java.util.List"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Cliente </title>
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
                    <table border="0,1" align="left">
                        <tr>
                            <td>
                                <a href="../interfacesJhano/interfazIngresoCliente.jsp">
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
                    <%
                        String strCancelar;
                        try {
                            strCancelar = (request.getParameter("can") != null) ? "true" : "false";
                        } catch (Exception excError) {
                            strCancelar = "false";
                        }
                        if (strCancelar.equals("true")) {
                            session.setAttribute("cliente", false);
                            request.getSession().setAttribute("correo", null);
                            request.getSession().setAttribute("cedula", null);
                            request.getSession().setAttribute("ruc", null);
                            request.getSession().setAttribute("correoVacio", 0);
                            request.getSession().setAttribute("cedulaVacio", 0);
                            request.getSession().setAttribute("rucVacio", 0);
                            request.getSession().setAttribute("nombreComercialVacio", 0);
                            request.getSession().setAttribute("nombreFiscalVacio", 0);
                            request.getSession().setAttribute("celularVacio", 0);
                            request.getSession().setAttribute("telefonoVacio", 0);
                            request.getSession().setAttribute("direccionVacio", 0);
                        }
                        String strErrorConexionCliente;
                        try {
                            strErrorConexionCliente = (String) request.getSession().getAttribute("errorCliente");
                        } catch (Exception excE) {
                            strErrorConexionCliente = null;
                        }
                        if (strErrorConexionCliente != null) {
                            out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + request.getSession().getAttribute("errorCliente") + "</font><a href=\"../interfacesJhano/interfazCargaCliente.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorCliente", null);
                        } else {
                    %>
                    <td width="88%">
                        <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Cliente</font></center></h3>
                        <form name="frmCargarClientes" action="../controladoresJhano/controladorInterfazCargarCliente.jsp" method="post" >
                            <table width="1000" align="center" border="1" bgcolor="white">
                                <tr>
                                    <td width="100" align="center">Cédula / RUC</td>
                                    <td width="250" align="center">Nombre y Apellido</td>
                                    <td width="400" align="center">Dirección</td>
                                    <td width="100" align="center">Teléfono</td>
                                    <td width="150" align="center" colspan="2">Acciones</td>
                                    
                                </tr>
                                <%
                                    String strCarga = (request.getParameter("car") != null) ? "true" : "false";
                                    if (strCarga.equals("false")) {
                                        response.sendRedirect("../controladoresJhano/controladorInterfazCargarCliente.jsp");
                                    }
                                    List<com.lewissa.jhano.logicanegocio.cliente.CCliente> clientes = (List<com.lewissa.jhano.logicanegocio.cliente.CCliente>) request.getSession().getAttribute("clientes");
                                    if (clientes != null) {
                                        for (com.lewissa.jhano.logicanegocio.cliente.CCliente cliente : clientes) {
                                            out.print("<tr>");
                                            out.print("  <td>" + cliente.getStrIdCliente() + "</td>");
                                            out.print("  <td>" + cliente.getStrNombreFiscal() + "</td>");
                                            out.print("  <td>" + cliente.getStrDireccion()+ "</td>");
                                            out.print("  <td>" + cliente.getStrConvencional()+ "</td>");
                                            out.print("  <td>Modificar</td>");
                                            //out.print("  <td>Eliminar</td>");
                                            out.print("  <td><a href='../controladoresJhano/controladorEliminarCliente.jsp?accion=delete&id=" + cliente.getStrIdCliente() + "'>Eliminar</a></td>");
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
