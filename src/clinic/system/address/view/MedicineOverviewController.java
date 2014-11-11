package clinic.system.address.view;

import java.io.IOException;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MedicineOverviewController {

	private MainApp mainApp;
    @FXML
    private TableColumn<?, ?> qulity;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    public void handleADD() {
    	
		try {
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicineAddWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			//DialogController controller = (DialogController) loader.getController();
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
