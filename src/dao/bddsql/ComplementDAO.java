package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.AjouterProduit;
import classes.Produit;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

public class ComplementDAO {
	
	public static int[] listofCinema() {

		int[] listCinema= new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT DISTINCT idCinema "
											 + "FROM Cinema ");

		try {
			while(rs.next())
			{
				listCinema[i]=rs.getInt("idCinema");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listCinema;
	}
	
	
	public static int[] listofPlanSalle(int idCinema) {

		int[] listPlanSalle= new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT DISTINCT idPlanSalle "
											 + "FROM PlanSalle "
											 + "WHERE idCinema = " + idCinema +";");

		try {
			while(rs.next())
			{
				listPlanSalle[i]=rs.getInt("idPlanSalle");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listPlanSalle;
	}
	
	public static void deleteCaseSalle(int idPlanSalle) {
		
		Connection.update("DELETE FROM CaseSalle WHERE idPlanSalle="
						  +idPlanSalle
						  +";");
	}
	
	public static int findbypos(int posX, int posY) {
		
		int idPositionCase = 0;
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idPositionCase "
													+ "FROM positioncase "
													+ "WHERE posXPositionCase="
													+ posX
													+ " AND posYPositionCase="
													+ posY
													+ ";");
			
			while(result.next())
			{
				idPositionCase = result.getInt("idPositionCase");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idPositionCase;
		
	}
	
	public static int findbyname(String nameTypeCase) {
		
		int idTypeCase = 0;
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idTypeCase "
													+ "FROM TypeCase "
													+ "WHERE nomTypeCase='"
													+nameTypeCase
													+"';");
			
			while(result.next())
			{
				idTypeCase = result.getInt("idTypeCase");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idTypeCase;
	}

	public static int findbynumPlanSalle(String numPlanSalle, int idCinema) {
		
		int idPlanSalle = 0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idPlanSalle "
					 + "FROM PlanSalle "
					 + "WHERE numPlanSalle ='" + numPlanSalle 
					 + "' AND idCinema=" + idCinema +";");

			
			while(result.next())
			{
				idPlanSalle = result.getInt("idPlanSalle");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idPlanSalle;
		
	}
	
	public static int verifierMdp(String login, String mdp) {
		
		int idClient=0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idClient "
					 + "FROM Client "
					 + "WHERE loginClient ='" + login 
					 + "' AND mdpClient='" + mdp +"';");

			
			while(result.next())
			{
				idClient = result.getInt("idClient");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idClient;

	}
	

	public static int[] listProduitPlace(int idPlace) {

		int[] listProduit= new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT DISTINCT idProduit "
											 + "FROM ajouterproduit "
											 + "WHERE idPlace =" + idPlace +";");

		try {
			while(rs.next())
			{
				listProduit[i]=rs.getInt("idProduit");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listProduit;
	}
	
	
	public static AjouterProduit  findAjouterProduit(int idPlace, int idProduit) {
		
		AjouterProduit ajouterProduit=new AjouterProduit();
		
		DAO <Produit> ProduitDAO = DAOFactory.getProduitDAO();
		
		int quantite=0;
		boolean livrer=false;
		Produit produit = new Produit();
		
		ResultSet rs = Connection.selectFrom("SELECT quantite,livrer "
											 + "FROM ajouterProduit "
											 + "WHERE idProduit = " + idProduit 
											 +" AND idPlace="+ idPlace +";");
		try {
			while(rs.next())
			{
				quantite=rs.getInt("quantite");
				livrer=rs.getBoolean("livrer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		produit=ProduitDAO.find(idProduit); 

		ajouterProduit = new AjouterProduit(idProduit,idPlace,quantite,livrer,produit); 
	
		return ajouterProduit;
	}
	
	public static int[] listPlace(int idClient) {

		int[] listPlaces= new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT DISTINCT idPlace "
											 + "FROM place "
											 + "WHERE idClient=" + idClient +";");

		try {
			while(rs.next())
			{
				listPlaces[i]=rs.getInt("idPlanSalle");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listPlaces;
	}
	
}
