/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Seance {
	
	private int id;
	private int idFilm;

	public Seance() {};
	
	public Seance(int id, int idFilm){
		this.id=id;
		this.idFilm=idFilm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getidFilm() {
		return idFilm;
	}

	public void setidFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", idFilm=" + idFilm + "]";
	}
}
