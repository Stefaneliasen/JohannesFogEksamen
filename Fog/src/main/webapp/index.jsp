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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="WEB-INF/fogstyle.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body id="backgroundcolor">
        <img src="images/fog.png" alt=""/>
        <h3> Login </h3>
        <div class="text-center">        
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="command" value="login">

                <div class="input-group">
                    <label class="col-md-4 control-label" for="">Email</label>  
                    <div class="col-md-12">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="email" class="form-control" name="email" placeholder="email@fog.dk">
                    </div>
                    <br>
                    <div class="input-group">
                        <label class="col-md-4 control-label" for="">Password</label>  
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
                        <input type="submit" value="Login">
                    </div>
                </div>

                <br>
            </form>
        </div>


        <h3>Registration</h3>
        <div class="text-center">        
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
                            <input type="submit" value="Registrer">
                        </div>
                    </div>
            </form>
        </div>        

        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p> <%= error%>
            <% }
            %>
    </body>

</html>
