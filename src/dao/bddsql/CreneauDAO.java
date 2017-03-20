/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import classes.Creneau;
import connection.Connection;
import dao.DAO;
/**
 * Data Access Object SQL for the class Creneau, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class CreneauDAO extends DAO<Creneau>{
	
	/**
	 * Create the Data in the Database of the class Creneau
	 * @author Thomas
	 * @param obj : class Creneau
	 * @return obj : class Creneau
	 * @exception  SQLException : When the query doesn't work
	 */
	public Creneau create(Creneau obj) {
		
		Connection.update("INSERT INTO creneau (heureDebutCreneau, heureFinCreneau) VALUES("
						  +obj.getHeureDebutCreneau()+","
						  +obj.getHeureFinCreneau()+")");
		
		ResultSet result = 	Connection.selectFrom("SELECT idCreneau "
				+ "FROM creneau "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idCreneau");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class Creneau
	 * @author Thomas
	 * @param id = idCreneau
	 * @return creneau : class Creneau
	 * @exception  SQLException : When the query doesn't work
	 */
	public Creneau find(int id) {
		
		Time heureDebutCreneau = null;
		Time heureFinCreneau = null;
		Creneau creneau = new Creneau();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT heureDebutCreneau, heureFinCreneau "
													+ "FROM creneau "
													+ "WHERE idCreneau="
													+id
													+";");
			
			while(result.next())
			{
				heureDebutCreneau = result.getTime("heureDebutCreneau");
				heureFinCreneau=result.getTime("posYPositionCase");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		creneau = new Creneau(id, heureDebutCreneau, heureFinCreneau);
		
		return creneau;
	}

	/**
	 * Update the Data in the Database of the class Creneau
	 * @author Thomas
	 * @param obj : class Creneau
	 * @return obj : class Creneau
	 */
	public Creneau update(Creneau obj) {
		
		Connection.update("UPDATE creneau SET heureDebutCreneau ="+obj.getHeureDebutCreneau()
														+",heureFinCreneau="+obj.getHeureFinCreneau()									
														+" WHERE idCreneau="
														+obj.getId()
														+";");	
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Creneau
	 * @author Thomas
	 * @param obj : class Creneau
	 */
	public void delete(Creneau obj) {
		
		Connection.update("DELETE  FROM creneau WHERE idCreneau="
						  +obj.getId()
						  +";");
	}
	
	
	

}
