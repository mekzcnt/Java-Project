package clinic.system.address.view;

import java.io.IOException;

import clinic.system.address.MainApp;
import clinic.system.address.model.medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import java.sql.*;

public class MedicineOverviewController {

    
	private MainApp mainApp;
    @FXML
    private TableView<medicine> medicineList;
    
	@FXML
    private TableColumn<medicine, Number> MedicineID;

    @FXML
    private TableColumn<medicine, String> MedicineName;
    
    @FXML
    private TableColumn<medicine, Number> MedicinePrice;

    @FXML
    private TableColumn<medicine, Number> MedicineQuatity;

    @FXML
    private TextField search; 

    private ObservableList<medicine> data = FXCollections.observableArrayList();
    
    @FXML
    public void handleADD() {
    	
		try {
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicineAddWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			MedicineAddWindow controller = loader.getController();
			controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
	    	Scene scene = new Scene(root);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void handleEdit() {
    	
		try {
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicineAddWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			//DialogController controller = (DialogController) loader.getController();
	    	Scene scene = new Scene(root);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void handleDelete() {
    	int selectedIndex = medicineList.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			
			data.remove(medicineList.getSelectionModel().getSelectedItem());
			medicineList.getItems().remove(selectedIndex);
			
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
		      c.setAutoCommit(false);

		      stmt = c.createStatement();
		      String sql = "DELETE from Medicine where ID="+medicineList.getSelectionModel().getSelectedItem().getMID().intValue()+";";
		      stmt.executeUpdate(sql);
		      c.commit();

		      
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    
			
		} else {
			// Nothing selected.
			Dialogs.create()
		        .title("No Selection")
		        .masthead("No Person Selected")
		        .message("Please select a person in the table.")
		        .showWarning();
		}
    	
    }
    
    public void handleSearch() {
    	Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");

          stmt = c.createStatement();
          String sql = "CREATE TABLE Medicine " +
                       "(ID INT PRIMARY KEY     NOT NULL," +
                       " NAME           TEXT    NOT NULL, " + 
                       " Amout          INT     NOT NULL, " + 
                       " Price          INT, " + 
                       " Details        CHAR(50))"; 
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Table created successfully");
    	
    }
    
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
    	display();
    	MedicineID.setCellValueFactory(cellData -> cellData.getValue().getMID());
    	MedicineName.setCellValueFactory(cellData -> cellData.getValue().getMName());
    	MedicinePrice.setCellValueFactory(cellData -> cellData.getValue().getPrice());
    	MedicineQuatity.setCellValueFactory(cellData -> cellData.getValue().getAmount());
    	medicineList.getItems().setAll(data);
    	
    }
    public void addMedicine(medicine medicine) {
    	Connection c = null;
        Statement stmt = null;
        data.add(medicine);
        medicineList.getItems().clear();
        medicineList.getItems().setAll(data);
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
          c.setAutoCommit(false);

          stmt = c.createStatement();
          String sql = "INSERT INTO Medicine (ID,NAME,Amout,Price,Details) " +
                  "VALUES ("+medicine.getMID().intValue()+", '"+medicine.getMName().getValue()+"', "+medicine.getAmount().intValue()+", "+medicine.getPrice().intValue()+", '"+medicine.getDescription().getValue()+"' );";
          System.out.print(sql);
          stmt.executeUpdate(sql);
          c.commit();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }
    public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}
    public void display() {
    	Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
            c.setAutoCommit(false);

          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Medicine;" );//ID,NAME,Amout,Price,Details
          while ( rs.next() ) {
            
             data.add(new medicine(rs.getInt("ID"),rs.getString("NAME"),rs.getInt("Price"),rs.getInt("Amout"),rs.getString("Details")));

          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
