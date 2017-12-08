<%-- 
    Document   : calculation
    Created on : 19-11-2017, 13:23:46
    Author     : Arne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="fogstyle.css" rel="stylesheet" type="text/css"/>
        <title>Carport Measurement</title>
    </head>
    <body>
        <div class="container-fluid">
            <h2>Please fill in the dimensions of your carport</h2>  
        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="visual">
            <br>
            <div class="input-group">
                <span class="input-group-addon">Length</span>
                <input type="number" min="300" max="1000" name="length" required>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Width</span>
                <input type="number" min="200" max="700" name="width" required>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Height</span>
                <input type="number" min="200" max="400" name="height" required>
            </div>

            <br>
            <br>
            <select class="btn btn-primary dropdown-toggle" id="skur" name="skurselector" onchange="onChanging()">
                <option value="uden">Uden skur</option>
                <option value="med">Med skur</option>
            </select>
            <br>
            <p id="sLengthText" style="display: none"> Skur length:</p>
            <input style="display: none" id="sLength" type="number" name="sLength">
            <br>
            <input type="submit" value="Gå til tegning">
            <br>
        </form>
        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="userlist">
            <br>
            <input type="submit" value="Gå til brugerliste">
        </form>
        </div>
        <script>
            var skur = document.getElementById("skur");

            function onChanging() {
                var sLength = document.getElementById("sLength");
                var sLengthText = document.getElementById("sLengthText");
                if (skur.value == 'med') {
                    sLength.style.display = 'block';
                    sLengthText.style.display = 'block';

                } else {
                    sLength.style.display = 'none';
                    sLengthText.style.display = 'none';
                }
            }
        </script>
    </body>
</html>
