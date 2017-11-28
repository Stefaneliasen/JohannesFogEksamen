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
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <% ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
                if (users != null) {
                    for (int i = 0; i < users.size(); i++) {
                        out.print("<li><a href='FrontController?userid=" +users.get(i).getId() +"&command=orderlist'>"+ users.get(i).getEmail() +"</a></li>");
                    }
                }
            %>
        </ul>
    </body>
</html>
