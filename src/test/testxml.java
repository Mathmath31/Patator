package test;
import java.util.ArrayList;

import classes.Cinema;
import classes.PositionCase;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
import xml_io.xmlReadAndWrite;;

public class testxml {

	public static void main(String[] args) {
		/*
		int bob=ComplementDAO.findbynumPlanSalle("1");
		
		System.out.println(bob);
		

		
		
    	xmltest.readXML();*/
		
		xmlReadAndWrite xmltest = new xmlReadAndWrite();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		ArrayList<Cinema> cine=new ArrayList<Cinema>();
		
		
		cine.add(CinemaDAO.find(1));
		
		cine.get(0).toString();
		
		xmltest.saveToXML(cine);
		System.out.println("\n Avant création d'un objet positionCase :");

	}
}
