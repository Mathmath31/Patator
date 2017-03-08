/**
 * 
 */
package classes;

/**
 * @author thomas
 *
 */
public class TypeCase {
	
	private int id;
	private String nomTypeCase;
	private String imgTypeCase;

	public TypeCase() {};
	
	public TypeCase(int id, String nomTypeCase, String imgTypeCase){
		this.id=id;
		this.nomTypeCase=nomTypeCase;
		this.imgTypeCase=imgTypeCase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomTypeCase() {
		return nomTypeCase;
	}

	public void setNomTypeCase(String nomTypeCase) {
		this.nomTypeCase = nomTypeCase;
	}

	public String getImgTypeCase() {
		return imgTypeCase;
	}

	public void setImgTypeCase(String imgTypeCase) {
		this.imgTypeCase = imgTypeCase;
	}

	@Override
	public String toString() {
		return "TypeCase [id=" + id + ", nomTypeCase=" + nomTypeCase + ", imgTypeCase=" + imgTypeCase + "]";
	}
	
	
}
