<%-- 
    Document   : calculation
    Created on : 19-11-2017, 13:23:46
    Author     : Arne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport Measurement</title>
    </head>
    <body>

        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="visual">
            Length:
            <br>
            <input type="text" name="length">
            <br>
            Width:
            <br>
            <input type="text" name="width" >
            <br>
            Height:
            <br>
            <input type="text" name="height">
            <br>
            <input type="submit" value="Gå til tegning">
        </form>
        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="userlist">
            <input type="submit" value="Gå til brugerliste">
        </form>

            </body>
            </html>
