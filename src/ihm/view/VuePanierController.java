package ihm.view;

import ihm.VistaNavigator;
import javafx.fxml.FXML;

public class VuePanierController {
	
	@FXML
	private void Reglement(){
		VistaNavigator.loadVista(VistaNavigator.REGLEMENT);
	}

}
