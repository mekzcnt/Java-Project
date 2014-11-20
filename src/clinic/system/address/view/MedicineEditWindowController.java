package clinic.system.address.view;

import clinic.system.address.model.medicine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicineEditWindowController {

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
    private Button EditMedicineButton;

    private Stage dialogStage;
    private MedicineOverviewController MedicineOverviewController;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setTitle("Edit Medicine");
    }
    
    public void setMececine(medicine med){
    	MedicineID.setText(""+med.getMID().getValue());
    	MedicineName.setText(""+med.getMName().getValue());
    	MedicinePrice.setText(""+med.getPrice().getValue());
    	MedicineAmount.setText(""+med.getAmount().getValue());
    	MedicineDetails.setText(""+med.getDescription().getValue());
    }
    @FXML
    public void handleEdit() {
    	try {
    	medicine med = new medicine(Integer.parseInt(MedicineID.getText()),MedicineName.getText(),Integer.parseInt(MedicinePrice.getText()),Integer.parseInt(MedicineAmount.getText()),MedicineDetails.getText());
    	MedicineOverviewController.editMedicine(med);
    	dialogStage.close();
    	}catch ( Exception e ) {
    		
    	}
    	
    }


    public void setMainApp(MedicineOverviewController MedicineOverviewController) {
		// TODO Auto-generated method stub
		this.MedicineOverviewController = MedicineOverviewController;

        // Add observable list data to the table

	}
}
