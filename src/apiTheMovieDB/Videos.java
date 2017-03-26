/**
 * Videos Class.
 * Contain infos of Videos returned by TMDB's API.
 * @author PAULY.M
 */
package apiTheMovieDB;
import java.util.ArrayList;
import java.util.List;

public class Videos {

	private  List<Results> results = new ArrayList<Results>();

	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "Videos [results=" + results + "]";
	}
}
