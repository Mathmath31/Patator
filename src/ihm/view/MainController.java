package ihm.view;

import ihm.VistaNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

/**
 * Main controller class for the entire layout.
 */
public class MainController {

    /** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;
    @FXML
    private MenuButton menubutton;
    @FXML
    public MenuButton menuAdmin;
    @FXML
    private TextField idUser;
    @FXML
    private TextField password;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private Button btnAutentifier;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    /**
     * 
     *
     *
     */
    public void autentification(){
    	//if iduser et password est ok
    	menubutton.setVisible(true);
    	btnEnregistrer.setDisable(true);
    	btnAutentifier.setDisable(true);
    	label1.setVisible(false);
    	label2.setVisible(false);
    	idUser.setVisible(false);
    	password.setVisible(false);
    	// si admin?
    	menuAdmin.setVisible(true);
    	
    	
    	
    	VistaNavigator.loadVista(VistaNavigator.CHOIXCINEMA);
    	//menuAdmin.setDisable(true);
    }
    
    /**
     * 
     *
     *
     */
    public void deconnection() {
    	//si on se deco supp les droits de l'user
    	menubutton.setVisible(false);
    	menuAdmin.setVisible(false);
    	btnEnregistrer.setDisable(false);
    	btnAutentifier.setDisable(false);
    	label1.setVisible(true);
    	label2.setVisible(true);
    	idUser.setVisible(true);
    	password.setVisible(true);
    	VistaNavigator.loadVista(VistaNavigator.HOME);
    }
    
    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }
    
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueChoixCinema(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.CHOIXCINEMA);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueChoixPosition(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.CHOIXPOSITION);
    }

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueChoixFilm(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.SELECTIONFILM);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueChoixAccompagnement(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.ACCOMPAGNEMENT);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goCreationSalle(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.CREATIONSALLE);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goNewUser(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.NEWUSER);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVuePanier(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.PANIER);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueReglement(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.REGLEMENT);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueInfoUser(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.INFOUSER);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueReservation(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.RESERVATION);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueAdminFilm(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.ADMINFILM);
    }
    
    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void goVueAdminCinema(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.ADMINCINEMA);
    }
}