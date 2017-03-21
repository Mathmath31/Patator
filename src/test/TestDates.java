/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import classes.Dates;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author Thomas
 *
 */
public class TestDates {
	
	public static void main(String[] args) {

		      
	  DAO<Dates> DatesDAO = DAOFactory.getDatesDAO();
	  ArrayList<Dates> listDates=new ArrayList<Dates>();
	  
	  
	  Date now=new Date();
	  
	  
	  Calendar c = Calendar.getInstance();
	  c.setTime(now);
	  
	  
	  
	  /*for(int i=0;i<90;i++){ //Create seanceDate for next i(day) period, here 90 days
		  c.add(Calendar.DATE,1);
		  Dates dates=new Dates();
		  dates.setSeanceDate(c.getTime());
		  System.out.println(dates.toString());
		  listDates.add(dates);
	  }
	  
	  
	  
	  for(Dates d:listDates){ // Save in the DB the period created previously
		  
		  d=DatesDAO.create(d);
		  System.out.println(d.toString());
		  //System.out.println(d.getSeanceDate().toString());
	  }*/
	  for(int i=1;i<=90;i++){ //Print
    	  
    	  Dates dates=new Dates();
    	  dates=DatesDAO.find(i);
    	  System.out.println(dates.toString());
      }	      
	  
	}
}
