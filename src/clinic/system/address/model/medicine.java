package clinic.system.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class medicine {
	private IntegerProperty MID;
	private StringProperty MName;
	private IntegerProperty price;
	private StringProperty description;
	private IntegerProperty amount;
	private IntegerProperty use;
	
	public medicine(int MID, String MName, int price, int amount, String description) {
		this.MID = new SimpleIntegerProperty(MID);
		this.MName = new SimpleStringProperty(MName);
		this.price = new SimpleIntegerProperty(price);
		this.description = new SimpleStringProperty(description);
		this.amount = new SimpleIntegerProperty(amount);
		
	}
	public IntegerProperty getUse() {
		return use;
	}
	public void setuse(int use) {
		this.use = new SimpleIntegerProperty(use);
		this.amount = new SimpleIntegerProperty(this.amount.intValue()-use);
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
