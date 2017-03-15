/**
 * 
 */
package classes;

/**
 * @author Thomas
 *
 */
public class Film {
	
	private int id;
	private String nomFilm;

	public Film() {};
	
	public Film(int id, String nomFilm){
		this.id=id;
		this.nomFilm=nomFilm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nomFilm=" + nomFilm + "]";
	}
}
