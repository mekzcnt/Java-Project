package clinic.system.address;
//test
//test 17/11/2557
import java.io.IOException;
import java.sql.*;

import clinic.system.address.view.DiseaseOverviewController;
import clinic.system.address.view.MainMenuOverviewController;
import clinic.system.address.view.MedicineOverviewController;
import clinic.system.address.view.ProfileOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

//test again again

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
        
       // this.primaryStage
        
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
			dialogStage.setTitle("Medicine Overview");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);
			//MedicineOverviewController controller = loader.getController();
            //controller.setMainApp(this);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
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
			dialogStage.setTitle("Disease Overview");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);
			//DiseaseOverviewController controller = loader.getController();
            //controller.setMainApp(this);
			
			

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
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
			dialogStage.setTitle("Profile Overview");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);
			//DiseaseOverviewController controller = loader.getController();
            //controller.setMainApp(this);
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			
			
			//Profilecontroller.setMainApp(this);

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
		}
	}
	
	public void showMoneyOverview() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MoneyOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Money Overview");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setWidth(800);
			dialogStage.setHeight(600);
			dialogStage.setResizable(false);
			//DiseaseOverviewController controller = loader.getController();
            //controller.setMainApp(this);
			//dialogStage.
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
		}
	}
	private static void createDatabase() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:CMSDatabase.db");
	      System.out.println("Opened database successfully");

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
	    System.out.println("Table created successfully");
	}
	
	public static void main(String[] args) {
		//createDatabase();
		launch(args);
	}
}
