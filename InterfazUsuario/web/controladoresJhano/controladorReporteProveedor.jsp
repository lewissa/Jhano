<%-- 
    Document   : controladorReporteProducto
    Created on : 19/06/2014, 07:14:15 PM
    Author     : msgoon6
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Properties"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="org.jfree.base.Library"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
        try {
            File reportFile = new File(application.getRealPath("/reportesJhano/reporteProveedor.jasper"));
            Class.forName("org.postgresql.Driver");
            Properties proCredenciales = new Properties();
            proCredenciales.setProperty("user","dba_Computech");
            proCredenciales.setProperty("password", "123456");
            Connection conConexion = DriverManager.getConnection("jdbc:postgresql://10.0.1.1:5432/bd_Jhano", proCredenciales);
           
            Map parameters = new HashMap();

            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters,conConexion);

            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception ex) {
            out.print(ex);
        }
    %>