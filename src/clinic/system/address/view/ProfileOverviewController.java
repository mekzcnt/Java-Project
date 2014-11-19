package clinic.system.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.controlsfx.dialog.Dialogs;

import clinic.system.address.MainApp;
import clinic.system.address.model.medicine;
import clinic.system.address.model.profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	    private TableColumn<profile, String> Name;  

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
	    private TableColumn<profile, Number> ID;

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
	    private TableColumn<profile, String> Surname;

	    @FXML
	    private Label District;

	    @FXML
	    private TableView<profile> profilelist;

	    @FXML
	    private Label BirthDate;
	    
	    private ObservableList<profile> data = FXCollections.observableArrayList();

	    @FXML
	    public void handleADD() {
	    	
	    	
			try {
				
				
				Stage dialogStage = new Stage();
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileAddWindow.fxml"));
		    	AnchorPane root;
				root = (AnchorPane)loader.load();
				ProfileAddWindow controller = loader.getController();
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
	    	int selectedIndex = profilelist.getSelectionModel().getSelectedIndex();
	    	if (selectedIndex >= 0) {
			try {
				
				Stage dialogStage = new Stage();
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileEditWindow.fxml"));
		    	AnchorPane root;
				root = (AnchorPane)loader.load();
				
				ProfileEditWindowController controller1 = loader.getController();
				controller1.setDialogStage(dialogStage);
	            controller1.setMainApp(this);
	            controller1.setProfile(profilelist.getSelectionModel().getSelectedItem());
	        
		    	Scene scene = new Scene(root);
		    	dialogStage.setScene(scene);
		    	dialogStage.showAndWait();
		    	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	}
	    	
	    }
	    @FXML
	    public void handleDelete() {
	    	int selectedIndex = profilelist.getSelectionModel().getSelectedIndex();
	    	
			if (selectedIndex >= 0) {
				
				
				
				Connection c = null;
			    Statement stmt = null;
			    try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
			      c.setAutoCommit(false);

			      stmt = c.createStatement();
			      String sql = "DELETE from Profile where ID="+profilelist.getSelectionModel().getSelectedItem().getID().intValue()+";";
			      System.out.print(sql);
			      stmt.executeUpdate(sql);
			      c.commit();

			      
			      stmt.close();
			      c.close();
			      
			      data.remove(profilelist.getSelectionModel().getSelectedItem());
				  profilelist.getItems().remove(selectedIndex);
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
	    @FXML
	    public void handleSearch() {
	    	Connection c = null;
	        Statement stmt = null;
	        try {
	        	Class.forName("org.sqlite.JDBC");
	            c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	            c.setAutoCommit(false);

	          stmt = c.createStatement();
	          
	          String sql = "SELECT * FROM Profile " +
	                  "WHERE FIRSTNAME LIKE '%"+search.getText()+"%' OR LASTNAME LIKE '%"+search.getText()+"%';" ;
	          
	          ResultSet rs = stmt.executeQuery(sql);
	          data.clear();
	          while ( rs.next() ) {
	            
	        	  data.add(new profile(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),rs.getInt("ID"),rs.getString("Birthday"),10,rs.getString("ADDRESS"),rs.getString("Canton"),
	            		 rs.getString("District"), rs.getString("Province"),rs.getInt("ZIP"),rs.getInt("Weight"),rs.getInt("Height"),rs.getInt("Pressure"), 
	            		 rs.getString("CongenitalDisease"),rs.getString("Disease")));

	          }
	          rs.close();
	          stmt.close();
	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        profilelist.getItems().clear();
	        profilelist.getItems().setAll(data);
	    	
	    }
	    @FXML
	    private void initialize() {
	    	// Initialize the person table with the two columns.
	    	
	    	display();
	    	Name.setCellValueFactory(cellData -> cellData.getValue().getFName());
	    	ID.setCellValueFactory(cellData -> cellData.getValue().getID());
	    	Surname.setCellValueFactory(cellData -> cellData.getValue().getLName());
	   
	    	profilelist.getItems().setAll(data);
	    	
	    }
	    public void addProfile(profile profile) {
	    	
	    	Connection c = null;
	        Statement stmt = null;
	        data.add(profile);
	        profilelist.getItems().clear();
	        profilelist.getItems().setAll(data);
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	          c.setAutoCommit(false);

	          stmt = c.createStatement();
	          String sql = "INSERT INTO Profile (ID,FIRSTNAME,LASTNAME,Birthday,ADDRESS,CITY,Canton,District,Province,ZIP,Weight,Height,Pressure,CongenitalDisease,Disease) " +
	                  "VALUES ("+profile.getID().getValue()+", '"+profile.getFName().getValue()+"', '"+profile.getLName().getValue()+"', '"+profile.getBirthday().getValue()+"', '"+profile.getAddress().getValue()+"', '"+profile.getProvince().getValue()+"', '"+profile.getCanton().getValue()+"', '"+profile.getDisease().getValue()+"', '"+profile.getProvince().getValue()+"', "+profile.getMailAddress().getValue()+", "+profile.getWeight().getValue()+", "+profile.getHeight().getValue()+", "+profile.getPressure().getValue()+", '"+profile.getCongenitalDisease().getValue()+"', '"+profile.getDisease().getValue() +"');";
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
	    public void editProfile(profile profile) {
	    	Connection c = null;
	        Statement stmt = null;
	        
	        
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	          c.setAutoCommit(false);

	          stmt = c.createStatement();
	          
	          String sql = "UPDATE Profile set ID = "+profile.getID().getValue()+
	        		  ", FIRSTNAME = '"+profile.getFName().getValue()+
	        		  "', LASTNAME = '"+profile.getLName().getValue()+
	        		  "', ADDRESS = '"+profile.getAddress().getValue()+
	        		  "', Canton = '"+profile.getCanton().getValue()+
	        		  "', District = '"+profile.getDistrict().getValue()+
	        		  "', Province = '"+profile.getProvince().getValue()+
	        		  "', ZIP = "+profile.getMailAddress().getValue()+
	        		  ", Weight = "+profile.getWeight().getValue()+
	        		  ", Height = "+profile.getHeight().getValue()+
	        		  ", CongenitalDisease = '"+profile.getCongenitalDisease().getValue()+
	        		  "', Disease = '"+profile.getDisease().getValue()+"';";
	          
	          //System.out.print(sql);
	          stmt.executeUpdate(sql);
	          c.commit();
	          stmt.close();
	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        profilelist.getItems().clear();
	        display();
	        profilelist.getItems().setAll(data);
	    }
	    public void display() {
	    	Connection c = null;
	        Statement stmt = null;
	        try {
	        	Class.forName("org.sqlite.JDBC");
	            c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	            c.setAutoCommit(false);

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT * FROM Profile;" );
	          data.clear();
	          while ( rs.next() ) {
	            
	             data.add(new profile(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),rs.getInt("ID"),rs.getString("Birthday"),10,rs.getString("ADDRESS"),rs.getString("Canton"),
	            		 rs.getString("District"), rs.getString("Province"),rs.getInt("ZIP"),rs.getInt("Weight"),rs.getInt("Height"),rs.getInt("Pressure"), 
	            		 rs.getString("CongenitalDisease"),rs.getString("Disease")));

	          }
	          rs.close();
	          stmt.close();
	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        
	    }
	    @FXML
	    public void haddledisplaydetail() {
	    	displaydetail(profilelist.getSelectionModel().getSelectedItem());
	    }
	    private void displaydetail(profile profile) {
	    	Name1.setText(profile.getFName().getValue());
	    	BloodPressure.setText(""+profile.getPressure().getValue());
	    	Address .setText(profile.getAddress().getValue());
	    	PostalCode .setText(""+profile.getMailAddress().getValue());
	    	HistoryDisease .setText(profile.getCongenitalDisease().getValue());
	    	PatientDisease .setText(profile.getDisease().getValue());
	    	Height.setText(""+profile.getHeight().getValue());
	    	Age .setText(""+profile.getOld().getValue());
	    	Surname1.setText(profile.getLName().getValue());
	    	Province.setText(profile.getProvince().getValue());
	    	Weight.setText(""+profile.getWeight().getValue());
	    	SubDistrict .setText(profile.getCanton().getValue());
	    	ID1.setText(""+profile.getID().getValue());
	    	District .setText(profile.getDistrict().getValue());
	    	BirthDate.setText(profile.getBirthday().getValue());
	    }
	 public void setMainApp(MainApp mainApp) {
			// TODO Auto-generated method stub
			this.mainApp = mainApp;

	        // Add observable list data to the table

		}
}
