package ihm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import apiTheMovieDB.CineGoFilm;

public class Panier {

	private String cinema;
	private String salle;
	private LocalDate dateSeance;
	private LocalTime heureSeance;
	private List<Place> place = new ArrayList<Place>();
	private List<Accompagnement> accompagnement = new ArrayList<Accompagnement>();
	private CineGoFilm film;

	public Panier(){
		
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public LocalDate getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(LocalDate dateSeance) {
		this.dateSeance = dateSeance;
	}
	
	public LocalTime getHeureSeance() {
		return heureSeance;
	}

	public void setHeureSeance(LocalTime localTime) {
		this.heureSeance = localTime;
	}

	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}

	public List<Accompagnement> getAccompagnement() {
		return accompagnement;
	}

	public void setAccompagnement(List<Accompagnement> accompagnement) {
		this.accompagnement = accompagnement;
	}
	
	public CineGoFilm getFilm() {
		return film;
	}

	public void setFilm(CineGoFilm film) {
		this.film = film;
	}
	
}
