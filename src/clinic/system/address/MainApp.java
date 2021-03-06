package clinic.system.address;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import clinic.system.address.view.MainMenuOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private String search;
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getSearch() {
		return this.search;
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Clinic Mangement System");
        this.primaryStage.setResizable(false);
        
        initRootLayout();
        showMainMenuOverview();
        
        
	}

	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            Image icon = new Image(getClass().getResourceAsStream("view/image/CMS-icon.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showMainMenuOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainMenuOverview.fxml"));
            AnchorPane MainMenuOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(MainMenuOverview);
            
            MainMenuOverviewController controller = loader.getController();
            controller.setMainApp(this);
       
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showMedicineOverview() {
		try {
			
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MedicineOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Medicine");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Image icon = new Image(getClass().getResourceAsStream("view/image/medicine-16x16.png"));
			dialogStage.getIcons().add(icon);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);

			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showDiseaseOverview() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/DiseaseOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Disease");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Image icon = new Image(getClass().getResourceAsStream("view/image/disease-16x16.png"));
			dialogStage.getIcons().add(icon);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);

			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showProfileOverview() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ProfileOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Profile");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Image icon = new Image(getClass().getResourceAsStream("view/image/CMS-patient.png"));
			dialogStage.getIcons().add(icon);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);

			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	public void showMoneyOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MoneyOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Money");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void createDatabase() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	      

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Profile " +
	                   "(ID 			INT PRIMARY KEY     NOT NULL," +
	                   " FIRSTNAME      TEXT    NOT NULL, " + 
	                   " LASTNAME       TEXT    NOT NULL, " + 
	                   " Birthday       TEXT    NOT NULL, " +
	                   " ADDRESS       	TEXT    NOT NULL, " + 
	                   " CITY       	TEXT    NOT NULL, " + 
	                   " Canton       	TEXT    NOT NULL, " + 
	                   " District       TEXT    NOT NULL, " + 
	                   " Province       TEXT    NOT NULL, " + 
	                   " ZIP       		INT    NOT NULL, " + 
	                   " Weight       	INT    NOT NULL, " + 
	                   " Height       	INT    NOT NULL, " + 
	                   " Pressure       INT , " +
	                   " CongenitalDisease TEXT, " +
	                   " Disease       	TEXT) ";
	      stmt.executeUpdate(sql);
	      sql = "CREATE TABLE Medicine " +
                  "(ID 			INT PRIMARY KEY     NOT NULL," +
                  " NAME      	TEXT    NOT NULL, " + 
                  " Amout       INT    NOT NULL, " + 
                  " Price       INT, " +
                  " Details     CHAR(50)) " ; 

	      stmt.executeUpdate(sql);
	      sql = "CREATE TABLE Disease " +
                  "(ID 			INT NOT NULL," +
                  " disease     TEXT, " +
                  " description TEXT) " ; 

	      stmt.executeUpdate(sql);
	      sql = "CREATE TABLE Money " +
                  "(ID 			INT PRIMARY KEY     NOT NULL," +
                  " disease     TEXT, " +
                  " description TEXT) " ; 

	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	   ;
	}
	
	public static void main(String[] args) {
		File f = new File("CMSDatabase.db");
		if(!f.exists()) { 
			createDatabase();
		}
		
		launch(args);
	}
}
