
package ihm.view;

import java.util.Iterator;

import classes.Cinema;
import classes.Client;
import ihm.view.MainController;
import ihm.VistaNavigator;
import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * ChoixCinema controller class for the entire layout.
 * 
 * @author MVM
 */
public class ChoixCinemaController {

	@FXML
	private TableView<InfoCine> tableView;
	@FXML
	private TableColumn<InfoCine, String> cinemaName;
	@FXML
	private TableColumn<InfoCine, String> cinemaAdresse;
	@FXML
	private TableColumn<InfoCine, String> cinemaCP;
	@FXML
	private TableColumn<InfoCine, String> cinemaVille;
	@FXML
	private Button buttonValidCine;

	private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();

	private Client client = new Client();
	private Cinema cinema = new Cinema();

    
	/**
	 * function called when the fxml view is called
	 * Populate the tableView with cinema information from the database
	 * @author MVM
	 */
	public void initialize(){	

		for(Iterator<Cinema> i = MainController.donnees.getCinemas().iterator(); i.hasNext(); ) {
		    Cinema item = i.next();
		    System.out.println(item);
			cineData.add(new InfoCine(item.getNomCine(),item.getnVoieCine(),item.getVilleCine().getCpVille(),item.getVilleCine().getNomVille(),""+item.getId()));
		}

		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
		cinemaVille.setCellValueFactory(cellData -> cellData.getValue().cinemaVilleProperty());
		cinemaCP.setCellValueFactory(cellData -> cellData.getValue().cinemaCPProperty());
		
		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
		
		/**
		 * function called when the user choicethe cinema
		 * call the next view
		 * @author MVM
		 */
		buttonValidCine.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				cinema.setNomCine(tableView.getSelectionModel().getSelectedItem().getCinemaName());
				cinema.setId(Integer.valueOf(tableView.getSelectionModel().getSelectedItem().getCinemaID()));
				MainController.donnees.setCinemaCommande(cinema);
				MainController.donnees.setClientCommande(client);
				
				//reste panier
		        VistaNavigator.loadVista(VistaNavigator.SELECTIONFILM);				
			}
		});
	}
}
