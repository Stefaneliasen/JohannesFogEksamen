<%-- 
    Document   : userOrders
    Created on : 28-11-2017, 11:26:00
    Author     : Arne
--%>

<%@page import="entity.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul>
         <% ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
                if (orders != null) {
                    for (int i = 0; i < orders.size(); i++) {
                        out.print("<li><a href='FrontController?orderid=" + orders.get(i).getId() +"&command=odetails'>"+ orders.get(i).getId() + session.getAttribute("totalpris") +"</a></li>");
                    }
                }
            %>
        </ul>
    </body>
</html>
