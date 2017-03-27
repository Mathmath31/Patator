package ihm.view;

import ihm.VistaNavigator;
import javafx.fxml.FXML;

/**
 * VuePanierController controller class for the entire layout.
 * 
 * @author MVM
 */
public class VuePanierController {
	
	/**
	 * Event handler fired when the user requests a new vista.
	 * @author MVM
	 * @param event the event that triggered the handler.
	 */
	@FXML
	private void Reglement(){
		VistaNavigator.loadVista(VistaNavigator.REGLEMENT);
	}
	
	/**
	 * function called when the fxml view is called
	 * add panier information
	 * @author MVM
	 */
	public void initialize(){
		
	}
}
