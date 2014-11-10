package clinic.system.address.view;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfileOverviewController {
	private MainApp mainApp;
	
	 @FXML
	 private TextField search;
	 @FXML
	 private  Button edit;
	 @FXML
	 private  Button SearchButton;
	 @FXML
	 private  Button delete;
	 @FXML
	 private  Button add;
	 
	 public void setMainApp(MainApp mainApp) {
			// TODO Auto-generated method stub
			this.mainApp = mainApp;

	        // Add observable list data to the table

		}
}
