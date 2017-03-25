package test;

import java.util.ArrayList;
import classes.Film;
import dao.bddsql.ComplementDAO;

public class TestFilm {
	public static void main(String[] args) {
		
	
		ArrayList<Film> films= new ArrayList<Film>();
		
		// Liste des films du cinema avec l'id 1
		films=ComplementDAO.listofFilms(1);
		
		for(Film f: films){
			System.out.println(f.toString());
		}
		
	}
}
