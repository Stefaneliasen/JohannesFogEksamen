
package PresentationLayer;

import FunctionLayer.CarportException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BillOfMaterial extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
                HttpSession session = request.getSession();
                session.getAttribute("order");
         return "index";
}
}
