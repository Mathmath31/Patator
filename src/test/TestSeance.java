package test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import classes.CreerSeance;
import classes.Dates;
import classes.Seance;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;

public class TestSeance {

	public static void main(String[] args) {
		
		
		Seance seance=new Seance();
		CreerSeance creerSeance= new CreerSeance();
		
		DAO<Seance> SeanceDAO = DAOFactory.getSeanceDAO();
		DAO<CreerSeance> CreerSeanceDAO = DAOFactory.getCreerSeanceDAO();
		
		
		
		/*for(int i=1;i<=2;i++){ // cinema
			for(int j=1;j<=90;j++){// dates
				for(int k=1;k<=3;k++){// creneaux
					for(int l=1;l<=3;l++){// Films
						seance.setIdFilm(l);
						seance=SeanceDAO.create(seance);
					}
					
				}
			}
		}*/
		
		
		
	/*	int s=813;
		while( s<=1620){
			
			for(int j=1;j<=90;j++){ //dates
					for(int l=1;l<=3;l++){//creneau
						creerSeance.setIdDate(j);
						creerSeance.setIdCreneau(l);
						creerSeance.setIdPlanSalle(6);
						creerSeance.setIdSeance(s);
						
						creerSeance=CreerSeanceDAO.create(creerSeance);
						s+=3;
					}				
			}
		}
		*/
		
		ArrayList<Seance> seances= new ArrayList<Seance>();
		
		Date now=new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		  
		  
		  
		Dates dates=new Dates();
		dates.setSeanceDate(c.getTime());
		
		
		seances=ComplementDAO.listofSeances(1, "121856", dates.getSeanceDate());
		
		for(Seance se: seances){
			System.out.println(se.toString());
		}
		
		//nb places restantes normal seance 1
		System.out.println(ComplementDAO.nbNormalPlacesSeance(82));
		//nb places restantes handicape seance 1
		System.out.println(ComplementDAO.nbHandicapePlacesSeance(82));
	}

}
