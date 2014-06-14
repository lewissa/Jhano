<%-- 
    Document   : interfazIngresoFactura
    Created on : 5-may-2014, 9:56:30
    Author     : Fredy Janeta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.lewissa.jhano.logicanegocio.producto.CProducto"%>
<%@page import="com.lewissa.jhano.logicanegocio.empresa.CEmpresa"%>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingreso Factura </title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <table bgcolor="#192B75" width="100%" height="50%" border="1">
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

        <table bgcolor="#C0C0C0" width="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="0.1" align="left">
                        <tr>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="../interfacesJhano/interfazCargaFactura.jsp">

                                    <font face="Arial">
                                        Regresar
                                    </font>
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <%
                    String strError = (String) request.getSession().getAttribute("errorFamiliaProducto");
                    if (strError != null) {
                        out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + strError.toString()+ "</font><a href=\"../interfacesJhano/interfazCargaFamiliaProducto.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorFamiliaProducto", null); }

                %>
                <td width="88%">
                    <font face="Arial">
                        <h3><center>Factura</center></h3>  
                        <%
        List<CProducto> listProductos = new ArrayList<CProducto>();
        
  
	com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa_Service service = new com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa_Service();
	com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa port = service.getWsLogicaNegocioEmpresaPort();
	 // TODO initialize WS operation arguments here
	java.lang.String strParametro = "0000000000001";
        CEmpresa oEmpresa = new CEmpresa();
	// TODO process result here
	java.util.List<com.lewissa.jhano.logicanegocio.empresa.CEmpresa> listEmpresas = port.buscarEmpresa(strParametro);
        for(CEmpresa oEmpresa1 : listEmpresas)
        {
            oEmpresa=oEmpresa1;
        }

    %>
                        <form method="post" action="../controladoresJhano/controladorInterfazIngresoFactura.jsp">        
                        <fieldset> <legend><FONT FACE="roman" SIZE="5">Datos de la Empresa</FONT></legend>
                        <table bgcolor="white">
                            <tr>                                
                                <td>Nombre Fiscal: </td>
                                <td><%=oEmpresa.getStrNombreFiscal()%></td>
                           
                            </tr>
                            <tr>
                                <td>RUC: </td>
                                <td><%=oEmpresa.getStrRuc()%></td>
                      
                            </tr>
                            <tr>
                                <td>Direccion: </td>
                                <td><%=oEmpresa.getStrDirecccion()%></td>
                        
                            </tr>
                            <tr>
                                <td>Telefono: </td>
                                <td><%=oEmpresa.getStrTelefono()%></td>
                
                            </tr>
                            </table>
                        </fieldset>
                                
                                
                       <% ///////////////////////////////////////////////////%>         
                       
                       <fieldset> <legend><FONT FACE="roman" SIZE="5">Datos del Cliente</FONT></legend>
                        <table bgcolor="white">
                            <tr>                 
                                
                                <td>CI/RUC: </td>
                                <td><input type="text" name="ciruc" maxlength="13" onchange="" /></td>
                                <td colspan="2"><input type="submit" name="boton" value="Buscar" /></td>
                               
                           
                            </tr>
                            <tr>
                                <td>Nombre y Apellidos: </td>
                                <td><input type="text" disabled name="nombre" maxlength="40" onchange="" /></td>
                                <td>Direccion: </td>
                                <td><input type="text" disabled name="direccion" /></td>
                                                     
                            </tr>
                            <tr>
                                <td>Telefono: </td>
                                <td><input type="text" disabled name="telefono"/></td>   
                                <td>fecha de Emision: </td>
                                <td><input type="date" name="fecha" onclick="Response.Write(Date())" > </input></td>
                
                            </tr>
                            </table>
                        </fieldset>
                                
                                <% ///////////////////////////////////// %>
                                <fieldset> <legend><FONT FACE="roman" SIZE="5">Productos</FONT></legend>
                        <table bgcolor="white" border="1">
                            <tr>                                
                                <td>Cantidad </td>
                                <td>Descripcion</td>
                                <td>Codigo EAN</td>
                                <td>V. Unitario</td>
                                <td>V. Total</td>
                                <td><td>
                            </tr> 
                            <tr>                                
                                <td><SELECT NAME="catidad">
                                    <OPTION>1
                                    <OPTION>2
                                    <OPTION>3
                                  </SELECT> </td>
                                <td><input type="text" name="descripcion" /></td>
                                <td><input type="text" name="codigoean" /></td>
                                <td><input type="text" name="vunitario" /></td>
                                <td><input type="text" disabled name="vtotal" /></td>
                                
                            </tr> 
                               
                                    <tr>
                                        <td colspan="3" rowspan="4" >
                                            <input type="submit" name="boton" value="Buscar Producto"/>
                                            <input type="submit" name="boton" value="Agregar"/>
                                        </td>
                                        <td>Subtotal $</td>
                                        <td>          </td>
                                    </tr>    
                                    <tr>

                                        <td>12% I.V.A $</td>
                                        <td>          </td>
                                    </tr>
                                    <tr>

                                        <td>Descuento $</td>
                                        <td><input name="descuento" type="text" maxlength="10" /> </td>
                                    </tr>
                                    <tr>

                                        <td>Total $</td>
                                        <td>          </td>
                                    </tr>                      
                           
                            </table>
                                    <fieldset>
                                    <table align="center">
                                        <tr>
                                            <td>
                                                <input type="submit" name="boton" value="Guardar"/>
                                                <input type="button" name="boton" value="Cancelar"/>
                                             </td>   
                                        </tr>   
                                    </table>
                                </fieldset>
                        </fieldset>
                        </form>     
                          
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