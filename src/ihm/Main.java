package ihm;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import ihm.view.MainController;

/**
 * Main application class.
 */
public class Main extends Application {
	
    @Override
    public void start(Stage stage) throws Exception{
    	
        stage.setTitle("Viva CineGo");
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.getIcons().add(new Image("icone.png"));
        stage.setScene(
            createScene(
                loadMainPane()
            )
    );
        stage.show();
    }
    
    /**
     * Loads the main fxml layout.
     * Sets up the view switching VistaNavigator.
     * Loads the first view into the fxml layout.
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
        VistaNavigator.loadVista(VistaNavigator.HOME);

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

        scene.getStylesheets().setAll(
            getClass().getResource("style/vista.css").toExternalForm()
        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
