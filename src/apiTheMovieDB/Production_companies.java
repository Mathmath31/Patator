/**
 * Production_companies Class.
 * Contain infos of Production_companies returned by TMDB's API.
 * @author PAULY.M
 */
package apiTheMovieDB;

public class Production_companies {
	private String id;
	private String name;
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
		return "Production_companies [id=" + id + ", name=" + name + "]";
	}
}
