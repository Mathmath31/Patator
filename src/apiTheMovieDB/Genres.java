/**
 * Genres Class.
 * Contain infos of Genres returned by TMDB's API.
 * @author PAULY.M
 */
package apiTheMovieDB;

public class Genres {
	private String id;
	private String name;
	
	public Genres(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genres [id=" + id + ", name=" + name + "]";
	}
	
}
