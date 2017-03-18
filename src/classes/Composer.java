																	/**
 * 
 */
package classes;

/**
 * @author thomas
 *
 */
public class Composer {
	
	private int idPlace;
	private int idCaseSalle;
	private int idSeance;

	public Composer() {};
	
	public Composer(int idPlace, int idCaseSalle, int idSeance) {
		this.idPlace=idPlace;
		this.idCaseSalle=idCaseSalle;
		this.idSeance=idSeance;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public int getIdCaseSalle() {
		return idCaseSalle;
	}

	public void setIdCaseSalle(int idCaseSalle) {
		this.idCaseSalle = idCaseSalle;
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	@Override
	public String toString() {
		return "Composer [idPlace=" + idPlace + ", idCaseSalle=" + idCaseSalle + ", idSeance=" + idSeance + "]";
	}
	
}
