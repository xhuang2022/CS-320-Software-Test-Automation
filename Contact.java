package ContactInfor;

public class Contact {
	//declare the variables for Contact class
	//declare final for contactID so it can't be change
	 private final String contactID;
	 private String firstName;
	 private String lastName;
	 private String phoneNum;
	 private String address;	 

	//create constructor and define the parameters.
	public Contact(String contactID, String firstName, String lastName, String phoneNum, 
			String address) {
		
		//declare the requirement for the parameters. The variable can not be empty or
		//greater than 10 length
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invaild contactID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invaild first name");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invaild last name");
		}
		
		if (phoneNum == null || phoneNum.length() > 10) {
			throw new IllegalArgumentException("Invaild phone number");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invaild address");
		}
		//after the parameters requirement passed, set the variables with the values.
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	//declare get and set methods for the class
	public String getID() {
		return contactID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public  String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public  String getphoneNum() {
		return phoneNum;
	}
	
	public void setphoneNum(String nums) {		
		this.phoneNum = nums;
	}
	
	public  String getaddress() {
		return address;
	}
	
	public void setaddress(String address) {
		this.address = address;
	}

}
