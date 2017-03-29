package facebook4j.examples.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PhotoSort extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("Entered into PHOTOSORT SERVLET");
	 HttpSession session = request.getSession();
	ArrayList imgWrapList = (ArrayList)session.getAttribute("Imgtosort");
	 System.out.println("AttributeValue$$$" + imgWrapList);
		
	 String selectedValue = request.getParameter("sortBy");
	 ArrayList<AlbumPhotoWrapper> sortedImageList = null;
		System.out.println("Sortby vlues $$$" +selectedValue );
		System.out.println("Entering Date sorting::"+selectedValue.length());
		if(selectedValue!=null && selectedValue.equalsIgnoreCase("DATE")){
			
			 sortedImageList = getSortedListByDate(imgWrapList);
			System.out.println("Print SortedImages of DATE***" +sortedImageList );
		}
		else{
			sortedImageList = getSortedListByID(imgWrapList);
			System.out.println("Print SortedImages:::" +sortedImageList );
		}
		 request.setAttribute ("optionVal",selectedValue );
		request.setAttribute("ImageList", sortedImageList);
		 RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
	              "/Images.jsp");
	         reqDisp.forward(request, response);
	}
	//get sorted dates
		public static ArrayList<AlbumPhotoWrapper> getSortedListByDate(ArrayList<AlbumPhotoWrapper> photoDateList){
			   Collections.sort(photoDateList, new Comparator<AlbumPhotoWrapper>() {
				    public int compare(AlbumPhotoWrapper m1, AlbumPhotoWrapper m2) {
				    	System.out.println("M1 value::" + m1);
				    	System.out.println("M2 value::" + m2);
				        return m1.getDate().compareTo(m2.getDate());
				        
				    }
				});
			   
			   return photoDateList;
			   
		   }
		//get sorted location
		/*public static ArrayList<AlbumPhotoWrapper> getSortedLisByLocation(ArrayList<AlbumPhotoWrapper> photoLocationList){
			   System.out.println("ENTERED INTO ID METHOD@@@");
			Collections.sort(photoLocationList, new Comparator<AlbumPhotoWrapper>() {
				    public int compare(AlbumPhotoWrapper m1, AlbumPhotoWrapper m2) {
				    	System.out.println("ENTERED INTO if condition#####");
				    	System.out.println("ENTERED INTO if condition#####");
				    	
				    		System.out.println("Checking the id");
				    		return m1.getLocation.compareTo(m2.getLocation());
				    		
				    	
				    		
				    	
							
				    	
				        
				        
				    }
				});
			   
			   return photoLocationList;
			   
		   }	
*/		  

		public static ArrayList<AlbumPhotoWrapper> getSortedListByID(ArrayList<AlbumPhotoWrapper> photoLocationList){
			   System.out.println("ENTERED INTO ID METHOD@@@");
			   Collections.sort(photoLocationList, new Comparator<AlbumPhotoWrapper>() {
				    public int compare(AlbumPhotoWrapper m1, AlbumPhotoWrapper m2) {
				    	System.out.println("M1 value::" + m1);
				    	System.out.println("M2 value::" + m2);
				        return m2.getDate().compareTo(m1.getDate());
				        
				    }
				});
			   
			   return photoLocationList;
			   
		   }	


}
