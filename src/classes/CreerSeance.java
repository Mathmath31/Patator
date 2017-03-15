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
	
	public CreerSeance() {};
	
	public CreerSeance(int idPlanSalle, int idCreneau,int idDate, int idSeance){
		this.idPlanSalle=idPlanSalle;
		this.idCreneau=idCreneau;
		this.idDate=idDate;
		this.idSeance=idSeance;
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

	@Override
	public String toString() {
		return "CreerSeance [idPlanSalle=" + idPlanSalle + ", idCreneau=" + idCreneau + ", idDate=" + idDate
				+ ", idSeance=" + idSeance + "]";
	}
	
}
