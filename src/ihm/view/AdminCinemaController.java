package ihm.view;

import classes.Cinema;
import classes.Client;
import classes.Donnees;
import classes.Ville;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
import ihm.model.InfoCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminCinemaController {

	@FXML
	private TableView<InfoCine> tableView;
	@FXML
	private TableColumn<InfoCine, String> cinemaName;
	@FXML
	private TableColumn<InfoCine, String> cinemaAdresse;
	@FXML
	private TableColumn<InfoCine, String> cinemaVille;
	@FXML
	private TableColumn<InfoCine, String> cinemaCP;

	@FXML
	private TextField adminNomCine;
	@FXML
	private TextField adminNoVoie;
	@FXML
	private TextField adminNomVille;
	@FXML
	private TextField adminCP;

	private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
	
	
	public void initialize(){
//TODO charger les cinemas
		

		for(Cinema c:MainController.donnees.getCinemas()){
			cineData.add(new InfoCine(c.getNomCine(),c.getnVoieCine(),c.getVilleCine().getCpVille(),c.getVilleCine().getNomVille(),c.getId()));	
		}
		
		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
		cinemaVille.setCellValueFactory(cellData -> cellData.getValue().cinemaVilleProperty());
		cinemaCP.setCellValueFactory(cellData -> cellData.getValue().cinemaCPProperty());
		
		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
	}
	
	/**
	 * Add a cinema into the DB if everything is good
	 * @author Thomas
     * @param event the event that triggered the handler.
     * @see ComplementDAO, CinemaDAO
     */
	@FXML
    void ajoutCine(ActionEvent event) {
		String message;
		Ville villeCinema=new Ville();
		Cinema cine=new Cinema();
		
		DAO<Ville> VilleDAO = DAOFactory.getVilleDAO();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		if (ComplementDAO.ExistsCinema(adminNomCine.getText()) != 0){
			message="Le Cin�ma existe d�j� dans la base de donn�es";
		}
		else if( !adminNomCine.getText().isEmpty() && !adminNoVoie.getText().isEmpty() && !adminNomVille.getText().isEmpty() && !adminCP.getText().isEmpty()){
			
			cine.setNomCine(adminNomCine.getText());
			cine.setnVoieCine(adminNoVoie.getText());
			
			if(ComplementDAO.ExistsVille(adminNomVille.getText())==0){
				villeCinema.setNomVille(adminNomVille.getText());
				villeCinema.setCpVille(adminCP.getText());
				villeCinema=VilleDAO.create(villeCinema);
	    	}
	    	else{
	    		villeCinema=VilleDAO.find(ComplementDAO.ExistsVille(adminNomVille.getText()));
	    	}
			
			cine.setIdVille(villeCinema.getId());
			cine.setVilleCine(villeCinema);
			cine=CinemaDAO.create(cine);
		}
		else{
			message="Au moins un des champs est vide";
		}
    }
	
	
	/**
	 * Delete a cinema from the DB if everything is good
	 * @author Thomas
     * @param event the event that triggered the handler.
     * @see ComplementDAO, CinemaDAO
     */
	@FXML
    void suppCine(ActionEvent event) {
		String message;
		Cinema cine=new Cinema();

		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		if (ComplementDAO.ExistsCinema(adminNomCine.getText()) != 0){
			cine=CinemaDAO.find(ComplementDAO.ExistsCinema(adminNomCine.getText()));
			CinemaDAO.delete(cine);
			message="Le Cin�ma " + cine.getNomCine() + " a bien �t� supprim�";
		}
		else{
			message="Le Cin�ma " + cine.getNomCine() + " n'existe pas dans la base de donn�es";
		}	
    }
	
	/**
	 * Update a cinema into the DB if everything is good
	 * @author Thomas
     * @param event the event that triggered the handler.
     * @see ComplementDAO, CinemaDAO
     */
	@FXML
    void modifCine(ActionEvent event) {
		String message;
		Ville villeCinema=new Ville();
		Cinema cine=new Cinema();
		
		DAO<Ville> VilleDAO = DAOFactory.getVilleDAO();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		if( !adminNomCine.getText().isEmpty() && !adminNoVoie.getText().isEmpty() && !adminNomVille.getText().isEmpty() && !adminCP.getText().isEmpty()){
			
			cine.setNomCine(adminNomCine.getText());
			cine.setnVoieCine(adminNoVoie.getText());
			
			if(ComplementDAO.ExistsVille(adminNomVille.getText())==0){
				villeCinema.setNomVille(adminNomVille.getText());
				villeCinema.setCpVille(adminCP.getText());
				villeCinema=VilleDAO.create(villeCinema);
	    	}
	    	else{
	    		villeCinema=VilleDAO.find(ComplementDAO.ExistsVille(adminNomVille.getText()));
	    	}
			// TODO ajouter l'id et le prendre en compte dans le code
			cine.setIdVille(villeCinema.getId());
			cine.setVilleCine(villeCinema);
			cine=CinemaDAO.update(cine);
		}
		else{
			message="Au moins un des champs est vide";
		}
    }
	
	
	@FXML
    void tableViewSelectionChanged(MouseEvent event) {
//TODO modifier les TextFields avec la s�lection actuelle
		adminNomCine.setText(tableView.getSelectionModel().getSelectedItem().getCinemaName());
		adminNoVoie.setText(tableView.getSelectionModel().getSelectedItem().getCinemaAdresse());
		adminNomVille.setText(tableView.getSelectionModel().getSelectedItem().getCinemaVille());
		adminCP.setText(tableView.getSelectionModel().getSelectedItem().getCinemaCP());
    }
	
}
