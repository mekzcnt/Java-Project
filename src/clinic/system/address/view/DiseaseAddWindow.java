package clinic.system.address.view;



import clinic.system.address.model.disease;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DiseaseAddWindow {
	@FXML
    private TextField DiseaseID;

    @FXML
    private TextArea DiseaseDetails;

    @FXML
    private TextField DiseaseFname;

    @FXML
    private TextField DiseaseLname;

    @FXML
    private TextField DiseaseName;

    @FXML
    private Button AddDiseaseButton;
    
    private DiseaseOverviewController DiseaseOverviewController;
    private Stage dialogStage;
    
    public void setPromtext(){
 	   //this.MedicineID.setText("Enter number");
 	   this.DiseaseID.setPromptText("Enter number");
 	   this.DiseaseDetails.setPromptText("Enter a detail of disease");
 	   this.DiseaseFname.setPromptText("Enter words' name");
 	   this.DiseaseLname.setPromptText("Enter words' name");
 	   this.DiseaseName.setPromptText("Enter words' name");
    }
     
     public void setDialogStage(Stage dialogStage) {
         this.dialogStage = dialogStage;
         //setPromtext();
         //this.dialogStage.setTitle("ADD Disease");
     }
     public void handleADD() {

     	disease med = new disease(DiseaseFname.getText(),DiseaseDetails.getText(),Integer.parseInt(DiseaseID.getText()),DiseaseLname.getText(),DiseaseName.getText());
     	//med.setMName(MedicineName.getText());
     	//med.setDescription(MedicineDetails.getText());
     	//med.setAmount(Integer.parseInt(MedicineAmount.getText()));
     	//med.setPrice(Integer.parseInt(MedicinePrice.getText()));
     	//med.setMID(Integer.parseInt(MedicineID.getText()));
     	
     	DiseaseOverviewController.addDisease(med);
     	dialogStage.close();
     }
     public void setMainApp(DiseaseOverviewController DiseaseOverviewController) {
 		// TODO Auto-generated method stub
 		this.DiseaseOverviewController = DiseaseOverviewController;

         // Add observable list data to the table

 	}

}
