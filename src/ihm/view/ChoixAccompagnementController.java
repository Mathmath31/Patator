package ihm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ChoixAccompagnementController {

	@FXML
	private ListView<String> listView;
	
	public void initialize(){		
		ObservableList<String> wordsList = FXCollections.observableArrayList("Mars","Snickers", "Lion", "M&M");
    	listView.setItems(wordsList);
	}
}
