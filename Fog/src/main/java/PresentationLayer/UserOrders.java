package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
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
public class UserOrders extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        int userId = Integer.parseInt(request.getParameter("userid"));
        ArrayList<Order> orders = LogicFacade.viewOrders(userId);
        HttpSession session = request.getSession();
        session.setAttribute( "orders", orders );
        return "userOrders";
    }

}
