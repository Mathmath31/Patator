package ihm;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoAPI;
import ihm.controller.MainController;

/**
 * Main application class.
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception{

    	List<String> listeIdFilms = new ArrayList<String>();			//Recuperer la liste de tout les films à l'affiche dans la base de donnee		
		listeIdFilms.add("121856");listeIdFilms.add("274870");listeIdFilms.add("47971");
		CineGoAPI API = new CineGoAPI(listeIdFilms);
		System.out.println(API.getTabFilms().toString());

		
        stage.setTitle("Cine GoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOo");
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(
            createScene(
                loadMainPane()
            )
        );
        stage.show();
    }

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
            getClass().getResourceAsStream(
                VistaNavigator.MAIN
            )
        );

        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.CHOIXCINEMA);

        return mainPane;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );

//        scene.getStylesheets().setAll(
//            getClass().getResource("vista.css").toExternalForm()
//        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
