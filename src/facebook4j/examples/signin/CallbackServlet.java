package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	final Facebook facebook =(Facebook) request.getSession().getAttribute("facebook");
    	final String oauthCode = request.getParameter("code");
    	
        //String oauthCode = request.getParameter("code");
        try {
           // facebook.getOAuthAccessToken(oauthCode);
        	 FaceBookInstance.setToken(facebook.getOAuthAccessToken(oauthCode));
        	 request.getSession().setAttribute("facebook",FaceBookInstance.get());
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
