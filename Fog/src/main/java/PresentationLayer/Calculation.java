package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.PriceCalculator;
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
        int sLength = 0;
        double totalPrice = 0;
        // tjek om sLength er null eller ej.
        PriceCalculator priceCalc = new PriceCalculator();
        if (session.getAttribute("sLength") != null) {
            sLength = (int) session.getAttribute("sLength");
            ArrayList<Material> shedList = LogicFacade.shedMaterialList(sLength, width, height);
            Order orderSkur = new Order(user.getId(), shedList);
            session.setAttribute("orderSkur", orderSkur);
            totalPrice += priceCalc.totalOrderPrice(shedList);
            try {
                LogicFacade.createOrder(orderSkur);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.getStackTrace();
            }
        }
        ArrayList<Material> materialList = LogicFacade.createMaterialList(length, width, height, sLength);
        Order order = new Order(user.getId(), materialList);
        session.setAttribute("order", order);
        totalPrice += priceCalc.totalOrderPrice(materialList);
        try {
            LogicFacade.createOrder(order);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getStackTrace();
        }
        session.setAttribute("totalPrice", totalPrice);
        return "billOfMaterial";
    }
}
