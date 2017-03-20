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
	private String codeFilm;

	public Film() {};
	
	public Film(int id, String nomFilm){
		this.id=id;
		this.codeFilm=nomFilm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeFilm() {
		return codeFilm;
	}

	public void setCodeFilm(String nomFilm) {
		this.codeFilm = nomFilm;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nomFilm=" + codeFilm + "]";
	}
}
