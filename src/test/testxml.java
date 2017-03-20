package test;
import java.util.ArrayList;

import classes.Cinema;
import dao.DAO;
import dao.DAOFactory;
import xml_io.xmlReadAndWrite;;

public class TestXml {

	public static void main(String[] args) {
		/*
		int bob=ComplementDAO.findbynumPlanSalle("1");
		
		System.out.println(bob);
		

		
		*/
    	
		
		xmlReadAndWrite xmltest = new xmlReadAndWrite();
		DAO<Cinema> CinemaDAO = DAOFactory.getCinemaDAO();
		ArrayList<Cinema> cine=new ArrayList<Cinema>();
		
		xmltest.readXML();
		
		cine.add(CinemaDAO.find(1));
		cine.add(CinemaDAO.find(2));
		
		
		
		xmltest.saveToXML(cine);
		System.out.println("\n Avant création d'un objet positionCase :");

	}
}
