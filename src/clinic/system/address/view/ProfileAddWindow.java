package clinic.system.address.view;


import clinic.system.address.model.profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

	 	   this.BloodPressure.setPromptText("Enter number"); //1
	 	   this.Address.setPromptText("Enter String");
	 	   this.PostalCode.setPromptText("Enter number");   //2
	 	   this.Subdistrict.setPromptText("Enter String"); //µÓºÅ
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
	    	try {
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
	    	}catch ( Exception e ) {
	    		
	    	}
	    	
	    }
	    
	    
	    public void setMainApp(ProfileOverviewController ProfileOverviewController) {
			this.ProfileOverviewController = ProfileOverviewController;


		}
	    
}
