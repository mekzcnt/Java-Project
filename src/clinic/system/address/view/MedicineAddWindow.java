package clinic.system.address.view;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import clinic.system.address.model.medicine;
import javafx.event.ActionEvent;
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

   public void setPromtext(){
	   //this.MedicineID.setText("Enter number");
	   this.MedicineID.setPromptText("Enter number");
	   this.MedicineDetails.setPromptText("Enter a detail of medicine");
	   this.MedicineName.setPromptText("Enter words' name");
	   this.MedicineAmount.setPromptText("Enter number");
	   this.MedicinePrice.setPromptText("Enter number");
   }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        setPromtext();
        this.dialogStage.setTitle("ADD medicine");
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
