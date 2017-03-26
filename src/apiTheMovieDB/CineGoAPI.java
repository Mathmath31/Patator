/**
 * CineGoAPI Class.
 * This class creates an instance of CineGoFilm.
 * It opens a connection with the TMDB API.
 * It generates a query and sends it to the API.
 * It deserializes the JSON object returned by the TMDB API and maps these informations with the cineGoFilms class
 * @author PAULY.M
 * @see https://github.com/google/gson 
 * @see https://www.jmdoudoux.fr/java/dej/chap-gson.htm
 */
package apiTheMovieDB;

import java.awt.image.BufferedImage;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.*;
import javax.imageio.*;

public class CineGoAPI {

	private String APIKey = "api_key=975c60bf70cb45fdc950f4d55f22cf3a";		// Key of l'API
	private String URLImgVideo = "&append_to_response=videos,images";		// Options of l'API
	private List<CineGoFilm> tabFilms = new ArrayList<CineGoFilm>();		// Array of CineGoFilm

	/**
	 * Constructor of CineGoAPI
	 * @param listeIdFilms => IDs form database. 
	 * @exception If connection with the API are KO.
	 */
	public CineGoAPI(List<String> listeIdFilms){
		/** Get info for films from API
		 */
		for( int i = 0 ; i < listeIdFilms.size() ; i++)
		{
			try {
				//URL TEST : https://api.themoviedb.org/3/movie/47971?api_key=975c60bf70cb45fdc950f4d55f22cf3a&append_to_response=videos,images
				URL TMDB = new URL("https://api.themoviedb.org/3/movie/"+listeIdFilms.get(i)+"?"+APIKey+URLImgVideo);
				JsonReader reader = new JsonReader(new InputStreamReader(TMDB.openStream(), "UTF-8"));			
				Gson gson = new GsonBuilder().setLenient().serializeNulls().create();
				this.tabFilms.add(gson.fromJson(reader, CineGoFilm.class));
			}
			catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Verifier si connection OK");
			}
		}

		//Get .jpg for films from API
		for( int i = 0 ; i < listeIdFilms.size() ; i++){

			try{
				URL URLIMG = new URL ("https://image.tmdb.org/t/p/w500"+this.tabFilms.get(i).getPoster_path());
				BufferedImage image = ImageIO.read(URLIMG);
				this.tabFilms.get(i).setDataIMG (image);
				//ImageIO.write(this.tabFilms.get(i).getDataIMG(), "jpg", new File("./"+this.tabFilms.get(i).getPoster_path()));
			}
			catch (Exception exImg) {
				exImg.printStackTrace();
				System.out.println("Verifier si connection OK");
			}
		}

	}

	/** Get infos of movies
	 * @return tabFilms
	 */
	public List<CineGoFilm> getTabFilms() {
		return tabFilms;
	}

}


