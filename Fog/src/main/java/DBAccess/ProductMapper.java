package DBAccess;

import FunctionLayer.CarportException;
import entity.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static void main(String[] args) throws CarportException {
        ProductMapper pm = new ProductMapper();
        System.out.println(pm.getMaterialById(3).getPname());

    }

    public Material getMaterialById(int id) throws CarportException {
        Material material = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT pname, price FROM material where id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                material = new Material(rs.getString("pname"), rs.getInt("price"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
            return material;
    }
}
