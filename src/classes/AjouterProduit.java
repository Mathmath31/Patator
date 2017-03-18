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
	
	public AjouterProduit() {};
	
	public AjouterProduit(int idPlace, int idProduit, int quantit�){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
		this.quantit�=quantit�;
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

	@Override
	public String toString() {
		return "AjouterProduit [idPlace=" + idPlace + ", idProduit=" + idProduit + ", quantit�=" + quantit� + "]";
	}

}
