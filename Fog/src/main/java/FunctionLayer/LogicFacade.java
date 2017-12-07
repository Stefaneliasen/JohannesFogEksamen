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

    public static ArrayList<Material> createMaterialList(int length, int width, int height, int sLength) throws CarportException {
        CarportCalculator Calc = new CarportCalculator();
        return Calc.flatRoofMaterial(length, width, height, sLength);
    }
    public static ArrayList<Material> shedMaterialList(int sLength, int width, int height) throws CarportException {
        ShedCalculator shed = new ShedCalculator();
        return shed.shedMaterial(sLength, width, height);
    }

    public static User login(String email, String password) throws CarportException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws CarportException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static int createOrder(Order order) throws SQLException, CarportException, ClassNotFoundException {
        OrderMapper om = new OrderMapper();
        return om.addOrder(order);
    }

    public static ArrayList<User> getUsers() throws CarportException {
        return UserMapper.getUser();
    }

    public static ArrayList<Order> viewOrders(int userid) throws CarportException {
        OrderMapper om = new OrderMapper();
        return om.viewOrder(userid);
    }
    public static ArrayList<Order> viewOdetails(int id) throws CarportException {
        OrderMapper om = new OrderMapper();
        return om.viewOdetails(id);
    }
}
