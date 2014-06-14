<%-- 
    Document   : interfazIngreseProducto
    Created on : 17/05/2014, 10:43:24 AM
    Author     : wmoina
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingresar Producto </title>
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

        <table bgcolor="#C0C0C0" width="100%" height="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="0.1" align="left">
                        <tr>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="../interfacesJhano/interfazCargaProducto.jsp">
                                    <font face="Arial">
                                        Regresar
                                    </font>
                                </a>
                            </td>
                        </tr>
                        
                    </table>
                </td>
                <td width="88%">
                    <font face="Arial">
                        <h3><center>Ingreso de Producto</center></h3>
                        <form name="form1" action="../controladoresJhano/controladorIngresoProducto.jsp" method="post">
                            <table border="0" align="center">
                                <%
                                    Boolean booResultado = (Boolean) request.getSession().getAttribute("producto");
                                    String strEan = (String) request.getSession().getAttribute("eanProductoVacio");
                                    String strFabricacion = (String) request.getSession().getAttribute("fabricacionProductoVacio");
                                    String strDescripcionGeneral = (String) request.getSession().getAttribute("descripcionGeneralProductoVacio");
                                    String strMargenGanancia = null;
                                    String strCantidad = null;
                                    String strPrecioCosto = null;
                                    String strMargenVenta = null;
                                    String strStockMax = null;
                                    String strStockMin = null;
                                    try {
                                        strMargenGanancia = (String) request.getSession().getAttribute("margenGananciaProductoVacio");
                                    } catch (Exception excError) {
                                        strMargenGanancia = null;
                                    }
                                    try {
                                        strCantidad = (String) request.getSession().getAttribute("cantidadProductoVacio");
                                    } catch (Exception excError) {
                                        strCantidad = null;
                                    }
                                    try {
                                        strPrecioCosto = (String) request.getSession().getAttribute("precioCostoProductoVacio");
                                    } catch (Exception excError) {
                                        strPrecioCosto = null;
                                    }
                                    try {
                                        strMargenVenta = (String) request.getSession().getAttribute("margenVentaProductoVacio");
                                    } catch (Exception excError) {
                                        strMargenVenta = null;
                                    }
                                    try {
                                        strStockMax = (String) request.getSession().getAttribute("stockMaximoProductoVacio");
                                    } catch (Exception excError) {
                                        strStockMax = null;
                                    }
                                    try {
                                        strStockMin = (String) request.getSession().getAttribute("stockMinimoProductoVacio");
                                    } catch (Exception excError) {
                                        strStockMin = null;
                                    }
                                    if (booResultado != null) {
                                        if (booResultado.equals(true)) {
                                            strMargenGanancia = null;
                                            strCantidad = null;
                                            strPrecioCosto = null;
                                            strMargenVenta = null;
                                            strStockMax = null;
                                            strStockMin = null;
                                            booResultado = null;
                                            strEan = null;
                                            strFabricacion = null;
                                            strDescripcionGeneral = null;
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
                                            response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                                        }
                                    }
                                %>
                                <tr>
                                    <td><label>EAN:</label></td>
                                    <%                                                if (strEan != null) {
                                            if (strEan.equals("0")) {
                                                out.print("<td><input name=\"ean\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                            } else {
                                                out.print("<td><input name=\"ean\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + strEan + "\"/></td>");
                                            }
                                        } else {
                                            out.print("<td><input name=\"ean\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                        }
                                    %>
                                </tr>
                                <tr>
                                    <td><label>Fabricación:</label></td>
                                    <%
                                        if (strFabricacion != null) {
                                            if (strFabricacion.equals("0")) {
                                                out.print("<td><input name=\"fabricacion\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                            } else {
                                                out.print("<td><input name=\"fabricacion\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + strFabricacion + "\"/></td>");
                                            }
                                        } else {
                                            out.print("<td><input name=\"fabricacion\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                        }
                                    %>
                                </tr>
                                <tr>
                                    <td><label>Descripcion general:</label></td>
                                    <%
                                        if (strDescripcionGeneral != null) {
                                            if (strDescripcionGeneral.equals("0")) {
                                                out.print("<td><input name=\"descripcionGeneral\" type=\"text\" size=\"50\" maxlength=\"50\"/><label><font color=\"red\">* Se requiere que el campo este lleno </font></label></td>");
                                            } else {
                                                out.print("<td><input name=\"descripcionGeneral\" type=\"text\" size=\"50\" maxlength=\"50\" value=\"" + strDescripcionGeneral + "\"/></td>");
                                            }
                                        } else {
                                            out.print("<td><input name=\"descripcionGeneral\" type=\"text\" size=\"50\" maxlength=\"50\"/></td>");
                                        }
                                    %>
                                </tr>
                                <tr>
                                    <td><label>Margen ganancia:</label></td>
                                    <%
                                        if (strMargenGanancia != null) {
                                            if (strMargenGanancia.equals("0")) {
                                                out.print("<td><input name=\"margenGanancia\" type=\"text\" size=\"20\"/></td>");
                                            } else {
                                                if (strMargenGanancia.equals("err0r")) {
                                                    out.print("<td><input name=\"margenGanancia\" type=\"text\" size=\"20\"/><font color=\"red\">* Dato mal ingresado </font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"margenGanancia\" type=\"text\" size=\"20\" value=\"" + strMargenGanancia + "\"/></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"margenGanancia\" type=\"text\" size=\"20\"/></td>");
                                        }
                                    %>                                
                                </tr>
                                <tr>
                                    <td><label>Cantidad:</label></td>
                                    <%
                                        if (strCantidad != null) {
                                            if (strCantidad.equals("0")) {
                                                out.print("<td><input name=\"cantidad\" type=\"text\" size=\"20\" maxlength=\"20\"/></td>");
                                            } else {
                                                if (strCantidad.equals("err0r")) {
                                                    out.print("<td><input name=\"cantidad\" type=\"text\" size=\"20\" maxlength=\"20\"/><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"cantidad\" type=\"text\" size=\"20\" maxlength=\"20\"/ value=\"" + strCantidad + "\"></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"cantidad\" type=\"text\" size=\"20\" maxlength=\"20\"/></td>");
                                        }
                                    %>                                
                                </tr>
                                <tr>
                                    <td><label>Precio costo:</label></td>
                                    <%
                                        if (strPrecioCosto != null) {
                                            if (strPrecioCosto.equals("0")) {
                                                out.print("<td><input name=\"precioCosto\" type=\"text\" size=\"20\" maxlength=\"20\"/><label><font color=\"red\">* Se requiere que el campo este lleno </font></label></td>");
                                            } else {
                                                if (strPrecioCosto.equals("err0r")) {
                                                    out.print("<td><input name=\"precioCosto\" type=\"text\" size=\"20\" maxlength=\"20\"/><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"precioCosto\" type=\"text\" size=\"20\" maxlength=\"20\"/ value=\"" + strPrecioCosto + "\"></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"precioCosto\" type=\"text\" size=\"20\" maxlength=\"20\"/></td>");
                                        }
                                    %>                                
                                </tr>
                                <tr>
                                    <td><label>Margen venta:</label></td>
                                    <%
                                        if (strMargenVenta != null) {
                                            if (strMargenVenta.equals("0")) {
                                                out.print("<td><input name=\"margenVenta\" type=\"text\" size=\"20\" maxlength=\"20\"/><label><font color=\"red\">* Se requiere que el campo este lleno </font></label></td>");
                                            } else {
                                                if (strMargenVenta.equals("err0r")) {
                                                    out.print("<td><input name=\"margenVenta\" type=\"text\" size=\"20\" maxlength=\"20\"/><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"margenVenta\" type=\"text\" size=\"20\" maxlength=\"20\"/ value=\"" + strMargenVenta + "\"></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"margenVenta\" type=\"text\" size=\"20\" maxlength=\"20\"/></td>");
                                        }
                                    %>
                                </tr>
                                <tr>
                                    <%
                                        com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service service = new com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto_Service();
                                        com.lewissa.jhano.logicanegocio.producto.WsLogicaNegocioProducto port = service.getWsLogicaNegocioProductoPort();
                                        java.util.List<com.lewissa.jhano.logicanegocio.producto.CProveedor> lisNombreProveedor = port.getNombreProveedor();
                                        if (port.getErrorConexionProducto() != null) {
                                            String strError = port.getErrorConexionProducto();
                                            request.getSession().setAttribute("errorProducto", strError);
                                            response.sendRedirect("../interfacesJhano/interfazCargaProducto.jsp");
                                        }
                                        out.print("<td><label>Proveedor:</label></td>");
                                        out.print("<td><select  name=\"proveedor\" size=\"1\"/>");
                                        if (lisNombreProveedor != null) {
                                            for (com.lewissa.jhano.logicanegocio.producto.CProveedor proProveedor : lisNombreProveedor) {
                                                out.print("<option value=\"" + proProveedor.getId() + "\">" + proProveedor.getNombreFiscal() + "</option>");
                                            }

                                        }
                                        out.print("</select>");
                                        out.print("</td>");
                                    %>                                
                                </tr>
                                <tr>
                                    <td><label>Stock máximo:</label></td>
                                    <%
                                        if (strStockMax != null) {
                                            if (strStockMax.equals("0")) {
                                                out.print("<td><input name=\"stockMax\" type=\"text\" size=\"50\" /></td>");
                                            } else {
                                                if (strStockMax.equals("err0r")) {
                                                    out.print("<td><input name=\"stockMax\" type=\"text\" size=\"50\" /><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"stockMax\" type=\"text\" size=\"50\" value=\"" + strStockMax + "\"/></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"stockMax\" type=\"text\" size=\"50\" /></td>");
                                        }
                                    %>                                
                                </tr>
                                <tr>
                                    <td><label>Stock mínimo:</label></td>
                                    <%
                                        if (strStockMin != null) {
                                            if (strStockMin.equals("0")) {
                                                out.print("<td><input name=\"stockMin\" type=\"text\" size=\"50\" /></td>");
                                            } else {
                                                if (strStockMin.equals("err0r")) {
                                                    out.print("<td><input name=\"stockMin\" type=\"text\" size=\"50\" /><label ><font color=\"red\">* Dato mal ingresado</font></label></td>");
                                                } else {
                                                    out.print("<td><input name=\"stockMin\" type=\"text\" size=\"50\" value=\"" + strStockMin + "\"/></td>");
                                                }
                                            }
                                        } else {
                                            out.print("<td><input name=\"stockMin\" type=\"text\" size=\"50\" /></td>");
                                        }
                                    %> 
                                </tr>
                                <tr>
                                    <%
                                        java.util.List<com.lewissa.jhano.logicanegocio.producto.CFamiliaProducto> lisFamiliaProducto = port.getDescripcionFamiliaProducto();
                                        out.print("<td><label>Familia de Producto:</label></td>");
                                        out.print("<td><select  name=\"familiaProducto\" size=\"1\"/>");
                                        if (lisFamiliaProducto != null) {
                                            for (com.lewissa.jhano.logicanegocio.producto.CFamiliaProducto famFamilia : lisFamiliaProducto) {
                                                out.print("<option value=\"" + famFamilia.getStrId() + "\">" + famFamilia.getStrDescripcion() + "</option>");
                                            }
                                        }
                                        out.print("</select>");
                                        out.print("</td>");
                                    %> 
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input name="guardar" type="submit" value="Guardar"  />
                                        <input name="cancelar" type="button" value="Cancelar" onclick="location.href = '../interfacesJhano/interfazCargaProducto.jsp?can=true'"/>
                                    </td>
                                </tr>
                            </table> 
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

