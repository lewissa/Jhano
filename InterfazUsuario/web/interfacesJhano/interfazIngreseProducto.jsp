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
                         <tr>
                            <td>
                                <a href="../InterfazUsuario_1/interfacesJhano/interfazCargaProducto.jsp">
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
                           <form name="form1" action="" method="POST">
                            <table border="0" align="center">
                                <tr>
                                    <td><label>EAN:</label></td>
                                    <td><input name="ean" type="text" size="50" maxlength="50" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Fabricación:</label></td>
                                    <td><input name="fabricacion" type="text" size="50" maxlength="50" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Descripcion general:</label></td>
                                    <td><input name="descripcion_general" type="text" size="50" maxlength="50" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Margen ganancia:</label></td>
                                    <td><input name="margen_ganancia" type="text" size="20" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Cantidad:</label></td>
                                    <td><input name="cantidad" type="text" size="20" maxlength="20" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Precio costo:</label></td>
                                    <td><input name="precio_costo" type="text" size="20" maxlength="20" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Margen venta:</label></td>
                                    <td><input name="margen_venta" type="text" size="20" maxlength="20" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Proveedor:</label></td>
                                    <td><select  name="proveedor" type="text" size="1" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Stock máximo:</label></td>
                                    <td><input name="stock_max" type="text" size="50" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Stock mínimo:</label></td>
                                    <td><input name="stock_min" type="text" size="50" value=""/></td>
                                </tr>
                                <tr>
                                    <td><label>Familia producto:</label></td>
                                    <td><select name="familia_prod" type="text" size="1" value=""/></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input name="submit" type="submit" value="Guardar"  />
                                        <input name="cancelar" type="button" value="Cancelar" />
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
