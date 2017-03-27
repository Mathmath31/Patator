package ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Cine & Salle.
 *
 * @author MVM
 */
public class ExportCine {


	    private final StringProperty idCinema;
	    private final StringProperty nomCinema;
	    private final StringProperty idSalle;
	    private final StringProperty nomSalle;

	    
		/**
	     * Default constructor.
	     */
	    public ExportCine() {
	        this(null, null,null,null);
	    }
	    
	    /**
	     * Constructor with some initial data.
	     * 
	     * @param idCinema
	     * @param nomCinema
	     * @param idSalle
	     * @param nomSalle
	     */
	    public ExportCine(String idCinema, String nomCinema, String idSalle, String nomSalle) {
	        this.idCinema = new SimpleStringProperty(idCinema);
	        this.nomCinema = new SimpleStringProperty(nomCinema);
	        this.idSalle = new SimpleStringProperty(idSalle);
	        this.nomSalle = new SimpleStringProperty(nomSalle);

	    }
	    
	    public String getIdCinema() {
	        return idCinema.get();
	    }

	    public void setIdCinema(String name) {
	        this.idCinema.set(name);
	    }

	    public StringProperty idCinemaProperty() {
	        return idCinema;
	    }
	    
	    public String getNomCinema() {
	        return nomCinema.get();
	    }

	    public void setNomCinema(String name) {
	        this.nomCinema.set(name);
	    }

	    public StringProperty nomCinemaProperty() {
	        return nomCinema;
	    }
	    
	    public String getIdSalle() {
	        return idSalle.get();
	    }

	    public void setIdSalle(String name) {
	        this.idSalle.set(name);
	    }

	    public StringProperty idSalleProperty() {
	        return idSalle;
	    }
	    
	    public String getNomSalle() {
	        return nomSalle.get();
	    }

	    public void setNomSalle(String name) {
	        this.nomSalle.set(name);
	    }

	    public StringProperty nomSalleProperty() {
	        return nomSalle;
	    }

}