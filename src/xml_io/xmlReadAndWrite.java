package xml_io;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Comment;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import classes.CaseSalle;
import classes.Cinema;
import classes.PlanSalle;
import classes.PositionCase;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;

public class xmlReadAndWrite {
	
	

	public boolean readXML() {
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
        try {
            /*
             * Etape 2 : création d'un parseur
             */
            final DocumentBuilder builder = factory.newDocumentBuilder();
			
		    /*
		     * Etape 3 : création d'un Document
		     */
		    final Document document= builder.parse(new File("PlansSalle.xml"));
		    
		    
		    final Element racine = document.getDocumentElement();
		    
		    System.out.println("\n*************RACINE************");
		    System.out.println(racine.getNodeName());
		    
	            
            final NodeList cinemaNoeuds = racine.getChildNodes();
            final int nbCinemaNoeuds = cinemaNoeuds.getLength();
            
            int[] Cine = new int[10];
            ArrayList<Cinema> ListCine=new ArrayList<Cinema>();
            DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		    DAO<CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();
            
            
            for (int i = 0; i<nbCinemaNoeuds; i++) {
    	        if(cinemaNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
    	            final Element Cinema = (Element) cinemaNoeuds.item(i);
    	            
    	            Cine[i]=Integer.parseInt(Cinema.getAttribute("idCinema"));
    	           // System.out.println("idCinema: " + Cinema.getAttribute("idCinema"));
    	            System.out.println(Cine[i]);

    	            final NodeList Salles = Cinema.getElementsByTagName("Salle");
        		    final int nbSalleElements = Salles.getLength();
        		    
        		    
        		    int[] ListSalle = new int[30];
                    
                    ListSalle=ComplementDAO.listofPlanSalle(Cine[i]);
                    
    	            for(int j = 0; j<nbSalleElements; j++) {
    	            	
        		        final Element Salle = (Element) Salles.item(j);
        		        
        		        PlanSalle salletemp=new PlanSalle();
        		        ComplementDAO.deleteCaseSalle(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle")));
 
        		        
        		        for (int w=0;w<30;w++){
	    		        	 if(ListSalle[w] == ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle"))) {
	         		        	salletemp.setId(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle")));
	         		        	PlanSalleDAO.delete(salletemp); 
	          		        }
        		        }
        		       
        		    
    		        	salletemp.setIdCinema(Cine[i]);
    		        	salletemp.setNumPlanSalle(Salle.getAttribute("numSalle"));
    		        	salletemp.setNomPlanSalle(Salle.getAttribute("nomSalle"));
    		        	PlanSalleDAO.create(salletemp);
        		       
        		       // System.out.println("numSalle: " + Salle.getAttribute(""));
        		       //  System.out.println("nomSalle: " + Salle.getAttribute("nomSalle"));
        
        		       
        		        final NodeList Sieges= Salle.getElementsByTagName("Siege");
        		        final int nbSiegesElements = Sieges.getLength();
        		        
        	            for(int k = 0; k<nbSiegesElements; k++) {
        	            	final Element Siege = (Element) Sieges.item(k);
        	            	CaseSalle casetemp= new CaseSalle();        	           
        	            		
    	            		casetemp.setIdPlanSalle(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle")));
    	            		casetemp.setIdPositionCase(ComplementDAO.findbypos(Integer.parseInt(Siege.getAttribute("x")),Integer.parseInt(Siege.getAttribute("y"))));
    	            		casetemp.setIdTypeCase(ComplementDAO.findbyname(Siege.getAttribute("nomTypeSiege")));
    	            		CaseSalleDAO.create(casetemp);
        	            		
             		           	   
        	            	System.out.println("nomTypeSiege: " + Siege.getAttribute("nomTypeSiege"));
        	            	System.out.println("x: " + Siege.getAttribute("x"));
        	            	System.out.println("y: " + Siege.getAttribute("y"));
        	            	
        	            }
     
        		    }
    	            
    	            
            return true;
    	    }
            
            } 
        }catch (ParserConfigurationException pce) {
        	System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    
    }
	
	
	public void saveToXML(String xml) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
		    /*
		     * Etape 2 : création d'un parseur
		     */
		    final DocumentBuilder builder = factory.newDocumentBuilder();
		    		
		    /*
		     * Etape 3 : création d'un Document
		     */
		    final Document document= builder.newDocument();
						
		    /*
		     * Etape 4 : création de l'Element racine
		     */
		    final Element racine = document.createElement("repertoire");
		    document.appendChild(racine);			
				
		    /*
		     * Etape 5 : création d'une personne
		     */
				
		    final Element personne = document.createElement("personne");
		    personne.setAttribute("sexe", "masculin");
		    racine.appendChild(personne);
				
		    /*
		     * Etape 6 : création du nom et du prénom
		     */
		    final Element nom = document.createElement("nom");
		    nom.appendChild(document.createTextNode("DOE"));
				
		    final Element prenom = document.createElement("prenom");
		    prenom.appendChild(document.createTextNode("John"));
				
		    personne.appendChild(nom);
		    personne.appendChild(prenom);			
								
		    /*
		     * Etape 7 : récupération des numéros de téléphone
		     */
		    final Element telephones = document.createElement("telephones");
		    
		    final Element fixe = document.createElement("telephone");
		    fixe.appendChild(document.createTextNode("01 02 03 04 05"));
		    fixe.setAttribute("type", "fixe");
				
		    final Element portable = document.createElement("telephone");
		    portable.appendChild(document.createTextNode("06 07 08 09 10"));
		    portable.setAttribute("type", "portable");
				
		    telephones.appendChild(fixe);
		    telephones.appendChild(portable);
		    personne.appendChild(telephones);
				
		    /*
		     * Etape 8 : affichage
		     */
		    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    final Transformer transformer = transformerFactory.newTransformer();
		    final DOMSource source = new DOMSource(document);
		    final StreamResult sortie = new StreamResult(new File("F:\\file.xml"));
		    //final StreamResult result = new StreamResult(System.out);
				
		    //prologue
		    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
		    		
		    //formatage
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		    //sortie
		    transformer.transform(source, sortie);	
		}
		catch (final ParserConfigurationException e) {
		    e.printStackTrace();
		}
		catch (TransformerConfigurationException e) {
		    e.printStackTrace();
		}
		catch (TransformerException e) {
		    e.printStackTrace();
		}			
	    }
	


	}
    

	