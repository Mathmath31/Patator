package ihm.view;

import classes.CaseSalle;
import classes.PlanSalle;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
import ihm.VistaNavigator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChoixPositionController {

	private int nombreCol = 20;
	private int nombreLig = 20;
	private int nombreDePlacePrise = 0;
	private int nombreDePlacePriseHandi = 0;
	private int nombreDePlaceTotal = 0;
	private int nombreDePlace = 0;
	private int nombreDePlaceHandi = 0;
		
	@FXML
	private Label nomSalle;
	@FXML
	private Pane pane;
	
	private PlanSalle planSalleEnCours=new PlanSalle();
	private GridPane gridPane;
	
	@FXML
	private void clicPlace(){
		
	}
	
	public void initialize(){
		//TODO mettre une phrase pour dire la salle
		nomSalle.setText("");
		
		int idPlanSalle = MainController.donnees.getClientCommande().getListPlace().get(0).getComposerPlace().getSeanceT().getCreerSeanceT().getIdPlanSalle();
		
		nombreDePlaceTotal = MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().size();
		for (int i = 0; i < nombreDePlaceTotal; i++)
		{
			if (MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getType().getId() == 6)
			{
				nombreDePlace ++ ;
			}
			else if (MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getType().getId() == 8)
			{
				nombreDePlaceHandi ++ ;
			}	
			System.out.println(MainController.donnees.getCinemaCommande().getListPlanSalle().get(0).getListCaseSalle().get(i).getType().getId());
		}
		
		DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		planSalleEnCours=PlanSalleDAO.find(idPlanSalle);
		int[] maxXY= new int[2];
		//nomSalle.setText("");
		
		maxXY=ComplementDAO.maxXYPlanSalle(planSalleEnCours.getId());
		
		nombreCol=maxXY[0];
		nombreLig=maxXY[1];
		
		pane.getChildren().clear();
		double tailleLig = pane.getPrefHeight();
		System.out.println(tailleLig);
		double tailleCol = pane.getPrefWidth();
		System.out.println(tailleCol);
		gridPane = new GridPane();
		
		gridPane.setGridLinesVisible(true);
		gridPane.setPrefWidth(pane.getPrefWidth());
		
		//int nombrelig = getRowCount(gridPane);
		
		for (int i = 0; i < nombreCol ; i++) {
			gridPane.getColumnConstraints().add(new ColumnConstraints((tailleCol / nombreCol)-1));
		}
		
		for (int j = 0 ; j < nombreLig; j++) {
        	gridPane.getRowConstraints().add(new RowConstraints((tailleLig / nombreLig)-1));
        }
        pane.getChildren().add(0,gridPane);
        
        for (int i = 0; i < nombreCol ; i++) {
			for (int j = 0 ; j < nombreLig; j++) {
				//ajout des rectangles
				Rectangle rectangle = new Rectangle(tailleCol / (nombreCol) - 1, tailleLig / (nombreLig) - 1);
				
				
	            rectangle.setFill(Color.GREEN);
	            rectangle.setStroke(Color.WHITE);
	         // evenement au click sur un rectangle
	            rectangle.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
	            	@Override
	            	public void handle(MouseEvent e) {
	            	click((GridPane.getRowIndex( rectangle)+1),(GridPane.getColumnIndex( rectangle)+1), rectangle );
	            	
	            	}
	            });
	            gridPane.add(rectangle, i, j);
	        }
		}
        
        for(CaseSalle cs: planSalleEnCours.getListCaseSalle()){
        	Rectangle rect= new Rectangle();
        	rect = (Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
        	switch(cs.getType().getId()){
        		case 1 : 
        			rect.setFill(Color.BROWN);
        			break;        	
        		case 2 : 
				 		 rect.setFill(Color.GREY);
    				break;
        		case 3 : 
				 	 	 rect.setFill(Color.BLACK);
    				break;
        		case 4 : 
				 		 rect.setFill(Color.RED);
    				break;
        		case 5 : 
				 		 rect.setFill(Color.WHITE);
    				break;
        		case 6 : 
				 		 rect.setFill(Color.GREEN);
    				break;
        		case 8 : 
				 		 rect.setFill(Color.BLUE);
    				break;
        	}
        }
        //TODO liste des places déja prise prises
	}
	/**
	 * Mise en forme au click
	 * @author Math
	 * @param i
	 * @param j
	 * @param rect
	 * @return
	 * @exception
	 * @see
	 */
	public void click(int i, int j, Rectangle rect){
		System.out.println(i + "/" + j);
		//si il reste des places normales
		if (rect.getFill() == Color.LIGHTGREEN || rect.getFill() == Color.GREEN)
		{
			if (rect.getFill() == Color.LIGHTGREEN)
			{
				rect.setFill(Color.GREEN);
				rect.setStroke(Color.WHITE);
				nombreDePlacePrise --;
			}
			else
			{
				if (nombreDePlacePrise < nombreDePlace)
				{
					rect.setFill(Color.LIGHTGREEN);
					rect.setStroke(Color.RED);
					nombreDePlacePrise ++;
				}
			}
		}
		//si il reste des places handicapés libre
		if (rect.getFill() == Color.LIGHTBLUE|| rect.getFill() == Color.BLUE)
		{
			if (rect.getFill() == Color.LIGHTBLUE)
			{
				rect.setFill(Color.BLUE);
				rect.setStroke(Color.WHITE);
				nombreDePlacePriseHandi --;
			}
			else
			{
				if (nombreDePlacePriseHandi < nombreDePlaceHandi)
				{
					rect.setFill(Color.LIGHTBLUE);
					rect.setStroke(Color.RED);
					nombreDePlacePriseHandi ++;
				}
			}
		}
		System.out.println(nombreDePlacePrise);
		System.out.println(nombreDePlacePriseHandi);
	}
	
	@FXML
	private void valider()
	{
		VistaNavigator.loadVista(VistaNavigator.ACCOMPAGNEMENT);
	}
	
	@FXML
	private void placementAuto()
	{
		VistaNavigator.loadVista(VistaNavigator.ACCOMPAGNEMENT);
	}
}
