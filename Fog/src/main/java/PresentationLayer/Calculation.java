package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import entity.Material;
import entity.Order;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Calculation extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
        ArrayList<Material> materialList = LogicFacade.createMaterialList(length, width, height);
        HttpSession session = request.getSession();

        User user = (User) request.getSession().getAttribute("user");
        Order order = new Order(user.getId(), materialList);
        session.setAttribute("order", order);
        try {
            LogicFacade.createOrder(order);
        } catch (SQLException ex) {
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.getStackTrace();
        }
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("height", height);
        return "billOfMaterial";
    }
}
