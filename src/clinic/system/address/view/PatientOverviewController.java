package clinic.system.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import clinic.system.address.MainApp;
import clinic.system.address.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PatientOverviewController {

	private MainMenuOverviewController MainMenuOverviewController;
	
	private Stage dialogStage;
	
	private profile profile;
	
    @FXML
    private Label BloodPressure;

    @FXML
    private TableColumn<medicine, Number> MedicinePrice;

    @FXML
    private Label Surname1;

    @FXML
    private Button AddMoneyButton;

    @FXML
    private ListView<medicine> MedicineList;
    private ObservableList<medicine> listViewData = FXCollections.observableArrayList();
    private ObservableList<medicine> data = FXCollections.observableArrayList();
    
	@FXML
    private Label Weight;

    @FXML
    private TextField DiseaseSearch;

    @FXML
    private TextField MedicineSearchBox;

    @FXML
    private TextField DiseaseDetails;

    @FXML
    private Label SumMedicinePrice;

    @FXML
    private TableColumn<medicine, String> MedicineName;
    
    @FXML
    private TextField AmountMedicine;

    @FXML
    private TableColumn<medicine, Number> MedicinePrice1;

    @FXML
    private Label ID1;

    @FXML
    private Label Height;

    @FXML
    private Button MedicineAddButton;

    @FXML
    private Label Name1;

    @FXML
    private Label Age;

    @FXML
    private Label BirthDate;
    
    @FXML
    private TableView<medicine> MedicineTable;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setTitle("PatientOverview");
    
    }
    public void setMainApp(MainMenuOverviewController MainMenuOverviewController) {
		// TODO Auto-generated method stub
		this.MainMenuOverviewController = MainMenuOverviewController;

        // Add observable list data to the table

	}
    

    public void setProfile(profile profile) {
		this.profile = profile;
		Name1.setText(profile.getFName().getValue());
		Surname1.setText(profile.getLName().getValue());
    	ID1.setText(""+this.profile.getID().getValue());
    	Height.setText(""+this.profile.getHeight().getValue());
    	Age.setText(""+profile.getOld().getValue());
    	BirthDate.setText(profile.getBirthday().getValue());
    	Weight.setText(""+profile.getWeight().getValue());
    	BloodPressure.setText(""+profile.getPressure().getValue());
    	
    	MedicineList.setItems(listViewData);
    	MedicineList.setCellFactory((list) -> {
    	    return new ListCell<medicine>() {
    	        @Override
    	        protected void updateItem(medicine item, boolean empty) {
    	            super.updateItem(item, empty);

    	            if (item == null || empty) {
    	                setText(null);
    	            } else {
    	                setText(item.getMName().getValue() + " " + item.getPrice().getValue());
    	            }
    	        }
    	    };
    	});
    	
    	MedicineName.setCellValueFactory(cellData -> cellData.getValue().getMName());
    	MedicinePrice.setCellValueFactory(cellData -> cellData.getValue().getPrice());
    	MedicinePrice1.setCellValueFactory(cellData -> cellData.getValue().getUse());
    	
	}
    @FXML
    public void handleSearch() {
    	if (MedicineSearchBox.getText().isEmpty()) {
    		MedicineList.setVisible(false);
    	}
    	else {
    		MedicineList.setVisible(true);
    		find(MedicineSearchBox.getText());
    	}
    	
    }
    public void find(String word) {
    	Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
            c.setAutoCommit(false);

          stmt = c.createStatement();
          
          String sql = "SELECT * FROM Medicine " +
                  "WHERE NAME LIKE '%"+word+"%' OR ID LIKE '%"+word+"%';" ;
          
          ResultSet rs = stmt.executeQuery(sql);
          listViewData.clear();
          while ( rs.next() ) {
            
        	  listViewData.add(new medicine(rs.getInt("ID"),rs.getString("NAME"),rs.getInt("Price"),rs.getInt("Amout"),rs.getString("Details")));

          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        
    }
    public void handleSubmit() {
    	System.out.print("ss");
    	//System.out.print(MedicineList.getSelectionModel().getSelectedItem().getMName().getValue());
    	medicine temp = MedicineList.getSelectionModel().getSelectedItem();
    	temp.setuse(Integer.parseInt(AmountMedicine.getText()));
    	data.add(temp);
    	
    	MedicineSearchBox.setText("");
    	MedicineTable.getItems().clear();
    	MedicineTable.getItems().setAll(data);
    	handleSearch();
    	displayprice();

    }
    
    private void displayprice() {
    	int price = 0;
    	for (medicine each:data) {
    		price += each.getPrice().intValue()*each.getUse().intValue();
    	}
    	SumMedicinePrice.setText(""+price);
    }
    
    @FXML
    public void submit() {
    	Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
          c.setAutoCommit(false);

          stmt = c.createStatement();
          String sql = "INSERT INTO Disease (ID,disease,description) " +
                  "VALUES ("+profile.getID().intValue()+", '"+DiseaseSearch.getText()+"', '"+DiseaseDetails.getText()+"' );";
          
          stmt.executeUpdate(sql);
          c.commit();
          
          for (medicine each:data) {
        	  sql = "UPDATE Medicine set Amout = "+each.getAmount().intValue() +"  where ID = "+each.getMID().intValue()+";";
              //System.out.print(sql);
              stmt.executeUpdate(sql);
             
              c.commit();
          }
           
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        dialogStage.close();
    }
    public void handleDelete() {
    	data.remove(MedicineTable.getSelectionModel().getSelectedItem());
    }
}
