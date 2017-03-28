package ihm.view;

import classes.AjouterProduit;
import classes.ComposerPlace;
import classes.Place;
import dao.DAO;
import dao.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * VueReglement controller class for the entire layout.
 * 
 * @author MVM
 */
public class VueReglementController {
	
	@FXML
	private Label message;
	
	
	/**
	 * function called when the fxml view is called
	 * @author MVM
	 */
	private void initialize(){
		
	}
	
	/**
	 * function called when we click on "Valider"
	 * @author MVM
	 */
	private void confirmer(){
		DAO<Place> PlaceDAO = DAOFactory.getPlaceDAO();
		DAO<ComposerPlace> ComposerPlaceDAO = DAOFactory.getComposerPlaceDAO();
		DAO<AjouterProduit> AjouterProduitDAO = DAOFactory.getAjouterProduitDAO();
		
		for(Place p:MainController.donnees.getClientCommande().getListPlace()){
			System.out.println(p);
			PlaceDAO.create(p);
			ComposerPlaceDAO.create(p.getComposerPlace());
			System.out.println(p.getComposerPlace());
			for(AjouterProduit a:p.getListAjouterProduit()){
				AjouterProduitDAO.create(a);
				System.out.println(a);
			}
		}
	}
	

}
