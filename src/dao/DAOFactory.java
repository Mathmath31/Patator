package dao;


import classes.AjouterProduit;
import classes.CaseSalle;
import classes.Cinema;
import classes.Client;
import classes.ComposerPlace;
import classes.CreerSeance;
import classes.Creneau;
import classes.Dates;
import classes.Film;
import classes.Place;
import classes.PlanSalle;
import classes.PositionCase;
import classes.Produit;
import classes.Seance;
import classes.TypeCase;
import classes.Ville;
import dao.bddsql.AjouterProduitDAO;
import dao.bddsql.CaseSalleDAO;
import dao.bddsql.CinemaDAO;
import dao.bddsql.ClientDAO;
import dao.bddsql.ComposerPlaceDAO;
import dao.bddsql.CreerSeanceDAO;
import dao.bddsql.CreneauDAO;
import dao.bddsql.DatesDAO;
import dao.bddsql.FilmDAO;
import dao.bddsql.PlaceDAO;
import dao.bddsql.PlanSalleDAO;
import dao.bddsql.PositionCaseDAO;
import dao.bddsql.ProduitDAO;
import dao.bddsql.SeanceDAO;
import dao.bddsql.TypeCaseDAO;
import dao.bddsql.VilleDAO;

/**
 * Data Access Object Factory -> encapsulating the instantiation of our objects into one class
 * @author Thomas
 */ 
public class DAOFactory {
	
	public static DAO<AjouterProduit> getAjouterProduitDAO(){
		return new AjouterProduitDAO();
	}
	
	public static DAO<CaseSalle> getCaseSalleDAO(){
		return new CaseSalleDAO();
	}
	
	public static DAO<Cinema> getCinemaDAO(){
		return new CinemaDAO();
	}
	
	public static DAO<Client> getClientDAO(){
		return new ClientDAO();
	}
	
	public static DAO<ComposerPlace> getComposerPlaceDAO(){
		return new ComposerPlaceDAO();
	}
	
	public static DAO<CreerSeance> getCreerSeanceDAO(){
		return new CreerSeanceDAO();
	}
	
	public static DAO<Creneau> getCreneauDAO(){
		return new CreneauDAO();
	}
	
	public static DAO<Dates> getDatesDAO(){
		return new DatesDAO();
	}
	
	public static DAO<Film> getFilmDAO(){
		return new FilmDAO();
	}
	
	public static DAO<Place> getPlaceDAO(){
		return new PlaceDAO();
	}
	
	public static DAO<PlanSalle> getPlanSalleDAO(){
		return new PlanSalleDAO();
	}
	
	public static DAO<PositionCase> getPositionCaseDAO(){
		return new PositionCaseDAO();
	}
	
	public static DAO<Produit> getProduitDAO(){
		return new ProduitDAO();
	}
	
	public static DAO<Seance> getSeanceDAO(){
		return new SeanceDAO();
	}
	
	public static DAO<TypeCase> getTypeCaseDAO(){
		return new TypeCaseDAO();
	}
	
	public static DAO<Ville> getVilleDAO(){
		return new VilleDAO();
	}


	


}
