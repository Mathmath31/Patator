package ihm.view;

import ihm.Main;
import ihm.Panier;
import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class ChoixCinemaController {

	@FXML
    private TableView<InfoCine> tableView;
    @FXML
    private TableColumn<InfoCine, String> cinemaName;
    @FXML
    private TableColumn<InfoCine, String> cinemaAdresse;
    @FXML
    private Button buttonValidCine;
	
    private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
    
    
	public void initialize(){	
    	
    	cineData.add(new InfoCine("Gaumont", "Labege"));
    	cineData.add(new InfoCine("Path�", "Montaudran"));
    	cineData.add(new InfoCine("Mega CGR", "Moncul"));
    	
    	
    	cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
        cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
        
        tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();

        buttonValidCine.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("clicked on  valide cine" + tableView.getSelectionModel().getSelectedIndex());
				
			}
		});
        
	}
}