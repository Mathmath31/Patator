package apiTheMovieDB;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> listeIdFilms = new ArrayList<String>();			//Recuperer la liste de tout les films à l'affiche dans la base de donnee		
		listeIdFilms.add("121856");listeIdFilms.add("274870");listeIdFilms.add("47971");


		CineGoAPI API = new CineGoAPI(listeIdFilms);
		
		System.out.println(API.getTabFilms().toString());
	}
}