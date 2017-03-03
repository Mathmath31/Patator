package apiTheMovieDB;

public class Results {

	private String id;
	private String iso_639_1;
	private String iso_3166_1;
	private String key;
	private String name;
	private String site;
	private String size;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIso_639_1() {
		return iso_639_1;
	}
	public void setIso_639_1(String iso_639_1) {
		this.iso_639_1 = iso_639_1;
	}
	public String getIso_3166_1() {
		return iso_3166_1;
	}
	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Results [id=" + id + ", iso_639_1=" + iso_639_1 + ", iso_3166_1=" + iso_3166_1 + ", key=" + key
				+ ", name=" + name + ", site=" + site + ", size=" + size + ", type=" + type + "]";
	}
}
