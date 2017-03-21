package test;

import classes.Client;
import dao.DAO;
import dao.DAOFactory;



public class TestClient {

	public static void main(String[] args) {
		
		Client client= new Client();
		
		client.setLoginClient("tcazals");
		client.setMdpClient("azerty");
		client.setIdVille(2);
		client.setAgeClient("29");
		client.setAdminClient(true);
		client.setCodeFideliteClient("56845848");
		client.setMailClient("tcaz@cesi.fr");
		client.setPrenomClient("Thomas");
		client.setNomClient("Cazals");
		client.setTelephoneClient("0565258852");
		client.setnVoieClient("20 rue des pommiers");
		
		DAO<Client> ClientDAO = DAOFactory.getClientDAO();
		
		//client=ClientDAO.create(client);
		
		client.setSexeClient("M");
		client.setId(1);
		client=ClientDAO.update(client);
	
	}

}
