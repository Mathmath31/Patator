/**
 * 
 */
package classes;

import java.sql.Time;

/**
 * @author Thomas
 *
 */
public class Creneau {
	
	private int id;
	private Time heureDebutCreneau;
	private Time heureFinCreneau;

	public Creneau() {};
	
	public Creneau(int id,Time heureDebutCreneau, Time heureFinCreneau){
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

	public Time getHeureDebutCreneau() {
		return heureDebutCreneau;
	}

	public void setHeureDebutCreneau(Time heureDebutCreneau) {
		this.heureDebutCreneau = heureDebutCreneau;
	}

	public Time getHeureFinCreneau() {
		return heureFinCreneau;
	}

	public void setHeureFinCreneau(Time heureFinCreneau) {
		this.heureFinCreneau = heureFinCreneau;
	}

	@Override
	public String toString() {
		return "Creneau [id=" + id + ", heureDebutCreneau=" + heureDebutCreneau + ", heureFinCreneau=" + heureFinCreneau
				+ "]";
	}
	
	
	
}
