/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class AjouterProduit {
	
	private int idProduit;
	private int idPlace;
	private int quantite;
	private boolean livrer;
	private Produit produit = new Produit();

	public AjouterProduit() {};
	
	public AjouterProduit(int idProduit, int idPlace, int quantite, boolean livrer, Produit produit){
		this.idPlace=idPlace;
		this.idProduit=idProduit;
		this.quantite=quantite;
		this.livrer=livrer;
		this.setProduit(produit);
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
	
	public int getQuantite() {
		return quantite;
	}
 
	public void setQuantite(int quantité) {
		this.quantite = quantité;
	}

	public boolean isLivrer() {
		return livrer;
	}

	public void setLivrer(boolean livré) {
		this.livrer = livré;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "AjouterProduit [idPlace=" + idPlace + ", idProduit=" + idProduit + ", quantite=" + quantite
				+ ", livrer=" + livrer + ", produit=" + produit + "]";
	}
	
}
