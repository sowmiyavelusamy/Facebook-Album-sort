package facebook4j.examples.signin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class taggedFriends
 */
@WebServlet("/taggedFriends")
public class taggedFriends extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
   
  
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Entered into TAGGED FRIENDS SERVLET ");
		 HttpSession session = request.getSession();
		 session.getAttribute( "tagnameList" );
		 System.out.println("FRIENDS NAME LIST::"+session.getAttribute( "tagnameList" ));
		RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
	            "/Tag.jsp");
	       reqDisp.forward(request, response);
	}

}
