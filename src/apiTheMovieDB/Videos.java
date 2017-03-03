package apiTheMovieDB;
import java.util.ArrayList;
import java.util.List;

public class Videos {
	
	private  List<Results> results = new ArrayList();

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
