package ihm.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoAPI;



public class FilmDetailsController {

	@FXML
	private ListView<String> listViewFilm;
	
	protected CineGoAPI API;
	
	public void initialize(){
		this.initInfoFilms();
		ListView<String> listViewFilm = new ListView<String>();		
		List<String> listFilms = new ArrayList<String>();
		for(int i = 0 ; i < API.getTabFilms().size(); i++ ){
			listFilms.add(API.getTabFilms().get(i).getOriginal_title());
		}
		listViewFilm.setItems(FXCollections.observableArrayList (listFilms));
	}

	public void initInfoFilms(){

		List<String> listeIdFilms = new ArrayList<String>();
		//Recuperer la liste de tout les films à l'affiche dans la base de donnee		
		listeIdFilms.add("121856");
		API = new CineGoAPI(listeIdFilms);
		System.out.println(API.getTabFilms().toString());
	}


}