/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.ComposerPlace;
import classes.Seance;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for the class ComposerPlace, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class ComposerPlaceDAO extends DAO<ComposerPlace> {
	
	/**
	 * Retrieve the Data in the Database of the class ComposerPlace
	 * @author Thomas
	 * @param id = idPlace
	 * @return composerPlace : class ComposerPlace
	 * @exception  SQLException : When the query doesn't work
	 */ 
	@Override 
	public ComposerPlace find(int id) {
		
		ComposerPlace composerPlace=new ComposerPlace();

		int idCaseSalle = 0;
		int idSeance = 0;

		DAO<Seance> SeanceDAO = DAOFactory.getSeanceDAO();
		Seance seance=new Seance();
		
		ResultSet result = Connection.selectFrom("SELECT idCaseSalle,idSeance "
												+ "FROM ComposerPlace "
												+ "WHERE idPlace="
												+id
												+";");
		try {
			while(result.next())
			{
				idCaseSalle=result.getInt("idCaseSalle");
				idSeance=result.getInt("idSeance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		seance=SeanceDAO.find(idSeance);

		composerPlace = new ComposerPlace(id,idCaseSalle,idSeance,seance); 
				
		return composerPlace;
	}

	
	
	/**
	 * Create the Data in the Database of the class ComposerPlace
	 * @author Thomas
	 * @param obj : class ComposerPlace
	 * @return obj : class ComposerPlace
	 */ 
	@Override
	public ComposerPlace create(ComposerPlace obj) {
		
		Connection.update("INSERT INTO ComposerPlace (idPlace,idCaseSalle,idSeance) VALUES("
						  +obj.getIdPlace()+","
						  +obj.getIdCaseSalle()+","
						  +obj.getIdSeance()+")");
		return obj;
	}


	
	/**
	 * Update the Data in the Database of the class ComposerPlace
	 * @author Thomas
	 * @param obj : class ComposerPlace
	 * @return obj : class ComposerPlace
	 */
	@Override
	public ComposerPlace update(ComposerPlace obj) {
		
		Connection.update("UPDATE ComposerPlace SET idCaseSalle ="+obj.getIdCaseSalle()
						  +",idSeance="+obj.getIdSeance()
						  +" WHERE idPlace="+obj.getIdPlace()+";");							
		return obj;
	}

	
	
	/**
	 * Delete the Data in the Database of the class ComposerPlace
	 * @author Thomas
	 * @param obj : class ComposerPlace
	 */
	@Override
	public void delete(ComposerPlace obj) {
		
		Connection.update("DELETE  FROM ComposerPlace WHERE idPlace ="
							+obj.getIdPlace()+";");	
	}
}
