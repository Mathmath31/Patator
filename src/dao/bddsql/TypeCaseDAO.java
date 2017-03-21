/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.TypeCase;
import connection.Connection;
import dao.DAO;

/**
 * Data Access Object SQL for the class TypeCase, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class TypeCaseDAO extends DAO<TypeCase>{
	
	/**
	 * Create the Data in the Database of the class TypeCase
	 * @author Thomas
	 * @param obj : class TypeCase
	 * @return obj : class TypeCase
	 * @exception  SQLException : When the query doesn't work
	 */
	public TypeCase create(TypeCase obj) {
		
		Connection.update("INSERT INTO TypeCase (nomTypeCase, imgTypeCase) VALUES('"
						  +obj.getNomTypeCase()+"','"
						  +obj.getImgTypeCase()+"')");
	
		ResultSet result = 	Connection.selectFrom("SELECT idTypeCase "
				+ "FROM TypeCase "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idTypeCase");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.println("idTypeCase = "+i+"\n\n");
		obj.setId(i);
		Connection.close();
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class TypeCase
	 * @author Thomas
	 * @param id : idTypeCase
	 * @return typCase : class TypeCase
	 * @exception  SQLException : When the query doesn't work
	 */
	public TypeCase find(int id) {
		
		String nomTypCas = null;
		String imgTypCas = null;
		TypeCase typCase = new TypeCase();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT nomTypeCase, imgTypeCase "
													+ "FROM TypeCase "
													+ "WHERE idTypeCase="
													+id
													+";");
			
			while(result.next())
			{
				nomTypCas = result.getString("nomTypeCase");
				imgTypCas=result.getString("imgTypeCase");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		typCase = new TypeCase(id, nomTypCas, imgTypCas);
		Connection.close();
		return typCase;
	}

	/**
	 * Update the Data in the Database of the class TypeCase
	 * @author Thomas
	 * @param obj : class TypeCase
	 * @return obj : class TypeCase
	 */
	public TypeCase update(TypeCase obj) {
		
		Connection.update("UPDATE TypeCase SET nomTypeCase ='"+obj.getNomTypeCase()
														+"',imgTypeCase='"+obj.getImgTypeCase()									
														+"' WHERE idTypeCase="
														+obj.getId()
														+";");	
		Connection.close();
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class TypeCase
	 * @author Thomas
	 * @param obj : class TypeCase
	 */
	public void delete(TypeCase obj) {
		
		Connection.update("DELETE  FROM TypeCase WHERE idTypeCase="
						  +obj.getId()
						  +";");
		Connection.close();
	}
	

}
