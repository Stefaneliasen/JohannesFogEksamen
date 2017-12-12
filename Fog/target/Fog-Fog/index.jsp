<%-- 
    Document   : login
    Created on : 19-11-2017, 12:57:34
    Author     : Arne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="fogStyle.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <img src="images/fog.png" alt=""/>
        <div class="divopacity">
            <div id="loginDiv" class="navigation">        
                <br>
                <h3> Login </h3>
                <form name="login" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="login">

                    <div class="input-group">
                        <label class="col-md-12 control-label" for="">Email</label>  
                        <div class="col-md-12">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="email" class="form-control" name="email" placeholder="email@fog.dk">
                        </div>
                        <br>
                        <div class="input-group">
                            <label class="col-md-12 control-label" for="">Password</label>  
                            <div class="col-md-12">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password" placeholder="password">
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="input-group">
                        <label class="col-md-8 control-label" for=""></label>
                        <div class="col-md-8">
                            <input type="submit" class="btn btn-primary" value="Login">
                        </div>
                    </div>
                </form>
                <br>
                <form class="formnavigation">
                    <input type="button" class="btn btn-primary" value="Sign up" onclick="hideDiv()">
                </form>
            </div>


            <div id="registerDiv" class="navigation">        
                <h3>Registration</h3>
                <form name="register" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="register">
                    <div class="input-group">
                        <label class="col-md-4 control-label" for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>  
                        <div class="col-md-12">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="email" class="form-control" name="email" placeholder="email@fog.dk">
                        </div>
                        <br>
                        <div class="input-group">
                            <label class="col-md-4 control-label" for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>  
                            <div class="col-md-12">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password1" placeholder="password">
                            </div>
                        </div>
                        <div class="input-group">
                            <label class="col-md-4 control-label" for=""> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>  
                            <div class="col-md-12">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" name="password2" placeholder="retype password">
                            </div>
                        </div>
                        <br>
                        <div class="input-group">
                            <label class="col-md-8 control-label" for=""></label>
                            <div class="col-md-8">
                                <input type="submit" class="btn btn-primary" value="Registrer">
                            </div>
                        </div>
                </form>
                <br>
                <form class="formnavigation">
                    <input type="button" class="btn btn-primary" value="Go back to login" onclick="hideDiv()">
                </form>
            </div>
        </div>
        <br>
    </div>

    <% String error = (String) request.getAttribute("error");
        if (error != null) {%>
    <H2>Error!!</h2>
    <p> <%= error%>
        <% }
        %>
        <script>
            function hideDiv() {
                var loginDiv = document.getElementById("loginDiv");
                var registerDiv = document.getElementById("registerDiv");
                if (registerDiv.style.display === "" || registerDiv.style.display === "none") {
                    registerDiv.style.display = "block";
                    loginDiv.style.display = "none";
                    console.log(registerDiv.style.display);
                    console.log(loginDiv.style.display)
                } else {
                    registerDiv.style.display = "none";
                    loginDiv.style.display = "block";
                }

            }
            function myFunction2() {
                var registerDiv = document.getElementById("registerDiv");
                var loginDiv = document.getElementById("loginDiv");
                if (loginDiv.style.display === "" || loginDiv.style.display === "none") {
                    registerDiv.style.display = "none";
                    loginDiv.style.display = "block";
                }
            }
        </script>
</body>

</html>
