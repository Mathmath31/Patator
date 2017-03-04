package ihm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class ChoixAccompagnementController {

	@FXML
	private ListView<String> listView;
	
	@FXML
	private ImageView viewAccompagnement;
	
	public void initialize(){		
		ObservableList<String> wordsList = FXCollections.observableArrayList("Mars","Snickers", "Lion", "M&M");
    	listView.setItems(wordsList);
	}
}
