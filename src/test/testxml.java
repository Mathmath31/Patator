package test;
import dao.bddsql.ComplementDAO;
import xml_io.xmlReadAndWrite;;

public class testxml {

	public static void main(String[] args) {
		
		int bob=ComplementDAO.findbynumPlanSalle("1");
		
		System.out.println(bob);
		

		
		xmlReadAndWrite xmltest = new xmlReadAndWrite();
    	xmltest.readXML();
    	
    	

	}
}
