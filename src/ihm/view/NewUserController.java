package ihm.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ihm.Main;
import ihm.VistaNavigator;


public class NewUserController {
	
	@FXML
	private TextField login;
	
	@FXML
	private TextField nom;

	@FXML
	private TextField prenom;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField sexe;
	
	@FXML
	private TextField carteFidel;
	
	@FXML
	private TextField adresse;
	
	@FXML
	private TextField ville;
	
	@FXML
	private TextField numTel;
	
	@FXML
	private TextField adresseMail;
	
	@FXML
	private TextField mdp;
	
	/**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void validerUser(ActionEvent event) {
        
    }
}
