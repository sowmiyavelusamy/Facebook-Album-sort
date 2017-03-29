package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

public class FaceBookInstance {
	static Facebook facebook = new FacebookFactory().getInstance();
    
	//Singleton implementation
	private FaceBookInstance () {
		
	}
	
	public static Facebook get() {
	    return facebook;
	}
	
	public static void setToken(final AccessToken oAuthAccessToken) {
	  final ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)                
	    .setOAuthAppId("******")                
	    .setOAuthAppSecret("*************")
	    .setOAuthAccessToken(oAuthAccessToken.getToken())
	    .setOAuthPermissions("email,user_birthday,publish_stream");
		final FacebookFactory ff = new FacebookFactory(cb.build());
		facebook = ff.getInstance();
		}
	
	
}
