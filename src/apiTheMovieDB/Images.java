/**
 * Images Class.
 * Contain backdrops & posters objects returned by TMDB's API.
 * @author PAULY.M
 */
package apiTheMovieDB;

import java.util.ArrayList;
import java.util.List;

public class Images {
	
	private  List<Backdrops> backdrops = new ArrayList<Backdrops>();
	private  List<Posters> posters = new ArrayList<Posters>();
	
	
	public List<Backdrops> getBackdrops() {
		return backdrops;
	}
	public void setBackdrops(List<Backdrops> backdrops) {
		this.backdrops = backdrops;
	}
	public List<Posters> getPosters() {
		return posters;
	}
	public void setPosters(List<Posters> posters) {
		this.posters = posters;
	}
	@Override
	public String toString() {
		return "Images [backdrops=" + backdrops + ", posters=" + posters + "]";
	}
}
