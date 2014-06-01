<%@page import="com.lewissa.jhano.logicanegocio.proveedor.CProveedor"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.lewissa.jhano.utilidades.cCorreo"%>
<%@page import="com.lewissa.jhano.utilidades.cRuc"%>
<%@page import="com.lewissa.jhano.utilidades.cCedula"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Modificar Proveedor </title>
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
            </tr>
        </table>

        <table bgcolor="#C0C0C0" width="100%" border="1">
            <tr>
                <td width="12%">
                    <table border="0.1" align="left">
                        <table border="0.1" align="center">
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
                        <h3><center>Modificar Proveedor</center></h3>
                        <form name="formProveedor" action="../controladoresJhano/controladorModificarProveedor.jsp" method="post">
                            <%
                                CProveedor oProveedor = new CProveedor();
                                if(request.getParameter("accion") != null)
                                {
                                    oProveedor.setId(request.getParameter("id"));
                                    oProveedor.setNombreFiscal(request.getParameter("nombreF"));
                                    oProveedor.setNombreComercial(request.getParameter("nombreC"));
                                    oProveedor.setDireccion(request.getParameter("direccion"));
                                    oProveedor.setConvencional(request.getParameter("convencional"));
                                    oProveedor.setCelular(request.getParameter("celular"));
                                    oProveedor.setCorreo(request.getParameter("correo"));
                                }else
                                {
                                    oProveedor= (CProveedor) request.getSession().getAttribute("oProveedor");
                                }
                                
                                
                                
                                  out.print("<table align=\"center\">");
                                   out.print("<tr>");
                                    out.print("<td><label>CI/RUC: </label></td>");
                                    out.print("<td><input type=\"hidden\" size=\"13\" maxlength=\"13\" name=\"id\"  value="+oProveedor.getId()+" />"+oProveedor.getId()+"</td>");
                                   out.print("<tr>"); 
                                   
                                    out.print("<td><label>Nombre Fiscal: </label></td>");
                                    if(oProveedor.getNombreFiscal().equals("0")){
                                    out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"nombreF\" /><font color=\"red\"> *Se requiere que el campo este lleno</font></td>");
                                    }else{
                                     out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"nombreF\" value="+oProveedor.getNombreFiscal()+" /></td>");   
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    
                                    
                                    out.print("<td><label>Nombre Comercial: </label></td>");
                                    if(oProveedor.getNombreComercial().equals("0")){
                                    out.print("<td><input type=\"text\" size=\50\" maxlength=\"50\" name=\"nombreC\" /></td>");
                                    }else{
                                        out.print("<td><input type=\"text\" size=\50\" maxlength=\"50\" name=\"nombreC\"  value="+oProveedor.getNombreComercial()+" /></td>");
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    
                                    
                                    out.print("<td><label>Direccion: </label></td>");
                                    if(oProveedor.getDireccion().equals("0")){
                                    out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"direccion\" /></td>");
                                    }else{
                                    out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"direccion\"  value="+oProveedor.getDireccion()+" /></td>");
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    
                                    
                                    out.print("<td><label>Telefono Convencional: </label></td>");
                                    if(oProveedor.getConvencional().equals("0"))
                                    {
                                    out.print("<td><input type=\"text\" name=\"telefonoCon\" size=\"7\" maxlength=\"7\"  /></td>");
                                    }else{
                                        out.print("<td><input type=\"text\" name=\"telefonoCon\" size=\"7\" maxlength=\"7\"  value="+oProveedor.getConvencional()+" /></td>");
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    
                                    
                                    out.print("<td><label>Telefono Celular: </label></td>");
                                    if(oProveedor.getCelular().equals("0")){
                                    out.print("<td><input type=\"text\" name=\"telefonoCel\" size=\"10\" maxlength=\"10\" /></td>");
                                    }else{
                                    out.print("<td><input type=\"text\" name=\"telefonoCel\" size=\"10\" maxlength=\"10\" value="+oProveedor.getCelular()+" /></td>");
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    
                                    out.print("<td><label>Correo Electronico: </label></td>");
                                    if(oProveedor.getCorreo().equals("0")){
                                    out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"correo\" /><font color=\"red\">*Se requiere que el campo este lleno</font> </td>");
                                    }else
                                    {
                                        if(request.getSession().getAttribute("errorCorreo") != null){
                                            Boolean booCorreo= (Boolean) request.getSession().getAttribute("errorCorreo");
                                            if(booCorreo == false){
                                                out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"correo\" value="+oProveedor.getCorreo()+" /><font color=\"red\">*Dato mal ingresado</font></td>");
                                            }
                                        }else{
                                            out.print("<td><input type=\"text\" size=\"50\" maxlength=\"50\" name=\"correo\" value="+oProveedor.getCorreo()+" /></td>");
                                        }
                                    }
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    out.print("<td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"boton\" value=\"Guardar Cambios\" />");
                                    out.print("<input type=\"button\" onclick=\"location.href='../interfacesJhano/interfazCargaProveedor.jsp'\" name=\"boton\" value=\"Cancelar\" /></td>");
                                    out.print("</tr>");
                                  out.print("</table>");
                                  
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