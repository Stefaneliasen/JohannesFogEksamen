<%-- 
    Document   : showOrders
    Created on : 28-11-2017, 11:49:34
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
        <title> Orders for customer </title>
    </head>
    <body>
        <table class="table table-striped">
            <tr>
                <th> Order id</th>
                <th> Material name</th>
                <th> Quantity </th>
                <th> Length </th>
                <th> Price per item </th>

            </tr>
            <% ArrayList<Order> odetails = (ArrayList<Order>) session.getAttribute("odetails");

                if (odetails != null) {
                    for (int i = 0; i < odetails.size(); i++) {
                        out.print("<tr><td>" + odetails.get(i).getId() + "</td>" + "<td>" + odetails.get(i).getPname() + "</td>" + "<td>" + odetails.get(i).getQuantity() + "</td>" + "<td>" + odetails.get(i).getLength() + "</td>" + "<td>" + odetails.get(i).getPrice() + "</td>" + "</tr>");
                    }
                }
            %>
        </table>
            
    </body>
</html>
