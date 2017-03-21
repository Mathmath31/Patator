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
	private String nomFilm;

	public Film() {};
	
	public Film(int id, String codeFilm,String nomFilm){
		this.id=id;
		this.codeFilm=codeFilm;
		this.nomFilm=nomFilm;
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

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
}
