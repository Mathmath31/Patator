/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Ville {
	
	private int id;
	private String nomVille;
	private String cpVille;

	public Ville() {};
	
	public Ville(int id, String nomVille, String cpVille){
		this.id=id;
		this.nomVille=nomVille;
		this.cpVille=cpVille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public String getCpVille() {
		return cpVille;
	}

	public void setCpVille(String cpVille) {
		this.cpVille = cpVille;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nomVille=" + nomVille + ", cpVille=" + cpVille + "]";
	}

	
	
}
