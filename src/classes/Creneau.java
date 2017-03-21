/**
 * 
 */
package classes;



/**
 * @author Thomas
 *
 */
public class Creneau {
	
	private int id;
	private String heureDebutCreneau;
	private String heureFinCreneau;

	public Creneau() {};
	
	public Creneau(int id,String heureDebutCreneau, String heureFinCreneau){
		this.id=id;
		this.heureDebutCreneau=heureDebutCreneau;
		this.heureFinCreneau=heureFinCreneau;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeureDebutCreneau() {
		return heureDebutCreneau;
	}

	public void setHeureDebutCreneau(String heureDebutCreneau) {
		this.heureDebutCreneau = heureDebutCreneau;
	}

	public String getHeureFinCreneau() {
		return heureFinCreneau;
	}

	public void setHeureFinCreneau(String heureFinCreneau) {
		this.heureFinCreneau = heureFinCreneau;
	}

	@Override
	public String toString() {
		return "Creneau [id=" + id + ", heureDebutCreneau=" + heureDebutCreneau + ", heureFinCreneau=" + heureFinCreneau
				+ "]";
	}
	
	
	
}
