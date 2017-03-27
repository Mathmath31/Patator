package ihm.view;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import apiTheMovieDB.CineGoAPI;
import apiTheMovieDB.CineGoFilm;
import classes.CaseSalle;
import classes.Cinema;
import classes.Client;
import classes.Dates;
import classes.Film;
import classes.Place;
import classes.PlanSalle;
import classes.Seance;
import dao.bddsql.ComplementDAO;
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

/**
 * FilmDetailController controller class for the entire layout.
 * 
 * @author MVM
 */
public class FilmDetailsController {
	@FXML
	private ListView<String> listView;
	@FXML
	private TextArea synopsis;
	@FXML
	private Label nomFilm;
	@FXML
	private Label message;
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
	
	private List<String> listeIdFilms = new ArrayList<String>();
	private boolean APILoadOK = false;
	private List<CineGoFilm> cineGoFilms = new ArrayList<CineGoFilm>();
	private List<Seance> seances= new ArrayList<Seance>();
	private ArrayList<Film> films= new ArrayList<Film>();
	private Dates dates = new Dates();
	private Integer index = 0;
	private Integer idSeance = 0;
	private Integer idPlanSalle = 0;
	private Integer nbPlacesNormal = 0;
	private Integer nbPlacesHandi = 0;



	private Client client = new Client();
	private Cinema cinema = new Cinema();


	/**This function initialize parameters of this view
	 * load the film for the cinema selected
	 * @author MVM
	 */
	public void initialize(){
		if (APILoadOK == false){
			this.initAPI();
			for( int i = 0 ; i < cineGoFilms.size() ; i++){
				filmsList.add(cineGoFilms.get(i).getTitle());
			}
		}
		//TODO remove donnees of client & cinema;
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
				System.out.println(MainController.donnees.getCinemaCommande().getId() + " " + MainController.donnees.getCinemaCommande().getNomCine());
			}
		});
		/** Action when a date are selected
		 */
		dateSeance.setOnAction(event -> {
			seances= new ArrayList<Seance>();
			if(dateSeance.getValue() != null){
				dates.setSeanceDate(Date.from(dateSeance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				seances = ComplementDAO.listofSeances(MainController.donnees.getCinemaCommande().getId(), films.get(listView.getSelectionModel().getSelectedIndex()).getCodeFilm(), dates.getSeanceDate());

				heureSeance.getItems().clear();
				for(Seance se: seances){
					heureSeance.getItems().add(LocalTime.parse(se.getCreerSeanceT().getCreneauT().getHeureDebutCreneau()));
				}
			}
			nbPlace.getSelectionModel().clearSelection();
			nbPlaceHandicape.getSelectionModel().clearSelection();
			heureSeance.setDisable(false);
			nbPlace.setDisable(true);
			nbPlaceHandicape.setDisable(true);
		});
		/** Action when an hour of cinema session are selected
		 */
		heureSeance.setOnAction(event -> {
			// Trick for manage OOB error on "seance.get(index)" when heureSeance's items are clear
			if(heureSeance.getSelectionModel().isEmpty() == false){
				index = heureSeance.getSelectionModel().getSelectedIndex();
			} 
			if(seances.isEmpty() == false){
				//nbPlace dispo
				idSeance = seances.get(index).getId();
				nbPlace.getItems().clear();
				for( Integer i = 0 ; i < ComplementDAO.nbNormalPlacesSeance(idSeance) + 1 ; i++){
					nbPlace.getItems().add(i,i.toString());
				}
				nbPlace.getSelectionModel().selectFirst();
				nbPlace.setDisable(false);
				//nbPlaceHandicape dispo
				nbPlaceHandicape.getItems().clear();
				for( Integer i = 0 ; i < ComplementDAO.nbHandicapePlacesSeance(idSeance) + 1 ; i++){
					nbPlaceHandicape.getItems().add(i,i.toString());
				}
				nbPlaceHandicape.getSelectionModel().selectFirst();
				nbPlaceHandicape.setDisable(false);
				idPlanSalle=ComplementDAO.planSalleFromSeance(idSeance);
				System.out.println("idseance : " + idSeance + " Selected date: " + seances.get(index).getId() + " idPlanSalle : " + idPlanSalle);
			}

		});
		/**Action when a date is clicked
		 */
		dateSeance.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				nbPlace.getSelectionModel().clearSelection();
				nbPlace.getItems().clear();
				nbPlace.setDisable(true);
				nbPlaceHandicape.getSelectionModel().clearSelection();
				nbPlaceHandicape.getItems().clear();
				nbPlaceHandicape.setDisable(true);
			}
		});
		/**Action when user click on 'valide' button
		 */
		buttonValidFilm.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(nbPlace.getValue() != null){
					nbPlacesNormal = Integer.parseInt(nbPlace.getValue());
				}
				if(nbPlaceHandicape.getValue() != null){
					nbPlacesHandi = Integer.parseInt(nbPlaceHandicape.getValue());
				}
				if(listView.getSelectionModel().isEmpty() == false && dateSeance.getValue() != null && dateSeance.getValue().toString() != "" && heureSeance.getValue() != null && (nbPlacesNormal + nbPlacesHandi) != 0 ){
					cinema.getListPlanSalle().add(new PlanSalle());
					for (int i = 0 ; i < Integer.parseInt(nbPlace.getValue()) ; i++){
						Place place = new Place();
						CaseSalle casesalle = new CaseSalle();
						place.getComposerPlace().setSeanceT(seances.get(heureSeance.getSelectionModel().getSelectedIndex()));
						client.getListPlace().add(place);
						casesalle.getType().setId(6);
						casesalle.getType().setNomTypeCase("Normal");
						cinema.getListPlanSalle().get(0).getListCaseSalle().add(casesalle);
						
					}
					for (int i = 0 ; i < Integer.parseInt(nbPlaceHandicape.getValue()) ; i++){
						Place place = new Place();
						CaseSalle casesalle = new CaseSalle();
						place.getComposerPlace().setSeanceT(seances.get(heureSeance.getSelectionModel().getSelectedIndex()));
						client.getListPlace().add(place);
						casesalle.getType().setId(8);
						casesalle.getType().setNomTypeCase("Handicapé");
						cinema.getListPlanSalle().get(0).getListCaseSalle().add(casesalle);
					}
					cinema.setId(MainController.donnees.getCinemaCommande().getId());
					cinema.setNomCine(MainController.donnees.getCinemaCommande().getNomCine());
					MainController.donnees.setClientCommande(client);
					MainController.donnees.setCinemaCommande(cinema);
					VistaNavigator.loadVista(VistaNavigator.CHOIXPOSITION);
					//for (int i = 0 ; i < MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().size() ; i++){
					//	System.out.println(MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getType().getId());
					//}
				}
				else{
					if( dateSeance.getValue() == null || dateSeance.getValue().toString() == "" )
					{
						message.setText("Veuillez sélectionner une date");
					}
					else if(heureSeance.getValue() == null)
					{
						message.setText("Veuillez sélectionner une heure");
					}
					else if((nbPlacesNormal + nbPlacesHandi) == 0)
					{
						message.setText("Veuillez sélectionner au moins une place");
					}
				}
			}
		});
	}
	/**This function create the movie's list
	 */
	public void initAPI(){
		listeIdFilms = new ArrayList<String>();
		films= new ArrayList<Film>();
		films=ComplementDAO.listofFilms(MainController.donnees.getCinemaCommande().getId());
		for(Film f: films){
			listeIdFilms.add(f.getCodeFilm());
		}
		CineGoAPI API = new CineGoAPI(listeIdFilms);
		for( int i = 0 ; i < API.getTabFilms().size() ; i++){
			cineGoFilms.add(API.getTabFilms().get(i));
		}
		APILoadOK = true;
	}
	/**This function refresh fields when one movie is selected
	 */
	private void refreshInfosFilm() {
		client = new Client();
		cinema = new Cinema();
		dateSeance.setEditable(false);
		dateSeance.setValue(null);
		nomFilm.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getTitle());
		synopsis.setText(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getInfoFilm());
		synopsis.setWrapText(true);
		Image image = SwingFXUtils.toFXImage(cineGoFilms.get(listView.getSelectionModel().getSelectedIndex()).getDataIMG(), null);
		viewImageFilm.setImage(image);
		heureSeance.setDisable(true);
		nbPlace.setDisable(true);
		nbPlaceHandicape.setDisable(true);
		heureSeance.getSelectionModel().clearSelection();
		nbPlace.getSelectionModel().clearSelection();
		nbPlaceHandicape.getSelectionModel().clearSelection();
	}
}