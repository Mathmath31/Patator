/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Produit {
	
	private int id;
	private String nomProduit;
	private String descriptionProduit;
	private Double prixProduit;
	
	public Produit() {};
	
	public Produit(int id, String nomProduit, String descriptionProduit, Double prixProduit){
		this.id=id;
		this.nomProduit=nomProduit;
		this.descriptionProduit=descriptionProduit;
		this.prixProduit=prixProduit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public Double getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", descriptionProduit=" + descriptionProduit
				+ ", prixProduit=" + prixProduit + "]";
	}

}
