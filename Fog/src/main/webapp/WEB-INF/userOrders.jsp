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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="../fogStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img src="../images/fog.png" alt=""/>
        <div class="divopacity">
            <div class="navigation">
                <ul class="list-group">
                    <h3> Brugerens ordrenumre</h3>
                    <% ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
                        if (orders != null) {
                            for (int i = 0; i < orders.size(); i++) {
                                out.print("<li class=\"list-group-item\"><a href='FrontController?orderid=" + orders.get(i).getId() + "&command=odetails'>" + orders.get(i).getId() + "</a></li>");

                            }
                        }
                    %>
                </ul>
            </div>
        </div>
    </body>
</html>
