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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Carport Measurement</title>
    </head>
    <body>

        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="visual">
            Length:
            <br>
            <input type="number" min="300" max="1000" name="length" required>
            <br>
            Width:
            <br>
            <input type="number" min="200" max="700" name="width" required>
            <br>
            Height:
            <br>
            <input type="number" min="200" max="400" name="height" required>
            <br>
            <br>
            <select class="btn btn-primary dropdown-toggle" id="skur" name="skurselector" onchange="onChanging()">
                <option value="uden">Uden skur</option>
                <option value="med">Med skur</option>
            </select>
            <p id="sLengthText" style="display: none"> Skur length:</p>
            <input style="display: none" id="sLength" type="number" name="sLength">
            <br>
            <input type="submit" value="Gå til tegning">
        </form>

        <form name="calculation" action="FrontController" method="POST">
            <input type="hidden" name="command" value="userlist">
            <input type="submit" value="Gå til brugerliste">
        </form>
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
