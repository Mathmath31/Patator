																	/**
 * 
 */
package classes;

/**
 * @author thomas
 *
 */
public class CaseSalle {
	
	private int id;
	private String nomSiegeCase;
	private int idPlanSalle;
	private int idPositionCase;
	private int idTypeCase;
	
	private PositionCase position;
	private TypeCase type;

	public CaseSalle() {};
	
	public CaseSalle(int id, String nomSiegeCase,int idPlanSalle, int idPositionCase, int idTypeCase, PositionCase position, TypeCase type) {
		this.id=id;
		this.nomSiegeCase=nomSiegeCase;
		this.idPlanSalle=idPlanSalle;
		this.idPositionCase=idPositionCase;
		this.idTypeCase=idTypeCase;
		this.setPosition(position);
		this.setType(type);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomSiegeCase() {
		return nomSiegeCase;
	}

	public void setNomSiegeCase(String nomSiegeCase) {
		this.nomSiegeCase = nomSiegeCase;
	}

	public int getIdPlanSalle() {
		return idPlanSalle;
	}

	public void setIdPlanSalle(int idPlanSalle) {
		this.idPlanSalle = idPlanSalle;
	}

	public int getIdPositionCase() {
		return idPositionCase;
	}

	public void setIdPositionCase(int idPositionCase) {
		this.idPositionCase = idPositionCase;
	}

	public int getIdTypeCase() {
		return idTypeCase;
	}

	public void setIdTypeCase(int idTypeCase) {
		this.idTypeCase = idTypeCase;
	}


	public PositionCase getPosition() {
		return position;
	}

	public void setPosition(PositionCase position) {
		this.position = position;
	}

	public TypeCase getType() {
		return type;
	}

	public void setType(TypeCase type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CaseSalle [id=" + id + ", nomSiegeCase=" + nomSiegeCase + ", idPlanSalle=" + idPlanSalle
				+ ", idPositionCase=" + idPositionCase + ", idTypeCase=" + idTypeCase + ", position=" + position
				+ ", type=" + type + "]";
	}
	
	
	
}
