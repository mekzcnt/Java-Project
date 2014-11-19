package clinic.system.address.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.controlsfx.dialog.Dialogs;

import clinic.system.address.MainApp;
import clinic.system.address.model.profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainMenuOverviewController {

	// Reference to the main application.
    private MainApp mainApp;

    @FXML
    private TextField MainSearch;
    //test
    
    @FXML
    private ListView<profile> ListSearch;
    private ObservableList<profile> listViewData = FXCollections.observableArrayList();
    
    @FXML
	public void handleMedicine() {
    	mainApp.showMedicineOverview();
    }
    
    public void handleDisease() {
    	mainApp.showDiseaseOverview();
    }
    
    public void handleProfile() {
    	//mainApp.setSearch(MainSearch.getText());
    	mainApp.showProfileOverview();
    }
    
    public void handlemoney() {
    	mainApp.showMoneyOverview();
    }
    

    @FXML
    private void initialize() {
    	ListSearch.setItems(listViewData);
    	ListSearch.setCellFactory((list) -> {
    	    return new ListCell<profile>() {
    	        @Override
    	        protected void updateItem(profile item, boolean empty) {
    	            super.updateItem(item, empty);

    	            if (item == null || empty) {
    	                setText(null);
    	            } else {
    	                setText(item.getFName().getValue() + " " + item.getLName().getValue());
    	            }
    	        }
    	    };
    	});
    	
    }
    
    public void handleSearch() {
    	if (MainSearch.getText().isEmpty()) {
    		ListSearch.setVisible(false);
    	}
    	else {
    		ListSearch.setVisible(true);
    		listViewData.add(new profile("Lydia", "Kunz",1,"",1,"","","","",1,1,1,1,"",""));
    		listViewData.add(new profile("Anna", "Best",1,"",1,"","","","",1,1,1,1,"",""));
    		listViewData.add(new profile("Stefan", "Meier",1,"",1,"","","","",1,1,1,1,"",""));
    		listViewData.add(new profile("Martin", "Mueller",1,"",1,"","","","",1,1,1,1,"",""));
        	//ListSearch.setItems(FXCollections.observableList(values));
    	}
    	
    }
    
    public void handleSubmit() {
    	System.out.print("ss");
    	System.out.print(ListSearch.getSelectionModel().getSelectedItem().getFName().getValue());
    	MainSearch.setText("");
    	handleSearch();
    }

	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}

}