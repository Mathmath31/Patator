package ihm;

import java.util.ArrayList;
import java.util.List;

public class Place {
	
	protected String typePlace;
	protected List<Integer> lignePlace = new ArrayList<Integer>();
	protected List<Integer> colonePlace = new ArrayList<Integer>();
	
	public Place(){
		
	}
	
	public String getTypePlace() {
		return typePlace;
	}
	public void setTypePlace(String typePlace) {
		this.typePlace = typePlace;
	}
	public List<Integer> getLignePlace() {
		return lignePlace;
	}
	public void setLignePlace(List<Integer> lignePlace) {
		this.lignePlace = lignePlace;
	}
	public List<Integer> getColonePlace() {
		return colonePlace;
	}
	public void setColonePlace(List<Integer> colonePlace) {
		this.colonePlace = colonePlace;
	}
	

}
