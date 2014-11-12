package clinic.system.address.view;


import clinic.system.address.MainApp;
import clinic.system.address.model.medicine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicineAddWindow {

    @FXML
    private TextField MedicineID;

    @FXML
    private TextArea MedicineDetails;

    @FXML
    private TextField MedicineName;

    @FXML
    private TextField MedicineAmount;

    @FXML
    private TextField MedicinePrice;

    @FXML
    private Button AddMedicineButton;
    
    private MedicineOverviewController MedicineOverviewController;
    private Stage dialogStage;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void handleADD() {
    	medicine med = new medicine(Integer.parseInt(MedicineID.getText()),MedicineName.getText(),Integer.parseInt(MedicinePrice.getText()),Integer.parseInt(MedicineAmount.getText()),MedicineDetails.getText());
    	//med.setMName(MedicineName.getText());
    	//med.setDescription(MedicineDetails.getText());
    	//med.setAmount(Integer.parseInt(MedicineAmount.getText()));
    	//med.setPrice(Integer.parseInt(MedicinePrice.getText()));
    	//med.setMID(Integer.parseInt(MedicineID.getText()));
    	
    	MedicineOverviewController.addMedicine(med);
    	dialogStage.close();
    }
    
    public void setMainApp(MedicineOverviewController MedicineOverviewController) {
		// TODO Auto-generated method stub
		this.MedicineOverviewController = MedicineOverviewController;

        // Add observable list data to the table

	}
    

}
