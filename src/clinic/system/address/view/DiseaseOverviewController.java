package clinic.system.address.view;

import java.io.IOException;

import clinic.system.address.MainApp;
import clinic.system.address.model.disease;
//import clinic.system.address.model.medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DiseaseOverviewController {
	
	private MainApp mainApp;
	
	@FXML
    private TableView<disease> diseaseList;
    @FXML
    private TableColumn<disease, String> diseaseFname;

    @FXML
    private TableColumn<disease, String> diseaseLName;
    
    @FXML
    private TableColumn<disease, Number> diseaseID;

    @FXML
    private TableColumn<disease, String> diseaseName;
    
    @FXML
    private TextField SearchBox; 
    
    private ObservableList<disease> data = FXCollections.observableArrayList();
    private Button AdddiseaseButton;
    
    @FXML
    public void handleADD() {
    	
    	
		try {
			
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DiseaseAddWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			MedicineAddWindow controller = loader.getController();
			controller.setDialogStage(dialogStage);
            controller.setMainApp(this);  /////// problem
	    	Scene scene = new Scene(root);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

    public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}
}
