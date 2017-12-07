package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.PriceCalculator;
import entity.Order;
import entity.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class ViewOdetails extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        int orderId = Integer.parseInt(request.getParameter("orderid"));
        ArrayList<Order> odetails = LogicFacade.viewOdetails(orderId);
        HttpSession session = request.getSession();
        PriceCalculator priceCalc = new PriceCalculator();
        for (int i = 0; i < odetails.size(); i++) {
        priceCalc.totalOrderPrice(odetails.get(i).getMaterials());
        }
        session.setAttribute( "odetails", odetails );
        return "showOrders";
    }

}