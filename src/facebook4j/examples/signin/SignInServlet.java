package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;
    private static final String appId="1122189991227970";
    private static final String appSecret="5f8d7bd51759e36c8f6a30e3c69eaf95";
   private static final String commaSeparetedPermissions="email,user_birthday,user_photos,user_videos,user_posts";
  // private static final String commaSeparetedPermissions="email,user_online_presence,user_birthday,user_groups,user_photos,user_videos,user_posts";
    private static final String accessToken="EAACEdEose0cBADV9oltvVvVhgS5Q6519FOZBsFmNd6zNMkTEy9caoA1PmZBZAF7qJNXz5AWpWK25ZA1ny9nAoQv4BBOJibBvUQljgmp6IV2IeV1ijb8s6HElHU3657lv9deVepMyHKCJCeE98TW1L7b9OOi6iomUqCKVABDGYgZDZD";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(appId, appSecret);
        facebook.setOAuthPermissions(commaSeparetedPermissions);
        facebook.setOAuthAccessToken(new AccessToken(accessToken, null));
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }
}
