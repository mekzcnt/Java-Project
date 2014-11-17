package clinic.system.address.view;

import java.io.IOException;

import org.controlsfx.dialog.Dialogs;
import clinic.system.address.MainApp;
import clinic.system.address.model.disease;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;
public class DiseaseOverviewController {
	
	private MainApp mainApp;
	
	@FXML
    private TableView<disease> diseaseList;
    @FXML
    private TableColumn<disease, String> diseaseFname;

    @FXML
    private TableColumn<disease, String> diseaseLName;
    
    @FXML
    private TableColumn<disease, Number> diseaseID;

    @FXML
    private TableColumn<disease, String> diseaseName;
    
    @FXML
    private TextField SearchBox; 
    
    private ObservableList<disease> data = FXCollections.observableArrayList();
    private Button AdddiseaseButton;
    
    @FXML
    public void handleADD() {
    	
    	
		try {
			
			
			Stage dialogStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DiseaseAddWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			DiseaseAddWindow controller = loader.getController();
			controller.setDialogStage(dialogStage);
            controller.setMainApp(this);  /////// problem
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
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DiseaseEditWindow.fxml"));
	    	AnchorPane root;
			root = (AnchorPane)loader.load();
			
			DiseaseEditWindowController controller1 = loader.getController();
			controller1.setDialogStage(dialogStage);
            controller1.setMainApp(this);
            controller1.setDisease(diseaseList.getSelectionModel().getSelectedItem());
            
	    	Scene scene = new Scene(root);
	    	dialogStage.setScene(scene);
	    	dialogStage.showAndWait();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
 public void handleDelete() {
 	int selectedIndex = diseaseList.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			
			data.remove(diseaseList.getSelectionModel().getSelectedItem());
			diseaseList.getItems().remove(selectedIndex);
			
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
		      c.setAutoCommit(false);

		      stmt = c.createStatement();
		      String sql = "DELETE from Medicine where ID="+diseaseList.getSelectionModel().getSelectedItem().getID().intValue()+";";
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
       String sql = "SELECT * FROM Disease " +
                    "WHERE NAME LIKE '%"+SearchBox.getText()+"%' OR ID LIKE '%"+SearchBox.getText()+"%';" ;
       
       ResultSet rs = stmt.executeQuery(sql);
       data.clear();
       while ( rs.next() ) {
    	   //String FName,String LName,int ID,String disease,String description
          data.add(new disease(rs.getString("FName"),rs.getString("LName"),rs.getInt("ID"),rs.getString("disease"),rs.getString("description")));

       }
       rs.close();
       stmt.close();
       c.close();
     } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
     }
     diseaseList.getItems().clear();
     diseaseList.getItems().setAll(data);
 	
 }
 @FXML
 private void initialize() {
 	// Initialize the person table with the two columns.
 	display();
 	diseaseID.setCellValueFactory(cellData -> cellData.getValue().getID());
 	diseaseFname.setCellValueFactory(cellData -> cellData.getValue().getFName());
 	diseaseLName.setCellValueFactory(cellData -> cellData.getValue().getLName());
 	diseaseName.setCellValueFactory(cellData -> cellData.getValue().getdisease());
    diseaseList.getItems().setAll(data);
 	
 }
 public void addDisease(disease disease) {
 	
 	Connection c = null;
     Statement stmt = null;
     data.add(disease);
     diseaseList.getItems().clear();
     diseaseList.getItems().setAll(data);
     try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
       c.setAutoCommit(false);

       stmt = c.createStatement();
       String sql = "INSERT INTO Disease (ID,FNAME,LName,Name,Details) " +
               "VALUES ("+disease.getID().intValue()+", '"+disease.getFName().getValue()+"', "+disease.getLName().getValue()+", "+disease.getdisease().getValue()+", '"+disease.getdescription().getValue()+"' );";
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
 public void editDisease(disease disease) {
 	Connection c = null;
     Statement stmt = null;
     
     
     try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
       c.setAutoCommit(false);

       stmt = c.createStatement();
       
       String sql = "UPDATE Disease set FNAME = '"+disease.getFName().getValue()+"', FName = "+disease.getFName().getValue()+" , LName = "+disease.getLName().getValue()+" , Disease = '"+disease.getdisease().getValue()+"'  Description="+disease.getdescription().getValue()+";";
       //System.out.print(sql);
       stmt.executeUpdate(sql);
       c.commit();
       stmt.close();
       c.close();
     } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
     }
     diseaseList.getItems().clear();
     display();
     diseaseList.getItems().setAll(data);
 }
 public void display() {
 	Connection c = null;
     Statement stmt = null;
     try {
     	Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
         c.setAutoCommit(false);

       stmt = c.createStatement();
       ResultSet rs = stmt.executeQuery( "SELECT * FROM Disease;" );//ID,FNAME,LName,Name,Details
       data.clear();
       while ( rs.next() ) {
    	 //String FName,String LName,int ID,String disease,String description
          data.add(new disease(rs.getString("FName"),rs.getString("LName"),rs.getInt("ID"),rs.getString("disease"),rs.getString("description")));

       }
       rs.close();
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
	
}
