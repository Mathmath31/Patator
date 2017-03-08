/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author thomas
 *
 */
public class PlanSalle {
	
	private int id;
	private String nomPlanSalle;
	private String numPlanSalle;
	private int idCinema;
	private ArrayList<CaseSalle> listPlanSalle = new ArrayList<CaseSalle>();
	
	public PlanSalle() {};
	
	public PlanSalle(int id,String nomPlanSalle, String numPlanSalle, int idCinema,ArrayList<CaseSalle> listPlanSalle){
		this.id=id;
		this.nomPlanSalle=nomPlanSalle;
		this.numPlanSalle=numPlanSalle;
		this.idCinema=idCinema;
		this.setListPlanSalle(listPlanSalle);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumPlanSalle() {
		return numPlanSalle;
	}

	public void setNumPlanSalle(String numPlanSalle) {
		this.numPlanSalle = numPlanSalle;
	}

	public String getNomPlanSalle() {
		return nomPlanSalle;
	}

	public void setNomPlanSalle(String nomPlanSalle) {
		this.nomPlanSalle = nomPlanSalle;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}
	
	
	public ArrayList<CaseSalle> getListPlanSalle() {
		return listPlanSalle;
	}

	public void setListPlanSalle(ArrayList<CaseSalle> listPlanSalle) {
		this.listPlanSalle = listPlanSalle;
	}

	@Override
	public String toString() {
		return "PlanSalle [id=" + id + ", numPlanSalle=" + numPlanSalle + ", nomPlanSalle=" + nomPlanSalle
				+ ", idCinema=" + idCinema + ", listPlanSalle=" + listPlanSalle + "]";
	}

	
	
}
