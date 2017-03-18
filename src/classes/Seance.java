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
	private String nomFilm;
	private Film filmT;
	private CreerSeance creerSeanceT;

	public Seance() {};
	
	public Seance(int id, String nomFilm, Film filmT, CreerSeance creerSeanceT){
		this.id=id;
		this.nomFilm=nomFilm;
		this.setFilmT(filmT);
		this.setCreerSeanceT(creerSeanceT);
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

	public Film getFilmT() {
		return filmT;
	}

	public void setFilmT(Film filmT) {
		this.filmT = filmT;
	}

	public CreerSeance getCreerSeanceT() {
		return creerSeanceT;
	}

	public void setCreerSeanceT(CreerSeance creerSeanceT) {
		this.creerSeanceT = creerSeanceT;
	}

	@Override
	public String toString() {
		return "Seance [id=" + id + ", nomFilm=" + nomFilm + ", filmT=" + filmT + ", creerSeanceT=" + creerSeanceT
				+ "]";
	}
}
