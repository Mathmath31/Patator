package ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoAccompagnement {

	/**
	 * Model class for a Cine.
	 *
	 * @author MVM
	 */

	    private final StringProperty accName;
	    private final StringProperty accDescription;
	    private final StringProperty accPrix;
	    private final StringProperty accID;
	    
		/**
	     * Default constructor.
	     */
	    public InfoAccompagnement() {
	        this(null, null,null,null);
	    }
	    
	    /**
	     * Constructor with some initial data.
	     * 
	     * @param cinemaName
	     * @param cinemaAdresse
	     */
	    public InfoAccompagnement(String accName, String accDescription, String accPrix, String accID) {
	        this.accName = new SimpleStringProperty(accName);
	        this.accDescription = new SimpleStringProperty(accDescription);
	        this.accPrix = new SimpleStringProperty(accPrix);
	        this.accID = new SimpleStringProperty(accID);
	    }
	    
	    public String getAccName() {
	        return accName.get();
	    }

	    public void setAccName(String name) {
	        this.accName.set(name);
	    }

	    public StringProperty AccNameProperty() {
	        return accName;
	    }
	    
	    public String getAccDescription() {
	        return accDescription.get();
	    }

	    public void setAccDescription(String name) {
	        this.accDescription.set(name);
	    }

	    public StringProperty accDescriptionProperty() {
	        return accDescription;
	    }
	    
	    public String getAccPrix() {
	        return accPrix.get();
	    }

	    public void setAccPrix(String name) {
	        this.accPrix.set(name);
	    }

	    public StringProperty accPrixProperty() {
	        return accPrix;
	    }
	    
	    public String getAccID() {
	        return accID.get();
	    }

	    public void setAccID(String name) {
	        this.accID.set(name);
	    }

	    public StringProperty accIDProperty() {
	        return accID;
	    }
	    
}
