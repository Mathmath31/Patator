/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author Thomas
 *
 */
public class Donnees {
	
	private Client clientCommande;
	private Client clientHistorique;
	private Cinema cinemaCommande;
	private Cinema cinemaHistorique;
	
	public Donnees() {};
	
	public Donnees(Client clientCommande, Client clientHistorique, Cinema cinemaCommande, Cinema cinemaHistorique){
		this.clientCommande=clientCommande;
		this.clientHistorique=clientHistorique;
		this.cinemaCommande=cinemaCommande;
		this.cinemaHistorique=cinemaHistorique;
	}
	
	
	

}
