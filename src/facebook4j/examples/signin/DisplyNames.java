package facebook4j.examples.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facebook4j.Album;
import facebook4j.Checkin;
import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Photo;
import facebook4j.ResponseList;
import facebook4j.Tag;
@WebServlet(name="DisplyNames",urlPatterns={"/disnam"})
public class DisplyNames extends HttpServlet{
	
	  

private static  final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a string arraylist to store all the photo ID names
		ArrayList<AlbumPhotoWrapper> imageUrlList = new ArrayList< AlbumPhotoWrapper>();
		
		 
		 Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
		 String targetAlbumId = "";
		System.out.println("Entered into DisplayAlbums doget"+request.getParameter("param"));
		String selectedAlbum = request.getParameter("param"); 
		String selectedDate = request.getParameter("Dates"); 
			     
				//Get all the photos that correspond to that Album ID
			 ResponseList<Photo> photos;
			 try {
			 if(selectedAlbum != null && selectedAlbum.equalsIgnoreCase("ALLPHOTOS")){
			  ResponseList<Album> albumList = facebook.getAlbums();
					for (Album album : albumList) {
						imageUrlList.addAll(getPhotoList(facebook,album.getId()));
					}
			 } else {
			    imageUrlList.addAll(getPhotoList(facebook,selectedAlbum));     
			 }
						 
				
		 //request.setAttribute ("DateList", Datesort );
		
			 } catch (FacebookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			  request.setAttribute ("ImageList", imageUrlList );
			 
			  //request.setAttribute ("ImageList2", imageUrlList );
			  HttpSession session = request.getSession();
			  session.setAttribute("Imgtosort", imageUrlList);
		 RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
	              "/Images.jsp");
	         reqDisp.forward(request, response);
			  }   
			  
			  private static ArrayList <AlbumPhotoWrapper> getPhotoList(Facebook facebook,String albumID) throws FacebookException {
			   ArrayList <AlbumPhotoWrapper>  tempImageList = new  ArrayList <AlbumPhotoWrapper> ();
			   ResponseList<Photo> photos = facebook.getAlbumPhotos(albumID);
			   System.out.println("print selected album:::" +photos.size());
	          AlbumPhotoWrapper alWrapperObj = null;
		    			  for  (Photo photoObj : photos) {  
					  //java.net.URL highQuality = photo.getImages().get(0).getSource();
					  alWrapperObj = new AlbumPhotoWrapper();
					 
						alWrapperObj.setUrl(facebook.getPhotoURL(photoObj.getId()));
						 
						System.out.println("Print name****" + photoObj.getName());
					  System.out.println("ALbum ID:::"+ facebook.getPhotoURL(photoObj.getId()));
					  
					  alWrapperObj.setDate(photoObj.getCreatedTime());
					  alWrapperObj.setID(photoObj.getId());
					  
					/* ResponseList<Tag> tagList = facebook.getTagsOnPhoto(photoObj.getId());
					 System.out.println("TAAAGGGED List+++" + tagList);
					 for(Tag tagid:tagList){
						 System.out.println("taggggggg"+tagid );
					 }
					  String tagName = "";*/
					  
					 /* if(tagList.size() > 0) {
						  
						  tagName = tagList.get(0).getName();
						  System.out.println("Print the tag names:::+++"+tagName);
					  }*/
					  
				/*	  checkin method 
					  System.out.println("#####Entered into CHECKIN******"+facebook.getMe().getId());
					  ResponseList<Event> checkinList = facebook.getEvents(facebook.getMe().getId());
					  System.out.println("CHECKIN LIST:$#%@" +checkinList );
					  for(Event checkid:checkinList){
						  System.out.println("CHECK+++" + checkid.getStartTime());
						  
					  }*/
					  
					  
					  
					  /*System.out.println("Photo location:::"+tagList );
					  alWrapperObj.setLocation(tagName);*/
					  System.out.println("Location :::"+ photoObj.getName());
					  tempImageList.add(alWrapperObj);
					  /*System.out.println("photoObj:::"+photoObj);
						System.out.println("Photoid>>>:" +  photoObj.getId());
						System.out.println("getLink()>>>:" +  facebook.getPhotoURL(photoObj.getId()));
						System.out.println("photo.getSource():" +  photoObj.getSource());
						System.out.println("photo.getPlace()>>>:" +  photoObj.getPlace());*/
						
				  } 
				 return tempImageList;
			 }
			
			}
