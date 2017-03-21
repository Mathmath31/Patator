package ihm.view;
//TODO 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import apiTheMovieDB.CineGoAPI;
import apiTheMovieDB.CineGoFilm;
import classes.Cinema;
import classes.Client;
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
	private ComboBox<LocalTime> heureSeance;
	@FXML
	private ComboBox<String>  nbPlace;
	@FXML
	private ComboBox<String>  nbPlaceHandicape;
	@FXML
	private ObservableList<String> filmsList = FXCollections.observableArrayList();

	private boolean APILoadOK = false;
	private List<CineGoFilm> cineGoFilms = new ArrayList<CineGoFilm>();

	private Client client = new Client();
	private Cinema cinema = new Cinema();


	/**This function initialize parameters of this view  
	 */
	public void initialize(){
		if (APILoadOK == false){
			this.initAPI();
			for( int i = 0 ; i < cineGoFilms.size() ; i++){
				filmsList.add(cineGoFilms.get(i).getTitle());
			}
		}
		client=MainController.donnees.getClientCommande();
		cinema=MainController.donnees.getCinemaCommande();
		System.out.println("clicked on valide cine " + MainController.donnees.getCinemaCommande().getId() + " " + MainController.donnees.getCinemaCommande().getNomCine());

		listView.setItems(filmsList);
		listView.getSelectionModel().selectFirst();
		refreshInfosFilm();
		/**Action when one film is clicked
		 */
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("clicked on " + listView.getSelectionModel().getSelectedIndex());
				refreshInfosFilm();
				System.out.println(cinema.getNomCine());
			}
		});
		/** Action when a date are selected
		 */
		dateSeance.setOnAction(event -> {
		    LocalDate date = dateSeance.getValue();
		    //TODO Replace their infos with databases infos 
		    //heureSeance place libre
			heureSeance.getItems().clear();
			heureSeance.getItems().addAll(LocalTime.parse("08:00"), LocalTime.parse("12:00"), LocalTime.parse("16:00"), LocalTime.parse("20:00"));
			heureSeance.getSelectionModel().selectFirst();
			heureSeance.setDisable(false);
		});
		/** Action when an hour of cinema session are selected
		 */
		heureSeance.setOnAction(event -> {
		    LocalTime heure = heureSeance.getSelectionModel().getSelectedItem();
		    //TODO Replace their infos with databases infos 
			//nbPlace dispo
			nbPlace.getItems().clear();
			nbPlace.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			nbPlace.getSelectionModel().selectFirst();
			nbPlace.setDisable(false);
			//nbPlaceHandicape dispo
			nbPlaceHandicape.getItems().clear();
			nbPlaceHandicape.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			nbPlaceHandicape.getSelectionModel().selectFirst();
			nbPlaceHandicape.setDisable(false);
		    System.out.println("Selected date: " + heure);
		});
		/**Action when a date is clicked
		 */
		dateSeance.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				heureSeance.getSelectionModel().clearSelection();
				nbPlace.getSelectionModel().clearSelection();
				nbPlaceHandicape.getSelectionModel().clearSelection();
			}
		});
		/**Action when user click on 'valide' button
		 */
		buttonValidFilm.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(listView.getSelectionModel().isEmpty() == false && dateSeance.getValue() != null && heureSeance.getValue() != null && (Integer.parseInt(nbPlace.getValue()) + Integer.parseInt(nbPlaceHandicape.getValue())) != 0 ){
					
//					client.getListPlace().get(0).getComposerPlace().getSeanceT().getFilmT().setCodeFilm(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getId());
//					
//					panier.setDateSeance(dateSeance.getValue());
//					panier.setHeureSeance(LocalTime.parse(heureSeance.getValue().toString()));
					MainController.donnees.setClientCommande(client);
			        VistaNavigator.loadVista(VistaNavigator.CHOIXPOSITION);
				}
				else{
					//TODO Send message for user
				}
			}
		});
	}
	/**This function create the movie's list
	 */
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
	/**This function refresh fields when one movie is selected
	 */
	private void refreshInfosFilm() {
		nomFilm.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getTitle());
		synopsis.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getInfoFilm());
		synopsis.setWrapText(true);
		Image image = SwingFXUtils.toFXImage(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getDataIMG(), null);
		viewImageFilm.setImage(image);
		dateSeance.setValue(null);
		heureSeance.setDisable(true);
		nbPlace.setDisable(true);
		nbPlaceHandicape.setDisable(true);
	}
}