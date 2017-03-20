/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.CreerSeance;
import classes.Creneau;
import classes.Dates;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for the class CreerSeance, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class CreerSeanceDAO extends DAO<CreerSeance> {
	
	/**
	 * Retrieve the Data in the Database of the class CreerSeance
	 * @author Thomas
	 * @param id = idCreerSeance
	 * @return creer : class CreerSeance
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override 
	public CreerSeance find(int id) {
		
		CreerSeance creer=new CreerSeance();

		int idCreneau = 0;
		int idPlanSalle = 0;
		int idDate = 0;
		
		DAO<Creneau> CreneauDAO = DAOFactory.getCreneauDAO();
		Creneau creneauT=new Creneau();
		
		DAO<Dates> DatesDAO = DAOFactory.getDatesDAO();
		Dates datesT=new Dates();
		
		ResultSet result = Connection.selectFrom("SELECT idCreneau,idPlanSalle,idDate "
												+ "FROM Creneau "
												+ "WHERE idSeance="
												+id
												+";");
		try {
			while(result.next())
			{
				idCreneau=result.getInt("idCreneau");
				idPlanSalle=result.getInt("idPlanSalle");
				idDate=result.getInt("idDate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		creneauT=CreneauDAO.find(idCreneau);
		datesT=DatesDAO.find(idDate); 

		creer = new CreerSeance(id,idPlanSalle,idCreneau,idDate,creneauT,datesT); 
				
		return creer;
	}

	/**
	 * Create the Data in the Database of the class CreerSeance
	 * @author Thomas
	 * @param obj : class CreerSeance
	 * @return obj : class CreerSeance
	 */
	@Override
	public CreerSeance create(CreerSeance obj) {
		
		Connection.update("INSERT INTO creer (idCreneau,idPlanSalle,idDate,idSeance) VALUES("
						  +obj.getIdCreneau()+","
						  +obj.getIdPlanSalle()+","
						  +obj.getIdDate()+","
						  +obj.getIdSeance()+")");
		return obj;
	}

	/**
	 * Update the Data in the Database of the class CreerSeance
	 * @author Thomas
	 * @param obj : class CreerSeance
	 * @return obj : class CreerSeance
	 */
	@Override
	public CreerSeance update(CreerSeance obj) {
		
		Connection.update("UPDATE creer SET idCreneau ="+obj.getIdCreneau()
						  +",idPlanSalle="+obj.getIdPlanSalle()
						  +",idDate="+obj.getIdDate()
						  +" WHERE idSeance="+obj.getIdSeance()+";");							
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class CreerSeance
	 * @author Thomas
	 * @param obj : class CreerSeance
	 */
	@Override
	public void delete(CreerSeance obj) {
		
		Connection.update("DELETE  FROM creer WHERE idCreneau ="+obj.getIdCreneau()
						  +" AND idPlanSalle="+obj.getIdPlanSalle()
						  +" AND idDate="+obj.getIdDate()
						  +" AND idSeance="+obj.getIdSeance()+";");	
	}

	

}
