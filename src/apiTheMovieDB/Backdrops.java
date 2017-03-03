package apiTheMovieDB;

public class Backdrops {

	private String aspect_ratio;
	private String file_path;
	private String height;
	private String iso_639_1;
	private String vote_average;
	private String vote_count;
	private String width;
	
	
	public String getAspect_ratio() {
		return aspect_ratio;
	}
	public void setAspect_ratio(String aspect_ratio) {
		this.aspect_ratio = aspect_ratio;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getIso_639_1() {
		return iso_639_1;
	}
	public void setIso_639_1(String iso_639_1) {
		this.iso_639_1 = iso_639_1;
	}
	public String getVote_average() {
		return vote_average;
	}
	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}
	public String getVote_count() {
		return vote_count;
	}
	public void setVote_count(String vote_count) {
		this.vote_count = vote_count;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Backdrops [aspect_ratio=" + aspect_ratio + ", file_path=" + file_path + ", height=" + height
				+ ", iso_639_1=" + iso_639_1 + ", vote_average=" + vote_average + ", vote_count=" + vote_count
				+ ", width=" + width + "]";
	}

}
