package ihm.view;

import ihm.VistaNavigator;
import ihm.model.InfoAccompagnement;
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
	private TableView<InfoAccompagnement> tableViewPlace;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeDate;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeFilm;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeSceance;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeSalle;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeSiegeX;
	@FXML
	private TableColumn<InfoAccompagnement, String> placeSiegeY;
	@FXML
	private TableColumn<InfoAccompagnement, String> placePrix;
	
	/**
	 * Event handler fired when the user requests a new vista.
	 * @author MVM
	 * @param event the event that triggered the handler.
	 */
	@FXML
	private void Reglement(){
		VistaNavigator.loadVista(VistaNavigator.REGLEMENT);
	}
	
	/**
	 * function called when the fxml view is called
	 * add panier information
	 * @author MVM
	 */
	public void initialize(){
		//TODO charger les items place et accompagnement
	}
}
