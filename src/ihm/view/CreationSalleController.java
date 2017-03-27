package ihm.view;

import classes.CaseSalle;
import classes.Cinema;
import classes.Client;
import classes.PlanSalle;
import dao.DAO;
import dao.DAOFactory;
import dao.bddsql.ComplementDAO;
import ihm.model.InfoCine;
import ihm.model.InfoSalle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * ChoixSalleController controller class for the entire layout.
 * 
 * @author MVM
 */
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
	private TableView<InfoCine> listCine;
	@FXML
	private TableView<InfoSalle> listSalle;
	@FXML
	private TableColumn<InfoCine, String> cinemaId;
	@FXML
	private TableColumn<InfoCine, String> cinemaName;
	@FXML
	private TableColumn<InfoSalle, String> salleId;
	@FXML
	private TableColumn<InfoSalle, String> salleName;
	
	private PlanSalle planSalleEnCours=new PlanSalle();
	
	private GridPane gridPane;
	
	private ObservableList<InfoCine> cineData = FXCollections.observableArrayList();
	
	/**
	 * function called when the fxml view is called
	 * Load the cinema
	 * Load the salle
	 * Loading an empty room (default 8x12)
	 * @author MVM
	 */
	public void initialize(){
		
		for(Cinema c:MainController.donnees.getCinemas()){
			cineData.add(new InfoCine(c.getNomCine(),c.getnVoieCine(),c.getVilleCine().getCpVille(),c.getVilleCine().getNomVille(),String.valueOf(c.getVilleCine().getId())));	
		}
		
		cinemaId.setCellValueFactory(cellData -> cellData.getValue().cinemaIDProperty());
		cinemaName.setCellValueFactory(cellData -> cellData.getValue().cinemaNameProperty());

		listCine.getItems().setAll(cineData);
		listCine.getSelectionModel().selectFirst();
		
		selCinema();
		
		remplirTableau();
        
	}
	
	/**
	 * function called when the fxml view is called
	 * Load the cinema
	 * Load the salle
	 * Loading an empty room (default 8x12)
	 * @author MVM
	 */
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
		
		remplirTableau();
	        	
	}
	
	private void remplirTableau(){
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
        System.out.println(gridPane.getHeight());
		System.out.println(gridPane.getWidth());
	}
	
	
	@FXML
	private void selectionSalles(){
		DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		planSalleEnCours=PlanSalleDAO.find(Integer.parseInt(listSalle.getSelectionModel().getSelectedItem().getSalleID()));
		int[] maxXY= new int[2];
		
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
        	Rectangle rect=new Rectangle();
            //rect = (Rectangle) (gridPane.getChildren().get(3*nombreLig + 2));
            //rect.setFill(Color.BISQUE);
        	switch(cs.getType().getId()){
        		case 1 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
        				 rect.setFill(Color.BROWN);
        			break;        	
        		case 2 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 		 rect.setFill(Color.GREY);
    				break;
        		case 3 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 	 	 rect.setFill(Color.BLACK);
    				break;
        		case 4 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 		 rect.setFill(Color.RED);
    				break;
        		case 5 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 		 rect.setFill(Color.WHITE);
    				break;
        		case 6 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 		 rect.setFill(Color.GREEN);
    				break;
        		case 8 : rect=(Rectangle)(gridPane.getChildren().get(cs.getPosition().getPosX()*nombreLig+cs.getPosition().getPosY()+1));
				 		 rect.setFill(Color.BLUE);
    				break;
        	}
        }
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
		planSalleEnCours= new PlanSalle();
		
		DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		DAO<CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();
		planSalleEnCours.setIdCinema(Integer.parseInt(listCine.getSelectionModel().getSelectedItem().getCinemaID()));
		planSalleEnCours.setNomPlanSalle(nomSalle.getText());
		planSalleEnCours=PlanSalleDAO.create(planSalleEnCours);
		
		
		for (int i = 0; i < nombreCol ; i++) {
			for (int j = 0 ; j < nombreLig; j++) {
				Rectangle rect=new Rectangle();
				rect=(Rectangle)(gridPane.getChildren().get(i*nombreLig+j+1));
				CaseSalle caseadd= new CaseSalle();
				
				if (rect.getFill()==Color.BROWN){
					//entree 1
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(1);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.GREY){
					//sortie 2
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(2);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.BLACK){
					//couloir 3
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(3);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.RED){
					//extincteur 4
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(4);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.WHITE){
					//ecran 5
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(5);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.GREEN){
					//normal 6
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(6);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.BLUE){
					//handicape 8
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(8);
					caseadd=CaseSalleDAO.create(caseadd);
				}			
	        }
		}
	}
	
	//TODO charger la salle du cinéma et salle présent
	public void modifierSalle(){
		planSalleEnCours= new PlanSalle();
		
		DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		DAO<CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();
		planSalleEnCours.setId(Integer.parseInt(listSalle.getSelectionModel().getSelectedItem().getSalleID()));
		planSalleEnCours.setIdCinema(Integer.parseInt(listCine.getSelectionModel().getSelectedItem().getCinemaID()));
		planSalleEnCours.setNomPlanSalle(nomSalle.getText());
		planSalleEnCours=PlanSalleDAO.update(planSalleEnCours);
		
		ComplementDAO.deleteCaseSalle(planSalleEnCours.getId());
		
		for (int i = 0; i < nombreCol ; i++) {
			for (int j = 0 ; j < nombreLig; j++) {
				Rectangle rect=new Rectangle();
				rect=(Rectangle)(gridPane.getChildren().get(i*nombreLig+j+1));
				
				CaseSalle caseadd= new CaseSalle();
				
				if (rect.getFill()==Color.BROWN){
					//entree 1
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(1);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.GREY){
					//sortie 2
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(2);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.BLACK){
					//couloir 3
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(3);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.RED){
					//extincteur 4
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(4);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.WHITE){
					//ecran 5
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(5);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.GREEN){
					//normal 6
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(6);
					caseadd=CaseSalleDAO.create(caseadd);
				}
				else if(rect.getFill()==Color.BLUE){
					//handicape 8
					caseadd.setIdPlanSalle(planSalleEnCours.getId());
					caseadd.setIdPositionCase(ComplementDAO.findbypos(i, j));
					caseadd.setIdTypeCase(8);
					caseadd=CaseSalleDAO.create(caseadd);
				}			
	        }
		}
		
		
	}
	
	public void selCinema(){
		ObservableList<InfoSalle> salleData = FXCollections.observableArrayList();
		
		for(PlanSalle p:MainController.donnees.getCinemas().get(listCine.getSelectionModel().getSelectedIndex()).getListPlanSalle()){
			salleData.add(new InfoSalle(String.valueOf(p.getId()),p.getNomPlanSalle(),p.getNumPlanSalle()));	
		}
		salleId.setCellValueFactory(cellData -> cellData.getValue().salleIDProperty());
		salleName.setCellValueFactory(cellData -> cellData.getValue().salleNameProperty());

		listSalle.getItems().setAll(salleData);
		listSalle.getSelectionModel().selectFirst();
		
		System.out.println("selectionSalle");
		remplirTableau();
	}

	public PlanSalle getPlanSalleEnCours() {
		return planSalleEnCours;
	}

	public void setPlanSalleEnCours(PlanSalle planSalleEnCours) {
		this.planSalleEnCours = planSalleEnCours;
	}
}
