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
 * @author thomas
 *
 */
public class PositionCaseDAO extends DAO<PositionCase>{

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

	
	public PositionCase update(PositionCase obj) {
		
		Connection.update("UPDATE positioncase SET posXPositionCase ="+obj.getPosX()
														+",posYPositionCase="+obj.getPosY()									
														+" WHERE idPositionCase="
														+obj.getId()
														+";");	
		return obj;
	}

	
	public void delete(PositionCase obj) {
		
		Connection.update("DELETE  FROM positioncase WHERE idPositionCase="
						  +obj.getId()
						  +";");
	}
	
	
	

}
