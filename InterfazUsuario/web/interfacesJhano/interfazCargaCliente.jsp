<%@page import="java.util.List"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Cliente </title>
        <link href="SpryAssets/estilo.css" rel="stylesheet" type="text/css">
            <script type="text/javascript" src="functions.js"></script>
            <script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
            <link href="../SpryAssets/SpryMenuBarHorizontalw.css" rel="stylesheet" type="text/css" />
            <link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
           
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
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
                    <table style="border: #f9f9f9" border="1" width="90%" height="90%">
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
        <table style="background-color: #999999; border-color: #f9f9f9" gcolor="#C0C0C0" width="100%" height="10%" border="1">
            <tr>
                <td border="1" width="10%">
                    <table style="background-color: #999999; border-color: #f9f9f9">                             
                        <tr>
                            <th><div>
                                    <ul id="MenuBar2" class="MenuBarHorizontalw">
                                        <li> 
                                            <font face="Arial">
                                                <a href="../interfacesJhano/interfazIngresoCliente.jsp"><center>Ingreso</center></a>
                                            </font>
                                        </li>
                                    </ul>
                                    <ul id="MenuBar2" class="MenuBarHorizontalw">
                                        <li>
                                            <font face="Arial">
                                                <a href="#"><center>Consulta</center></a>
                                            </font>
                                        </li>
                                    </ul>
                                    <ul id="MenuBar2" class="MenuBarHorizontalw">
                                        <li>
                                            <font face="Arial">
                                                <a href="../index.jsp"><center>Regresar</center></a>
                                            </font>
                                        </li>
                                    </ul>
                            </th>
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
                                    <td width="100" align="center" bgcolor="#C0C0C0">Cédula / RUC</td>
                                    <td width="250" align="center" bgcolor="#C0C0C0">Nombre y Apellido</td>
                                    <td width="400" align="center" bgcolor="#C0C0C0">Dirección</td>
                                    <td width="100" align="center" bgcolor="#C0C0C0">Teléfono</td>
                                    <td width="150" align="center" colspan="2" bgcolor="#C0C0C0">Acciones</td>

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
                                            out.print("  <td bgcolor=\"#FFF\">" + cliente.getStrIdCliente() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">" + cliente.getStrNombreFiscal() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">" + cliente.getStrDireccion() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">" + cliente.getStrConvencional() + "</td>");
                                            out.print("  <td bgcolor=\"#FFF\">Modificar</td>");
                                            //out.print("  <td>Eliminar</td>");
                                            out.print("  <td bgcolor=\"#FFF\"><a href='../controladoresJhano/controladorEliminarCliente.jsp?accion=delete&id=" + cliente.getStrIdCliente() + "'>Eliminar</a></td>");
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
