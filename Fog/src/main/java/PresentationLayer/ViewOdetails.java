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
        double totalPrice = 0;
//        for (int i = 0; i < odetails.size(); i++) {
//        totalPrice += priceCalc.totalOrderPriceOrder(odetails);
        session.setAttribute( "odetails", odetails);
        session.setAttribute ("totalprice1", totalPrice);
        return "showOrders";
    }

}