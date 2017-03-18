/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class CreerSeance {
	
	private int idPlanSalle;
	private int idCreneau;
	private int idDate;
	private int idSeance;
	private Creneau creneauT;
	private Dates datesT;
	

	public CreerSeance() {};
	
	public CreerSeance(int idPlanSalle, int idCreneau,int idDate, int idSeance, Creneau creneauT, Dates datesT){
		this.idPlanSalle=idPlanSalle;
		this.idCreneau=idCreneau;
		this.idDate=idDate;
		this.idSeance=idSeance;
		this.setCreneauT(creneauT);
		this.setDatesT(datesT);	
	}

	public int getIdPlanSalle() {
		return idPlanSalle;
	}

	public void setIdPlanSalle(int idPlanSalle) {
		this.idPlanSalle = idPlanSalle;
	}

	public int getIdCreneau() {
		return idCreneau;
	}

	public void setIdCreneau(int idCreneau) {
		this.idCreneau = idCreneau;
	}

	public int getIdDate() {
		return idDate;
	}

	public void setIdDate(int idDate) {
		this.idDate = idDate;
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public Creneau getCreneauT() {
		return creneauT;
	}

	public void setCreneauT(Creneau creneauT) {
		this.creneauT = creneauT;
	}

	public Dates getDatesT() {
		return datesT;
	}

	public void setDatesT(Dates datesT) {
		this.datesT = datesT;
	}

	
	
}
