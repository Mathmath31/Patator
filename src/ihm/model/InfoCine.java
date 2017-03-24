package ihm.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class InfoCine {

	/**
	 * Model class for a Person.
	 *
	 * @author MVM
	 */

	    private final StringProperty cinemaName;
	    private final StringProperty cinemaAdresse;
	    private final StringProperty cinemaVille;
	    private final StringProperty cinemaCP;
	    private final StringProperty cinemaID;

		/**
	     * Default constructor.
	     */
	    public InfoCine() {
	        this(null, null,null,null,null);
	    }

	    /**
	     * Constructor with some initial data.
	     * 
	     * @param cinemaName
	     * @param cinemaAdresse
	     */
	    public InfoCine(String cinemaName, String cinemaAdresse,String cinemaCP, String cinemaVille, String cinemaID) {
	        this.cinemaName = new SimpleStringProperty(cinemaName);
	        this.cinemaAdresse = new SimpleStringProperty(cinemaAdresse);
	        this.cinemaCP = new SimpleStringProperty(cinemaCP);
	        this.cinemaVille = new SimpleStringProperty(cinemaVille);
	        this.cinemaID = new SimpleStringProperty(cinemaID);
	    }

	    public String getCinemaName() {
	        return cinemaName.get();
	    }

	    public void setCinemaName(String name) {
	        this.cinemaName.set(name);
	    }

	    public StringProperty cinemaNameProperty() {
	        return cinemaName;
	    }

	    public String getCinemaAdresse() {
	        return cinemaAdresse.get();
	    }

	    public void setCinemaAdresse(String adresse) {
	        this.cinemaAdresse.set(adresse);
	    }

	    public StringProperty cinemaAdresseProperty() {
	        return cinemaAdresse;
	    }
	    
	    public String getCinemaVille() {
	        return cinemaVille.get();
	    }

	    public void setCinemaVille(String ville) {
	        this.cinemaVille.set(ville);
	    }

	    public StringProperty cinemaVilleProperty() {
	        return cinemaVille;
	    }
	    
	    public String getCinemaCP() {
	        return cinemaCP.get();
	    }

	    public void setCinemaCP(String cp) {
	        this.cinemaCP.set(cp);
	    }

	    public StringProperty cinemaCPProperty() {
	        return cinemaCP;
	    }

	    public String getCinemaID() {
			return cinemaID.get();
		}
	    public void setCinemaID(String id) {
	        this.cinemaID.set(id);
	    }
	    
	    public StringProperty cinemaIDProperty() {
	        return cinemaID;
	    }
}
