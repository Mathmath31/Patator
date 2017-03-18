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
	private boolean livré;
	
	public AjouterProduit() {};
	
	public AjouterProduit(int idPlace, int idProduit, int quantité, boolean livré){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
		this.quantité=quantité;
		this.livré=livré;
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

	public boolean isLivré() {
		return livré;
	}

	public void setLivré(boolean livré) {
		this.livré = livré;
	}

	@Override
	public String toString() {
		return "AjouterProduit [idPlace=" + idPlace + ", idProduit=" + idProduit + ", quantité=" + quantité + ", livré="
				+ livré + "]";
	}

	
}
