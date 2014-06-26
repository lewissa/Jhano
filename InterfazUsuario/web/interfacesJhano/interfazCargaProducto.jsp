<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Menú Producto </title>
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
                    <a href="../index.jsp">
                        <center>
                            <font color="#FFFFFF" size="+6" face="Arial, Helvetica, sans-serif">
                                Computech
                            </font><br/></a>
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
                                                <a href="../interfacesJhano/interfazIngresoProducto.jsp"><center>Ingreso</center></a>
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
                                                <a href="../controladoresJhano/controladorReporteProducto.jsp"><center>Reporte</center></a>
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

                        String strErrorConexionProducto = null;
                        if (request.getSession().getAttribute("errorProducto") != null) {
                            strErrorConexionProducto = (String) request.getSession().getAttribute("errorProducto");
                            out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + strErrorConexionProducto + "</font><a href=\"../interfacesJhano/interfazCargaProducto.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorProducto", null);

                    %>
                    <% } else {


                    %>
                    <td width="88%">
                        <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Producto</font></center></h3>
                                    <%                            Boolean booErrorElimiancion = null;
                                        String strCodigoElimiando = null;
                                        if (request.getSession().getAttribute("errorEliminacionProducto") != null) {
                                            booErrorElimiancion = (Boolean) request.getSession().getAttribute("errorEliminacionProducto");
                                            strCodigoElimiando = (String) request.getSession().getAttribute("codigoElimandoProducto");
                                        }
                                        if ((request.getSession().getAttribute("errorEliminacionProducto") != null) && booErrorElimiancion == false) {
                                            request.getSession().setAttribute("id", strCodigoElimiando);
                                            out.print("<form name=\"frmEliminar\" method=\"post\" action=\"../controladoresJhano/controladorEliminarProducto.jsp\" >");
                                            out.print("<fieldset><legend>Advertencia</legend>El proveedor de CI/RUC: " + strCodigoElimiando + ", posee documentos asociados. Decea realizar eliminacion logica?  ");
                                            out.print("<input type=\"submit\" name=\"accion\" value=\"Aceptar\" />");
                                            out.print("<input type=\"submit\" name=\"accion\" value=\"Cancelar\" /></fieldset> ");
                                            out.print("<br>");
                                            out.print("</form>");
                                        }
                                    %>

                        <form name="frmCargarProductos" action="../controladoresJhano/controladorInterfazCargaProducto.jsp" method="post" >
                            <div STYLE=" height: 350px; width: auto; font-size: 15px; overflow: auto;"/>
                            <table  align="center" border="1" style="font-size:15px; width: 1155x; height: 25px">
                                <tr>
                                    <th width="8%" align="center" bgcolor="#C0C0C0">Ean</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Fabricante</th>
                                    <th width="8%"align="center" bgcolor="#C0C0C0">Descripcion general</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Margen ganancia</th>
                                    <th width="3%"align="center" bgcolor="#C0C0C0">Cantidad</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Precio costo</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Margen venta</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Stock maximo</th>
                                    <th width="5%"align="center" bgcolor="#C0C0C0">Stock minimo</th>
                                    <th colspan="2" width="5%"align="center" bgcolor="#C0C0C0">Accion</th>
                                </tr>
                                <tr>
                                    <%
                                            try {

                                                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                                                com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();
                                                // TODO process result here
                                                java.util.List<com.lewissa.jhano.logicanegocio.producto.CProducto> listProducto = port.cargaProducto();

                                                if (port.getErrorConexionProducto() != null) {
                                                    String strError = (String) port.getErrorConexionProducto();
                                                    request.getSession().setAttribute("errorProducto", strError);
                                                    response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                                                }

                                                for (CProducto oProducto : listProducto) {

                                                    out.print("<tr>");
                                                    out.print("<td width=\"8%\" align=\"center\" bgcolor=\"#FFF\" >" + oProducto.getStrEan() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getStrFabricante() + "</td>");
                                                    out.print("<td width=\"8%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getStrDescripcionGeneral() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getDouMargenGanancia() + "</td>");
                                                    out.print("<td width=\"3%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getIntCantidad() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getDouPrecioCosto() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getDouMargenVenta() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getIntStockMaximo() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#FFF\">" + oProducto.getIntStockMinimo() + "</td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#C0C0C0\"><a href=\"../controladoresJhano/controladorInterfazModificarProducto.jsp?id=" + oProducto.getStrIdProdu() + "\">Modificar</a></td>");
                                                    out.print("<td width=\"5%\" align=\"center\" bgcolor=\"#C0C0C0\"><a href=\"../controladoresJhano/controladorEliminarProducto.jsp?id=" + oProducto.getStrIdProdu() + "\">Eliminar</a></td>");

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
