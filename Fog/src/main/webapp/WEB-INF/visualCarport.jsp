<%-- 
    Document   : visualCarport
    Created on : 23-11-2017, 10:15:25
    Author     : Arne
--%>

<%@page import="PresentationLayer.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int width = (int) request.getSession().getAttribute("width");
    int length = (int) request.getSession().getAttribute("length");
    int height = (int) request.getSession().getAttribute("height");
    int sLength = (int) request.getSession().getAttribute("sLength");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Se din carport</title>
    </head>
    <body>
        <svg width="75%" viewBox="0 0 <%=length * 2 + 1%> <%=width * 2 + 1%>">
        <%= SVGUtil.svgCarport(length, width, height, sLength)%>
        
        </svg>
        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="calculation">
            <input type="submit" value="Gå til stykliste">
        </form>
    </body>
</html>
