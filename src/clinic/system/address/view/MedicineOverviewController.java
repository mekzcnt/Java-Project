package clinic.system.address.view;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

    public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}
}
