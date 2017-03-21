/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.Ville;
import connection.Connection;
import dao.DAO;

/**
 * Data Access Object SQL for the class Ville, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class VilleDAO extends DAO<Ville>{
	
	/**
	 * Create the Data in the Database of the class Ville
	 * @author Thomas
	 * @param obj : class Ville
	 * @return obj : class Ville
	 * @exception  SQLException : When the query doesn't work
	 */
	public Ville create(Ville obj) {
		
		Connection.update("INSERT INTO Ville (nomVille, cpVille) VALUES('"
						  +obj.getNomVille()+"','"
						  +obj.getCpVille()+"')");
	
		ResultSet result = 	Connection.selectFrom("SELECT idVille "
				+ "FROM Ville "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idVille");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.println("idVille = "+i+"\n\n");
		obj.setId(i);
		Connection.close();
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class Ville
	 * @author Thomas
	 * @param id : idVille
	 * @return ville_find : class Ville
	 * @exception  SQLException : When the query doesn't work
	 */
	public Ville find(int id) {
		
		String nomVille = null;
		String cpVille= null;
		Ville Vill_find = new Ville();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT nomVille, cpVille "
													+ "FROM Ville "
													+ "WHERE idVille="
													+id
													+";");
			
			while(result.next())
			{
				nomVille = result.getString("nomVille");
				cpVille=result.getString("cpVille");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Vill_find = new Ville(id, nomVille, cpVille);
		Connection.close();
		return Vill_find;
	}

	/**
	 * Update the Data in the Database of the class Ville
	 * @author Thomas
	 * @param obj : class Ville
	 * @return obj : class Ville
	 */
	public Ville update(Ville obj) {
		
		Connection.update("UPDATE Ville SET nomVille ='"+obj.getNomVille()
														+"',imgVille='"+obj.getCpVille()									
														+"' WHERE idVille="
														+obj.getId()
														+";");	
		Connection.close();
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Ville
	 * @author Thomas
	 * @param obj : class Ville
	 */
	public void delete(Ville obj) {
		
		Connection.update("DELETE  FROM Ville WHERE idVille="
						  +obj.getId()
						  +";");
		Connection.close();
	}


	


}