package clinic.system.address.view;

import java.io.IOException;

import clinic.system.address.MainApp;
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
    private TableColumn<?, ?> qulity;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    public void handleADD() {
    	
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
    public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}
}
