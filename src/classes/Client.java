/**
 * 
 */
package classes;



/**
 * @author Thomas
 *
 */
public class Client {
	
	private int id;
	private String loginClient;
	private String mdpClient;
	private String mailClient;
	private String telephoneClient;
	private String nomClient;
	private String prenomClient;
	private String ageClient;
	private String nVoieClient;
	private String sexeClient;
	private String codeFideliteClient;
	private boolean adminClient;
	private int idVille;
	private Ville VilleCine;

	
	public Client() {};
	
	public Client(int id, String loginClient, String mdpClient, String mailClient, String telephoneClient, String nomClient, String prenomClient, String ageClient,
			String nVoieClient, String sexeClient, String codeFideliteClient, boolean adminClient, int idVille ,Ville VilleCine){
		
		this.id=id;
		this.loginClient=loginClient;
		this.mdpClient=mdpClient;
		this.mailClient=mailClient;
		this.telephoneClient=telephoneClient;
		this.nomClient=nomClient;
		this.prenomClient=prenomClient;
		this.ageClient=ageClient;
		this.nVoieClient=nVoieClient;
		this.sexeClient=sexeClient;
		this.codeFideliteClient=codeFideliteClient;
		this.adminClient=adminClient;
		this.idVille=idVille;
		this.setVilleCine(VilleCine);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginClient() {
		return loginClient;
	}

	public void setLoginClient(String loginClient) {
		this.loginClient = loginClient;
	}

	public String getMdpClient() {
		return mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}

	public String getMailClient() {
		return mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAgeClient() {
		return ageClient;
	}

	public void setAgeClient(String ageClient) {
		this.ageClient = ageClient;
	}

	public String getnVoieClient() {
		return nVoieClient;
	}

	public void setnVoieClient(String nVoieClient) {
		this.nVoieClient = nVoieClient;
	}

	public String getSexeClient() {
		return sexeClient;
	}

	public void setSexeClient(String sexeClient) {
		this.sexeClient = sexeClient;
	}

	public String getCodeFideliteClient() {
		return codeFideliteClient;
	}

	public void setCodeFideliteClient(String codeFideliteClient) {
		this.codeFideliteClient = codeFideliteClient;
	}

	public boolean isAdminClient() {
		return adminClient;
	}

	public void setAdminClient(boolean adminClient) {
		this.adminClient = adminClient;
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}


	public Ville getVilleCine() {
		return VilleCine;
	}

	public void setVilleCine(Ville villeCine) {
		VilleCine = villeCine;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", loginClient=" + loginClient + ", mdpClient=" + mdpClient + ", mailClient="
				+ mailClient + ", telephoneClient=" + telephoneClient + ", nomClient=" + nomClient + ", prenomClient="
				+ prenomClient + ", ageClient=" + ageClient + ", nVoieClient=" + nVoieClient + ", sexeClient="
				+ sexeClient + ", codeFideliteClient=" + codeFideliteClient + ", adminClient=" + adminClient
				+ ", idVille=" + idVille + ", VilleCine=" + VilleCine + "]";
	}
	
	
	
}
