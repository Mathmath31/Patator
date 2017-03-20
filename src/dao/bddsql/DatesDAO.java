/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import classes.Creneau;
import classes.Dates;
import connection.Connection;
import dao.DAO;
/**
 * @author thomas
 *
 */
public class DatesDAO extends DAO<Dates>{

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

	
	public Dates update(Dates obj) {
		
		Connection.update("UPDATE dates SET seanceDate ="+obj.getSeanceDate()																				
														+" WHERE idDate="
														+obj.getId()
														+";");	
		return obj;
	}

	
	public void delete(Dates obj) {
		
		Connection.update("DELETE  FROM dates WHERE idDate="
						  +obj.getId()
						  +";");
	}
	
	
	

}
