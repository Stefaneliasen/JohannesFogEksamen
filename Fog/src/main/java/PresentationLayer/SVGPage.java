package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class SVGPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        // Check om sLength er null før vi parser
        int sLength = Integer.parseInt(request.getParameter("sLength"));
        
        session.setAttribute("sLength", sLength);
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("height", height);
        return "visualCarport";
    }

}
