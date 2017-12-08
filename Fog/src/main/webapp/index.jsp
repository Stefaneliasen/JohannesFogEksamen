<%-- 
    Document   : login
    Created on : 19-11-2017, 12:57:34
    Author     : Arne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="WEB-INF/fogStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h3 class="titelLogin"> Login </h3>
        <table>
            <tr>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">

                        <div class="container">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="email" class="form-control" name="email" placeholder="Email@Fog.com">
                            </div>
                            <br>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password" placeholder="password">
                            </div>
                            <br>
                        </div>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <h3 class="titelLogin"> Or Register </h3>
        <table>
            <tr>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        <div class="container">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="email" class="form-control" name="email" placeholder="email">
                            </div>
                            <br>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password1" placeholder="password">
                                <br>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password2" placeholder="retype password">
                                <br>
                            </div>
                        </div>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p> <%= error%>
            <% }
            %>
    </body>

</html>
