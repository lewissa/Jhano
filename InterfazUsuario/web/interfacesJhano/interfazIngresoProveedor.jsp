<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.lewissa.jhano.utilidades.cCorreo"%>
<%@page import="com.lewissa.jhano.utilidades.cRuc"%>
<%@page import="com.lewissa.jhano.utilidades.cCedula"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%
    String strId, strNombFisc, strNombComer, strDireccion, strConvencional, strCeular, strCorreo;
    com.lewissa.jhano.proveedor.CProveedor provProve
            = (com.lewissa.jhano.proveedor.CProveedor) request.getSession().getAttribute("sesprov");
    if (request.getSession().getAttribute("sesprov") != null) {
        strId = provProve.getId();
        strNombFisc = provProve.getNombreFiscal();
        strNombComer = provProve.getNombreComercial();
        strDireccion = provProve.getDireccion();
        strConvencional = provProve.getConvencional();
        strCeular = provProve.getCelular();
        strCorreo = provProve.getCorreo();
    } else {
        strId = "";
        strNombFisc = "";
        strNombComer = "";
        strDireccion = "";
        strConvencional = "";
        strCeular = "";
        strCorreo = "";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Ingresar Proveedor </title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <table bgcolor='#192B75' width="100%" height="50%" border="1">
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
            </tr>
        </table>

        <table bgcolor="#C0C0C0" width="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="1" align="left">
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
                    <font face='Arial'>
                        <h3><center>Ingreso de Proveedor</center></h3>
                        <form name="form1" action="../controladoresJhano/controladorIngresoProveedor.jsp" method="POST">
                            <table border="0" align="center">
                                <tr>
                                    <td><label>CI / RUC:</label></td>
                                    <td><input name="ciruc" type="text" size="13" maxlength="13" value="<%out.print(strId);%>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Nombre Fiscal:</label></td>
                                    <td><input name="nombrefiscal" type="text" size="25" value="<%
                                        out.print(strNombFisc);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Nombre Comercial:</label></td>
                                    <td><input name="nombrecomer" type="text" size="25" value="<%
                                        out.print(strNombComer);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Dirección:</label></td>
                                    <td><input name="direccion" type="text" size="50" value="<%
                                        out.print(strDireccion);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Teléfono Convencional:</label></td>
                                    <td><input name="convencional" type="text" size="7" maxlength="7" value="<%
                                        out.print(strConvencional);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Celular:</label></td>
                                    <td><input name="celular" type="text" size="10" maxlength="10" value="<%
                                        out.print(strCeular);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td><label>Correo Electrónico:</label></td>
                                    <td><input name="correo" type="text" size="50" value="<%
                                        out.print(strCorreo);
                                               %>"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input name="submit" type="submit" value="Guardar"  />
                                        <input name="cancelar" type="button" value="Cancelar" />
                                    </td>
                                </tr>
                                
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