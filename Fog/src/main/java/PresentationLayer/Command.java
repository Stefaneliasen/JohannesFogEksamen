package PresentationLayer;

import FunctionLayer.CarportException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of Command is to...

 @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "register", new Register());
        commands.put( "login", new Login() );
        commands.put("calculation", new Calculation());
        commands.put("visual", new SVGPage());
        commands.put("userlist", new UserList());
        commands.put("orderlist", new UserOrders());
        commands.put("odetails", new ViewOdetails());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException;

}
