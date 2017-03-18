package ihm;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import apiTheMovieDB.CineGoFilm;

public class Panier {

	private String cinema;
	private String salle;
	private LocalDate dateSeance;
	private Time heureSeance;
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
	
	public Time getHeureSeance() {
		return heureSeance;
	}

	public void setHeureSeance(Time heureSeance) {
		this.heureSeance = heureSeance;
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
