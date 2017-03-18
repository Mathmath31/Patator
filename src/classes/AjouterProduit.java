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
	private int quantit�;
	private boolean livr�;
	
	public AjouterProduit() {};
	
	public AjouterProduit(int idPlace, int idProduit, int quantit�, boolean livr�){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
		this.quantit�=quantit�;
		this.livr�=livr�;
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
	
	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public boolean isLivr�() {
		return livr�;
	}

	public void setLivr�(boolean livr�) {
		this.livr� = livr�;
	}

	@Override
	public String toString() {
		return "AjouterProduit [idPlace=" + idPlace + ", idProduit=" + idProduit + ", quantit�=" + quantit� + ", livr�="
				+ livr� + "]";
	}

	
}
