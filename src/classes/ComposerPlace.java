																	/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class ComposerPlace {
	
	private int idPlace;
	private int idCaseSalle;
	private int idSeance;
	private Seance seanceT;

	public ComposerPlace() {
		seanceT = new Seance();
	};
	
	public ComposerPlace(int idPlace, int idCaseSalle, int idSeance, Seance seanceT) {
		this.idPlace=idPlace;
		this.idCaseSalle=idCaseSalle;
		this.idSeance=idSeance;
		this.setSeanceT(seanceT);
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

	public Seance getSeanceT() {
		return seanceT;
	}

	public void setSeanceT(Seance seanceT) {
		this.seanceT = seanceT;
	}

	@Override
	public String toString() {
		return "ComposerPlace [idPlace=" + idPlace + ", idCaseSalle=" + idCaseSalle + ", idSeance=" + idSeance
				+ ", seanceT=" + seanceT + "]";
	}
	
	
}
