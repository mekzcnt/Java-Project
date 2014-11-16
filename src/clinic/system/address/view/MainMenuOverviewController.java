package clinic.system.address.view;

import java.io.IOException;

import org.controlsfx.dialog.Dialogs;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuOverviewController {

	// Reference to the main application.
    private MainApp mainApp;

    @FXML
    private TextField MainSearch;
    //test
    
    @FXML
	public void handleMedicine() {
    	mainApp.showMedicineOverview();
    }
    
    public void handleDisease() {
    	
    }
    
    public void handleProfile() {
    	//mainApp.setSearch(MainSearch.getText());
    	mainApp.showProfileOverview();
    }
    
    public void handlemoney() {
    	mainApp.showMoneyOverview();
    }
    
    
    public void handleSearch() {
    	try {
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileOverview.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			//DialogController controller = (DialogController) loader.getController();
			ProfileOverviewController Profilecontroller = loader.getController();
			Profilecontroller.search("eii");
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