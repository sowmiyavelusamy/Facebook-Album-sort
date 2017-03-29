package facebook4j.examples.signin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import javax.servlet.RequestDispatcher;

public class PhotoSorting  {
//sorting by getting parameter from arraylist(datastring)
   public static ArrayList<AlbumPhotoWrapper> getSortedListByDate(ArrayList<AlbumPhotoWrapper> photoAlbumList){
	   Collections.sort(photoAlbumList, new Comparator<AlbumPhotoWrapper>() {
		    public int compare(AlbumPhotoWrapper m1, AlbumPhotoWrapper m2) {
		        return m1.getDate().compareTo(m2.getDate());
		        
		    }
		});
	   
	   return photoAlbumList;
	   
   }
 	
	public static void main(String[] args) throws ParseException  {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = "7-Jun-2013";
		String dateInString1 = "9-jan-2010";
		String dateInString2 = "21-sep-2015";
		String dateInString3 = "18-Feb-2009";
		String dateInString4 = "05-mar-2012";
		formatter.parse(dateInString);
		formatter.parse(dateInString1);
		formatter.parse(dateInString2);
		formatter.parse(dateInString3);
		formatter.parse(dateInString4);
	 	
		AlbumPhotoWrapper sortedDate = new AlbumPhotoWrapper();
		AlbumPhotoWrapper sortedDate1 = new AlbumPhotoWrapper();
		AlbumPhotoWrapper sortedDate2 = new AlbumPhotoWrapper();
		AlbumPhotoWrapper sortedDate3 = new AlbumPhotoWrapper();
		AlbumPhotoWrapper sortedDate4 = new AlbumPhotoWrapper();
		sortedDate.setDate(formatter.parse(dateInString));
		sortedDate1.setDate(formatter.parse(dateInString1));
		sortedDate2.setDate(formatter.parse(dateInString2));
		sortedDate3.setDate(formatter.parse(dateInString3));
		sortedDate4.setDate(formatter.parse(dateInString4));
		
		ArrayList<AlbumPhotoWrapper> datestring=new ArrayList<AlbumPhotoWrapper>();
		datestring.add(sortedDate);
		datestring.add(sortedDate1);
		datestring.add(sortedDate2);
		datestring.add(sortedDate3);
		datestring.add(sortedDate4);
	
		//System.out.println("SortedDate:::" +datestring);
		
		
		ArrayList<AlbumPhotoWrapper> sortedresult = 	getSortedListByDate(datestring);
	
	//	System.out.println("SortedDate:::" +sortedresult);
		for(AlbumPhotoWrapper sorted:sortedresult ){
			System.out.println("SortedDate:::" +sorted.toString());	
		}
	

	//after sorting	
		//Collections.sort(datestring );
		/*for(AlbumPhotoWrapper sorted: datestring){
		System.out.println("date sorted::"+sorted );
		}*/
		
		
		/* sortDates(datestring);
		for(String orederedDates:datestring){
			System.out.println( orederedDates);
			//datestring.add( orederedDates);
			}
		*/
	}
	
	
	/*private static void sortDates(ArrayList<AlbumPhotoWrapper> datestring){
		 Collections.sort(datestring, new Comparator<String>() {
			 DateFormat f = new SimpleDateFormat("dd/MM/yyyy '@'hh:mm a");
			 public int compare(String DATE_1, String DATE_2) {
				
					 try {
						return f.parse(DATE_1).compareTo(f.parse(DATE_2));
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
					 
				
				 
			 }
		 });
	}*/


}
