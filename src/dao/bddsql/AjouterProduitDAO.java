package dao.bddsql;

import classes.AjouterProduit;
import connection.Connection;
import dao.DAO;

/**
 * Data Access Object SQL for the class AjouterProduit, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class AjouterProduitDAO extends DAO<AjouterProduit> {

	/**
	 * Can't use this function, idAjouterProduit is made of 2 foreign keys, extends forbid
	 * @author Thomas
	 * @see ComplementDAO
	 */ 
	@Override
	public AjouterProduit find(int id) {

		AjouterProduit ajouterProduit=new AjouterProduit();	
		Connection.close();
		return ajouterProduit;
	}

	/**
	 * Create the Data in the Database of the class AjouterProduit, and return this same class
	 * @author Thomas
	 * @param obj : class AjouterProduit
	 * @return obj : class AjouterProduit
	 */ 
	@Override
	public AjouterProduit create(AjouterProduit obj) {

		Connection.update("INSERT INTO ajouterProduit (idProduit,idPlace,quantite,livrer) VALUES("
					   	  +obj.getIdProduit() + ","
						  +obj.getIdPlace()+","	
						  +obj.getQuantite()+","
						  +obj.isLivrer()+")");
		Connection.close();
		return obj;
	}

	/**
	 * Update the Data in the Database of the class AjouterProduit, and return this same class
	 * @author Thomas
	 * @param obj : class AjouterProduit
	 * @return obj : class AjouterProduit
	 */ 
	@Override
	public AjouterProduit update(AjouterProduit obj) {

		Connection.update("UPDATE ajouterProduit SET "
						  +",quantite=" + obj.getQuantite()
						  +",livrer="  + obj.isLivrer() 
						  +" WHERE idProduit=" + obj.getIdProduit()
						  +" AND idPlace="+obj.getIdPlace()+";");
		Connection.close();
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class AjouterProduit
	 * @author Thomas
	 * @param obj : class AjouterProduit
	 */ 
	@Override
	public void delete(AjouterProduit obj) {

		Connection.update("DELETE  FROM PlanSalle WHERE idProduit=" + obj.getIdProduit()
						  +" AND idPlace="+obj.getIdPlace()+";"); 
		Connection.close();
	}
}