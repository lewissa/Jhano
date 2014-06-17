<%-- 
    Document   : interfazCargaPagos
    Created on : 15/06/2014, 09:31:43 AM
    Author     : wmoina
--%>

<%@page import="java.util.List"%>
<%@page import="com.google.common.util.concurrent.ExecutionError"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Jhano | Pagos </title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <link href="../SpryAssets/css/bootstrap.min.css" rel="stylesheet" media="screen">
            <link href="../SpryAssets/css/bootstrap-responsive.min.css" rel="stylesheet">
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
                </head>
                <body>
                    <table  style="background-color: #002a80; border: #f9f9f9" width="100%" height="50%" border="1">
                        <tr>
                            <th>
                                <a href="../index.jsp">
                                    <img src="Image/computech.jpg" alt="espoch" />
                                </a>
                            </th>
                            <th width="780">
                                <center>
                                    <font color="#FFFFFF" size="+6" face="Arial, Helvetica, sans-serif">
                                        Computech
                                    </font><br/>
                                    <h3>
                                        <font color="#FFFFFF" face="Arial">
                                            Soluciones en Tecnología Computacional
                                        </font>
                                    </h3>
                                </center>
                            </th>
                            <th align="center" rowspan="2">
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

                    <table style="background-color: #999999; border-color: #C0C0C0" width="100%" height="100%" border="1">
                        <tr>
                            <td width="12%">
                                <table border="0,1" align="left">
                                    <tr>
                                        <td>
                                            <a href="interfazIngresoPago.jsp">
                                                <font face="Arial">
                                                    Ingreso
                                                </font>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#">
                                                <font face="Arial">
                                                    Consulta
                                                </font>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="../index.jsp">
                                                <font face="Arial">
                                                    Regresar
                                                </font>
                                            </a>
                                        </td>
                                    </tr>
                                </table>

                                <td width="88%" align="center">
                                    <h3><center> <font size="5" face="Arial, Helvetica, sans-serif">Matriz Pago </font></center></h3>
                                    <form name="frmCargarPagos" action="../controladoresJhano/controladorInterfazCargaPago.jsp" method="post" >
                                        <table width="700" border="1" bgcolor="white">                                       
                                            <div class="container-fluid" >
                                                <div class="row-fluid" align="center">                                     
                                                    <div class="btn-toolbar span8 ">                       
                                                        <div class="btn-group span4" >
                                                            <a class="btn btn-primary span6" role="button" data-target="#addModal" data-toggle="modal">Nuevo</a>
                                                            <a class="btn btn-primary span6 dropdown-toggle" data-toggle="dropdown" href="#">
                                                                Eliminar
                                                                <span class="caret"></span>
                                                            </a>
                                                            <ul class="dropdown-menu">
                                                                <li><a id="delete" >Eliminar Seleccionado</a></li>
                                                                <!-- <li><a id="delete-all">Eliminar todos</a></li> -->
                                                            </ul>
                                                        </div>  
                                                        <div class="btn-group span4">
                                                            <a id="pagado" class="btn span6"><i class="icon-ok"></i> Pagado</a>
                                                            <a id="pendiente" class="btn span6"><i class="icon-remove"></i>Pendiente</a>
                                                        </div>
                                                    </div>  
                                                </div>      
                                                <div class="row-fluid" span="span8" >
                                                    <div span="span8">
                                                        <center>
                                                            <table class="table table-hover table-bordered" style="width: 50%; ">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Monto</th>
                                                                        <th>Fecha de pago</th>
                                                                        <th>Forma de pago</th>
                                                                        <th>Estado</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="prueba1">
                                                                </tbody>
                                                            </table>
                                                        </center>
                                                    </div>
                                                </div>
                                                </center>

                                                <!-- MODAL -->
                                                <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h3 id="myModalLabel">Ingreso Pagos</h3>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form>
                                                            <fieldset>
                                                                <div class="row-fluid">
                                                                    <div class="span6">
                                                                        <label>Monto:</label>
                                                                        <input class="span12" id="monto" type="text" placeholder="Dolares">
                                                                    </div>
                                                                    <div class="span6">
                                                                        <label>Forma de pago:</label>
                                                                        <div class="btn-group span12" data-toggle="buttons-radio">
                                                                            <a id="formaPago" class="memb-button btn btn-info  span6">Efectivo</a>
                                                                            <a class="memb-button btn btn-info span6">Cheque</a>
                                                                        </div> 
                                                                    </div>
                                                                </div>
                                                                <div class="row-fluid">
                                                                    <div class="span6">
                                                                        <label>Fecha de pago:</label>
                                                                        <input id="fechaPago" type="date" class="span12" >
                                                                    </div>                       
                                                                    <div class="span6">
                                                                        <label>Estado</label>
                                                                        <div class="btn-group span12" data-toggle="buttons-radio">
                                                                            <a id="estado" class="memb-button btn btn-info span6">Pendiente</a>
                                                                            <a class="memb-button btn btn-info span6">Pagado</a>
                                                                        </div> 
                                                                    </div>
                                                                </div>

                                                            </fieldset>
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <a id="save" href="#" class="btn btn-primary">Guardar</a>
                                                        <a class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</a>
                                                    </div>
                                                </div>

                                            </div>
                                            <script src="../SpryAssets/js/jquery-latest.js"></script>
                                            <script src="../SpryAssets/js/bootstrap.min.js"></script>
                                            <script type="text/javascript">
                                                /* Algo de funcionalidad basica... */
                                                $(document).ready(function() {
                                                    $("input").tooltip({"title": "Requerido"});
                                                });

                                                $("#pagado").click(function() {
                                                    $(".info").removeClass("error").addClass("success");
                                                    $(".info > .status").html("Pagado");
                                                });

                                                $("#pendiente").click(function() {
                                                    $(".info").removeClass("success").addClass("error");
                                                    $(".info > .status").html("Pendiente");
                                                });
                                                $("#save").click(function() {
                                                    save();
                                                });

                                                $("#delete").click(function() {
                                                    $(".info").remove();
                                                });
                                                function toggleSelected(tr) {
                                                    $(tr).toggleClass("info");
                                                }

                                                function resetForm() {
                                                    $("#monto").val("");
                                                    $("#fechaPago").val("");
                                                    $(".memb-button").removeClass("active");
                                                    $("#estado").addClass("active");
                                                    $("#formaPago").addClass("active");
                                                }

                                                function save() {
                                                    var approved = $("#estado").hasClass("active");
                                                    var approved1 = $("#formaPago").hasClass("active");
                                                    var colourClass = approved ? "success" : "error"
                                                    var colourClass1 = approved1 ? "success" : "error"
                                                    var status = approved ? "Pagado" : "Pendiente"
                                                    var status1 = approved1 ? "Efectivo" : "Cheque"
                                                    var row = "<tr class='" + colourClass + "'' onclick='toggleSelected(this)'><td>" + $("#monto").val() + "</td><td>" + $("#fechaPago").val() + "</td><td class='status1'>" + status1 + "</td><td class='status'>" + status + "</td></tr>";
                                                    $("#prueba1").append(row);
                                                    resetForm();
                                                    $("#addModal").modal("hide");
                                                }
                                            </script>
                                        </table>
                                </td>
                            </td>
                        </tr>
                    </table>
                    <script type="text/javascript">
                        var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
                        var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {imgDown: "SpryAssets/SpryMenuBarDownHover.gif", imgRight: "SpryAssets/SpryMenuBarRightHover.gif"});
                    </script>
                </body>
                </html>