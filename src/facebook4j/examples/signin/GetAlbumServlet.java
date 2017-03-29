package facebook4j.examples.signin;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import facebook4j.Album;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Photo;
import facebook4j.ResponseList;
import facebook4j.Tag;


public class GetAlbumServlet extends HttpServlet {
    private static final long serialVersionUID = 4179545353414298791L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HashMap< String, String> albumNameIdMap = new HashMap<>();
    	System.out.println("Entered GetAlbumServlet");
    	request.setCharacterEncoding("UTF-8");
    	
    	HttpSession session = request.getSession();
    	//create array list to store albums
    	 ArrayList<String> AlbumNamesList = new ArrayList<String>();
    	//create array list to store tag
    	 Set<String> tagNamesList = new HashSet<String>();
    	 HashMap<String,List<AlbumPhotoWrapper>> personToPhotoURLsMap = new HashMap<String,List <AlbumPhotoWrapper>>();//key taggedperson name value list of photoUrl
    	 List<AlbumPhotoWrapper> photoUrlList =  null;
    	 AlbumPhotoWrapper albumWrapperObt = null;
    	 ResponseList<Album> albumList = null;
    	String gotTagname = request.getParameter("param1");
    	
    	
                      
      //  String message = request.getParameter("message");
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        try {
        	
        	System.out.println("ID:"+facebook.getId());
        	System.out.println("Name:"+facebook.getName());
        	albumList = facebook.getAlbums();
      	  /* System.out.println("albumList"+albumList);*/
         	for (Album album : albumList) {
              	albumNameIdMap.put(album.getName(),album.getId());
         	   /*System.out.println("album name"+album.getName());
         	   System.out.println("ALBUM ID:::"+album.getId());*/
         	   AlbumNamesList.add(album.getName());
         	   /*System.out.println("Alubum Names List:::" + AlbumNamesList.add(album.getName()));*/
         	  }
        	
        	/*HashMap<String,List<String>> personToPhotoURLsMap = new HashMap<String,List<String>>();*///key taggedperson name value list of photoUrl
        	
        	/*tag method*/
        	ResponseList<Album> albumList2 = null;
        	 albumList2 = facebook.getAlbums();					
        	for(Album albums2:albumList2){
        		/*System.out.println("ALBUM 2 NAMES:}}}}"+ albums2);*/
        		ResponseList<Photo> albPic = facebook.getAlbumPhotos(albums2.getId());  
        		/*System.out.println("ALBUUUUMPIIICCCCCC" + albPic);*/
        		   
        		    for(Photo tempPhoto:albPic){
        		    	System.out.println("Print the tempphoto::"+ tempPhoto);
        		    	ResponseList<Tag> tagList = facebook.getTagsOnPhoto(tempPhoto.getId());
        		    	/*System.out.println("tagged name List::%%%%&&&&&&&"+ tagList);*/
        		    	for(Tag tempTag: tagList){
        		    		tagNamesList.add(tempTag.getName());
        		    		System.out.println("tag values"+ tempTag.getName());
        		    		System.out.println("tag values"+ tempTag.getId());
        		    		//new code
        		    		
            		    	/*System.out.println("Before if condition");*/
            		    	if(!personToPhotoURLsMap.containsKey(tempTag.getName())){
            		    		System.out.println("if");
            		    		System.out.println("getting PhotoUrl"+facebook.getPhotoURL(tempPhoto.getId()));
            		    		photoUrlList = new ArrayList<AlbumPhotoWrapper>();
            		    		albumWrapperObt = new AlbumPhotoWrapper();
            		    		albumWrapperObt.setID(tempPhoto.getId());
            		    		albumWrapperObt.setDate(tempPhoto.getCreatedTime());
            		    		albumWrapperObt.setUrl(facebook.getPhotoURL(tempPhoto.getId()));
            		    			gotTagname = tempTag.getName();
            		    		
            		    	photoUrlList.add(albumWrapperObt);
            		    	   	personToPhotoURLsMap.put(tempTag.getName(),photoUrlList);
            		    		}else {
            		    		System.out.println("else");
            		    		albumWrapperObt = new AlbumPhotoWrapper();
                			albumWrapperObt.setDate(tempPhoto.getCreatedTime());
                		    		albumWrapperObt.setUrl(facebook.getPhotoURL(tempPhoto.getId()));
            		    		personToPhotoURLsMap.get(tempTag.getName()).add(albumWrapperObt);//if tag name already exist in the map 
            		    	}
        		    	}
        		    	
        		    	        		    }
        		   
        		    	
        		    System.out.println("Print personToPhotoURLsMap: size:"+personToPhotoURLsMap.size());
        		    System.out.println("Print personToPhotoURLsMap::"+personToPhotoURLsMap);
   
        		    
        	}
        	
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        for(int i=0; i<AlbumNamesList.size();i++){
        	System.out.println("print" + AlbumNamesList.get(i));
        	
        }
        session.setAttribute ("tagnameList", tagNamesList);
        session.setAttribute ("TagPhotourlMap", personToPhotoURLsMap );
        request.setAttribute ("AlbumList", AlbumNamesList);
        session.setAttribute ("albumIdMap", albumNameIdMap);
        RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
	              "/Albums.jsp");
	         reqDisp.forward(request, response);
		
        //response.sendRedirect(request.getContextPath()+ "/");
        
    }
    
}