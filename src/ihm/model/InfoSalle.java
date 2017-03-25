package ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoSalle {
	
	/**
	 * Model class for a Salle.
	 *
	 * @author MVM
	 */
    	private final StringProperty salleID;
	    private final StringProperty salleName;
	    private final StringProperty salleNum;
		/**
	     * Default constructor.
	     */
	    public InfoSalle() {
	        this(null, null,null);
	    }

	    /**
	     * Constructor with some initial data.
	     * 
	     * @param salleName
	     * @param salleID
	     */
	    public InfoSalle(String salleID,String salleName, String salleNum) {
	        this.salleName = new SimpleStringProperty(salleName);
	        this.salleID = new SimpleStringProperty(salleID);
	        this.salleNum = new SimpleStringProperty(salleID);
	    }
	    
	    public String getSalleName() {
	        return salleName.get();
	    }

	    public void setSalleName(String name) {
	        this.salleName.set(name);
	    }

	    public StringProperty salleNameProperty() {
	        return salleName;
	    }
	    
	    public String getSalleID() {
	        return salleID.get();
	    }

	    public void setSalleID(String id) {
	        this.salleID.set(id);
	    }

	    public StringProperty salleIDProperty() {
	        return salleID;
	    }
	    
	    public String getSalleNum() {
	        return salleNum.get();
	    }

	    public void setSalleNum(String num) {
	        this.salleNum.set(num);
	    }

	    public StringProperty salleNumProperty() {
	        return salleNum;
	    }
}
