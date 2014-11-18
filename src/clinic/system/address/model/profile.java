package clinic.system.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class profile {
	//private final IntegerProperty MID;
	private final StringProperty FName;
	private final StringProperty LName;
	private final IntegerProperty ID;
	private final StringProperty Birthday; // dd/mm/yy
	private final IntegerProperty Old;
	private final StringProperty Address;
	private final StringProperty Canton;//aumper
	private final StringProperty District; //tumbon
	private final StringProperty Province; //jungwod
	private final IntegerProperty MailAddress;
	private final IntegerProperty Weight;
	private final IntegerProperty Height;
	private final IntegerProperty Pressure;
	private final StringProperty CongenitalDisease;
	private final StringProperty Disease;
	
	public profile(String FName, String LName, int ID, String Birthday, int Old, String Address, String Canton,
			String District, String Province, int MailAddress, int Weight, int Height, int Pressure, 
			String CongenitalDisease, String Disease){
		this.FName = new SimpleStringProperty(FName);
		this.LName = new SimpleStringProperty(LName);
		this.ID =  new SimpleIntegerProperty(ID);
		this.Birthday = new SimpleStringProperty(Birthday);
		this.Old = new SimpleIntegerProperty(Old);
		this.Address = new SimpleStringProperty(Address);
		this.Canton = new SimpleStringProperty(Canton);
		this.District = new SimpleStringProperty(District);
		this.Province = new SimpleStringProperty(Province);
		this.MailAddress = new SimpleIntegerProperty(MailAddress);
		this.Weight = new SimpleIntegerProperty(Weight);
		this.Height = new SimpleIntegerProperty(Height);
		this.Pressure = new SimpleIntegerProperty(Pressure);
		this.CongenitalDisease = new SimpleStringProperty(CongenitalDisease);
		this.Disease = new SimpleStringProperty(Disease);
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
	public StringProperty getBirthday() {
		return Birthday;
	}
	public IntegerProperty getOld() {
		return Old;
	}
	public StringProperty getAddress() {
		return Address;
	}
	public StringProperty getCanton() {
		return Canton;
	}
	public StringProperty getDistrict() {
		return District;
	}
	public StringProperty getProvince() {
		return Province;
	}
	public IntegerProperty getMailAddress() {
		return MailAddress;
	}
	public IntegerProperty getWeight() {
		return Weight;
	}
	public IntegerProperty getHeight() {
		return Height;
	}
	public IntegerProperty getPressure() {
		return Pressure;
	}
	public StringProperty getCongenitalDisease() {
		return CongenitalDisease;
	}
	public StringProperty getDisease() {
		return Disease;
	}
}

