package ihm.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.TimeUnit;

import classes.Client;
import classes.Ville;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
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
	
	@FXML
	private TextField cp;
	
	@FXML
	private Label message;
	
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
		Ville villeClient=new Ville();
		DAO<Client> ClientDAO = DAOFactory.getClientDAO();
		DAO<Ville> VilleDAO = DAOFactory.getVilleDAO();

		
		if(ComplementDAO.ExistsLoginClient(login.getText())){
			message.setText("Le login existe déjà, veuillez en choisir un autre");
		}
		else if (  !login.getText().isEmpty()  &&   !mdp.getText().isEmpty()  && !age.getText().isEmpty()  && !carteFidel.getText().isEmpty()  &&  !adresseMail.getText().isEmpty() 
				&& !prenom.getText().isEmpty() && !nom.getText().isEmpty()  && !numTel.getText().isEmpty() && !adresse.getText().isEmpty()   && !sexe.getText().isEmpty()){
			
			//XXX le message ne s'affiche pas
			message.setText("Votre profil à été créé, vous pouvez dés à présent vous connecter. Retour sur l'écran d'accueil dans 4 secondes.");
			
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
			
			if(ComplementDAO.ExistsVille(ville.getText())==0){
	    		villeClient.setNomVille(ville.getText());
	    		villeClient.setCpVille(cp.getText());
	    		villeClient=VilleDAO.create(villeClient);
	    	}
	    	else{
	    		villeClient=VilleDAO.find(ComplementDAO.ExistsVille(ville.getText()));
	    	}
			
			client.setVilleClient(villeClient);
			client.setIdVille(villeClient.getId());
			
			client=ClientDAO.create(client);
			
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			VistaNavigator.loadVista(VistaNavigator.HOME);
			
		}
		else{
			message.setText("Au moins un champ n'est pas renseigné");
		}
    }
}
