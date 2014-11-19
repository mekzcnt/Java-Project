package clinic.system.address.view;

import clinic.system.address.MainApp;
import clinic.system.address.model.medicine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PatientOverviewController<profile> {

	private MainMenuOverviewController MainMenuOverviewController;
	
	private Stage dialogStage;
	
	private profile profile1;
	
    @FXML
    private Label BloodPressure;

    @FXML
    private TableColumn<medicine, Number> MedicinePrice;

    @FXML
    private Label Surname1;

    @FXML
    private Button AddMoneyButton;


	@FXML
    private Label Weight;

    @FXML
    private TextField DiseaseSearch;

    @FXML
    private TextField MedicineSearchBox;

    @FXML
    private AnchorPane DiseaseDetails;

    @FXML
    private Label SumMedicinePrice;

    @FXML
    private TableColumn<medicine, String> MedicineName;

    @FXML
    private Label ID1;

    @FXML
    private Label Height;

    @FXML
    private Button MedicineAddButton;

    @FXML
    private Label Name1;

    @FXML
    private Label Age;

    @FXML
    private Label BirthDate;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setTitle("");
    
    }
    public void setMainApp(MainMenuOverviewController MainMenuOverviewController) {
		// TODO Auto-generated method stub
		this.MainMenuOverviewController = MainMenuOverviewController;

        // Add observable list data to the table

	}
    
    private void initialize() {
    	Name1.setText(( this.profile1).getFName().getValue());
    }
    public void setProfile(profile profile) {
		this.profile1 = profile;
	}

}
