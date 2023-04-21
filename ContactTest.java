import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactInfor.Contact;

class ContactTest {

	//check to ensure all contact information are correct
	@Test
	void testContactget() {
		Contact contact1 = new Contact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		assertEquals("test1", contact1.getID());
		assertEquals("Lea", contact1.getfirstName());
		assertEquals("Camp", contact1.getlastName());
		assertEquals("1234569876", contact1.getphoneNum());
		assertEquals("128 Roy St, Boston, MA 018899", contact1.getaddress());		
	}
	
	//check the set and get methods
	@Test
	void testContactset() {
		Contact contact1 = new Contact("test1","Lea", "Camp", "1234569876", 
				"128 Roy St, Boston, MA 018899");
		String newFirstName = "Mary";
		String newLastName = "Moore";
		String newPhoneNum = "234567890";
		String newAddress = "P.O. Box 212, Hampton, NH";
		
		contact1.setfirstName(newFirstName);
		contact1.setlastName(newLastName);
		contact1.setphoneNum(newPhoneNum);
		contact1.setaddress(newAddress);
		
		assertEquals(newFirstName, contact1.getfirstName());
		assertEquals(newLastName, contact1.getlastName());
		assertEquals(newPhoneNum, contact1.getphoneNum());
		assertEquals(newAddress, contact1.getaddress());		
	}

	//following tests are to check the error handling for the variables. 
	@Test
	void testContactClassFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea999999999", "Camp", "1234569876", 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassLasttNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test1", "Lea", "Camp999999999", "1234569876", 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassPhoneNumToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea", "Camp", "1234569876999999999", 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea", "Camp", "1234569876", 
			"128 Roy St, Boston, MA 018899999999999");
		});
	}
	
	@Test
	void testContactClassNullID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null,"Lea", "Camp", "1234569876", 
			"128 Roy St, Boston, MA 018899999999999");
		});
	}
		
	@Test
	void testContactClassNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1",null, "Camp", "1234569876", 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea99", null, "1234569876", 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassNullPhoneNum() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea99", "Leo", null, 
			"128 Roy St, Boston, MA 018899");
		});
	}
	
	@Test
	void testContactClassNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("test1","Lea99", "Leo", "12345666", 
			null);
		});
	}
}
