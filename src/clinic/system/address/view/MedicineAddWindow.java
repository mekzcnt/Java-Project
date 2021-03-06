package clinic.system.address.view;



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

   public void setPromtext(){
	  
	   this.MedicineID.setPromptText("Enter number");
	   this.MedicineDetails.setPromptText("Enter a detail of medicine");
	   this.MedicineName.setPromptText("Enter words' name");
	   this.MedicineAmount.setPromptText("Enter number");
	   this.MedicinePrice.setPromptText("Enter number");
   }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        setPromtext();
        this.dialogStage.setTitle("Add Medicine");
    }
    
   
    @FXML
    public void handleADD() {
    	try {
    	medicine med = new medicine(Integer.parseInt(MedicineID.getText()),MedicineName.getText(),Integer.parseInt(MedicinePrice.getText()),Integer.parseInt(MedicineAmount.getText()),MedicineDetails.getText());

    	MedicineOverviewController.addMedicine(med);
    	dialogStage.close();
    	}catch ( Exception e ) {
    		
    	}

    }

    public void setMainApp(MedicineOverviewController MedicineOverviewController) {
		this.MedicineOverviewController = MedicineOverviewController;
	}
    

}
