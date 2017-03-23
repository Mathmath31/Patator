package ihm.view;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import classes.Donnees;
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
	private PasswordField password;
	@FXML
	private Button btnEnregistrer;
	@FXML
	private Button btnAutentifier;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private Label labelMessage;

	@FXML
	protected Button btCinema;

	@FXML
	protected Button btFilm;

	@FXML
	protected Button btPosition;

	@FXML
	protected Button btAccompagnement;

	@FXML
	protected Button btPanier;

	@FXML
	protected Button btReglement;

	protected static Donnees donnees= new Donnees();

	@FXML
	public void initialize(){
		
	}

	/**
	 * Autentification
	 *
	 *
	 */
	public void autentification(){
		//if iduser et password est ok
		
		String login = null;
		String mdp = null;
		
		login = idUser.getText();
		mdp = password.getText();
		
		donnees.connection(login, mdp);
		if (donnees.isConnecté() == true){
			System.out.println("Connecté");
			menubutton.setVisible(true);
			btnEnregistrer.setDisable(true);
			btnAutentifier.setDisable(true);
			label1.setVisible(false);
			label2.setVisible(false);
			idUser.setVisible(false);
			password.setVisible(false);
			
			if (donnees.getClientHistorique().isAdminClient())
			{
			menuAdmin.setVisible(true);
			}
			VistaNavigator.loadVista(VistaNavigator.CHOIXCINEMA);
			String message = "Bonjour "+ MainController.donnees.getClientHistorique().getNomClient();
			message = message + ", " + MainController.donnees.getClientHistorique().getPrenomClient();
			
			labelMessage.setText(message);
			password.setText("");
			idUser.setText("");
		}
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
		
		labelMessage.setText("Veuillez vous identifier ==>");
	}

	
	public void setDisableBtBandeau(boolean boolBtCinema, boolean boolBtFilm,boolean boolBtPosition,boolean boolBtAccompagnement,boolean boolBtPanier,boolean boolBtReglement) {
		this.btCinema.setDisable(boolBtCinema);
		this.btFilm.setDisable(boolBtFilm);
		this.btPosition.setDisable(boolBtPosition);
		this.btAccompagnement.setDisable(boolBtAccompagnement);
		this.btPanier.setDisable(boolBtPanier);
		this.btReglement.setDisable(boolBtReglement);
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

	public static Donnees getDonnees() {
		return donnees;
	}

	public static void setDonnees(Donnees donnees) {
		MainController.donnees = donnees;
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
	
	/**
	 * Event handler fired when the user requests a new vista.
	 *
	 * @param event the event that triggered the handler.
	 */
	@FXML
	void goVueAdminSeanceFilm(ActionEvent event) {
		VistaNavigator.loadVista(VistaNavigator.ADMINSEANCE);
	}

}