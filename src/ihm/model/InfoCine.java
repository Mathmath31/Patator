package ihm.model;

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

	    /**
	     * Default constructor.
	     */
	    public InfoCine() {
	        this(null, null);
	    }

	    /**
	     * Constructor with some initial data.
	     * 
	     * @param cinemaName
	     * @param cinemaAdresse
	     */
	    public InfoCine(String cinemaName, String cinemaAdresse) {
	        this.cinemaName = new SimpleStringProperty(cinemaName);
	        this.cinemaAdresse = new SimpleStringProperty(cinemaAdresse);
	    }

	    public String getCinemaName() {
	        return cinemaName.get();
	    }

	    public void setCinemaName(String firstName) {
	        this.cinemaName.set(firstName);
	    }

	    public StringProperty cinemaNameProperty() {
	        return cinemaName;
	    }

	    public String getCinemaAdresse() {
	        return cinemaAdresse.get();
	    }

	    public void setCinemaAdresse(String lastName) {
	        this.cinemaAdresse.set(lastName);
	    }

	    public StringProperty cinemaAdresseProperty() {
	        return cinemaAdresse;
	    }

}
