package clinic.system.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class disease {
	private final StringProperty FName;
	private final StringProperty LName;
	private final IntegerProperty ID;
	private final StringProperty disease;
	private final StringProperty description;
	
	public disease(String FName, String LName, int ID, String disease, String description) {
		this.FName = new SimpleStringProperty(FName);
		this.LName = new SimpleStringProperty(LName);
		this.ID = new SimpleIntegerProperty(ID);
		this.disease = new SimpleStringProperty(disease);
		this.description = new SimpleStringProperty(description);
	}
	public StringProperty getFName() {
		return FName;
	}
	public StringProperty getLName() {
		return LName;
	}
	public IntegerProperty getID() {
		return ID;
	}
	public StringProperty getdisease() {
		return disease;
	}
	
	public StringProperty getdescription() {
		return description;
	}
}
