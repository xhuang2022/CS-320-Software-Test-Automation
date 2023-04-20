import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactInfor.ContactService;

class ContactServiceTest {

	//check to make sure contact is added to the map with correct contact information
	@Test
	void testaddContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		
		contactService.addContact("test2","Mary", "Hugh", "3020194738", 
				"18 Roy St, Boston, MA 018899");

		assertEquals("test1", contactService.getContact("test1").getID());
		assertEquals("Mary", contactService.getContact("test2").getfirstName());
		assertEquals("Camp", contactService.getContact("test1").getlastName());
		assertEquals("3020194738", contactService.getContact("test2").getphoneNum());
		assertEquals("128 Roy St, Boston, MA 018899", contactService.getContact("test1").getaddress());
	}
	
	//check the duplication id error handling
	@Test
	void testduplicateID() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
		});
	}
	
	/*check remove contact methods. After removing it successfully, it should be 
	  null when I use to getContact to search it in the map
	*/
	@Test
	void testremoveContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		contactService.removeContact("test1");
		
		assertNull(contactService.getContact("test1"));
	}
	
	//check update methods for first name, last name, phone numbers, and address
	@Test
	void testUpdateFirstName() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		String newFirstName = "Mary";
		contactService.updateFirstName("test1", newFirstName);
		assertEquals("Mary", contactService.getContact("test1").getfirstName());
	}

	@Test
	void testUpdateLastName() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		String newLastName = "Mary";
		contactService.updateLastName("test1", newLastName);
		assertEquals("Mary", contactService.getContact("test1").getlastName());
	}
	
	@Test
	void testupdatePhoneNum() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		String updateNums = "88888888";
		contactService.updatePhoneNum("test1", updateNums);
		assertEquals("88888888", contactService.getContact("test1").getphoneNum());
	}
	
	@Test
	void testupdateAddress() {
		ContactService contactService = new ContactService();
		contactService.addContact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		String updateAddress = "8 Ellis St, Reading MA 000999";
		contactService.updateAddress("test1", updateAddress);
		assertEquals("8 Ellis St, Reading MA 000999", contactService.getContact("test1").getaddress());
	}
	
	// tests to check for error handling for the update variables. 
	@Test
	void testUpdateFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String newFirstName = "Mary1234556yy5";
			contactService.updateFirstName("test1", newFirstName);
		});
	}
	
	@Test
	void testUpdateNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String newFirstName = null;
			contactService.updateFirstName("test1", newFirstName);
		});
	}
	
	@Test
	void testUpdateLasttNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String newLastName = "Mary12345678";
			contactService.updateLastName("test1", newLastName);
		});
	}
	
	@Test
	void testUpdateNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String newLastName = null;
			contactService.updateLastName("test1", newLastName);
		});
	}
	@Test
	void testUpdatePhoneNumToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String updateNums = "888888888888888";
			contactService.updatePhoneNum("test1", updateNums);
		});
	}
	
	@Test
	void testUpdateNullPhoneNum() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String updateNums = null;
			contactService.updatePhoneNum("test1", updateNums);
		});
	}
	
	@Test
	void testUpdateAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String updateAddress = "8 Ellis St, Reading MA 00099912345555555555556";
			contactService.updateAddress("test1", updateAddress);
		});
	}
	
	@Test
	void testUpdateNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			contactService.addContact("test1","Lea", "Camp", "1234569876", 
					"128 Roy St, Boston, MA 018899");
			String updateAddress = null;
			contactService.updateAddress("test1", updateAddress);
		});
	}
}
