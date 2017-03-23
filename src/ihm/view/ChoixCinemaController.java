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

    
	
	public void initialize(){	

		MainController.donnees.getCinemas().get(0).getNomCine();
		for(Iterator<Cinema> i = MainController.donnees.getCinemas().iterator(); i.hasNext(); ) {
		    Cinema item = i.next();
		    System.out.println(item);
			cineData.add(new InfoCine(item.getNomCine(),"",item.getVilleCine().toString(),"",item.getId()));
		}
//		cineData.add(new InfoCine("Gaumont","", "Labege","",1));
//		cineData.add(new InfoCine("Pathé","", "Montaudran","",2));
//		cineData.add(new InfoCine("Mega CGR","", "Moncul","",3));

		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaVilleProperty());

		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
		
		buttonValidCine.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				cinema.setNomCine(tableView.getSelectionModel().getSelectedItem().getCinemaName());
				cinema.setId(tableView.getSelectionModel().getSelectedItem().getCinemaID());
				MainController.donnees.setCinemaCommande(cinema);
				MainController.donnees.setClientCommande(client);
				
				//reste panier
		        VistaNavigator.loadVista(VistaNavigator.SELECTIONFILM);				
			}
		});
	}
}
