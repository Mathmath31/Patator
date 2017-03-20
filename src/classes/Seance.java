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
	private Film filmT;
	private CreerSeance creerSeanceT;

	public Seance() {};
	
	public Seance(int id, int idFilm, Film filmT, CreerSeance creerSeanceT){
		this.id=id;
		this.idFilm=idFilm;
		this.setFilmT(filmT);
		this.setCreerSeanceT(creerSeanceT);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	@Override
	public String toString() {
		return "Seance [id=" + id + ", idFilm=" + idFilm + ", filmT=" + filmT + ", creerSeanceT=" + creerSeanceT + "]";
	}
}
