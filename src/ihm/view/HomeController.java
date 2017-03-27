package ihm.view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * Home controller class for the entire layout.
 * 
 * @author MVM
 */
public class HomeController {

	@FXML
	private ImageView logo;
	
	/**
	 * function called when the fxml view is called
	 * add logo to Image view
	 * @author MVM
	 */
	public void initialize(){
		String imageURI = "";
		imageURI = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Mars.png/220px-Mars.png";
		Image image = new Image(imageURI);
		logo.setImage(image);
	}
}
