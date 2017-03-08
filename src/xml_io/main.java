/**
 * 
 */
package xml_io;
import java.util.ArrayList;

import xml_io.xmlReadAndWrite; 

/**
 * @author thoma
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		
//		ArrayList<String> valeurs = new ArrayList<String>();
//		
//		xmlReadAndWrite xmltest = new xmlReadAndWrite();
//		xmltest.readXML("bob.xml");
//		valeurs=xmltest.getRolev();
//		
//		for(String val : valeurs) {
//		    
//		    System.out.println(val);
//		}
		xmlReadAndWrite xmltest = new xmlReadAndWrite();
    	xmltest.readXML();

	}
}