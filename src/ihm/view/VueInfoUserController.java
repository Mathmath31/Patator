package ihm.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * VueInfoUserController controller class for the entire layout.
 * 
 * @author MVM
 */
public class VueInfoUserController {
	@FXML
	private Label login;
	
	@FXML
	private Label nom;

	@FXML
	private Label prenom;
	
	@FXML
	private Label age;
	
	@FXML
	private Label sexe;
	
	@FXML
	private Label carteFidel;
	
	@FXML
	private Label adresse;
	
	@FXML
	private Label ville;
	
	@FXML
	private Label numTel;
	
	@FXML
	private Label adresseMail;
	
	@FXML
	private Label mdp;
	
	@FXML
	private Label cp;
	
	/**
	 * function called when the fxml view is called
	 * add user information to label
	 * @author MVM
	 */
	public void initialize(){	
		login.setText(MainController.donnees.getClientHistorique().getLoginClient());
		nom.setText(MainController.donnees.getClientHistorique().getNomClient());
		age.setText(MainController.donnees.getClientHistorique().getAgeClient());
		prenom.setText(MainController.donnees.getClientHistorique().getPrenomClient());
		sexe.setText(MainController.donnees.getClientHistorique().getSexeClient());
		carteFidel.setText(MainController.donnees.getClientHistorique().getCodeFideliteClient());
		adresse.setText(MainController.donnees.getClientHistorique().getnVoieClient());
		ville.setText(MainController.donnees.getClientHistorique().getVilleClient().getNomVille());
		numTel.setText(MainController.donnees.getClientHistorique().getTelephoneClient());
		adresseMail.setText(MainController.donnees.getClientHistorique().getMailClient());
		cp.setText(MainController.donnees.getClientHistorique().getVilleClient().getCpVille());
		mdp.setText(MainController.donnees.getClientHistorique().getMdpClient());
	}
}
