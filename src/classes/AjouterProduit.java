/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class AjouterProduit {
	
	private int idPlace;
	private int idProduit;
	private int quantité;
	
	public AjouterProduit() {};
	
	public AjouterProduit(int idPlace, int idProduit, int quantité){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
		this.quantité=quantité;
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
	
	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	@Override
	public String toString() {
		return "AjouterProduit [idPlace=" + idPlace + ", idProduit=" + idProduit + ", quantité=" + quantité + "]";
	}

}
