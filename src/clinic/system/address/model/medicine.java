package clinic.system.address.model;

public class medicine {
	private int MID;
	private String MName;
	private int price;
	private String description;
	private int amount;
	
	
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setMID(int mID) {
		MID = mID;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMID() {
		return MID;
	}
	
}
