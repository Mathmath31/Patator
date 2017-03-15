/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Place {
	
	private int id;
	private boolean choixPlace;
	private int idClient;

	public Place() {};
	
	public Place(int id, boolean choixPlace, int idClient){
		this.id=id;
		this.choixPlace=choixPlace;
		this.idClient=idClient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isChoixPlace() {
		return choixPlace;
	}

	public void setChoixPlace(boolean choixPlace) {
		this.choixPlace = choixPlace;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", choixPlace=" + choixPlace + ", idClient=" + idClient + "]";
	}

	
}
