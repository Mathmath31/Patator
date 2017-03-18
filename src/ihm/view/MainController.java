package ihm.view;

import ihm.VistaNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
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
    

	private static Panier curentPanier = new Panier();
	private static Panier oldPanier = new Panier();
	

    /**
     * 
     *
     *
     */
    public void autentification(){
    	//if iduser et password est ok
    	// si admin?
    	menubutton.setVisible(true);
    	menuAdmin.setVisible(true);
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
    
	public static Panier getCurentPanier() {
		return curentPanier;
	}

	public static void setCurentPanier(Panier Panier) {
		curentPanier = Panier;
	}

	public static Panier getOldPanier() {
		return oldPanier;
	}

	public static void setOldPanier(Panier Panier) {
		oldPanier = Panier;
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