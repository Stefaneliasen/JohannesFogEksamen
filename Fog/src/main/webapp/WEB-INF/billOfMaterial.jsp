<%-- 
    Document   : billOfMeterial
    Created on : 22-11-2017, 09:55:06
    Author     : Arne
--%>

<%@page import="entity.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill of Materials</title>
        <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="myOrders">
        <table class="table table-striped">
            <tr>
                <th> | MaterialId  | </th>
                <th> Materialname | </th>
                <th> Quantity | </th>
                <th> Length | </th>
                <th> Price per item | </th>
                
            </tr>
            <% Order order = (Order) session.getAttribute("order");
                if (order.getMaterials() != null) {
                    for (int i = 0; i < order.getMaterials().size(); i++) {
                        out.print("<tr><td>" + order.getMaterials().get(i).getId() + "</td>" + "<td>" + order.getMaterials().get(i).getPname() + "</td>" + "<td>" + order.getMaterials().get(i).getAmount() + "</td>" +"<td>" + order.getMaterials().get(i).getLength() + "</td>" + "<td>" + order.getMaterials().get(i).getPrice() + "</td>" + "</tr>");
                    }
                }
            %>
            </tbody>
        </table>
    </form>
    </head>
    <body>
    </body>
</html>
