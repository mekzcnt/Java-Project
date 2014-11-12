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
	
	public medicine(int MID, String MName,int price,int amount,String description) {
		this.MID = new SimpleIntegerProperty(MID);
		this.MName = new SimpleStringProperty(MName);
		
		// Some initial dummy data, just for convenient testing.
		this.price = new SimpleIntegerProperty(price);
		this.description = new SimpleStringProperty(description);
		this.amount = new SimpleIntegerProperty(amount);
		
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
