package ContactInfor;

import java.util.HashMap;
import java.util.Map;


public class ContactService{
	//declare Map to store the contact information. contactId as the key
	//and contact object as the values
	Map<String, Contact> contactList = new HashMap<String, Contact>();
	
	public void addContact(String id,String firstName, String lastName, String phoneNum, 
			String address) {
		//before adding the new contact object into map, check if id is duplicate.
		//if not, then go ahead and add the contact into map
		if (contactList.containsKey(id)) {
			throw new IllegalArgumentException("Duplicate contactID, please enter a new contactID.");
		}
		else {
			Contact contact = new Contact(id,firstName, lastName, 
					phoneNum, address);
		
			contactList.put(contact.getID(), contact);	
		}		
	}
	
	//remove method to remove the contact by using the id as the key to search
	public void removeContact(String id) {
		contactList.remove(id);
	}
	
	//declare update methods to update the first name, last name, phone numbers, 
	//and address. First check the update first name
	//meet the requirement before updating the information
	public void updateFirstName (String id,String fName) {
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invaild first name");
		}
		contactList.get(id).setfirstName(fName);
		
	}
	
	public void updateLastName (String id,String lName) {
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invaild last name");
		}

		contactList.get(id).setlastName(lName);
		
	}
	
	public void updatePhoneNum (String id,String nums) {
		if (nums == null || nums.length() > 10) {
			throw new IllegalArgumentException("Invaild phone number");
		}

		contactList.get(id).setphoneNum(nums);
		
	}
	
	public void updateAddress (String id,String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invaild address");
		}
		
		contactList.get(id).setaddress(address);
		
	}
	
	//method use to test the ContactService. 
	public Contact getContact(String id) {
		return contactList.get(id);
	}
	

}
