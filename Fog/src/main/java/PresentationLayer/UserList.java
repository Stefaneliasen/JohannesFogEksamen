package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import entity.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class UserList extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        ArrayList<User> users = LogicFacade.getUsers();
        HttpSession session = request.getSession();
        session.setAttribute( "users", users );
        return "userList";
    }

}