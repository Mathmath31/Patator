/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import classes.Dates;
import connection.Connection;
import dao.DAO;
/**
 * Data Access Object SQL for the class Dates, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class DatesDAO extends DAO<Dates>{
	
	/**
	 * Create the Data in the Database of the class Dates
	 * @author Thomas
	 * @param obj : class Dates
	 * @return obj : class Dates
	 * @exception  SQLException : When the query doesn't work
	 */
	public Dates create(Dates obj) {
		
		
		java.sql.Date sqlDate = new java.sql.Date(obj.getSeanceDate().getTime());


		Connection.update("INSERT INTO date (seanceDate) VALUES('"
						  + sqlDate +"')");
		
		ResultSet result = 	Connection.selectFrom("SELECT idDate "
				+ "FROM date "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idDate");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class Dates
	 * @author Thomas
	 * @param id : idDate
	 * @return dates : class Dates
	 * @exception  SQLException : When the query doesn't work
	 */
	public Dates find(int id) {
		
		Date seanceDate = null;
		Dates dates = new Dates();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT seanceDate "
													+ " FROM date "
													+ " WHERE idDate="
													+ id + ";");
			
			while(result.next())
			{
				seanceDate = result.getDate("seanceDate");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		dates = new Dates(id, seanceDate);
		
		return dates;
	}

	/**
	 * Update the Data in the Database of the class Dates
	 * @author Thomas
	 * @param obj : class Dates
	 * @return obj : class Dates
	 */
	public Dates update(Dates obj) {
		
		java.sql.Date sqlDate = new java.sql.Date(obj.getSeanceDate().getTime());
		
		Connection.update("UPDATE date SET seanceDate ="+sqlDate																				
														+" WHERE idDate="
														+obj.getId()
														+";");	
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Dates
	 * @author Thomas
	 * @param obj : class Dates
	 */
	public void delete(Dates obj) {
		
		Connection.update("DELETE  FROM date WHERE idDate="
						  +obj.getId()
						  +";");
	}
	
	
	

}
