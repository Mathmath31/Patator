package xml_io;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;

public class xmlReadAndWrite {



	public boolean readXML() {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			/*
			 * Création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Création d'un Document
			 */
			final Document document= builder.parse(new File("ImportCinego.xml"));

			final Element racine = document.getDocumentElement();

			final NodeList cineGoNoeuds = racine.getChildNodes();
			final int nbCineGoNoeuds = cineGoNoeuds.getLength();


			int[] Cine = new int[10];
			DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
			DAO<CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();


			for (int i = 0; i<nbCineGoNoeuds; i++) {		//Récupération des noeuds de CineGo
				if(cineGoNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {

					final Element CineGo = (Element) cineGoNoeuds.item(i);

					final NodeList Cinemas = CineGo.getElementsByTagName("Cinema");
					final int nbCinemalements = Cinemas.getLength();

					for (int z = 0; z<nbCinemalements; z++) { //Récupération des cinémas
						final Element Cinema = (Element) Cinemas.item(z);

						Cine[z]=Integer.parseInt(Cinema.getAttribute("idCinema"));


						final NodeList Salles = Cinema.getElementsByTagName("Salle");
						final int nbSalleElements = Salles.getLength();


						int[] ListSalle = new int[30];

						ListSalle=ComplementDAO.listofPlanSalle(Cine[z]);

						for(int j = 0; j<nbSalleElements; j++) {	//Récupération des salles du cinéma

							final Element Salle = (Element) Salles.item(j);

							PlanSalle salletemp=new PlanSalle();
							ComplementDAO.deleteCaseSalle(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle"),Cine[z]));


							for (int w=0;w<30;w++){
								if(ListSalle[w] == ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle"),Cine[z])) {
									salletemp.setId(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle"),Cine[z]));
									PlanSalleDAO.delete(salletemp); 
								}
							}


							salletemp.setIdCinema(Cine[z]);
							salletemp.setNumPlanSalle(Salle.getAttribute("numSalle"));
							salletemp.setNomPlanSalle(Salle.getAttribute("nomSalle"));
							PlanSalleDAO.create(salletemp);

							/*System.out.println("numSalle: " + Salle.getAttribute(""));
	            		        System.out.println("nomSalle: " + Salle.getAttribute("nomSalle"));*/

							final NodeList Sieges= Salle.getElementsByTagName("Siege");
							final int nbSiegesElements = Sieges.getLength();

							for(int k = 0; k<nbSiegesElements; k++) {		//Récupération des sieges
								final Element Siege = (Element) Sieges.item(k);
								CaseSalle casetemp= new CaseSalle();        	           

								casetemp.setIdPlanSalle(ComplementDAO.findbynumPlanSalle(Salle.getAttribute("numSalle"),Cine[z]));
								casetemp.setIdPositionCase(ComplementDAO.findbypos(Integer.parseInt(Siege.getAttribute("x")),Integer.parseInt(Siege.getAttribute("y"))));
								casetemp.setIdTypeCase(ComplementDAO.findbyname(Siege.getAttribute("nomTypeSiege")));
								CaseSalleDAO.create(casetemp);

								/*System.out.println("nomTypeSiege: " + Siege.getAttribute("nomTypeSiege"));
	            	            	System.out.println("x: " + Siege.getAttribute("x"));
	            	            	System.out.println("y: " + Siege.getAttribute("y"));*/


							}

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


	public void saveToXML(ArrayList<Cinema> listCinema, String fileName) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		/*String cineExport = "";
		String salleExport ="( ";*/
		try {
			/*
			 * Création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Création d'un Document
			 */
			final Document document= builder.newDocument();

			/*
			 * Création de l'Element racine
			 */

			final Element racine = document.createElement("CineGo");
			document.appendChild(racine);			

			/*
			 * Création du ou des Cinemas
			 */
			final Element cinemas = document.createElement("Cinemas");
			for (Cinema c: listCinema){
				final Element cine = document.createElement("Cinema");
				cine.setAttribute("idCinema",String.valueOf(c.getId()));



				for(PlanSalle p:c.getListPlanSalle()){   // Création des salles
					final Element salle = document.createElement("Salle");
					salle.setAttribute("numSalle", String.valueOf(p.getNumPlanSalle()));
					salle.setAttribute("nomSalle", String.valueOf(p.getNomPlanSalle()));

					final Element sieges = document.createElement("Sieges");

					for(CaseSalle cs:p.getListCaseSalle()){ // Création des sièges
						final Element siege = document.createElement("Siege");
						siege.setAttribute("nomTypeSiege", cs.getType().getNomTypeCase());
						siege.setAttribute("x",  String.valueOf(cs.getPosition().getPosX()));
						siege.setAttribute("y",  String.valueOf(cs.getPosition().getPosY()));

						sieges.appendChild(siege);
						salle.appendChild(sieges);
					}
					cine.appendChild(salle);
					/*salleExport += p.getNomPlanSalle() +" " ;*/
				}	
				/*salleExport += ")";
				cineExport += " " + c.getNomCine() + salleExport;*/
				cinemas.appendChild(cine);
			}
			racine.appendChild(cinemas);

			/*
			 * Création du fichier de sortie
			 */
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult(new File(fileName + ".xml"));
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


