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
	    private final StringProperty cinemaVille;
	    private final StringProperty cinemaCP;

	    /**
	     * Default constructor.
	     */
	    public InfoCine() {
	        this(null, null,null,null);
	    }

	    /**
	     * Constructor with some initial data.
	     * 
	     * @param cinemaName
	     * @param cinemaAdresse
	     */
	    public InfoCine(String cinemaName, String cinemaAdresse, String cinemaVille,String cinemaCP) {
	        this.cinemaName = new SimpleStringProperty(cinemaName);
	        this.cinemaAdresse = new SimpleStringProperty(cinemaAdresse);
	        this.cinemaVille = new SimpleStringProperty(cinemaName);
	        this.cinemaCP = new SimpleStringProperty(cinemaCP);
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

}
