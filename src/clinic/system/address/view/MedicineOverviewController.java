package clinic.system.address.view;

import java.io.IOException;

import clinic.system.address.MainApp;
import clinic.system.address.model.medicine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class MedicineOverviewController {

    
	private MainApp mainApp;
    @FXML
    private TableColumn<medicine, String> MedicineID;

    @FXML
    private TableColumn<medicine, String> MedicineName;
    
    @FXML
    private TableColumn<medicine, String> MedicinePrice;

    @FXML
    private TableColumn<medicine, String> MedicineQuatity;

    @FXML
    private TextField search; 

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

   
    }
    public void addMedicine(medicine medicine) {
    	Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
          c.setAutoCommit(false);

          stmt = c.createStatement();
          String sql = "INSERT INTO Medicine (ID,NAME,Amout,Price,Details) " +
                  "VALUES ("+medicine.getMID()+", '"+medicine.getMName()+"', "+medicine.getAmount()+", "+medicine.getPrice()+", '"+medicine.getDescription()+"' );";
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
             int id = rs.getInt("ID");
             String  name = rs.getString("NAME");
             int amout  = rs.getInt("Amout");
             int price  = rs.getInt("Price");
             String  Details = rs.getString("Details");
            
             System.out.println( "ID = " + id );
             System.out.println( "NAME = " + name );
             System.out.println( "AGE = " + amout );
             System.out.println( "ADDRESS = " + price );
             System.out.println( "SALARY = " + Details );
             System.out.println();
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
