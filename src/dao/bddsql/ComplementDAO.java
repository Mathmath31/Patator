package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import classes.AjouterProduit;
import classes.Film;
import classes.Place;
import classes.Produit;
import classes.Seance;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for all the class that i can't implement because of the extends keyword
 * @author Thomas
 */ 
public class ComplementDAO {
	
	/**
	 * Retrieve all the idCinema of the DB and return them on an array
	 * @author Thomas
	 * @return listCinema : Array idCinema
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return listCinema;
	}
	
	/**
	 * Retrieve all the idPlanSalle of the DB from one Cinema and return them on an array
	 * @author Thomas
	 * @return listPlanSalle : Array idPlansalle
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return listPlanSalle;
	}
	
	/**
	 * Delete one to many CaseSalle by send idPlanSalle
	 * @author Thomas
	 * @param idPlanSalle
	 */
	public static void deleteCaseSalle(int idPlanSalle) {
		
		Connection.update("DELETE FROM CaseSalle WHERE idPlanSalle="
						  +idPlanSalle
						  +";");
		Connection.close();
	}
	
	/**
	 * Retrieve the idPositionCase with posX and posY
	 * @author Thomas
	 * @param posX : x positifon of the case 
	 * @param posY : x positifon of the case 
	 * @return intidPositionCase
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return idPositionCase;
		
	}
	
	/**
	 * Retrieve the idTypeCase with posX and posY
	 * @author Thomas
	 * @param nameTypeCase : name of the case 
	 * @return idTypeCase, int
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return idTypeCase;
	}
	
	/**
	 * Retrieve the idPlanSalle from the DB by numPlanSalle and idCinema
	 * @author Thomas
	 * @param numPlanSalle : string, identification of the PlanSalle 
	 * @param idCinema : int, id of the movie theater
	 * @return idTypeCase, int
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return idPlanSalle;
		
	}
	
	/**
	 * Retrieve the idTypeCase with posX and posY
	 * @author Thomas
	 * @param numPlanSalle : string, identification of the PlanSalle 
	 * @param idCinema : int, id of the movie theater
	 * @return idTypeCase, int
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return idClient;

	}
	
	/**
	 * Retrieve all the idProduit of the DB from one Place with idPlace and return them on an array
	 * @author Thomas
	 * @param idPlace, identifier of the place
	 * @return listProduit : Array of idProduit
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return listProduit;
	}
	
	/**
	 * Retrieve quantite and livrer from the DB using idPlace and idProduit
	 * @author Thomas
	 * @param idPlace : string, identification of the PlanSalle 
	 * @param idProduit : int, id of the movie theater
	 * @return ajouterProduit : class AjouterProduit
	 * @exception  SQLException : When the query doesn't work
	 * @see AjouterProduitDAO
	 */
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
		Connection.close();
		return ajouterProduit;
	}
	
	/**
	 * Retrieve all the idPlace of the DB for one Client and return them on an array
	 * @author Thomas
	 * @param idClient, identifier of the CLient
	 * @return listPlaces : Array of idPlace
	 * @exception  SQLException : When the query doesn't work
	 */
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
		Connection.close();
		return listPlaces;
	}
	
	
	/**
	 * Retrieve the loginClient from the DB if it exists, return true or false depending on the result
	 * @author Thomas
	 * @param loginClient : name of the login choose
	 * @return boolean : true or false
	 * @exception  SQLException : When the query doesn't work
	 */
	public static boolean ExistsLoginClient(String loginClient) {
		
		int idClient = 0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idClient "
					 + "FROM client "
					 + "WHERE loginClient ='" + loginClient + "';");

			while(result.next())
			{
				idClient = result.getInt("idClient");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();

		if (idClient==0){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	/**
	 * Retrieve the idVille from the DB if it exists, return the idVille
	 * @author Thomas
	 * @param nomVille : name of the city searched
	 * @return idClient : int 0 if city not found
	 * @exception  SQLException : When the query doesn't work
	 */
	public static int ExistsVille(String nomVille) {
		
		int idVille = 0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idVille "
					 + "FROM ville "
					 + "WHERE nomVille ='" + nomVille + "';");

			while(result.next())
			{
				idVille = result.getInt("idVille");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();

		return idVille;
		
	}
	
	/**
	 * Retrieve the idCinema from the DB if it exists, return the idCinema
	 * @author Thomas
	 * @param nomCine : name of the cinema searched
	 * @return idCinema : int 0 if cinema not found
	 * @exception  SQLException : When the query doesn't work
	 */
	public static int ExistsCinema(String nomCine) {
		
		int idCinema = 0; 
		
		try {
			ResultSet result = Connection.selectFrom("SELECT idCinema "
					 + "FROM cinema "
					 + "WHERE idCinema ='" + nomCine + "';");

			while(result.next())
			{
				idCinema = result.getInt("idCinema");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();

		return idCinema;
	}
	
	/**
	 * Retrieve the seances from the DB on the cinema, with the film and the date parameters
	 * @author Thomas
	 * @param idCinema : int Id of the Cinema searched
	 * @param codeFilm : String id of the film searched
	 * @param seanceDate : Date, date searched
	 * @return seances : arraylist of seance corresponding to the parameters
	 * @exception  SQLException : When the query doesn't work
	 */
	public static ArrayList<Seance> listofSeances(int idCinema, String codeFilm, Date seanceDate) {

		ArrayList<Seance> seances= new ArrayList<Seance>();
		DAO<Seance> SeanceDAO = DAOFactory.getSeanceDAO();
		java.sql.Date sqlDate = new java.sql.Date(seanceDate.getTime());
	
		ResultSet rs = Connection.selectFrom("SELECT s.idSeance FROM seance s INNER JOIN creerseance c ON s.idSeance=c.idSeance "
											+" INNER JOIN plansalle p ON c.idPlanSalle=p.idPlanSalle "									
											+" INNER JOIN film f ON s.idFilm=f.idFilm "
											+" INNER JOIN date d ON c.idDate=d.idDate "
											+" WHERE f.codeFilm='" + codeFilm
											+"' AND d.seanceDate='" + sqlDate
											+"' AND p.idCinema=" + idCinema + ";");
		int k=0;
		try {
			while(rs.next())
			{
				System.out.println(k);
				Seance seance=new Seance();
				seance=SeanceDAO.find(rs.getInt("s.idSeance"));
				seances.add(seance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();
		return seances;
	}
	
	/**
	 * Retrieve the number of normal place left for a seance from the DB 
	 * @author Thomas
	 * @param idSeance : id of the seance searched
	 * @return nbPlaces : int number of place left for the seance
	 * @exception  SQLException : When the query doesn't work
	 */
	public static int nbNormalPlacesSeance(int idSeance) {
		
		int nbPlacesTotal=0;
		int nbPlacesOccupe=0;
		int nbPlaces = 0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT COUNT(cs.idCaseSalle) FROM  casesalle cs"
					 								+ " INNER JOIN composerplace cp ON cs.idCaseSalle=cp.idCaseSalle "
					 								+ " INNER JOIN typecase tc ON cs.idTypeCase=tc.idTypeCase "
					 								+ " WHERE cp.idSeance =" + idSeance 
					 								+ " AND tc.nomTypeCase='Normal' ;");
			while(result.next())
			{
				nbPlacesOccupe = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(nbPlacesOccupe);
		try {
			ResultSet result = Connection.selectFrom("SELECT COUNT(cs.idCaseSalle) FROM  casesalle cs"
													+ " INNER JOIN typecase tc ON cs.idTypeCase=tc.idTypeCase"
					 								+ " INNER JOIN plansalle p ON cs.idPlanSalle=p.idPlanSalle "
					 								+ " INNER JOIN creerseance c ON p.idPlanSalle=c.idPlanSalle "
					 								+ " WHERE c.idSeance =" + idSeance 
					 								+ " AND tc.nomTypeCase='Normal' ;");
			while(result.next())
			{
				nbPlacesTotal = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(nbPlacesTotal);
		
		nbPlaces=nbPlacesTotal-nbPlacesOccupe;
		
		Connection.close();
		return nbPlaces;
		
	}
	
public static int nbHandicapePlacesSeance(int idSeance) {
		
		int nbPlacesTotal=0;
		int nbPlacesOccupe=0;
		int nbPlaces = 0;
		
		
		try {
			ResultSet result = Connection.selectFrom("SELECT COUNT(cs.idCaseSalle) FROM  casesalle cs"
					 								+ " INNER JOIN composerplace cp ON cs.idCaseSalle=cp.idCaseSalle "
					 								+ " INNER JOIN typecase tc ON cs.idTypeCase=tc.idTypeCase "
					 								+ " WHERE cp.idSeance =" + idSeance 
					 								+ " AND tc.nomTypeCase='Handicapé' ;");
			while(result.next())
			{
				nbPlacesOccupe = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(nbPlacesOccupe);
		try {
			ResultSet result = Connection.selectFrom("SELECT COUNT(cs.idCaseSalle) FROM  casesalle cs"
													+ " INNER JOIN typecase tc ON cs.idTypeCase=tc.idTypeCase"
					 								+ " INNER JOIN plansalle p ON cs.idPlanSalle=p.idPlanSalle "
					 								+ " INNER JOIN creerseance c ON p.idPlanSalle=c.idPlanSalle "
					 								+ " WHERE c.idSeance =" + idSeance 
					 								+ " AND tc.nomTypeCase='Handicapé' ;");
			while(result.next())
			{
				nbPlacesTotal = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(nbPlacesTotal);
		
		nbPlaces=nbPlacesTotal-nbPlacesOccupe;
		
		Connection.close();
		return nbPlaces;
		
	}
	/**
	 * Retrieve the movies from the DB on the cinema wanted
	 * @author Thomas
	 * @param idCinema : int Id of the Cinema searched
	 * @return films : arraylist of films corresponding to the cinema
	 * @exception  SQLException : When the query doesn't work
	 */
	public static ArrayList<Film> listofFilms(int idCinema) {
	
		ArrayList<Film> films= new ArrayList<Film>();
		DAO<Film> FilmDAO = DAOFactory.getFilmDAO();
	
		ResultSet rs = Connection.selectFrom("SELECT DISTINCT f.idFilm FROM film f INNER JOIN seance s ON f.idFilm=s.idFilm "
											+" INNER JOIN creerseance cs ON s.idSeance=cs.idSeance "									
											+" INNER JOIN plansalle p ON cs.idPlanSalle=p.idPlanSalle"
											+" WHERE p.idCinema=" + idCinema + ";");
		try {
			while(rs.next())
			{
				Film film=new Film();
				film=FilmDAO.find(rs.getInt("f.idFilm"));
				films.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();
		return films;
	}

	/**
	 * Retrieve the max posX and posY from a PlanSalle in the DB
	 * @author Thomas
	 * @param idPlanSalle, identifier of the the PlanSalle
	 * @return maxXY : array with 2 values max on X and max on Y
	 * @exception  SQLException : When the query doesn't work
	 */
	public static int[] maxXYPlanSalle(int idPlanSalle) {

		int[] maxXY= new int[2];
		
		ResultSet rs = Connection.selectFrom("SELECT MAX(posXPositionCase),MAX(posYPositionCase) "
											 + " FROM positioncase pc INNER JOIN casesalle cs ON pc.idPositionCase "
											 + " INNER JOIN plansalle p ON cs.idPlanSalle=p.idPlanSalle "
											 + " WHERE p.idPlanSalle=" + idPlanSalle +";");
		try {
			while(rs.next())
			{
				maxXY[0]=rs.getInt(1);
				maxXY[1]=rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection.close();
		return maxXY;
	}
	
}
