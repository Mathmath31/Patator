package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Client;
import classes.Place;
import classes.Ville;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for the class Client, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class ClientDAO extends DAO<Client> {
	
	/**
	 * Retrieve the Data in the Database of the class Client
	 * @author Thomas
	 * @param id = idClient
	 * @return client : class Client
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override
	public Client find(int id) {

		Client client=new Client();
		
		DAO <Ville> VilleDAO = DAOFactory.getVilleDAO();
		Ville villeClient = new Ville();
		
		DAO<Place> PlaceDAO = DAOFactory.getPlaceDAO();
		ArrayList<Place> listPlace=new ArrayList<Place>();

		String loginClient=null;
		String mdpClient=null;
		String mailClient=null;
		String telephoneClient=null;
		String nomClient=null;
		String prenomClient=null;
		String ageClient=null;
		String nVoieClient=null;
		String sexeClient=null;
		String codeFideliteClient=null;
		boolean adminClient=false;
		int idVille=0;
		int[] listIdPlace = new int[30];
		int i=0;

		ResultSet rs = Connection.selectFrom("SELECT loginClient,mdpClient,mailClient,telephoneClient,nomClient,prenomClient,"
											 + "ageClient,nVoieClient,sexeClient,codeFideliteClient,adminClient,idVille "
											 + "FROM client "
											 + "WHERE idClient = " + id +";");
		try {
			while(rs.next())
			{
				loginClient = rs.getString("loginClient");
				mdpClient = rs.getString("mdpClient");
				mailClient = rs.getString("mailClient");
				telephoneClient = rs.getString("telephoneClient");
				nomClient = rs.getString("nomClient");
				prenomClient = rs.getString("prenomClient");
				ageClient = rs.getString("ageClient");
				nVoieClient = rs.getString("nVoieClient");
				sexeClient = rs.getString("sexeClient");
				codeFideliteClient = rs.getString("codeFideliteClient");
				adminClient = rs.getBoolean("adminClient");
				idVille=rs.getInt("idVille");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		listIdPlace=ComplementDAO.listPlace(id);
		
		while (listIdPlace[i] != 0)
		{
			listPlace.add(PlaceDAO.find(listIdPlace[i]));
			i++;
		}
		
		villeClient=VilleDAO.find(idVille);
		
		client = new Client(id,loginClient,mdpClient,mailClient,telephoneClient,nomClient,prenomClient,ageClient,
				            nVoieClient,sexeClient,codeFideliteClient,adminClient,idVille,villeClient,listPlace); 

		return client;
	}

	/**
	 * Create the Data in the Database of the class Client
	 * @author Thomas
	 * @param obj : class Client
	 * @return obj : class Client
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override
	public Client create(Client obj) {

		Connection.update("INSERT INTO client (loginClient,mdpClient,mailClient,telephoneClient,nomClient,prenomClient,ageClient,"
				          +"nVoieClient,sexeClient,codeFideliteClient,adminClient,idVille) VALUES('"
					   	  +obj.getLoginClient() + "','"
						  +obj.getMdpClient()+"','"
					   	  +obj.getMailClient() + "','"
						  +obj.getTelephoneClient()+"','"
					   	  +obj.getNomClient() + "','"
						  +obj.getPrenomClient()+"','"
					   	  +obj.getAgeClient() + "','"
						  +obj.getnVoieClient()+"','"
					   	  +obj.getSexeClient() + "','"
						  +obj.getCodeFideliteClient()+"',"
						  +obj.isAdminClient()+","
						  +obj.getIdVille()+")");

		ResultSet result = Connection.selectFrom("SELECT idClient "
											   	 + "FROM client "
												 +";");
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idClient");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}
	
	/**
	 * Update the Data in the Database of the class Client
	 * @author Thomas
	 * @param obj : class Client
	 * @return obj : class Client
	 */
	@Override
	public Client update(Client obj) {

		Connection.update("UPDATE client SET "
						  +"loginClient='"+obj.getLoginClient() + "',"
						  +"mdpClient='"+obj.getMdpClient()+"',"
						  +"mailClient='"+obj.getMailClient() + "',"
						  +"telephoneClient='"+obj.getTelephoneClient()+"',"
						  +"nomClient='"+obj.getNomClient() + "',"
						  +"prenomClient='"+obj.getPrenomClient()+"',"
						  +"ageClient='"+obj.getAgeClient() + "',"
						  +"nVoieClient='"+obj.getnVoieClient()+"',"
						  +"sexeClient='"+obj.getSexeClient() + "',"
						  +"codeFideliteClient='"+obj.getCodeFideliteClient()+"',"
						  +"adminClient="+obj.isAdminClient()+","
						  +"idVille="+obj.getIdVille()		
						  +" WHERE idPlace=" + obj.getId() + ";");        
		return obj;
	}
	
	/**
	 * Delete the Data in the Database of the class Client
	 * @author Thomas
	 *  obj : class Client
	 */
	@Override
	public void delete(Client obj) {

		Connection.update("DELETE  FROM client WHERE idClient="
						  +obj.getId()
						  +";");
	}
}