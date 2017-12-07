package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import entity.Material;
import entity.Order;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Calculation extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int length = (int) session.getAttribute("length");
        int width = (int) session.getAttribute("width");
        int height = (int) session.getAttribute("height");
        // tjek om sLength er null eller ej.
        int sLength = (int) session.getAttribute("sLength");
            ArrayList<Material> materialList = LogicFacade.createMaterialList(length, width, height);
            Order order = new Order(user.getId(), materialList);
            session.setAttribute("order", order);
            try {
                LogicFacade.createOrder(order);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.getStackTrace();
            }
        
            return "billOfMaterial";
    }
}
