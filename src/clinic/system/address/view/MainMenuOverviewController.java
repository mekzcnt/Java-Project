package clinic.system.address.view;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuOverviewController {

	// Reference to the main application.
    private MainApp mainApp;

    @FXML
    private TextField MainSearch;
    
    
    @FXML
	public void handleMedicine() {
    	mainApp.showMedicineOverview();
    }
    
    public void handleDisease() {
    	mainApp.showDiseaseOverview();
    }
    
    public void handleProfile() {
    	mainApp.showProfileOverview(MainSearch.getText());
    }
    
    public void handlemoney() {
    	mainApp.showMoneyOverview();
    }
    

	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}

}