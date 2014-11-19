package clinic.system.address.view;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import clinic.system.address.model.medicine;
import clinic.system.address.model.profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileAddWindow {

	  @FXML
	    private TextField BloodPressure;

	    @FXML
	    private TextField Address;

	    @FXML
	    private TextField PostalCode;

	    @FXML
	    private TextField Subdistrict;

	    @FXML
	    private TextField HistoryDisease;

	    @FXML
	    private TextField Birthdate;

	    @FXML
	    private TextField Province;

	    @FXML
	    private TextField Weight;

	    @FXML
	    private TextField Name;

	    @FXML
	    private Button AddProfileButton;

	    @FXML
	    private TextField PatientDisease;

	    @FXML
	    private TextField PatientID;

	    @FXML
	    private TextField Height;

	    @FXML
	    private TextField District;

	    @FXML
	    private TextField Surname;

	    @FXML
	    private TextField Age;
	    
	    private ProfileOverviewController ProfileOverviewController;
	    private Stage dialogStage;
	    public void setPromtext(){
	 	   //this.MedicineID.setText("Enter number");
	 	   this.BloodPressure.setPromptText("Enter number"); //1
	 	   this.Address.setPromptText("Enter String");
	 	   this.PostalCode.setPromptText("Enter number");   //2
	 	   this.Subdistrict.setPromptText("Enter String"); //�Ӻ�
	 	   this.HistoryDisease.setPromptText("Enter String");
	 	  this.Birthdate.setPromptText("Enter String");
	 	 this.Province.setPromptText("Enter String");
	 	this.Weight.setPromptText("Enter number"); //3
	 	this.Name.setPromptText("Enter String");
	 	this.PatientDisease.setPromptText("Enter String");
	 	this.PatientID.setPromptText("Enter number"); //4
	 	this.Height.setPromptText("Enter number"); //5
	 	this.District.setPromptText("Enter String"); //6
	 	this.Surname.setPromptText("Enter String");
	 	this.Age.setPromptText("Enter number"); //7
	    }
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	        setPromtext();
	        this.dialogStage.setTitle("ADD Profile");
	    
	    }
	    public void handleADD() {
	    	//,MedicineName.getText() 4
	    	profile med = new profile(
	    	Name.getText(),
	    	Surname.getText(),
	    	Integer.parseInt(PatientID.getText()),
	    	Birthdate.getText(),
	    	Integer.parseInt(Age.getText()),
	    	Address.getText(),
	    	Subdistrict.getText(),
	    	District.getText(),
	    	Province.getText(),
	    	Integer.parseInt(PostalCode.getText()),
	    	Integer.parseInt(Weight.getText()),
	    	Integer.parseInt(Height.getText()),
	    	Integer.parseInt(BloodPressure.getText()),
	    	HistoryDisease.getText(),
	    	PatientDisease.getText()
	    	);
	    	
	    	
	    	ProfileOverviewController.addProfile(med);
	    	dialogStage.close();
	    	
	    	
	    }
	    private boolean Iscorrect() {
	    	String number = "0123456789";
	    	if (Name.getText().matches(number) && 
	    			Surname.getText().matches(number) && 
	    			PatientID.getText().matches(number) &&
	    					Age.getText().matches(number) &&	
	    							Address.getText().matches(number) &&
	    									Subdistrict.getText().matches(number )&&
	    											District.getText().matches(number )&&
	    													Province.getText().matches(number )&&
	    															PostalCode.getText().matches(number) &&
	    																Weight.getText().matches(number ) &&
	    																	Height.getText().matches(number ) &&
	    																		BloodPressure.getText().matches(number ) &&
	    																			HistoryDisease.getText().matches(number ) &&
	    																				PatientDisease.getText().matches(number ) ){
	    		return !true;
	    	}
	    	return true;
	    	
	    	
	    }
	    
	    public void setMainApp(ProfileOverviewController ProfileOverviewController) {
			// TODO Auto-generated method stub
			this.ProfileOverviewController = ProfileOverviewController;

	        // Add observable list data to the table

		}
	    
}
