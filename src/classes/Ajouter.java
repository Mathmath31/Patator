/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Ajouter {
	
	private int idPlace;
	private int idProduit;
	
	public Ajouter() {};
	
	public Ajouter(int idPlace, int idProduit){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	@Override
	public String toString() {
		return "Ajouter [idPlace=" + idPlace + ", idProduit=" + idProduit + "]";
	}
	

}
