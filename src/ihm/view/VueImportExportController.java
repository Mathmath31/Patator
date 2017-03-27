package ihm.view;

import java.util.ArrayList;

import classes.Cinema;
import classes.PlanSalle;
import ihm.model.ExportCine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VueImportExportController {

	@FXML
	private TableView<ExportCine> tableViewChoix1;
	@FXML
	private TableColumn<ExportCine, String> idCine1;
	@FXML
	private TableColumn<ExportCine, String> nomCine1;
	@FXML
	private TableColumn<ExportCine, String> idSalle1;
	@FXML
	private TableColumn<ExportCine, String> nomSalle1;
	@FXML
	private TableView<ExportCine> tableViewChoix2;
	@FXML
	private TableColumn<ExportCine, String> idCine2;
	@FXML
	private TableColumn<ExportCine, String> nomCine2;
	@FXML
	private TableColumn<ExportCine, String> idSalle2;
	@FXML
	private TableColumn<ExportCine, String> nomSalle2;
	@FXML
	private TextField nomFichier;
	
	private ObservableList<ExportCine> exportCine1 = FXCollections.observableArrayList();
	private ObservableList<ExportCine> exportCine2 = FXCollections.observableArrayList();
	
	private int nombreSalle = 0;
	private int nblig = 0;
	
	@FXML
	private void ajouter()
	{
		boolean present = false;
		
		String idCine = tableViewChoix1.getItems().get(tableViewChoix1.getSelectionModel().getSelectedIndex()).getIdCinema();
		String nomCine = tableViewChoix1.getItems().get(tableViewChoix1.getSelectionModel().getSelectedIndex()).getNomCinema();
		String idSalle = tableViewChoix1.getItems().get(tableViewChoix1.getSelectionModel().getSelectedIndex()).getIdSalle();
		String nomSalle = tableViewChoix1.getItems().get(tableViewChoix1.getSelectionModel().getSelectedIndex()).getNomSalle();
		
		if (nombreSalle == 0)
		{
			exportCine2.add(new ExportCine(idCine,nomCine,idSalle,nomSalle));
			idCine2.setCellValueFactory(cellData -> cellData.getValue().idCinemaProperty());
			nomCine2.setCellValueFactory(cellData -> cellData.getValue().nomCinemaProperty());
			idSalle2.setCellValueFactory(cellData -> cellData.getValue().idSalleProperty());
			nomSalle2.setCellValueFactory(cellData -> cellData.getValue().nomSalleProperty());
			tableViewChoix2.getItems().setAll(exportCine2);
			tableViewChoix2.getSelectionModel().selectFirst();
			nombreSalle ++;
		}
		else
		{
			nblig = 0;
			//si produit déja dans la liste?
			for (Object o : tableViewChoix2.getItems()) {
				if(tableViewChoix2.getItems().get(nblig).getIdSalle() == idSalle)
					{
						present = true;
					};
				nblig++;
			}
			
			//ajout de la ligne entiere si pas dans la liste
			if (present != true)
			{
				exportCine2.add(new ExportCine(idCine,nomCine,idSalle,nomSalle));
			}
			tableViewChoix2.getItems().setAll(exportCine2);
			nombreSalle ++;
		}
		
	}
	
	@FXML
	private void supprimer()
	{
		if (nombreSalle != 0)
		{
			ExportCine selectedItem = tableViewChoix2.getSelectionModel().getSelectedItem();
			tableViewChoix2.getItems().remove(selectedItem);
			nombreSalle --;
		}
	}
	
	@FXML
	private void exporter()
	{
		ArrayList<Cinema> cine=new ArrayList<Cinema>();
		int[] idCines= new int[20];
		
		
		
		for(int i=0;i<nblig;i++){
			
			tableViewChoix2.getItems().get(nblig).getIdSalle();
		}
		
		for(int i=0;i<nblig;i++){
			tableViewChoix2.getItems().get(nblig).getIdSalle();
		}
		
	}
	
	@FXML
	private void importer()
	{
		
		
	}
	

	
	public void initialize()
	{
		int i=0;
		for(Cinema c : MainController.donnees.getCinemas()){
			for(PlanSalle p: MainController.donnees.getCinemas().get(i).getListPlanSalle()){
				exportCine1.add(new ExportCine(String.valueOf(c.getId()),c.getNomCine(),String.valueOf(p.getId()),p.getNomPlanSalle()));
			}
			i++;
		}

		
		idCine1.setCellValueFactory(cellData -> cellData.getValue().idCinemaProperty());
		nomCine1.setCellValueFactory(cellData -> cellData.getValue().nomCinemaProperty());
		idSalle1.setCellValueFactory(cellData -> cellData.getValue().idSalleProperty());
		nomSalle1.setCellValueFactory(cellData -> cellData.getValue().nomSalleProperty());
		
		tableViewChoix1.getItems().setAll(exportCine1);
		tableViewChoix1.getSelectionModel().selectFirst();
	}
}
