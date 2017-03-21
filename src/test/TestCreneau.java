package test;

import classes.Creneau;
import dao.DAO;
import dao.DAOFactory;

public class TestCreneau {
	public static void main(String[] args) {
		
		DAO<Creneau> CreneauDAO = DAOFactory.getCreneauDAO();

		
		Creneau creneau=new Creneau();

		String deb;
		String fin;
		
		deb="10:00";
		fin="12:00";
		
		creneau.setHeureDebutCreneau(deb);
		creneau.setHeureFinCreneau(fin);
		creneau=CreneauDAO.create(creneau);
		
		
		deb="16:00";
		fin="18:00";
		
		creneau.setHeureDebutCreneau(deb);
		creneau.setHeureFinCreneau(fin);
		creneau=CreneauDAO.create(creneau);
		
		
		deb="21:00";
		fin="23:00";
		
		creneau.setHeureDebutCreneau(deb);
		creneau.setHeureFinCreneau(fin);
		creneau=CreneauDAO.create(creneau);
		
		
	}
}
