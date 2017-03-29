package facebook4j.examples.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Datesort
 */
@WebServlet("/Datesort")
public class Datesort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datesort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ENTERED INTO DATESORT SERVLET");
		HttpSession session = request.getSession();
	String selectedName = (String)session.getAttribute("selectedName");
		System.out.println("get the tagged name:"+selectedName);
		request.setAttribute("isSorted", "true");
		HashMap<String,List<AlbumPhotoWrapper>> tagUrl =(HashMap<String,List<AlbumPhotoWrapper>>)session.getAttribute("TagPhotourlMap");
		 String selectedValue = request.getParameter("sort");
				 
				 System.out.println("printing the selectedvalue:"+selectedValue);
		 if(selectedValue != null && selectedValue.equalsIgnoreCase("Sortbydate")){
			 System.out.println("enterdif");
			 request.setAttribute("sortedList", getSortedListByDate((ArrayList<AlbumPhotoWrapper>)tagUrl.get(selectedName)));
		
		 } else {
			 System.out.println("enterd else");
			 request.setAttribute("isSorted", "true");
			 request.setAttribute("sortedList", getSortedListByID((ArrayList<AlbumPhotoWrapper>)tagUrl.get(selectedName)));
		 }
		 request.setAttribute ("optionVal",selectedValue );
		
		
		
		RequestDispatcher reqDisp  = getServletConfig().getServletContext().getRequestDispatcher(
	              "/tagImages.jsp");
	         reqDisp.forward(request, response);
	}

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
