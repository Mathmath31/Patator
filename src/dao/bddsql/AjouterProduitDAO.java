package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.AjouterProduit;
import classes.CaseSalle;
import classes.PlanSalle;
import classes.Produit;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author Thomas
 *
 */

public class AjouterProduitDAO extends DAO<AjouterProduit> {

	@Override
	public AjouterProduit find(int id) {

		AjouterProduit ajouterProduit=new AjouterProduit();	
		return ajouterProduit;
	}

	@Override
	public AjouterProduit create(AjouterProduit obj) {

		Connection.update("INSERT INTO ajouterProduit (idProduit,idPlace,quantite,livrer) VALUES("
					   	  +obj.getIdProduit() + ","
						  +obj.getIdPlace()+","	
						  +obj.getQuantite()+","
						  +obj.isLivrer()+")");
		return obj;
	}

	@Override
	public AjouterProduit update(AjouterProduit obj) {

		Connection.update("UPDATE ajouterProduit SET "
						  +",quantite=" + obj.getQuantite()
						  +",livrer="  + obj.isLivrer() 
						  +" WHERE idProduit=" + obj.getIdProduit()
						  +" AND idPlace="+obj.getIdPlace()+";");        
		return obj;
	}

	@Override
	public void delete(AjouterProduit obj) {

		Connection.update("DELETE  FROM PlanSalle WHERE idProduit=" + obj.getIdProduit()
						  +" AND idPlace="+obj.getIdPlace()+";"); 
	}
}