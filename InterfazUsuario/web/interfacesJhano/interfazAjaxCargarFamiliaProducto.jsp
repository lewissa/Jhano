<%@page import="com.sun.rowset.WebRowSetImpl"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.List"%>
<div>
    <%
        //String strCod = request.getParameter("cod");
        String strCodigo = (request.getParameter("cod") != null) ? "true" : "false";
        Integer intCantidad= (request.getParameter("cantidad") != null) ? Integer.parseInt(request.getParameter("cantidad")) : 0;
        if (strCodigo.equals("false")) {
            String strCarga = (request.getParameter("car") != null) ? "true" : "false";
            if (strCarga.equals("false")) {
                response.sendRedirect("../controladoresJhano/controladorAjaxFamiliaProducto.jsp");
            }

            List<com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto> familiaprod = (List<com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto>) request.getSession().getAttribute("familiaproductos");
            out.print("<ul>");
            if (familiaprod != null) {
                for (com.lewissa.jhano.logicanegocio.familiaproducto.CFamiliaProducto familia : familiaprod) {
                   

                        com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service service = new com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto_Service();
                        com.lewissa.jhano.logicanegocio.familiaproducto.WsLogicaNegocioFamiliaProducto port = service.getWsLogicaNegocioFamiliaProductoPort();
                        // TODO process result here
                        java.lang.String result = port.getNumeroDeProductosPorFamilia(familia.getStrId());
                        StringReader strReader = new StringReader(result);
                        WebRowSetImpl wrsImplement = new WebRowSetImpl();
                        wrsImplement.readXml(strReader);
                        Integer intNumeroProductos=0;
                        while(wrsImplement.next()){
                        intNumeroProductos =  Integer.parseInt(wrsImplement.getString("numero_registro").toString());
                        }
                        out.print("<div><li type=\"disc\"><a href=\" javascript:cargarFamiliaProductos('columnaFamiliaProductos', '../interfacesJhano/interfazAjaxCargarFamiliaProducto.jsp?cod="+familia.getStrId()+"&cantidad="+intNumeroProductos+"') \" class='more'>"+familia.getStrDescripcion()+" ("+intNumeroProductos+")</li></div>");

                }
            } else {
                out.print("Está vacio");
            }
            out.print("<ul>");

        } else {

            String strCarga = (request.getParameter("car") != null) ? "true" : "false";
            if (strCarga.equals("false")) {
            response.sendRedirect("../controladoresJhano/controladorAjaxProducto.jsp?cod=" + request.getParameter("cod") + " ");
            }
            List<com.lewissa.jhano.logicanegocio.producto.CProducto> lsproducto = (List<com.lewissa.jhano.logicanegocio.producto.CProducto>) request.getSession().getAttribute("producto");
            

                if (lsproducto != null) {
                    out.print("<ul>");
                    for (com.lewissa.jhano.logicanegocio.producto.CProducto product : lsproducto) {
                        out.print("<li type=\"circle\">");
                        out.print(product.getStrDescripcionGeneral()+" ("+product.getIntCantidad()+")");
                        out.print("</li>");
                    }
                    out.print("</ul>");

                } else {
                    out.print("Está vacio");
                }
       
    %>   
    <br><br/>
    <a href="javascript:cargarFamiliaProductos('columnaFamiliaProductos' , '../interfacesJhano/interfazAjaxCargarFamiliaProducto.jsp')">&lt;&lt; volver</a><br><br />
    <%
            //out.print(strCod);
            //out.print("Llegare....");
            //out.print(request.getParameter("cod"));
        }
    %>

</div>