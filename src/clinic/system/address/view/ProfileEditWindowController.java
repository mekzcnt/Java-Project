package clinic.system.address.view;

import clinic.system.address.model.profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileEditWindowController {
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
    private Button EditPersonButton;

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
    
    private Stage dialogStage;
    private ProfileOverviewController ProfileOverviewController;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setTitle("Edit Profile");
    }
    public void setProfile(profile med){
    	BloodPressure.setText(""+med.getPressure().getValue());
    	Address.setText(""+med.getAddress().getValue());
    	PostalCode.setText(""+med.getMailAddress().getValue());
    	Subdistrict.setText(""+med.getCanton().getValue());
    	HistoryDisease.setText(""+med.getCongenitalDisease().getValue());
    	Birthdate.setText(""+med.getBirthday().getValue());
    	Province.setText(""+med.getProvince().getValue());
    	Weight.setText(""+med.getWeight().getValue());
    	Name.setText(""+med.getFName().getValue());
    	PatientDisease.setText(""+med.getDisease().getValue());
    	PatientID.setText(""+med.getID().getValue());
    	Height.setText(""+med.getHeight().getValue());
    	District.setText(""+med.getDistrict().getValue());
    	Surname.setText(""+med.getLName().getValue());
    	Age.setText(""+med.getOld().getValue());
    	
    }
    public void handleEdit() {
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
    	
    	
    	ProfileOverviewController.editProfile(med);
    	dialogStage.close();
    	}catch ( Exception e ) {
    		
    	}
    }

    public void setMainApp(ProfileOverviewController ProfileOverviewController) {
		this.ProfileOverviewController = ProfileOverviewController;


	}
}
