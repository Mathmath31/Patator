/**
 * 
 */
package classes;

import java.util.Date;

/**
 * @author Thomas
 *
 */
public class Dates {
	
	private int id;
	private Date seanceDate;

	public Dates() {};
	
	public Dates(int id, Date seanceDate){
		this.id=id;
		this.seanceDate=seanceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSeanceDate() {
		return seanceDate;
	}

	public void setSeanceDate(Date seanceDate) {
		this.seanceDate = seanceDate;
	}

	@Override
	public String toString() {
		return "Date [id=" + id + ", seanceDate=" + seanceDate + "]";
	}
}
