<%-- 
    Document   : visualCarport
    Created on : 23-11-2017, 10:15:25
    Author     : Arne
--%>

<%@page import="PresentationLayer.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int length = 600; // get this from a request attribute
    int width = 300; // get this from a request attribute
    int height = 200; // ditto
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Se din carport</title>
    </head>
     <svg width="75%" viewBox="0 0 <%=length*2+1%> <%=width*2+1%>">

        <!-- Benyt samme princip som tidligere til RenderUtils - her er det blot SVG vi genererer -->
        <%= SVGUtil.svgCarport(length, width, height)%>
        </svg>
   
        
        
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
