package ihm.controller;

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
    
}