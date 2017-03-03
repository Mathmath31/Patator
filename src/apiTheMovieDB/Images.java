package apiTheMovieDB;

import java.util.ArrayList;
import java.util.List;

public class Images {
	
	private  List<Backdrops> backdrops = new ArrayList();
	private  List<Posters> posters = new ArrayList();
	
	
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
