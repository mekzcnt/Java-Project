package clinic.system.address.view;

import clinic.system.address.model.disease;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DiseaseEditWindowController {
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
    private Button EditDiseaseButton;
    
    private Stage dialogStage;
    private DiseaseOverviewController DiseaseOverviewController;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setTitle("Edit Disease");
    }
    public void setDisease(disease med){
    	DiseaseID.setText(""+med.getID().getValue());
    	DiseaseFname.setText(""+med.getFName().getValue());
    	DiseaseLname.setText(""+med.getLName().getValue());
    	DiseaseName.setText(""+med.getdisease().getValue());
    	DiseaseDetails.setText(""+med.getdescription().getValue());
    }
    public void handleEdit() {
    	disease med = new disease(DiseaseDetails.getText(),DiseaseFname.getText(),Integer.parseInt(DiseaseID.getText()),DiseaseName.getText(),DiseaseLname.getText());
    	DiseaseOverviewController.editDisease(med);
    	dialogStage.close();
    }
    public void setMainApp(DiseaseOverviewController DiseaseOverviewController) {
		// TODO Auto-generated method stub
		this.DiseaseOverviewController = DiseaseOverviewController;

        // Add observable list data to the table

	}
}
