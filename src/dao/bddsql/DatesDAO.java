/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		Connection.update("INSERT INTO dates (seanceDate) VALUES("
						  +obj.getSeanceDate()+")");
		
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
			ResultSet result = Connection.selectFrom("SELECT seanceDate"
													+ "FROM dates "
													+ "WHERE idDate="
													+id
													+";");
			
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
		
		Connection.update("UPDATE dates SET seanceDate ="+obj.getSeanceDate()																				
														+" WHERE idDate="
														+obj.getId()
														+";");	
		return obj;
	}

	/**
	 * Create the Data in the Database of the class Dates
	 * @author Thomas
	 * @param obj : class Dates
	 */
	public void delete(Dates obj) {
		
		Connection.update("DELETE  FROM dates WHERE idDate="
						  +obj.getId()
						  +";");
	}
	
	
	

}
