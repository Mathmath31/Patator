package ihm.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CreationSalleController {
	
	private int nombreCol = 8;
	private int nombreLig = 12;
	
	@FXML
	private Pane pane;
	
	@FXML
	private TextField nbcol;
	
	@FXML
	private TextField nblig;
	
	@FXML
	private Button normal;
	
	@FXML
	private Button handi;
	
	@FXML
	private Button couloir;
	
	@FXML 
	private Button entree;
	
	@FXML
	private Button extincteur;
	
	@FXML
	private Button sortie;
	
	@FXML
	private Button ecran;
	
	@FXML
	private TextField nomSalle;
	
	@FXML
	private ListView listCine;
	
	@FXML
	private ListView listSalle;
	
	public void initialize(){
		
		
		
		
		pane.getChildren().clear();
		double tailleLig = pane.getPrefHeight();
		System.out.println(tailleLig);
		double tailleCol = pane.getPrefWidth();
		System.out.println(tailleCol);
		GridPane gridPane = new GridPane();
		
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
        System.out.println(gridPane.getHeight());
		System.out.println(gridPane.getWidth());
        
	}
	
	@FXML
	private void creeSalles(){
		try{
			nombreCol = Integer.parseInt(nbcol.getText());

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number for colonne.");
		}
		
		
		try{
			nombreLig = Integer.parseInt(nblig.getText());

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number for rows.");
		}
		
		initialize();
	        	
	}
	
	@FXML
	private void selNormal(){
		normal.setTextFill(Color.RED);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selHandi(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.RED);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selEntree(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.RED);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selCouloir(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.RED);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selSortie(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.RED);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selExtincteur(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.RED);
		ecran.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selEcran(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		entree.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
		sortie.setTextFill(Color.BLACK);
		extincteur.setTextFill(Color.BLACK);
		ecran.setTextFill(Color.RED);
	}
	
	public void click(int i, int j, Rectangle rect){
		System.out.println(i + "/" + j);
		if (normal.getTextFill() == Color.RED)
		{
			rect.setFill(Color.GREEN);
		}
		if (handi.getTextFill() == Color.RED)
		{
			rect.setFill(Color.BLUE);
		}
		if (entree.getTextFill() == Color.RED)
		{
			rect.setFill(Color.BROWN);
		}
		if (couloir.getTextFill() == Color.RED)
		{
			rect.setFill(Color.BLACK);
		}
		if (sortie.getTextFill() == Color.RED)
		{
			rect.setFill(Color.GREY);
		}
		if (extincteur.getTextFill() == Color.RED)
		{
			rect.setFill(Color.RED);
		}
		if (ecran.getTextFill() == Color.RED)
		{
			rect.setFill(Color.WHITE);
		}	
	}
	
	
	//TODO ajouter la salle a la BDD (XML)
	public void ajouterSalle(){
		
		
	}
	
	//TODO charger la salle du cinéma et salle présent
	public void modifierSalle(){
		
		
		
	}
	
	// TODO si cinema selctionner charger ses salles
	public void selCinema(){
		
		
		
	}
}
