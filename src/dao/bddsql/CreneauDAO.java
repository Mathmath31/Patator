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
 * @author thomas
 *
 */
public class CreneauDAO extends DAO<Creneau>{

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

	
	public Creneau update(Creneau obj) {
		
		Connection.update("UPDATE creneau SET heureDebutCreneau ="+obj.getHeureDebutCreneau()
														+",heureFinCreneau="+obj.getHeureFinCreneau()									
														+" WHERE idCreneau="
														+obj.getId()
														+";");	
		return obj;
	}

	
	public void delete(Creneau obj) {
		
		Connection.update("DELETE  FROM creneau WHERE idCreneau="
						  +obj.getId()
						  +";");
	}
	
	
	

}
