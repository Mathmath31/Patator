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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Admin cinema controller class for the entire layout.
 * 
 * @author MVM
 */
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
	private TableColumn<InfoCine, String> id;

	@FXML
	private TextField adminNomCine;
	@FXML
	private TextField adminNoVoie;
	@FXML
	private TextField adminNomVille;
	@FXML
	private TextField adminCP;

	@FXML
	private Label message;
	
	private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
	
	/**
	 * function called when the fxml view is called
	 * Populate the tableView with the cinema information in the database
	 * @author MVM
	 */
	public void initialize(){

		for(Cinema c:MainController.donnees.getCinemas()){
			cineData.add(new InfoCine(c.getNomCine(),c.getnVoieCine(),c.getVilleCine().getCpVille(),c.getVilleCine().getNomVille(),""+c.getId()));	
		}
		
		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());
		cinemaAdresse.setCellValueFactory(cellData -> cellData.getValue().cinemaAdresseProperty());
		cinemaCP.setCellValueFactory(cellData -> cellData.getValue().cinemaCPProperty());
		cinemaVille.setCellValueFactory(cellData -> cellData.getValue().cinemaVilleProperty());
		id.setCellValueFactory(cellData -> cellData.getValue().cinemaIDProperty());

		tableView.getItems().setAll(cineData);
		tableView.getSelectionModel().selectFirst();
		
		chargerTextField();
	}
	
	/**
	 * Add a cinema into the DB if everything is good
	 * @author Thomas
     * @param event the event that triggered the handler.
     * @see ComplementDAO, CinemaDAO
     */
	@FXML
    void ajoutCine(ActionEvent event) {
		Ville villeCinema=new Ville();
		Cinema cine=new Cinema();
		
		DAO<Ville> VilleDAO = DAOFactory.getVilleDAO();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		if (ComplementDAO.ExistsCinema(adminNomCine.getText()) != 0){
			message.setText("Le Cinéma existe déjà dans la base de données");
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
			message.setText("Au moins un des champs est vide");
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
		Cinema cine=new Cinema();

		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		cine.setId(Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getCinemaID()));
		cine.setNomCine(tableView.getSelectionModel().getSelectedItem().getCinemaName());
		CinemaDAO.delete(cine);
		message.setText("Le Cinéma " + cine.getNomCine() + " a bien été supprimé");
			
    }
	
	/**
	 * Update a cinema into the DB if everything is good
	 * @author Thomas
     * @param event the event that triggered the handler.
     * @see ComplementDAO, CinemaDAO
     */
	@FXML
    void modifCine(ActionEvent event) {
		Ville villeCinema=new Ville();
		Cinema cine=new Cinema();
		
		DAO<Ville> VilleDAO = DAOFactory.getVilleDAO();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		
		if( !adminNomCine.getText().isEmpty() && !adminNoVoie.getText().isEmpty() && !adminNomVille.getText().isEmpty() && !adminCP.getText().isEmpty()){
			
			cine.setId(Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getCinemaID()));
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
			message.setText("Au moins un des champs est vide");
		}
    }
	
	/**
	 * change the textfield with the information of selected row
	 * @author MVM
     * @param event the event that triggered the handler.
     * 
     */
	@FXML
    void tableViewSelectionChanged(MouseEvent event) {
		chargerTextField();
    }
	
	/**
	 * change the textfield with the information of selected row
	 * @author MVM
     * @param event the event that triggered the handler.
     * 
     */
	void chargerTextField()
	{
		adminNomCine.setText(tableView.getSelectionModel().getSelectedItem().getCinemaName());
		adminNoVoie.setText(tableView.getSelectionModel().getSelectedItem().getCinemaAdresse());
		adminNomVille.setText(tableView.getSelectionModel().getSelectedItem().getCinemaVille());
		adminCP.setText(tableView.getSelectionModel().getSelectedItem().getCinemaCP());
		message.setText(tableView.getSelectionModel().getSelectedItem().getCinemaID());
	}
	
}
