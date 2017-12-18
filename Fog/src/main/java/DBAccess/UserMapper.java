package DBAccess;

import FunctionLayer.CarportException;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper {

private static final Logger LOGGER = Logger.getLogger( UserMapper.class.getName() );
private static final Handler handler = new ConsoleHandler();

    public static void main(String[] args) throws CarportException {
        
        for (int i = 0; i < 1; i++) {
            System.out.println(getUser().get(i).getId());
            System.out.println(getUser().get(i).getEmail());
        }

    }

    public static void createUser(User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws CarportException {
    LOGGER.addHandler(handler);
    handler.setLevel(Level.WARNING);
    LOGGER.setLevel(Level.WARNING);
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new CarportException("Could not validate user");
                //Simpel logger på userlogin
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log( Level.SEVERE, ex.toString(), ex);
            
            throw new CarportException(ex.getMessage());
        }
    }

    public static ArrayList<User> getUser() throws CarportException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString
                = "select * from user";

        User user = null;
        ArrayList<User> users = new ArrayList();
        try {
            Connection con = Connector.connection();
            stmt = con.prepareStatement(SQLString);
            rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("email"), rs.getInt("id"));
                users.add(user);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());

        }

        return users;
    }
}
