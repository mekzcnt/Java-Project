package clinic.system.address.view;

import java.io.IOException;
import clinic.system.address.model.medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.sql.*;

public class MedicineOverviewController {

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
    private TextField SearchBox; 
   
    private ObservableList<medicine> data = FXCollections.observableArrayList();
    @FXML
    private Button AddMedicineButton;
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
	    	Image icon = new Image(getClass().getResourceAsStream("image/CMS-medicine-16x16.png"));
			dialogStage.getIcons().add(icon);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    @FXML
    public void handleEdit() {	
    	int selectedIndex = medicineList.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
		try {
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicineEditWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			
			MedicineEditWindowController controller1 = loader.getController();
			controller1.setDialogStage(dialogStage);
            controller1.setMainApp(this);
            controller1.setMececine(medicineList.getSelectionModel().getSelectedItem());
            
	    	Scene scene = new Scene(root);
	    	Image icon = new Image(getClass().getResourceAsStream("image/CMS-medicine-16x16.png"));
			dialogStage.getIcons().add(icon);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();   	
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
    	
    }
    @FXML
    public void handleDelete() {
    	int selectedIndex = medicineList.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			
			
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
		      data.remove(medicineList.getSelectionModel().getSelectedItem());
		      medicineList.getItems().remove(selectedIndex);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    
			
		}
    }
    @FXML
    public void handleSearch() {
    	Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");

          stmt = c.createStatement();
          String sql = "SELECT * FROM Medicine " +
                       "WHERE NAME LIKE '%"+SearchBox.getText()+"%' OR ID LIKE '%"+SearchBox.getText()+"%';" ;
          
          ResultSet rs = stmt.executeQuery(sql);
          data.clear();
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
        medicineList.getItems().clear();
        medicineList.getItems().setAll(data);
    	
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

    public void editMedicine(medicine medicine) {
    	Connection c = null;
        Statement stmt = null;
        
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
          c.setAutoCommit(false);

          stmt = c.createStatement();
          
          String sql = "UPDATE Medicine set NAME = '"+medicine.getMName().getValue()+"', Amout = "+medicine.getAmount().intValue()+" , Price = "+medicine.getPrice().intValue()+" , Details = '"+medicine.getDescription().getValue()+"'  where ID="+medicine.getMID().intValue()+";";
          stmt.executeUpdate(sql);
          c.commit();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        medicineList.getItems().clear();
        display();
        medicineList.getItems().setAll(data);
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
          data.clear();
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
        
    }
}
