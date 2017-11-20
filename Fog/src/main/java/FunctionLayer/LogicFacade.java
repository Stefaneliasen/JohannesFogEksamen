package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import entity.Material;
import entity.Order;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static ArrayList<Material> createMaterialList(int length, int width, int height) throws CarportException {
        CarportCalculator Calc = new CarportCalculator();
        return Calc.flatRoofMaterial(length, width, height);
    }
   public static User login( String email, String password ) throws CarportException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws CarportException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static int createOrder(Order order) throws SQLException, CarportException, ClassNotFoundException {
        OrderMapper om = new OrderMapper();
        return om.addOrder(order);
    }
    
}
