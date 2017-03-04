package ihm.view;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoAPI;
import apiTheMovieDB.CineGoFilm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FilmDetailsController {


	@FXML
	private ListView<String> listView;

	@FXML
	private TextArea synopsis;

	@FXML
	private Label nomFilm;

	@FXML
	private ImageView viewImageFilm;

	protected boolean APILoadOK = false;
	protected List<CineGoFilm> cineGoFilms = new ArrayList<CineGoFilm>();
	protected ObservableList<String> filmsList = FXCollections.observableArrayList();

	public void initialize(){
		if (APILoadOK == false){
			this.initAPI();
			for( int i = 0 ; i < cineGoFilms.size() ; i++){
				filmsList.add(cineGoFilms.get(i).getTitle());
			}
		}
		listView.setItems(filmsList);
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("clicked on " + listView.getSelectionModel().getSelectedIndex());
				nomFilm.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getTitle());
				synopsis.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getOverview());
				synopsis.setWrapText(true);
				Image image = SwingFXUtils.toFXImage(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getDataIMG(), null);
				viewImageFilm.setImage(image);
			}
		});
	}

	public void initAPI(){
		List<String> listeIdFilms = new ArrayList<String>();		
		//SIMULATION DE RECUPERATION DE LA LISTE DES ID DE FILM DANS LA BASE
		listeIdFilms.add("121856");listeIdFilms.add("274870");listeIdFilms.add("47971");listeIdFilms.add("47973");
		CineGoAPI API = new CineGoAPI(listeIdFilms);
		//System.out.println(API.getTabFilms().toString());
		for( int i = 0 ; i < API.getTabFilms().size() ; i++){
			cineGoFilms.add(API.getTabFilms().get(i));
		}
		APILoadOK = true;
	}

}

