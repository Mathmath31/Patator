package ihm.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.concurrent.TimeUnit;

import classes.Client;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
import ihm.Main;
import ihm.VistaNavigator;


public class NewUserController {
	
	@FXML
	private TextField login;
	
	@FXML
	private TextField nom;

	@FXML
	private TextField prenom;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField sexe;
	
	@FXML
	private TextField carteFidel;
	
	@FXML
	private TextField adresse;
	
	@FXML
	private TextField ville;
	
	@FXML
	private TextField numTel;
	
	@FXML
	private TextField adresseMail;
	
	@FXML
	private TextField mdp;
	
	/**
	 * Check the informations provided by the client, save him in the DB if everything right
	 * @author Thomas
	 * @exception InterruptedException : event interrupting the sleep 
     * @param event the event that triggered the handler.
     * @see ComplementDAO, ClientDAO
     */
    @FXML
    void validerUser(ActionEvent event) {
    	
    	Client client= new Client();
    	String message=null;
		
		client.setLoginClient(login.getText());
		client.setMdpClient(mdp.getText());
		
		client.setAgeClient(age.getText());
		client.setAdminClient(false);
		client.setCodeFideliteClient(carteFidel.getText());
		client.setMailClient(adresseMail.getText());
		client.setPrenomClient(prenom.getText());
		client.setNomClient(nom.getText());
		client.setTelephoneClient(numTel.getText());
		client.setnVoieClient(adresse.getText());
		client.setSexeClient(sexe.getText());
		
		client.setIdVille(2); //TODO Ajouter champ code postal pour traiter la ville du client
		
		DAO<Client> ClientDAO = DAOFactory.getClientDAO();
		
		if(ComplementDAO.ExistsLoginClient(login.getText())){
			message ="Le login existe déjà, veuillez en choisir un autre";
		}
		else if (login.getText() + "" != "" &&   mdp.getText() + "" != "" && age.getText() + "" != "" && carteFidel.getText() + "" != "" &&  adresseMail.getText()  + "" != ""
				&& prenom.getText() + "" != ""  && nom.getText()+ "" != ""  && numTel.getText() + "" != ""  && adresse.getText() + "" != ""  && sexe.getText()  + "" != ""   ){
			message ="Votre profil à été créé, vous pouvez dés à présent vous connecter. Retour sur l'écran d'accueil dans 4 secondes.";
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			VistaNavigator.loadVista(VistaNavigator.HOME);
			client=ClientDAO.create(client);
		}
		else{
			message ="Au moins un champ n'est pas renseigné";
		}
    }
}
