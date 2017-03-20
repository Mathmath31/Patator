/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author Thomas
 *
 */
public class Place {
	
	private int id;
	private boolean choixPlace;
	private int idClient;
	private ComposerPlace composerPlace;
	private ArrayList<AjouterProduit> listAjouterProduit = new ArrayList<AjouterProduit>();

	public Place() {};
	
	public Place(int id, boolean choixPlace, int idClient, ComposerPlace composerPlace, ArrayList<AjouterProduit> listAjouterProduit){
		this.id=id;
		this.choixPlace=choixPlace;
		this.idClient=idClient;
		this.setComposerPlace(composerPlace);
		this.setListAjouterProduit(listAjouterProduit);
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

	public ComposerPlace getComposerPlace() {
		return composerPlace;
	}

	public void setComposerPlace(ComposerPlace composerPlace) {
		this.composerPlace = composerPlace;
	}

	public ArrayList<AjouterProduit> getListAjouterProduit() {
		return listAjouterProduit;
	}

	public void setListAjouterProduit(ArrayList<AjouterProduit> listAjouterProduit) {
		this.listAjouterProduit = listAjouterProduit;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", choixPlace=" + choixPlace + ", idClient=" + idClient + ", composerPlace="
				+ composerPlace + ", listAjouterProduit=" + listAjouterProduit + "]";
	}
}
