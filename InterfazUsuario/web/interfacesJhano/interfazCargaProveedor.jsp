<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CProveedor;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingresar Proveedor </title>
         <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <link href="../SpryAssets/SpryMenuBarHorizontalw.css" rel="stylesheet" type="text/css" />
        <link href="../SpryAssets/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
        <link href="../SpryAssets/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 

    </head>

    <body>
        <table style="background-color: #002a80; border: #f9f9f9" bgcolor='#192B75' width="100%" height="50%" border="1">
            <tr>
                <td>
                    <a href="../index.jsp">
                        <img src="Image/computech.jpg" alt="espoch" />
                    </a>
                </td>
                <td width="880">
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
                    <table border='1' width="90%" height="90%">
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
                <td height="41" colspan="2"><div align="center" style="font-size: 1.2em">
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
            </tr>
        </table>
        <table style="background-color: #999999; border-color: #f9f9f9" gcolor="#C0C0C0" width="100%" height="10%" border="1">
            <tr>
                <td border="1" width="10%" style="font-size: 1.2em">
                    <table style="background-color: #999999; border-color: #f9f9f9">                             
                        <tr>
                            <th><div>
                                    <ul id="MenuBar2" class="MenuBarHorizontalw">
                                        <li> 
                                            <font face="Arial">
                                                <a href="../interfacesJhano/interfazIngresoProveedor.jsp"><center>Ingreso</center></a>
                                                        <%
                                                            request.getSession().setAttribute("proveedor", null);
                                                            request.getSession().setAttribute("convencional", null);
                                                            request.getSession().setAttribute("celular", null);
                                                            request.getSession().setAttribute("errorCorreo", null);
                                                            request.getSession().setAttribute("errorConvencional", null);
                                                            request.getSession().setAttribute("errorCelular", null);
                                                        %>
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
                                                <a href="../controladoresJhano/controladorReporteProveedor.jsp"><center>Reporte</center></a>
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
                    <%                        String strErrorConexionProveedor = null;
                        if (request.getSession().getAttribute("errorProveedor") != null) {
                            strErrorConexionProveedor = (String) request.getSession().getAttribute("errorProveedor");
                            out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + strErrorConexionProveedor + "</font><a href=\"../interfacesJhano/interfazCargaProveedor.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorProveedor", null);

                    %>
                    <% } else {


                    %>
                    <td width="88%">
                        <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Proveedor</font></center></h3>
                                    <%                            request.getSession().setAttribute("errorCorreo", null);
                                        request.getSession().setAttribute("errorConvencional", null);
                                        request.getSession().setAttribute("errorCelular", null);
                                        Boolean booErrorElimiancion = null;
                                        String strCodigoElimiando = null;

                                        if (request.getSession().getAttribute("errorEliminacion") != null) {
                                            booErrorElimiancion = (Boolean) request.getSession().getAttribute("errorEliminacion");
                                            strCodigoElimiando = (String) request.getSession().getAttribute("codigoElimando");
                                        }
                                        if ((request.getSession().getAttribute("errorEliminacion") != null) && booErrorElimiancion == false) {
                                            request.getSession().setAttribute("id", strCodigoElimiando);
                                            out.print("<form name=\"frmEliminar\" method=\"post\" action=\"../controladoresJhano/controladorEliminarProveedor.jsp\" >");
                                            out.print("<fieldset><legend>Advertencia</legend>El proveedor de CI/RUC: " + strCodigoElimiando + ", posee documentos asociados. Decea realizar eliminacion logica?  ");
                                            out.print("<input type=\"submit\" name=\"accion\" value=\"Aceptar\" />");
                                            out.print("<input type=\"submit\" name=\"accion\" value=\"Cancelar\" /></fieldset> ");
                                            out.print("<br>");
                                            out.print("</form>");
                                        }
                                    %>
                        <div class="row-fluid" span="span8" />
                            <div span="span8">
                                <center>
                                <table class="table table-hover table-condensed" align="center" style="font-size:15px; width: 1155x; height: 25px">
                                <tr>
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Identificacion
                                </th>
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Nombre Fiscal
                                </th>
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Nombre Comercial
                                </th>
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Direccion
                                </th>
                                <th  width="8%"align=\"center\" bgcolor=#C0C0C0>
                                    Telefono Convencional
                                </th> 
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Telefono Celular
                                </th>
                                <th width="8%" align=\"center\" bgcolor=#C0C0C0>
                                    Correo Electronico
                                </th>
                                    <th  width="8%"colspan="2" align=\"center\" bgcolor=#C0C0C0><center>
                                            Accion</center>
                                </th>
                            </tr>
                            <%
                                    try {

                                        com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service service = new com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor_Service();
                                        com.lewissa.jhano.logicanegocio.proveedor.WsLogicaNegocioProveedor port = service.getWsLogicaNegocioProveedorPort();
                                        // TODO process result here
                                        java.util.List<com.lewissa.jhano.logicanegocio.proveedor.CProveedor> listProveedor = port.cargaProveedor();

                                        if (port.getErrorConexionProveedor() != null) {
                                            String strError = (String) port.getErrorConexionProveedor();
                                            request.getSession().setAttribute("errorProveedor", strError);
                                            response.sendRedirect("../interfacesJhano/interfazCargaProveedor.jsp");
                                        }

                                        for (CProveedor oProveedor : listProveedor) {

                                            out.print("<tr>");
                                            out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getId() + "</td>");
                                            out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getNombreFiscal() + "</td>");

                                            if (oProveedor.getNombreComercial() == null) {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\"> </td>");
                                            } else {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getNombreComercial() + "</td>");
                                            }

                                            if (oProveedor.getDireccion() == null) {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\"> </td>");
                                            } else {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getDireccion() + "</td>");
                                            }

                                            if (oProveedor.getConvencional() == null) {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\"> </td>");
                                            } else {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getConvencional() + "</td>");
                                            }

                                            if (oProveedor.getCelular() == null) {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\"> </td>");
                                            } else {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getCelular() + "</td>");
                                            }

                                            if (oProveedor.getCorreo() == null) {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\"> </td>");
                                            } else {
                                                out.print("<td align=\"center\" bgcolor=\"#FFF\">" + oProveedor.getCorreo() + "</td>");
                                            }

                                            out.print("<td align=\"center\" bgcolor=\"#C0C0C0\"><a href=\"../controladoresJhano/controladorEliminarProveedor.jsp?id=" + oProveedor.getId() + "\">Eliminar</a></td>");
                                            out.print("<td align=\"center\" bgcolor=\"#C0C0C0\"><a href=\"../interfacesJhano/interfazModificarProveedor.jsp?accion=modificar&id=" + oProveedor.getId()
                                                    + "&nombreF=" + oProveedor.getNombreFiscal() + "&nombreC=" + oProveedor.getNombreComercial()
                                                    + "&direccion=" + oProveedor.getDireccion() + "&convencional=" + oProveedor.getConvencional()
                                                    + "&celular=" + oProveedor.getCelular() + "&correo=" + oProveedor.getCorreo() + "\">Modificar</a></td>");
                                            out.print("</tr>");
                                        }
                                    } catch (Exception ex) {
                                        out.print(ex.getMessage());
                                    }
                                }
                            %>
                        </table>
                    </td>
                </td>
            </tr>                     
            </tr>
        </table>

        <script type="text/javascript">
            var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
            var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
        </script>
    </body>
</html>