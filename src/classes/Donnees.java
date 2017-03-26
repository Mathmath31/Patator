package classes;

import java.util.ArrayList;

import crypter.Crypter;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;

/**
 * @author Thomas
 *
 */
public class Donnees {
	
	private boolean connecté;
	private Client clientCommande;
	private Client clientHistorique;
	private Cinema cinemaCommande;
	private ArrayList<Cinema> cinemas=new ArrayList<Cinema>();
	
	public Donnees() {};
	
	public Donnees(Client clientCommande, Client clientHistorique, Cinema cinemaCommande, ArrayList<Cinema> cinemas){
		this.clientCommande=clientCommande;
		this.clientHistorique=clientHistorique;
		this.cinemaCommande=cinemaCommande;
		this.setCinemas(cinemas);
	}
	
	public void connection(String login, String mdp){
		
		int i=0;
		int idClient =ComplementDAO.verifierMdp(login, Crypter.cryptWithMD5(mdp));
		
		int[] nbcines = new int[20];
		this.setConnecté(false);
		
		DAO<Client> ClientDAO= DAOFactory.getClientDAO();
		ArrayList<Cinema> cines=new ArrayList<Cinema>();
		DAO<Cinema> CinemaDAO= DAOFactory.getCinemaDAO();
		nbcines = ComplementDAO.listofCinema();
	
		if (idClient != 0){ // Le client est trouvé et le mot de passe est valide
			
			this.setClientHistorique(ClientDAO.find(idClient));
			
			while (nbcines[i] != 0){ //Ajout des cinémas
				cines.add(CinemaDAO.find(nbcines[i]));
				i++;
			}
			this.setCinemas(cines);
			this.setConnecté(true);
		}
		else{ //connexion non valide
			//TODO Evenement Login ou mot de passe Incorrect
		}
	}
	
	

	public Client getClientCommande() {
		return clientCommande;
	}

	public void setClientCommande(Client clientCommande) {
		this.clientCommande = clientCommande;
	}

	public Client getClientHistorique() {
		return clientHistorique;
	}

	public void setClientHistorique(Client clientHistorique) {
		this.clientHistorique = clientHistorique;
	}

	public Cinema getCinemaCommande() {
		return cinemaCommande;
	}

	public void setCinemaCommande(Cinema cinemaCommande) {
		this.cinemaCommande = cinemaCommande;
	}


	public boolean isConnecté() {
		return connecté;
	}

	public void setConnecté(boolean connecté) {
		this.connecté = connecté;
	}

	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(ArrayList<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
}
