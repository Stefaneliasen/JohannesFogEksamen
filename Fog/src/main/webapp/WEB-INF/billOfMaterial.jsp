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
            <tbody>
            <h4>Carportens materialer</h4>
            <tr>
                <th> Material id </th>
                <th> Materialname </th>
                <th> Quantity </th>
                <th> Length </th>
                <th> Price per item </th>

            </tr>
            <% Order order = (Order) session.getAttribute("order");
                if (order.getMaterials() != null) {
                    for (int i = 0; i < order.getMaterials().size(); i++) {
                        if (order.getMaterials().get(i).getLength() == 0) {
                            out.print("<tr><td>" + order.getMaterials().get(i).getId() + "</td>" + "<td>" + order.getMaterials().get(i).getPname() + "</td>" + "<td>" + order.getMaterials().get(i).getAmount() + "</td>" + "<td>" + "-" + "</td>" + "<td>" + order.getMaterials().get(i).getPrice() + "</td>" + "</tr>");
                        } else {
                            out.print("<tr><td>" + order.getMaterials().get(i).getId() + "</td>" + "<td>" + order.getMaterials().get(i).getPname() + "</td>" + "<td>" + order.getMaterials().get(i).getAmount() + "</td>" + "<td>" + order.getMaterials().get(i).getLength() + "</td>" + "<td>" + order.getMaterials().get(i).getPrice() + "</td>" + "</tr>");
                        }
                    }
                }
            %>
            </tbody>
        </table>
        <table class=" table table-striped">
            <tbody>
                <% if (session.getAttribute("orderSkur") != null) { %>
            <h4>Skurets materialer</h4>
            <tr>
                <th> Material id &nbsp; | </th>
                <th> Materialname </th>
                <th> Quantity </th>
                <th> Length </th>
                <th> Price per item </th>   
            </tr>

            <% Order orderSkur = (Order) session.getAttribute("orderSkur");
                    if (orderSkur.getMaterials() != null) {
                        for (int i = 0; i < orderSkur.getMaterials().size(); i++) {
                            if (orderSkur.getMaterials().get(i).getLength() == 0) {
                                out.print("<tr><td>" + orderSkur.getMaterials().get(i).getId() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getPname() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getAmount() + "</td>" + "<td>" + "-" + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getPrice() + "</td>" + "</tr>");

                            } else {
                                out.print("<tr><td>" + orderSkur.getMaterials().get(i).getId() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getPname() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getAmount() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getLength() + "</td>" + "<td>" + orderSkur.getMaterials().get(i).getPrice() + "</td>" + "</tr>");
                            }
                        }
                    }
                }
            %>
            </tbody>
        </table>
    </form>
    <%= session.getAttribute("totalPrice")%>
</head>
<body>
</body>
</html>
