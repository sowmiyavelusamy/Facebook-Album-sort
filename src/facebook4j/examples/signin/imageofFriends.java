package facebook4j.examples.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class imageofFriends
 */
@WebServlet("/imageofFriends")
public class imageofFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("Entered into IMAGE OF FRIENDS SERVLET");
	 HttpSession session = request.getSession();
	 
	 
	 System.out.println("PIC URL LIST::"+session.getAttribute( "TagPhotourlMap" ));
	 String clickedName = request.getParameter("tagName");
	 session.setAttribute("selectedName",clickedName);
	 System.out.println("print the clicked name::"+ request.getParameter("tagName"));
	 
	 
	RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
           "/tagImages.jsp");
      reqDisp.forward(request, response);
	 }
}
