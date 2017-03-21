package ihm.view;

import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminCinemaController {

	@FXML
	private TableView<InfoCine> tableView;
	@FXML
	private TableColumn<InfoCine, String> cinemaName;
	@FXML
	private TableColumn<InfoCine, String> cinemaAdresse;
	@FXML
	private TableColumn<InfoCine, String> cinemaVille;
	@FXML
	private TableColumn<InfoCine, String> cinemaCP;

	@FXML
	private TextField adminNomCine;
	@FXML
	private TextField adminNoVoie;
	@FXML
	private TextField adminNomVille;
	@FXML
	private TextField adminCP;

	private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
	
	
	public void initialize(){
//TODO charger les cinemas
		cineData.add(new InfoCine("Gaumont", "Labege"));
		cineData.add(new InfoCine("Pathé", "Montaudran"));
		cineData.add(new InfoCine("Mega CGR", "Toulouse"));
		
		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
		
		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
	}
	
	
	@FXML
    void ajoutCine(ActionEvent event) {
//TODO ajouter le cine
    }
	
	@FXML
    void suppCine(ActionEvent event) {
//TODO supprimer le cine
    }
	
	@FXML
    void modifCine(ActionEvent event) {
//TODO modifier le cine
    }
	
	@FXML
    void tableViewSelectionChanged(ActionEvent event) {
//TODO modifier les TextFields avec la sélection actuelle
    }
	
}
