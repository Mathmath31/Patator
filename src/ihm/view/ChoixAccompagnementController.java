package ihm.view;

import java.io.File;

import ihm.model.InfoAccompagnement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChoixAccompagnementController {

	@FXML
	private Button btnAjoute;
	@FXML
	private Button btnSupprimer;
	@FXML
	private Button btnValider;
	@FXML
	private TableView<InfoAccompagnement> tableViewChoix;
	@FXML
	private TableColumn<InfoAccompagnement, String> accName;
	@FXML
	private TableColumn<InfoAccompagnement, String> accDesc;
	@FXML
	private TableColumn<InfoAccompagnement, String> accPrix;
	@FXML
	private TableColumn<InfoAccompagnement, String> accID;
	@FXML
	private TableView<InfoAccompagnement> tableViewChoix2;
	@FXML
	private TableColumn<InfoAccompagnement, String> accName2;
	@FXML
	private TableColumn<InfoAccompagnement, String> accDesc2;
	@FXML
	private TableColumn<InfoAccompagnement, String> accPrix2;
	@FXML
	private TableColumn<InfoAccompagnement, String> accID2;
	@FXML
	private TableColumn<InfoAccompagnement, String> accQty2;
	@FXML
	private CheckBox livraison;
	
	private int nombreProduit = 0;
	private int nblig = 0;
	
	@FXML
	private ImageView imgAccompagnement;
	
	private ObservableList<InfoAccompagnement> accData = FXCollections.observableArrayList();
	private ObservableList<InfoAccompagnement> accData2 = FXCollections.observableArrayList();
	
	public void initialize(){		
		accData.add(new InfoAccompagnement("Mars","et ca repart", "2","1",""));
		accData.add(new InfoAccompagnement("Lion","pour rugir", "3.5","2",""));
		accData.add(new InfoAccompagnement("eau","au bon gout de H2O", "4","3",""));
		
		accName.setCellValueFactory(cellData -> cellData.getValue().accNameProperty());
		accDesc.setCellValueFactory(cellData -> cellData.getValue().accDescriptionProperty());
		accPrix.setCellValueFactory(cellData -> cellData.getValue().accPrixProperty());
		accID.setCellValueFactory(cellData -> cellData.getValue().accIDProperty());
		
		tableViewChoix.getItems().setAll(accData);
		tableViewChoix.getSelectionModel().selectFirst();
		

	}
	
	@FXML
	public void ajouter(){
		boolean present = false;
		
		String nom = tableViewChoix.getItems().get(tableViewChoix.getSelectionModel().getSelectedIndex()).getAccName();
		String desc = tableViewChoix.getItems().get(tableViewChoix.getSelectionModel().getSelectedIndex()).getAccDescription();
		String prix = tableViewChoix.getItems().get(tableViewChoix.getSelectionModel().getSelectedIndex()).getAccPrix();
		String id = tableViewChoix.getItems().get(tableViewChoix.getSelectionModel().getSelectedIndex()).getAccID();
		String qty = "1";
		if (nombreProduit == 0)
		{
			accData2.add(new InfoAccompagnement(nom,desc,prix,id,qty));
			accName2.setCellValueFactory(cellData -> cellData.getValue().accNameProperty());
			accDesc2.setCellValueFactory(cellData -> cellData.getValue().accDescriptionProperty());
			accPrix2.setCellValueFactory(cellData -> cellData.getValue().accPrixProperty());
			accID2.setCellValueFactory(cellData -> cellData.getValue().accIDProperty());
			accQty2.setCellValueFactory(cellData -> cellData.getValue().accQtyProperty());
			tableViewChoix2.getItems().setAll(accData2);
			tableViewChoix2.getSelectionModel().selectFirst();
		}
		else
		{
			nblig = 0;
			//si produit déja dans la liste?
			for (Object o : tableViewChoix2.getItems()) {
				if(tableViewChoix2.getItems().get(nblig).getAccID() == id)
					{
						present = true;
						int nbprod = (Integer.parseInt(tableViewChoix2.getItems().get(nblig).getAccQty()) + 1);
						tableViewChoix2.getItems().get(nblig).setAccQty("" + nbprod);
						tableViewChoix2.getItems().get(nblig).setAccPrix("" + (nbprod*Double.parseDouble(prix)));
					};
				nblig++;
			}
			
			//ajout de la ligne entiere si pas dans la liste
			if (present != true)
			{
				accData2.add(new InfoAccompagnement(nom,desc,prix,id,qty));
			}
			tableViewChoix2.getItems().setAll(accData2);
		}
			nombreProduit ++;
	}
	
	@FXML
	public void supprimer(){
		int qty = Integer.valueOf(tableViewChoix2.getItems().get(tableViewChoix2.getSelectionModel().getSelectedIndex()).getAccQty());
		double prix = Double.valueOf(tableViewChoix2.getItems().get(tableViewChoix2.getSelectionModel().getSelectedIndex()).getAccPrix());
		if (nombreProduit != 0)
		{
			if (qty != 1)
			{
				tableViewChoix2.getItems().get(tableViewChoix2.getSelectionModel().getSelectedIndex()).setAccQty("" + (qty - 1));
				tableViewChoix2.getItems().get(tableViewChoix2.getSelectionModel().getSelectedIndex()).setAccPrix("" + ((qty-1)*(prix/qty)));
			}
			else
			{
				InfoAccompagnement selectedItem = tableViewChoix2.getSelectionModel().getSelectedItem();
				tableViewChoix2.getItems().remove(selectedItem);
			}
		}
		nombreProduit --;
	}
	
	@FXML
	public void valider(){

	}
	
	@FXML
	public void selectionChanged(){
			//TODO récuperer le lien de l'image et l'afficher dans imgAccompagnement
		int index = Integer.valueOf(tableViewChoix2.getItems().get(nblig).getAccID());
		switch (index)
		{
		  case 1:
			  File file = new File("https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Mars.png/220px-Mars.png");
			  Image image = new Image(file.toPath().toString());
			  imgAccompagnement.setImage(image);
		    break;
		  case 2:
			  File file2 = new File("https://upload.wikimedia.org/wikipedia/en/7/7b/Lion-Bar-Wrapper-Small.jpg");
			  Image image2 = new Image(file2.toURI().toString());
			  imgAccompagnement.setImage(image2);
		    break;
		  case 3:
			  File file3 = new File("https://upload.wikimedia.org/wikipedia/fr/8/82/Logo_Evian.jpg");
			  Image image3 = new Image(file3.toURI().toString());
			  imgAccompagnement.setImage(image3);
		    break;
		  default:
		}
	}
	
}
