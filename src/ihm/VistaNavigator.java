package ihm;


import javafx.fxml.FXMLLoader;

import java.io.IOException;

import ihm.view.MainController;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class VistaNavigator {

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN    = "view/main.fxml";
    public static final String CHOIXCINEMA = "view/ChoixCinema.fxml";  
    public static final String NEWUSER = "view/NewUser.fxml";
    public static final String SELECTIONFILM = "view/FilmDetails.fxml";
    public static final String CHOIXPOSITION = "view/ChoixPosition.fxml";
    public static final String ACCOMPAGNEMENT = "view/ChoixAccompagnement.fxml";
    public static final String CREATIONSALLE = "view/CréationSalle.fxml";
    public static final String HOME = "view/home.fxml";
    public static final String PANIER = "view/VuePanier.fxml";
    public static final String REGLEMENT = "view/VueReglement.fxml";
    public static final String INFOUSER = "view/VueInfoUser.fxml";
    public static final String ADMINFILM = "view/AdminFilm.fxml";
    public static final String ADMINCINEMA = "view/AdminCinema.fxml";
    public static final String ADMINSEANCE = "view/AdminSeanceFilm.fxml";
    public static final String HISTORIQUE = "view/VueHistorique.fxml";
    public static final String IMPORTEXPORT = "view/VueImportExport.fxml";

    /** The main application layout controller. */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        try {
            mainController.setVista(
                FXMLLoader.load(
                    VistaNavigator.class.getResource(
                        fxml
                    )
                )
            );         
            switch (fxml) {
            case MAIN:
                mainController.setDisableBtBandeau(true, true, true, true, true, true);
                break;
            case CHOIXCINEMA:
                mainController.setDisableBtBandeau(false, true, true, true, true, true);
                break;
            case SELECTIONFILM:
                mainController.setDisableBtBandeau(false, false, true, true, true, true);
                break;
            case CHOIXPOSITION:
                mainController.setDisableBtBandeau(false, false, false, true, true, true);
                break;
            case ACCOMPAGNEMENT:
                mainController.setDisableBtBandeau(false, false, false, false, true, true);
                break;
            case PANIER:
                mainController.setDisableBtBandeau(false, false, false, false, false, true);
                break;
            case REGLEMENT:
                mainController.setDisableBtBandeau(false, false, false, false, false, false);
                break;
            case HOME:
            	mainController.setDisableBtBandeau(true, true, true, true, true, true);
                break;
            default:
                mainController.setDisableBtBandeau(false, true, true, true, true, true);
                break;
        }
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}