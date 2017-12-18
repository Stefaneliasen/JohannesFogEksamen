<%-- 
    Document   : userList
    Created on : 28-11-2017, 10:31:53
    Author     : Arne
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="../fogStyle.css" rel="stylesheet" type="text/css"/>
        <title>List of Users</title>
    </head>
    <body>
        <img src="../images/fog.png" alt=""/>
        <div class="divopacity">
            <div class="navigation">
                <h3>Alle brugere</h3>
                <ul class="list-group">
                    <% ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
                        if (users != null) {
                            for (int i = 0; i < users.size(); i++) {
                                out.print("<li class=\"list-group-item\"><a href='FrontController?userid=" + users.get(i).getId() + "&command=orderlist'>" + users.get(i).getEmail() + "</a></li>");
                            }
                        }
                    %>
                </ul>
            </div>
        </div>
    </body>
</html>
