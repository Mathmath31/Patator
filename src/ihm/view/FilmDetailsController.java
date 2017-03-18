package ihm.view;


import java.sql.Time;
/*
 * A FAIRE +
 * - recuperer date + heure de sceance + NB place + NB place handicape + implemnter boutton valider pour aller sur la page suivante
 
 */
import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoAPI;
import apiTheMovieDB.CineGoFilm;
import ihm.Panier;
import ihm.VistaNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FilmDetailsController {


	@FXML
	private ListView<String> listView;

	@FXML
	private TextArea synopsis;

	@FXML
	private Label nomFilm;

	@FXML
	private ImageView viewImageFilm;
	
	@FXML
	private Button buttonValidFilm;
	
	@FXML
	private DatePicker dateSeance;
	
	@FXML
	private ComboBox heureSeance;
	
	@FXML
	private ComboBox nbPlace;
	
	@FXML
	private ComboBox nbPlaceHandicape;
	

	private boolean APILoadOK = false;
	private List<CineGoFilm> cineGoFilms = new ArrayList<CineGoFilm>();
	private ObservableList<String> filmsList = FXCollections.observableArrayList();
	private Panier panier;

	public void initialize(){
		if (APILoadOK == false){
			this.initAPI();
			for( int i = 0 ; i < cineGoFilms.size() ; i++){
				filmsList.add(cineGoFilms.get(i).getTitle());
			}
		}
		panier=MainController.getCurentPanier();
		listView.setItems(filmsList);
		listView.getSelectionModel().selectFirst();
		nomFilm.setText(cineGoFilms.get(0).getTitle());
		synopsis.setText(cineGoFilms.get(0).getInfoFilm());
		synopsis.setWrapText(true);
		Image image = SwingFXUtils.toFXImage(cineGoFilms.get(0).getDataIMG(), null);
		viewImageFilm.setImage(image);

		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("clicked on " + listView.getSelectionModel().getSelectedIndex());
				nomFilm.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getTitle());
				synopsis.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getInfoFilm());
				synopsis.setWrapText(true);
				Image image = SwingFXUtils.toFXImage(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getDataIMG(), null);
				viewImageFilm.setImage(image);
				System.out.println(panier.getCinema());
			}
		});
		
		buttonValidFilm.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				panier.setFilm(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()));
				panier.setDateSeance(dateSeance.getValue());
				panier.setHeureSeance((Time)heureSeance.getValue());
				MainController.setCurentPanier(panier);
				MainController.setOldPanier(panier);
		        VistaNavigator.loadVista(VistaNavigator.CHOIXPOSITION);
			}
		});
	}

	public void initAPI(){
		List<String> listeIdFilms = new ArrayList<String>();
		//SIMULATION DE RECUPERATION DE LA LISTE DES ID DE FILM DANS LA BASE
		listeIdFilms.add("121856");listeIdFilms.add("274870");listeIdFilms.add("47971");
		CineGoAPI API = new CineGoAPI(listeIdFilms);
		for( int i = 0 ; i < API.getTabFilms().size() ; i++){
			cineGoFilms.add(API.getTabFilms().get(i));
		}
		APILoadOK = true;
	}
}

