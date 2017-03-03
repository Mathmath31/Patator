package ihm.view;

import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class FilmDetailsController {

	
	@FXML
    private ListView<String> listView;
	
	@FXML
    private Label synopsis;
	
	@FXML
    private Label nomFilm;
	
	@FXML
    private AnchorPane image;
	
	public void initialize(){
		
    	List<String> listeIdFilms = new ArrayList<String>();			//Recuperer la liste de tout les films à l'affiche dans la base de donnee		
		listeIdFilms.add("121856");listeIdFilms.add("274870");listeIdFilms.add("47971");
		CineGoAPI API = new CineGoAPI(listeIdFilms);
		System.out.println(API.getTabFilms().toString());
		
		
		ObservableList<String> wordsList = FXCollections.observableArrayList("First word","Second word", "Third word", "Etc.");
    	listView.setItems(wordsList);
	}
	
	
}

