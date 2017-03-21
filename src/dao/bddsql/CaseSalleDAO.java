/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.CaseSalle;
import classes.PositionCase;
import classes.TypeCase;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for the class CaseSalle, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class CaseSalleDAO extends DAO<CaseSalle> {
	
	/**
	 * Retrieve the Data in the Database of the class CaseSalle
	 * @author Thomas
	 * @param id = idCaseSalle
	 * @return case_find : class CaseSalle
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override
	public CaseSalle find(int id) {
		
		CaseSalle case_find = new CaseSalle();
		
		String nomSiegeCase = null;
		int idPlanSalle = 0;
		int idPositionCase = 0;
		int idTypeCase = 0;
		
		
		DAO<PositionCase> PositionCaseDAO = DAOFactory.getPositionCaseDAO();
		PositionCase posCase=new PositionCase();
		
		DAO<TypeCase> TypeCaseDAO = DAOFactory.getTypeCaseDAO();
		TypeCase typCase=new TypeCase();
		

		ResultSet result = Connection.selectFrom("SELECT nomSiegeCase,idPlanSalle,idPositionCase,idTypeCase "
												+ "FROM CaseSalle "
												+ "WHERE idCaseSalle="
												+id
												+";");
		try {
			while(result.next())
			{
				nomSiegeCase = result.getString("nomSiegeCase");
				idPlanSalle=result.getInt("idPlanSalle");
				idPositionCase=result.getInt("idPositionCase");
				idTypeCase=result.getInt("idTypeCase");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		posCase=PositionCaseDAO.find(idPositionCase);
		typCase=TypeCaseDAO.find(idTypeCase); 

		
		if(nomSiegeCase != null)
		{
			case_find = new CaseSalle(id,nomSiegeCase,idPlanSalle,idPositionCase,idTypeCase,posCase,typCase); 
		}
		Connection.close();
		return case_find;
	}

	/**
	 * Create the Data in the Database of the class CaseSalle
	 * @author Thomas
	 * @param obj : class CaseSalle
	 * @return obj : class CaseSalle
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override
	public CaseSalle create(CaseSalle obj) {
		
		Connection.update("INSERT INTO CaseSalle (nomSiegeCase,idPlanSalle,idPositionCase,idTypeCase) VALUES('"
						  +obj.getNomSiegeCase()+"',"
						  +obj.getIdPlanSalle()+","
						  +obj.getIdPositionCase()+","
						  +obj.getIdTypeCase()+")");


		ResultSet result = 	Connection.selectFrom("SELECT idCaseSalle "
												  + "FROM CaseSalle "
												  +";");
		
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idCaseSalle");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		obj.setId(i);
		Connection.close();
		return obj;
	}

	/**
	 * Update the Data in the Database of the class CaseSalle
	 * @author Thomas
	 * @param obj : class CaseSalle
	 * @return obj : class CaseSalle
	 */
	@Override
	public CaseSalle update(CaseSalle obj) {
		
		Connection.update("UPDATE CaseSalle SET nomSiegeCase ='"+obj.getNomSiegeCase()
						  +"',idPlanSalle="+obj.getIdPlanSalle()
						  +",idPositionCase="+obj.getIdPositionCase()
						  +",idTypeCase="+obj.getIdTypeCase()
						  +" WHERE idCaseSalle="
						  +obj.getId()
						  +";");	
		Connection.close();				
		return obj;
	}
	
	/**
	 * Delete the Data in the Database of the class CaseSalle
	 * @author Thomas
	 * @param obj : class CaseSalle
	 */
	@Override
	public void delete(CaseSalle obj) {
		
		Connection.update("DELETE  FROM CaseSalle WHERE idCaseSalle="
						  +obj.getId()
						  +";");
		Connection.close();
	}
}
