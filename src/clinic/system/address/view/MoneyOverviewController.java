package clinic.system.address.view;

import clinic.system.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MoneyOverviewController {
	
	private MainApp mainApp;
	@FXML
	private TextField search;
    @FXML
    private Button EditButton;

    @FXML
    private TableColumn<?, ?> MoneyDetails;

    @FXML
    private TableColumn<?, ?> MoneyAmount;

    @FXML
    private TextField SearchBox;

    @FXML
    private TableView<?> MoneyTable;

    @FXML
    private Tab TableViewTab;

    @FXML
    private MenuButton MoneyMenu;

    @FXML
    private Tab ChartViewTab;

    @FXML
    private TableColumn<?, ?> MoneyStatus;

    @FXML
    private PieChart DisplayPieChart;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button SearchButton;

    @FXML
    private TableColumn<?, ?> MoneyID;
    public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;

        // Add observable list data to the table

	}

}