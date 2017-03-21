package ihm.view;

import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
		cineData.add(new InfoCine("Gaumont","9 rue de chez pas quoi", "Labege","31256"));
		cineData.add(new InfoCine("Pathe","12 impasse du lac", "Montaudran","31547"));
		cineData.add(new InfoCine("Mega CGR","3 rue de la Pie", "Toulouse","32154"));
		
		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
		cinemaVille.setCellValueFactory(cellData -> cellData.getValue().cinemaVilleProperty());
		cinemaCP.setCellValueFactory(cellData -> cellData.getValue().cinemaCPProperty());
		
		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
	}
	
	
	@FXML
    void ajoutCine(ActionEvent event) {
//TODO ajouter le cine
		System.out.println("clicked on ajoutCine" + tableView.getSelectionModel().getSelectedItem().getCinemaName() + tableView.getSelectionModel().getSelectedItem().getCinemaAdresse());
    }
	
	@FXML
    void suppCine(ActionEvent event) {
//TODO supprimer le cine
		System.out.println("clicked on suppCine" + tableView.getSelectionModel().getSelectedItem());
    }
	
	@FXML
    void modifCine(ActionEvent event) {
//TODO modifier le cine
		System.out.println("clicked on modifCine");
    }
	
	@FXML
    void tableViewSelectionChanged(MouseEvent event) {
//TODO modifier les TextFields avec la sélection actuelle
		adminNomCine.setText(tableView.getSelectionModel().getSelectedItem().getCinemaName());
		adminNoVoie.setText(tableView.getSelectionModel().getSelectedItem().getCinemaAdresse());
		adminNomVille.setText(tableView.getSelectionModel().getSelectedItem().getCinemaVille());
		adminCP.setText(tableView.getSelectionModel().getSelectedItem().getCinemaCP());
    }
	
}
