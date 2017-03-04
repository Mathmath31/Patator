package ihm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Panier {

	protected String cinema;
	protected String salle;
	protected Date dateHeureSeance;
	protected List<Place> place = new ArrayList<Place>();
	protected List<Accompagnement> accompagnement = new ArrayList<Accompagnement>();
	
	public Panier(){
		
	}
	
}
