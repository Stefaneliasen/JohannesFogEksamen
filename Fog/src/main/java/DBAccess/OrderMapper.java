package DBAccess;

import FunctionLayer.CarportException;
import entity.Material;
import entity.Order;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderMapper {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, CarportException {
        OrderMapper om = new OrderMapper();
        Material material = new Material("hej", 1);
        ArrayList<Material> materials = new ArrayList();
        materials.add(material);
        Order order = new Order(1, materials);
        om.addOrder(order);

    }

    public int addOrder(Order order) throws SQLException, ClassNotFoundException, CarportException {
        Connection con = Connector.connection();
        String sql = "insert into orders (user_userId) values (?);";
        try (
                PreparedStatement statement = con.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);) {
            statement.setInt(1, order.getUserId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new CarportException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                    addOdetails(order);
                } else {
                    throw new CarportException("Creating order failed, no ID obtained.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                throw new CarportException("addorder" + ex.getMessage());
            }
        }
        return order.getId();
    }

    public void addOdetails(Order order) throws ClassNotFoundException, SQLException, CarportException {
        Connection con = Connector.connection();
        PreparedStatement order1 = null;
        String SQLString = "insert into billofmaterials (orders_orderId, material_id, quantity, length) values (?,?,?,?)";
        try {
            order1 = con.prepareStatement(SQLString);
            order1.setInt(1, order.getId());
            for (int i = 0; i < order.getMaterials().size(); i++) {
                System.out.println("Material id " + order.getMaterials().get(i).getId());
                order1.setInt(2, order.getMaterials().get(i).getId());
                order1.setInt(3, order.getMaterials().get(i).getAmount());
                order1.setInt(4, order.getMaterials().get(i).getLength());
                order1.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new CarportException("addodetails: " + ex.getMessage());
        }
    }

    public ArrayList<Order> viewOrder(int id) throws CarportException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString
                = "Select * from orders where user_userId = ?";
        
        Order order = null;
        ArrayList<Order> orders = new ArrayList();
        
        try {
            Connection con = Connector.connection();
            stmt = con.prepareStatement(SQLString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt("orderid"), rs.getInt("user_userId"));
                orders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
        return orders;
    }
    public ArrayList<Order> viewOdetails(int id) throws CarportException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString
                = "Select * from material m, billofmaterials b where b.orders_orderId = ? AND b.material_id = m.id";
        
        Order order = null;
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            stmt = con.prepareStatement(SQLString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) { 
                order = new Order(rs.getInt("orders_orderId"), rs.getString("pname"), rs.getInt("length"), rs.getInt("quantity"), rs.getInt("price"));
                orders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
        return orders;
    }
    
}
