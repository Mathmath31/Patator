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
		
		
		
		/*for(int i=1;i<=90;i++){ // dates
			for(int j=1;j<=3;j++){// Creneaux
				for(int k=1;k<=3;k++){// Salles
					
					for(int l=1;l<=3;l++){// Films
						seance.setIdFilm(l);
						seance=SeanceDAO.create(seance);
					}
					
				}
			}
		}*/
		/*int s=1;
		for(int i=1;i<=2430;i+=3){ //salle
			for(int j=1;j<=3;j++){ //creneau
				for(int k=1;k<=3;k++){ //film
					for(int l=1;l<=90;l++){//dates
						creerSeance.setIdDate(l);
						creerSeance.setIdCreneau(j);
						creerSeance.setIdPlanSalle(i);
						creerSeance.setIdSeance(s);
						
						creerSeance=CreerSeanceDAO.create(creerSeance);
						s++;
					}
					
				}
			}
		}*/
		
		ArrayList<Seance> seances= new ArrayList<Seance>();
		
		Date now=new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		  
		  
		  
		Dates dates=new Dates();
		dates.setSeanceDate(c.getTime());
		
		
		seances=ComplementDAO.listofSeances(1, "121856", dates.getSeanceDate());
		
		for(Seance se: seances){
			System.out.println(se.getIdFilm());
		}
	}

}
