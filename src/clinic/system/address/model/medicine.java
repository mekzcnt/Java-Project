package clinic.system.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class medicine {
	private final IntegerProperty MID;
	private final StringProperty MName;
	private final IntegerProperty price;
	private final StringProperty description;
	private final IntegerProperty amount;
	
	public medicine(String firstName, String lastName) {
		this.MID = new SimpleIntegerProperty(1234);
		this.MName = new SimpleStringProperty(lastName);
		
		// Some initial dummy data, just for convenient testing.
		this.price = new SimpleIntegerProperty(1234);
		this.description = new SimpleStringProperty(lastName);
		this.amount = new SimpleIntegerProperty(1234);
		
	}
	
	public IntegerProperty getMID() {
		return MID;
	}
	public StringProperty getMName() {
		return MName;
	}
	public IntegerProperty getPrice() {
		return price;
	}
	public StringProperty getDescription() {
		return description;
	}
	public IntegerProperty getAmount() {
		return amount;
	}
	
	
}
