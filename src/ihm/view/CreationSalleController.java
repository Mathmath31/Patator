package ihm.view;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	private ReadOnlyDoubleProperty heightProperty;
    private ReadOnlyDoubleProperty widthProperty;
	
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
	private Button porte;
	
	public void initialize(){
		pane.getChildren().clear();
		double tailleLig = pane.getPrefHeight();
		double tailleCol = pane.getPrefWidth();
				
		GridPane gridPane = new GridPane();
		
		gridPane.setGridLinesVisible(true);
		
		//int nombrelig = getRowCount(gridPane);
		
		for (int i = 0; i < nombreCol ; i++) {
			gridPane.getColumnConstraints().add(new ColumnConstraints(tailleCol / nombreCol));
		}
		
		for (int j = 0 ; j < nombreLig; j++) {
        	gridPane.getRowConstraints().add(new RowConstraints(tailleLig / nombreLig));
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
        
	}
	
	@FXML
	private void creeSalles(){
		try{
			nombreCol = Integer.parseInt(nbcol.getText()) - 1;

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number for colonne.");
		}
		
		
		try{
			nombreLig = Integer.parseInt(nblig.getText()) - 1;

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number for rows.");
		}
		
		initialize();
	        	
	}
	
	@FXML
	private void selNormal(){
		normal.setTextFill(Color.RED);
		handi.setTextFill(Color.BLACK);
		porte.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selHandi(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.RED);
		porte.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selPorte(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		porte.setTextFill(Color.RED);
		couloir.setTextFill(Color.BLACK);
	}
	
	@FXML
	private void selCouloir(){
		normal.setTextFill(Color.BLACK);
		handi.setTextFill(Color.BLACK);
		porte.setTextFill(Color.BLACK);
		couloir.setTextFill(Color.RED);
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
		if (porte.getTextFill() == Color.RED)
		{
			rect.setFill(Color.BROWN);
		}
		if (couloir.getTextFill() == Color.RED)
		{
			rect.setFill(Color.BLACK);
		}
		
	}
	        	
	            
//
//	            Label label = new Label();
//	            label.setText("HAAAAAAAAAAAAAAAAAAAAA");
//	            label.setWrapText(true);
//	            
//	            rectangle.setFill(Color.TRANSPARENT);
//
//	            rectangle.setStroke(Color.BLACK);
//	            
//	            //Binding the fraction of the grid size to the width
//	            //and heightProperty of the child
//	            //rectangle.widthProperty().bind(widthProperty.divide(3));
//	            //rectangle.heightProperty().bind(heightProperty.divide(3));
//	            gridPane.add(label, i, j);
//	            gridPane.add(rectangle, i, j);

		

	
//	private int getRowCount(GridPane pane) {
//        int numRows = pane.getRowConstraints().size();
//        for (int i = 0; i < pane.getChildren().size(); i++) {
//            Node child = pane.getChildren().get(i);
//            if (child.isManaged()) {
//                Integer rowIndex = GridPane.getRowIndex(child);
//                if(rowIndex != null){
//                    numRows = Math.max(numRows,rowIndex+1);
//                }
//            }
//        }
//        return numRows;
//    }
	
	
	
		
		
	

}
