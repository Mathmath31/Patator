package ihm.view;

import classes.AjouterProduit;
import classes.ComposerPlace;
import classes.CreerSeance;
import classes.Creneau;
import classes.Place;
import classes.PlanSalle;
import classes.Seance;
import dao.DAO;
import dao.DAOFactory;
import ihm.VistaNavigator;
import ihm.model.InfoAccompagnement;
import ihm.model.InfoPlace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



/**
 * VuePanierController controller class for the entire layout.
 * 
 * @author MVM
 */
public class VuePanierController {
	
	@FXML
	private TableView<InfoAccompagnement> tableViewAccompagnement;
	@FXML
	private TableColumn<InfoAccompagnement, String> accName;
	@FXML
	private TableColumn<InfoAccompagnement, String> accDesc;
	@FXML
	private TableColumn<InfoAccompagnement, String> accPrix;
	@FXML
	private TableColumn<InfoAccompagnement, String> accID;
	@FXML
	private TableColumn<InfoAccompagnement, String> accQty;
	
	@FXML
	private TableView<InfoPlace> tableViewPlace;
	@FXML
	private TableColumn<InfoPlace, String> placeDate;
	@FXML
	private TableColumn<InfoPlace, String> placeFilm;
	@FXML
	private TableColumn<InfoPlace, String> placeSceance;
	@FXML
	private TableColumn<InfoPlace, String> placeSalle;
	@FXML
	private TableColumn<InfoPlace, String> placeSiegeX;
	@FXML
	private TableColumn<InfoPlace, String> placeSiegeY;
	@FXML
	private TableColumn<InfoPlace, String> placePrix;
	
	
	private ObservableList<InfoPlace> placeData = FXCollections.observableArrayList();
	private ObservableList<InfoAccompagnement> accomData = FXCollections.observableArrayList();
	/**
	 * Event handler fired when the user requests a new vista.
	 * @author MVM, Thomas
	 * @param event the event that triggered the handler.
	 */
	@FXML
	private void Reglement(){
		
		VistaNavigator.loadVista(VistaNavigator.REGLEMENT);
	}
	
	/**
	 * function called when the fxml view is called
	 * add panier information
	 * @author MVM, Thomas
	 */
	public void initialize(){
		
		int i=0;
		for(Place p:MainController.donnees.getClientCommande().getListPlace()){
			
			
			placeData.add(new InfoPlace(
					p.getComposerPlace().getSeanceT().getCreerSeanceT().getDatesT().getSeanceDate().toString(),
					p.getComposerPlace().getSeanceT().getFilmT().getNomFilm(),
					p.getComposerPlace().getSeanceT().getCreerSeanceT().getCreneauT().getHeureDebutCreneau(),
					MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getNomPlanSalle(),
					String.valueOf(MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getPosition().getPosX()),
					String.valueOf(MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getPosition().getPosY()),
					"12,5"
					));
			i++;
		}

		placeDate.setCellValueFactory(cellData -> cellData.getValue().placeDateProperty());
		placeFilm.setCellValueFactory(cellData -> cellData.getValue().placeFilmProperty());
		placeSceance.setCellValueFactory(cellData -> cellData.getValue().placeSeanceProperty());
		placeSalle.setCellValueFactory(cellData -> cellData.getValue().placeSalleProperty());
		placeSiegeX.setCellValueFactory(cellData -> cellData.getValue().placeXSiegeProperty());
		placeSiegeY.setCellValueFactory(cellData -> cellData.getValue().placeYSiegeProperty());
		placePrix.setCellValueFactory(cellData -> cellData.getValue().placePrixProperty());
		
		tableViewPlace.getItems().setAll(placeData);
		
		for(AjouterProduit a:MainController.donnees.getClientCommande().getListPlace().get(0).getListAjouterProduit()){
			accomData.add(new InfoAccompagnement(
					a.getProduit().getNomProduit(),
					a.getProduit().getDescriptionProduit(),
					String.valueOf(a.getProduit().getPrixProduit()*a.getQuantite()),
					"",
					String.valueOf(a.getQuantite())

					));
		}
		accName.setCellValueFactory(cellData -> cellData.getValue().accNameProperty());
		accDesc.setCellValueFactory(cellData -> cellData.getValue().accDescriptionProperty());
		accPrix.setCellValueFactory(cellData -> cellData.getValue().accPrixProperty());
		accID.setCellValueFactory(cellData -> cellData.getValue().accIDProperty());
		accQty.setCellValueFactory(cellData -> cellData.getValue().accQtyProperty());
		
		tableViewAccompagnement.getItems().setAll(accomData);
	
	}
}
