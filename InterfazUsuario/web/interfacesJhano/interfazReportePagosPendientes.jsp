<%@page import="com.sun.rowset.WebRowSetImpl"%>
<%@page import="java.io.StringReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Inicio </title>
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
                                    <a href="interfacesJhano/interfazCargaCliente.jsp"><center>Clientes</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="interfacesJhano/interfazCargaProveedor.jsp"><center>Proveedores</center></a>
                                </font>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="interfacesJhano/interfazCargaProducto.jsp"><center>Productos</center></a>
                                </font>
                                <ul>
                                <font face="Arial">
                                        <a href="interfacesJhano/interfazCargaFamiliaProducto.jsp"><center>Familias</center></a>
                                </font>
                                </ul>
                            </li>
                            <li>
                                <font face="Arial">
                                    <a href="interfacesJhano/interfazIngresoFactura.jsp"><center>Facturas</center></a>
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
                    <td  width="12%" >
                        <a href="../index.jsp">Atras</a>
                    </td> 
                    <td width="88%"  >
                        <font face="Arial">
                        <h1><center>Pagos Pendientes</center></h1>
                        <center>
                        <%
                            
                            try {
                                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service service = new com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago_Service();
                                com.lewissa.jhano.logicanegocio.pago.WsLogicaNegocioPago port = service.getWsLogicaNegocioPagoPort();
                                java.lang.String TotalPagosPendintes = port.getTotalPagosPendientes();
                                java.lang.String result = port.getPagosPendientes();
                                if(result != null)
                                {
                                    out.print("<table border=\"1\" >");
                                        StringReader sr = new StringReader(result);
                                        WebRowSetImpl wrs = new WebRowSetImpl();
                                        wrs.readXml(sr);
                                        out.print("<tr>");
                                                out.print("<td>CI/RUC</td>");
                                                out.print("<td>Nombre Fiscal</td>");
                                                out.print("<td>Telefono Convencional</td>");
                                                out.print("<td>Telefono Celular</td>");
                                                out.print("<td>Correo Electronico</td>");
                                                out.print("<td>Direccion</td>");
                                                out.print("<td>Fecha de Pago</td>");
                                                out.print("<td>Monto</td>");
                                        out.print("</tr>");
                                        while (wrs.next()) {
                                            out.print("<tr>");
                                                    out.print("<td>"+wrs.getString("Id_cliente")+"</td>");
                                                    out.print("<td>"+wrs.getString("Nombre_fiscal")+"</td>");
                                                    out.print("<td>"+wrs.getString("Convencional")+"</td>");
                                                    out.print("<td>"+wrs.getString("Celular")+"</td>");
                                                    out.print("<td>"+wrs.getString("Correo")+"</td>");
                                                    out.print("<td>"+wrs.getString("Direccion")+"</td>");
                                                    out.print("<td>"+wrs.getString("fecha_pago")+"</td>");
                                                    out.print("<td>"+wrs.getString("monto")+"</td>");
                                                    out.print("</tr>");
                                        }
                                        
                                        StringReader strReader = new StringReader(TotalPagosPendintes);
                                        WebRowSetImpl wrsImplement = new WebRowSetImpl();
                                        wrsImplement.readXml(strReader);
                                        while(wrsImplement.next())
                                        {
                                            out.print("<tr>");
                                            out.print("<td colspan=\"7\" >Total</td>");
                                            out.print("<td>"+wrsImplement.getString("total")+"</td>");
                                            out.print("</tr>");
                                        }                                      
                                        
                                    out.print("</table>");
                                }
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }                        
                        %>
                        </center>
                        
                        </font>
                    </td>
                </tr>
        </table>

        <script type="text/javascript">
            var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1",
                    {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
            var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2",
                    {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
        </script>
    </body>
</html>

