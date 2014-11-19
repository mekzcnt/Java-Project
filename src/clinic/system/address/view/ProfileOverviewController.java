package clinic.system.address.view;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProfileOverviewController {
	private MainApp mainApp;
	
	 @FXML
	 private TextField search;
	 @FXML
	    private Button EditButton;

	    @FXML
	    private Label BloodPressure;

	    @FXML
	    private Label Address;

	    @FXML
	    private Label PostalCode;

	    @FXML
	    private Label HistoryDisease;

	    @FXML
	    private TextField SearchBox;

	    @FXML
	    private TableColumn<?, ?> Name;

	    @FXML
	    private Label PatientDisease;

	    @FXML
	    private Button DeleteButton;

	    @FXML
	    private Button AddButton;

	    @FXML
	    private Button SearchButton;

	    @FXML
	    private Label Height;

	    @FXML
	    private TableColumn<?, ?> ID;

	    @FXML
	    private AnchorPane ProfileSplitPane;

	    @FXML
	    private Label Name1;

	    @FXML
	    private Label Age;

	    @FXML
	    private Label Surname1;

	    @FXML
	    private Label Province;

	    @FXML
	    private Label Weight;

	    @FXML
	    private Label SubDistrict;

	    @FXML
	    private MenuButton ProfileMenu;

	    @FXML
	    private Label ID1;

	    @FXML
	    private TableColumn<?, ?> Surname;

	    @FXML
	    private Label District;

	    @FXML
	    private TableView<?> TableSplitPane;

	    @FXML
	    private Label BirthDate;

	 
	 
	public void search(String searchtxt) {
		search.setText(searchtxt);
	}
	private void initialize(){
		
	}
	
	 public void setMainApp(MainApp mainApp) {
			// TODO Auto-generated method stub
			this.mainApp = mainApp;

	        // Add observable list data to the table

		}
}
