
 package facebook4j.examples.signin;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AlbumPhotoWrapper  {

   public URL getUrl() {
		return photoUrl;
	}

	public void setUrl(URL urlValue) {
		photoUrl = urlValue;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
  
	public String getId(){
		return ID;
	}
	
	public void setID(String id) {
		ID = id;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String toString() {
		  return "List: " +date;
		}
   public URL photoUrl;
   
   public String Location;
   
   public  Date date;
   public String ID;

   }


