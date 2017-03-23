package ihm.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChoixPositionController {

	private int nombreCol = 20;
	private int nombreLig = 20;
	private int nombreDePlacePrise = 0;
	private int nombreDePlacePriseHandi = 0;
	//TODO Renseigner le nombre de place normal
	private int nombreDePlace = 2;
	//TODO Renseigner le nombre de place normal
	private int nombreDePlaceHandi = 2;
		
	@FXML
	private Pane pane;
	
	@FXML
	private void clicPlace(){
		
	}
	
	public void initialize(){
		pane.getChildren().clear();
		double tailleLig = pane.getPrefHeight();
		double tailleCol = pane.getPrefWidth();
				
		GridPane gridPane = new GridPane();
		
		gridPane.setGridLinesVisible(true);		
		
		// TODO Récupérer le nombre de ligne et colonne et les assigner a nombreCol et nombreLig
		for (int i = 0; i < nombreCol ; i++) {
			gridPane.getColumnConstraints().add(new ColumnConstraints(tailleCol / nombreCol));
		}
		
		for (int j = 0 ; j < nombreLig; j++) {
        	gridPane.getRowConstraints().add(new RowConstraints(tailleLig / nombreLig));
        }
        pane.getChildren().add(0,gridPane);
        
        
        // TODO lire la salle appeler 
        for (int i = 0; i < nombreCol ; i++) {
			for (int j = 0 ; j < nombreLig; j++) {
				//ajout des rectangles
				Rectangle rectangle = new Rectangle(tailleCol / (nombreCol) - 1, tailleLig / (nombreLig) - 1);
				
				// TODO remplacer le if par un select en fonction de la place
				if(j == 1)
				{
					rectangle.setFill(Color.BLUE);
				}
				else
				{
					rectangle.setFill(Color.GREEN);	
				}
				
				
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
				if (nombreDePlacePrise < nombreDePlace)
				{
					rect.setFill(Color.LIGHTBLUE);
					rect.setStroke(Color.RED);
					nombreDePlacePriseHandi ++;
				}
			}
		}
		System.out.println(nombreDePlacePrise);

	}
}
