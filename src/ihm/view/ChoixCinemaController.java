package ihm.view;

import ihm.Main;
import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ChoixCinemaController {

	@FXML
    private TableView<InfoCine> tableView;
    @FXML
    private TableColumn<InfoCine, String> cinemaName;
    @FXML
    private TableColumn<InfoCine, String> cinemaAdresse;
	
    private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
    
    
	public void initialize(){	
    	
    	cineData.add(new InfoCine("Gaumont", "Labege"));
    	cineData.add(new InfoCine("Pathé", "Montaudran"));
    	cineData.add(new InfoCine("Mega CGR", "Moncul"));
    	
    	
    	cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
        cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
        
        tableView.getItems().setAll(cineData);
	}
}
