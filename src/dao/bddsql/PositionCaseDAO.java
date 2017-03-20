/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.PositionCase;
import connection.Connection;
import dao.DAO;

/**
 * Data Access Object SQL for the class PositionCase, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class PositionCaseDAO extends DAO<PositionCase>{
	
	/**
	 * Create the Data in the Database of the class PositionCase
	 * @author Thomas
	 * @param obj : class PositionCase
	 * @return obj : class PositionCase
	 * @exception  SQLException : When the query doesn't work
	 */
	public PositionCase create(PositionCase obj) {
		
		Connection.update("INSERT INTO positioncase (posXPositionCase, posYPositionCase) VALUES("
						  +obj.getPosX()+","
						  +obj.getPosY()+")");
		
		ResultSet result = 	Connection.selectFrom("SELECT idPositionCase "
				+ "FROM positioncase "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idPositionCase");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class PositionCase
	 * @author Thomas
	 * @param id : idPositionCase
	 * @return posCase : class PositionCase
	 * @exception  SQLException : When the query doesn't work
	 */
	public PositionCase find(int id) {
		
		int posX = 0;
		int posY = 0;
		PositionCase posCase = new PositionCase();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT posXPositionCase, posYPositionCase "
													+ "FROM positioncase "
													+ "WHERE idPositionCase="
													+id
													+";");
			
			while(result.next())
			{
				posX = result.getInt("posXPositionCase");
				posY=result.getInt("posYPositionCase");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		posCase = new PositionCase(id, posX, posY);
		
		return posCase;
	}

	/**
	 * Update the Data in the Database of the class PositionCase
	 * @author Thomas
	 * @param obj : class PositionCase
	 * @return obj : class PositionCase
	 */
	public PositionCase update(PositionCase obj) {
		
		Connection.update("UPDATE positioncase SET posXPositionCase ="+obj.getPosX()
														+",posYPositionCase="+obj.getPosY()									
														+" WHERE idPositionCase="
														+obj.getId()
														+";");	
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class PositionCase
	 * @author Thomas
	 * @param obj : class PositionCase
	 */
	public void delete(PositionCase obj) {
		
		Connection.update("DELETE  FROM positioncase WHERE idPositionCase="
						  +obj.getId()
						  +";");
	}
}
