/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.Produit;
import connection.Connection;
import dao.DAO;

/**
 * Data Access Object SQL for the class Produit, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class ProduitDAO extends DAO<Produit>{
	
	/**
	 * Create the Data in the Database of the class Produit
	 * @author Thomas
	 * @param obj : class Produit
	 * @return obj : class Produit
	 * @exception  SQLException : When the query doesn't work
	 */
	public Produit create(Produit obj) {
		
		Connection.update("INSERT INTO produit (nomProduit, descriptionProduit, prixProduit) VALUES('"
						  +obj.getNomProduit()+"','"
						  +obj.getDescriptionProduit()+"',"
						  +obj.getPrixProduit()+")");
	
		ResultSet result = 	Connection.selectFrom("SELECT idProduit "
				+ "FROM produit "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idProduit");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		obj.setId(i);
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class Produit
	 * @author Thomas
	 * @param id : idProduit
	 * @return produit : class Produit
	 * @exception  SQLException : When the query doesn't work
	 */
	public Produit find(int id) {
		
		String nomProduit = null;
		String descriptionProduit = null;
		Double prixProduit=(double) 0;
		
		Produit produit = new Produit();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT nomProduit, descriptionProduit, prixProduit "
													+ "FROM produit "
													+ "WHERE idProduit="
													+id
													+";");
			while(result.next())
			{
				nomProduit = result.getString("nomProduit");
				descriptionProduit=result.getString("descriptionProduit");
				prixProduit=result.getDouble("prixProduit");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		produit = new Produit(id, nomProduit, descriptionProduit, prixProduit);
		
		return produit;
	}

	/**
	 * Update the Data in the Database of the class Produit
	 * @author Thomas
	 * @param obj : class Produit
	 * @return obj : class Produit
	 */
	public Produit update(Produit obj) {
		
		Connection.update("UPDATE produit SET nomTypeCase ='"+obj.getNomProduit()
														+"',descriptionProduit='"+obj.getDescriptionProduit()
														+"',prixProduit="+obj.getPrixProduit()
														+" WHERE idProduit="
														+obj.getId()
														+";");	
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Produit
	 * @author Thomas
	 * @param obj : class Produit
	 */
	public void delete(Produit obj) {
		
		Connection.update("DELETE  FROM produit WHERE idProduit="
						  +obj.getId()
						  +";");
	}
}
