<%-- 
    Document   : interfazIngresoFactura
    Created on : 5-may-2014, 9:56:30
    Author     : Fredy Janeta
--%>

<%@page import="com.lewissa.jhano.logicanegocio.cliente.CCliente"%>
<%@page import="com.lewissa.jhano.logicanegocio.producto.CFamiliaProducto"%>
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
        <script src="../javascript/insertarFactura.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="../calendario/tcal.css" />
        <script type="text/javascript" src="../calendario/tcal.js"></script> 
    </head>

    <body>
         <script type="text/javascript">
            //se crea un objeto para manejar Ajax
            function nuevoAjax() {
                var xmlhttp = false;
                try {
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (E) {
                        xmlhttp = false;
                    }
                }

                if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
                    xmlhttp = new XMLHttpRequest();
                }
                return xmlhttp;
                
            }

            function cargarFamiliaProductos(idFamiliaPro, urlFamiliaPro) {
                var contenedorFamiliaPro;
                contenedorFamiliaPro = document.getElementById(idFamiliaPro);
                ajaxFamiliaPro = nuevoAjax();
                ajaxFamiliaPro.open("GET", urlFamiliaPro, true);
                ajaxFamiliaPro.onreadystatechange = function() {
                    if (ajaxFamiliaPro.readyState == 4) {
                        contenedorFamiliaPro.innerHTML = ajaxFamiliaPro.responseText;
                    }
                }
                ajaxFamiliaPro.send(null);
            }

            window.onload = function() {
                cargarFamiliaProductos('columnaFamiliaProductos', '../interfacesJhano/interfazAjaxCargarFamiliaProducto.jsp');
            }
        </script>
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
                <td width="30%" valign="top" >
                    <fieldset> <legend><FONT FACE="roman" SIZE="5">Familias de Productos</FONT></legend>
                    <table border="0.1" align="left">
                         <tr>
                            <td>
                                <%
                                        if(request.getSession().getAttribute("parametroProducto") != null)
                                        {    
                                            String strParametroBusquedaP= (String) request.getSession().getAttribute("parametroProducto");
                                            out.print("<input name=\"txtBusquedaProducto\" autofocus onfocus=\"finalFoco(this)\" onkeyup=\"redirectControladorProductoProducto()\" placeholder=\"Ingrese parametro de busqueda de Producto\" value='"+strParametroBusquedaP+"' size=\"50\" />");
                                            if(request.getSession().getAttribute("lisProductos") != null)
                                            {
                                                List<CProducto> lisProductos = (List<CProducto>) request.getSession().getAttribute("lisProductos");
                                                if(lisProductos.size() > 0){
                                                    out.print("<select name=\"productos\" >");
                                                    for(CProducto oProducto : lisProductos)
                                                    {
                                                        out.print("<option onclick=\"rellenarProducto('"+oProducto.getStrDescripcionGeneral()
                                                                +"','"+oProducto.getStrEan()+"','"+oProducto.getIntCantidad()+"','"+oProducto.getDouPrecioCosto()
                                                                +"')\" value="+oProducto.getStrIdProdu()+">"+oProducto.getStrEan()+", "+oProducto.getStrDescripcionGeneral());
                                                    }
                                                    out.print("</select>");
                                                }
                                                else
                                                {
                                                    request.getSession().setAttribute("lisProductos", null);
                                                }
                                                
                                            }
                                        }else{
                                            out.print("<input name=\"txtBusquedaProducto\" autofocus onfocus=\"finalFoco(this)\" onkeyup=\"redirectControladorProductoProducto()\" placeholder=\"Ingrese parametro de busqueda de Producto\"  size=\"50\" />");
                                        }
                                    %>
                                
                            </td>                                    
                        </tr>
                        <tr>
<<<<<<< HEAD
                              <td>
                                  <div id="columnaFamiliaProductos">

                                </div>
                              </td>
                          </tr>                                 
                        </table>
                     </fieldset>
                         
=======
                            <td>
                                <a href="../interfacesJhano/interfazCargaFactura.jsp">

                                    <font face="Arial">
                                        Regresar
                                    </font>
                                </a>
                            </td>
                        </tr>
                    </table>
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034
                </td>
                <%
                    String strError = (String) request.getSession().getAttribute("errorFamiliaProducto");
                    if (strError != null) {
                        out.print("<td >");
                            out.print("</td>");
                            out.print("<h3><center> <font size=\"3\" face=\"Arial, Helvetica, sans-serif\">" + strError.toString()+ "</font><a href=\"../interfacesJhano/interfazCargaFamiliaProducto.jsp\"><input name=\"cancelar\" type=\"button\" value=\"Ocultar\" /></a></center></h3>");
                            request.getSession().setAttribute("errorFamiliaProducto", null); }

                %>
                
                <td width="70%">
                    <font face="Arial">
                       
                        <%
<<<<<<< HEAD
                            List<CProducto> listProductosSeleccionados = new ArrayList<CProducto>();
                            CCliente oClienteSelecionado =  new CCliente();
                            
=======
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
>>>>>>> c5ada354b8e8925fb32c4ea2bb98c08598ab9034


                            com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa_Service service = new com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa_Service();
                            com.lewissa.jhano.logicanegocio.empresa.WsLogicaNegocioEmpresa port = service.getWsLogicaNegocioEmpresaPort();
                             // TODO initialize WS operation arguments here
                            java.lang.String strParametro = "1723834931001";
                            CEmpresa oEmpresa = new CEmpresa();
                            // TODO process result here
                            java.util.List<com.lewissa.jhano.logicanegocio.empresa.CEmpresa> listEmpresas = port.buscarEmpresa(strParametro);

                            



                            for(CEmpresa oEmpresa1 : listEmpresas)
                            {
                                oEmpresa=oEmpresa1;
                            }
                         %>
                        <form method="post" action="../controladoresJhano/controladorInterfazIngresoFactura.jsp" name="formIngresoFactura">        
                        <%-->
                        <fieldset> <legend><FONT FACE="roman" SIZE="5">Datos de la Empresa</FONT></legend>
                        <table bgcolor="white">
                            <tr>                                
                                <td>Nombre Fiscal: </td>
                                <td><input type="text" readonly="true" name="nombreFiscal" value="<%=oEmpresa.getStrNombreFiscal()%>" /></td>
                           
                            </tr>
                            <tr>
                                <td>RUC: </td>
                                <td><input type="text" readonly="true" name="ciruc" value="<%=oEmpresa.getStrRuc()%>" /></td>
                      
                            </tr>
                            <tr>
                                <td>Direccion: </td>
                                <td><input type="text" readonly="true" name="direccion" value="<%=oEmpresa.getStrDirecccion()%>" /></td>
                        
                            </tr>
                            <tr>
                                <td>Telefono: </td>
                                <td><input type="text" readonly="true" name="telefono" value="<%=oEmpresa.getStrTelefono()%>" /></td>
                
                            </tr>
                            </table>
                        </fieldset>
                                
                        <--%>        
                       <% ///////////////////////////////////////////////////%>         
                       
                       <fieldset> <legend><FONT FACE="roman" SIZE="5">Factura</FONT></legend>
                        <table bgcolor="">
                            <tr>
                                <td colspan="4">
                                    <%
                                        if(request.getSession().getAttribute("parametroCliente") != null)
                                        {    
                                            String strParametroBusquedaC= (String) request.getSession().getAttribute("parametroCliente");
                                            out.print("<input name=\"txtBusquedaCliente\" autofocus onfocus=\"finalFoco(this)\" onkeyup=\"redirectControladorProductoCliente()\" placeholder=\"Ingrese parametro de busqueda de Cliente\" value='"+strParametroBusquedaC+"' size=\"50\" /><br>");
                                            if(request.getSession().getAttribute("lisClientes") != null)
                                            {
                                                List<CCliente> lisClientes = (List<CCliente>) request.getSession().getAttribute("lisClientes");
                                                if(lisClientes.size() > 0){
                                                    out.print("<select id=\"selectCliente\" name=\"clientes\">");
                                                    for(CCliente oCliente : lisClientes)
                                                    {
                                                        out.print("<option onclick=\"rellenarCiente('"+oCliente.getStrIdCliente()+"','"+oCliente.getStrNombreFiscal()
                                                                +"','"+oCliente.getStrDireccion()+"','"+oCliente.getStrCelular()
                                                                +"')\" value="+oCliente.getStrIdCliente()+">"+oCliente.getStrIdCliente()+", "+oCliente.getStrNombreFiscal());
                                                        out.print("</option>");
                                                        
                                                    }
                                                    out.print("</select>");
                                                }
                                                else
                                                {
                                                    request.getSession().setAttribute("lisClientes", null);
                                                }
                                                
                                            }
                                        }else{
                                            out.print("<input name=\"txtBusquedaCliente\" autofocus onfocus=\"finalFoco(this)\" onkeyup=\"redirectControladorProductoCliente()\" placeholder=\"Ingrese parametro de busqueda de Cliente\"  size=\"50\" /><br>");
                                        }
                                    %>
                                   
                                    
                                                                       
                                </td>
                            </tr>
                                    <% if(request.getSession().getAttribute("clienteSeleccionado") != null){  
                                    CCliente oClienteS = (CCliente) request.getSession().getAttribute("clienteSeleccionado");
                                    
                                    %>     
                            <tr>                 
                                
                                <td colspan="2" >CI/RUC: </td>
                                <td><input type="text" id="cirucC" readonly="true" name="cirucC" maxlength="13" value="<%=oClienteS.getStrIdCliente()%>" /></td>
                                
                                <td colspan="2">N. Factura: </td>
                                <td><input type="text"  id="idFactura"  name="idFactura" maxlength="40" value="<% 
                                if(request.getSession().getAttribute("idFactura") != null) 
                                {
                                    out.print(request.getSession().getAttribute("idFactura"));
                                }    
                                
                                %>" /></td>
                               
                           
                            </tr>
                            <tr>
                                <td colspan="2">Nombre y Apellidos: </td>
                                <td><input type="text"  id="nombreC" name="nombreC" readonly="true" maxlength="50" size="50" value="<%=oClienteS.getStrNombreFiscal()%>" /></td>
                         
                                <td colspan="2">Telefono: </td>
                                <td><input type="text" id="telefonoC" readonly="true" name="telefonoC" size="10" value="<%
                                if(!(oClienteS.getStrCelular().equals("null")))
                                   out.print(oClienteS.getStrCelular());
                                %>" /></td>   
                                                   
                            </tr>
                            <tr>
                                <td colspan="2">Direccion: </td>
                                <td><input type="text" id="direccionC" readonly="true" name="direccionC" size="50" maxlength="50" value="<%=oClienteS.getStrDireccion()%>" /></td>
                      
                                <td colspan="2">fecha de Emision: </td>
                                <td><input type="text" id="fechaC" name="fechaC" required maxlength="10" class="tcal" value="<% 
                                        if((request.getSession().getAttribute("fechaC") != null))                        
                                            out.print(request.getSession().getAttribute("fechaC"));                                  
                                %>" /></td>
                
                            </tr>
                            <% 
                                    }else{
                                    
                            %>
                                    <tr>                 
                                
                                <td colspan="2">CI/RUC: </td>
                                <td><input type="text" id="cirucC" readonly="true" name="cirucC" maxlength="13" value="" /></td>
                      
                                <td colspan="2">N. Factura: </td>
                                <td><input type="text"  id="idFactura"  name="idFactura" maxlength="40" value="" /></td>
                               
                           
                            </tr>
                            <tr>
                                <td colspan="2">Nombre y Apellidos: </td>
                                <td><input type="text"  id="nombreC" name="nombreC" readonly="true" maxlength="50" size="50" value="" /></td>
                      
                                <td colspan="2">Telefono: </td>
                                <td><input type="text" id="telefonoC" readonly="true" maxlength="10" size="10" name="telefonoC" value="" /></td>
                                
                                                     
                            </tr>
                            <tr>
                                <td colspan="2">Direccion: </td>
                                <td><input type="text" id="direccionC" readonly="true" name="direccionC" size="50" maxlength="50" value="" /></td>  
                          
                                <td colspan="2">fecha de Emision: </td>
                                <td><input type="text" id="fechaC" name="fechaC" required class="tcal" value="" /></td>
                
                            </tr>
                            
                            <%
                                    }
                            %>
                            </table>
                           <br>

                       
                       
                       
                                
                                <% ///////////Productos %>

                        <table bgcolor="" border="1">
                            <tr>                                
                                
                                <td>Descripcion</td>
                                <td>Codigo EAN</td>
                                <td>Cantidad </td>
                                <td>V. Unitario</td>
                                <td>V. Total</td>
                                
                            </tr> 
                            <tr>                                
                      
                                    <td><input type="text"  id="descripcionP" readonly="true" name="descripcion"/></td>
                                    <td><input type="text"  id="codigoEanP" name="codigoean" readonly="true" /></td>
                                    <td><input type="text" id="cantidadP" onchange="sumarUnitarioTotal()" name="cantidad" required /></td>
                                    <td><input type="text" id="vUnitarioP" onchange="sumarUnitarioTotal()" name="vunitario" required/></td>
                                    <td><input type="text"id="vTotal"  readonly="true" name="vtotal" /></td>
                                
                                </tr> 
                                    <%
                                     if(request.getSession().getAttribute("listaProductos") != null)
                                     {  
                                       listProductosSeleccionados= (List<CProducto>)request.getSession().getAttribute("listaProductos");
                                       if(listProductosSeleccionados.size()>0)
                                       {
                                           request.getSession().setAttribute("listaProductos",listProductosSeleccionados);
                                           for(CProducto oProducto : listProductosSeleccionados)
                                           {
                                             %>
                                              <tr>
                                                <td><input type="text"  id="descripcionPL" readonly value="<%=oProducto.getStrDescripcionGeneral()%>" required /></td>
                                                <td><input type="text"  id="codigoEanPL"  readonly value="<%=oProducto.getStrEan()%>" /></td>
                                                <td><input type="text" id="cantidadPL" readonly value="<%=oProducto.getIntCantidad()%>" /></td>
                                                <td><input type="text" id="vUnitarioPL" readonly  value="<%=oProducto.getDouPrecioCosto()%>" /></td>
                                                <td><input type="text"id="vTotalL"  readonly /></td>
                                              </tr>  
                                             <%
                                           }
                                           
                                       }
                                     }
                                    %>
                               
                                    <tr>
                                        <td colspan="3" rowspan="4" >
                                            <input type="button" name="boton" onclick="agregarProducto()" value="Agregar"/>  
                                        </td>
                                        <td>Subtotal $</td>
                                        <td><input name="subtotal" readonly type="text" maxlength="10" />          </td>
                                    </tr>    
                                    <tr>

                                        <td>12% I.V.A $</td>
                                        <td><input name="iva" type="text" readonly maxlength="10" />          </td>
                                    </tr>
                                    
                                    <tr>

                                        <td>Total $</td>
                                        <td> <input name="total" readonly type="text" maxlength="10" />         </td>
                                    </tr>                      
                           
                            </table>

                            <table>
                                        <tr>
                                            <td>
                                                <br>
                                                Pagada
                                                <INPUT TYPE="RADIO" id="estadoF" NAME="estadoF" VALUE="TRUE">
                                                
                                            <td> 
                                            <td>
                                                <br>
                                                No Pagada
                                                <INPUT TYPE="RADIO" id="estadoF" NAME="estadoF" VALUE="FALSE">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" >
                                                <center>
                                                <br>
                                                <input type="submit" name="boton" value="Guardar"/>
                                                <input type="submit" name="boton" value="Imprimir"/>
                                                <input type="button" name="boton" onclick="location.href='../interfacesJhano/interfazCargaFactura.jsp'" value="Cancelar"/>
                                                </center>
                                             </td>   
                                        </tr>   
                           
                            
                            
                            
                            </table>

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