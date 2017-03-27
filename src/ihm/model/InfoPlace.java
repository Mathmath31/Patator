
	package ihm.model;

	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.property.StringProperty;

	/**
	 * Model class for a Accompagnement.
	 *
	 * @author MVM
	 */
	public class InfoPlace {

		    private final StringProperty placeDate;
		    private final StringProperty placeFilm;
		    private final StringProperty placeSeance;
		    private final StringProperty placeSalle;
		    private final StringProperty placeXSiege;
		    private final StringProperty placeYSiege;
		    private final StringProperty placePrix;
		    
			/**
		     * Default constructor.
		     */
		    public InfoPlace() {
		        this(null, null,null,null,null,null,null);
		    }
		    
		    /**
		     * Constructor with some initial data.
		     * 
		     * @param placeDate
		     * @param placeFilm
		     * @param placeSeance
		     * @param placeSalle
		     * @param accQuantity
		     */
		    public InfoPlace(String placeDate, String placeFilm, String placeSeance, String placeSalle, String placeXSiege, String placeYSiege, String placePrix) {
		        this.placeDate = new SimpleStringProperty(placeDate);
		        this.placeFilm = new SimpleStringProperty(placeFilm);
		        this.placeSeance = new SimpleStringProperty(placeSeance);
		        this.placeSalle = new SimpleStringProperty(placeSalle);
		        this.placeXSiege = new SimpleStringProperty(placeXSiege);
		        this.placeYSiege = new SimpleStringProperty(placeYSiege);
		        this.placePrix = new SimpleStringProperty(placePrix);
		    }
		    
		    public String getplaceDate() {
		        return placeDate.get();
		    }

		    public void setplaceDate(String date) {
		        this.placeDate.set(date);
		    }

		    public StringProperty placeDateProperty() {
		        return placeDate;
		    }
		    
		    public String getplaceFilm() {
		        return placeFilm.get();
		    }

		    public void setplaceFilm(String film) {
		        this.placeFilm.set(film);
		    }

		    public StringProperty placeFilmProperty() {
		        return placeFilm;
		    }
		    
		    public String getplaceSeance() {
		        return placeSeance.get();
		    }

		    public void setplaceSeance(String seance) {
		        this.placeSeance.set(seance);
		    }

		    public StringProperty placeSeanceProperty() {
		        return placeSeance;
		    }
		    
		    public String getplaceSalle() {
		        return placeSalle.get();
		    }

		    public void setplaceSalle(String salle) {
		        this.placeSalle.set(salle);
		    }

		    public StringProperty placeSalleProperty() {
		        return placeSalle;
		    }

		    public String getplaceXSiege() {
		        return placeXSiege.get();
		    }

		    public void setplaceXSiege(String x) {
		        this.placeXSiege.set(x);
		    }

		    public StringProperty placeXSiegeProperty() {
		        return placeXSiege;
		    }
		    
		    public String getplaceYSiege() {
		        return placeYSiege.get();
		    }

		    public void setplaceYSiege(String y) {
		        this.placeYSiege.set(y);
		    }

		    public StringProperty placeYSiegeProperty() {
		        return placeYSiege;
		    }
		    
		    public String getplacePrix() {
		        return placePrix.get();
		    }

		    public void setplacePrix(String prix) {
		        this.placePrix.set(prix);
		    }

		    public StringProperty placePrixProperty() {
		        return placePrix;
		    }
	}

