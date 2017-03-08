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
 * @author thomas
 *
 */
public class VilleDAO extends DAO<Ville>{
	
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
		
		return obj;
	}
	
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
				cpVille=result.getString("imgVille");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Vill_find = new Ville(id, nomVille, cpVille);
		
		return Vill_find;
	}

	
	public Ville update(Ville obj) {
		
		Connection.update("UPDATE Ville SET nomVille ='"+obj.getNomVille()
														+"',imgVille='"+obj.getCpVille()									
														+"' WHERE idVille="
														+obj.getId()
														+";");	
		return obj;
	}

	
	public void delete(Ville obj) {
		
		Connection.update("DELETE  FROM Ville WHERE idVille="
						  +obj.getId()
						  +";");
	}


	


}