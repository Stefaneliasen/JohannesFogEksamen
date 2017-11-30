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

        int length = (int) request.getSession().getAttribute("length");
        int width = (int) request.getSession().getAttribute("width");
        int height = (int) request.getSession().getAttribute("height");
        if (request.getSession().getAttribute("sLength") != null) {
            int sLength = (int) request.getSession().getAttribute("sLength");
            if (sLength > 0 && sLength < length) {
                ArrayList<Material> shedList = LogicFacade.shedMaterialList(sLength, width, height);
                Order orderSkur = new Order(user.getId(), shedList);
                session.setAttribute("orderSkur", orderSkur);
                try {
                    LogicFacade.createOrder(orderSkur);
                } catch (SQLException ex) {
                    ex.getStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.getStackTrace();
                }
            }
        }
            ArrayList<Material> materialList = LogicFacade.createMaterialList(length, width, height);
            Order order = new Order(user.getId(), materialList);
            session.setAttribute("order", order);
            try {
                LogicFacade.createOrder(order);
            } catch (SQLException ex) {
                ex.getStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.getStackTrace();
            }
        
            return "billOfMaterial";
    }
}
