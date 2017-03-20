package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.AjouterProduit;
import classes.CaseSalle;
import classes.ComposerPlace;
import classes.Place;
import classes.PlanSalle;
import classes.Seance;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author Thomas
 *
 */

public class PlaceDAO extends DAO<Place> {

	@Override
	public Place find(int id) {

		Place place=new Place();
		
		DAO<ComposerPlace> ComposerPlaceDAO = DAOFactory.getComposerPlaceDAO();
		ComposerPlace composerPlace=new ComposerPlace();
		
		ArrayList<AjouterProduit> listAjouterProduit=new ArrayList<AjouterProduit>();

		boolean choixPlace=false;
		int idClient=0;
		
		int[] listIdProduit = new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT choixPlace,idClient "
											 + "FROM place "
											 + "WHERE idPlace = " + id +";");
		try {
			while(rs.next())
			{
				choixPlace = rs.getBoolean("choixPlace");
				idClient=rs.getInt("idClient");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		listIdProduit=ComplementDAO.listProduitPlace(id);
		
		while (listIdProduit[i] != 0)
		{
			listAjouterProduit.add(ComplementDAO.findAjouterProduit(id, listIdProduit[i]));
			i++;
		}
		
		composerPlace=ComposerPlaceDAO.find(id);
		
		place = new Place(id,choixPlace,idClient,composerPlace,listAjouterProduit); 

		return place;
	}

	@Override
	public Place create(Place obj) {

		Connection.update("INSERT INTO place (choixPlace,idClient) VALUES("
					   	  +obj.isChoixPlace() + ","
						  +obj.getIdClient()+")");

		ResultSet result = Connection.selectFrom("SELECT idPlace "
											   	 + "FROM place "
												 +";");
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idPlace");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}

	@Override
	public Place update(Place obj) {

		Connection.update("UPDATE place SET "
				          + "choixPlace =" + obj.isChoixPlace()
						  +",idClient='" + obj.getIdClient()					
						  +" WHERE idPlace=" + obj.getId() + ";");        
		return obj;
	}

	@Override
	public void delete(Place obj) {

		Connection.update("DELETE  FROM place WHERE idPlace="
						  +obj.getId()
						  +";");
	}
	
	
}