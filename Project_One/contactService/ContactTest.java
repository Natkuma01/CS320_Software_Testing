package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {

	@Test
	@DisplayName("Should create contact successfully with valid parameters")
	public void testValidContactCreation() {
		Contact contact = new Contact("001", "Patrick", "Doe", "1234567890", "123 Ocean Street");
		assertEquals("001", contact.getContactId());
		assertEquals("Patrick", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Ocean Street", contact.getAddress());
	}
	
	// check contact ID
	@Test
	@DisplayName("Throw exception when contact ID is null")
	public void testContactIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Patrick", "Doe", "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Throw exception when contact ID is 11 digit")
	public void testContactID11() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Patrick", "Doe", "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Create contact ID with 10 digits")
	public void testContactID10() {
		Contact person1 = new Contact("1234567890", "Patrick", "Smith", "1234567890", "123 Ocean Street");
		assertEquals("1234567890", person1.getContactId());
	}
	
	@Test
	@DisplayName("Create contact ID with 9 digit")
	public void testContactId9() {
		Contact person1 = new Contact("123456789", "Patrick", "Smith", "1234567890", "123 Ocean Street");
		assertEquals("123456789", person1.getContactId());
				
	}
	
	// check first name
	@Test
	@DisplayName("Throw exception when first name is null")
	public void testFirstNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", null, "Doe", "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Throw exception when first name has 11 characters")
	public void testFirstName11() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrickkkkk", "Doe", "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Create contact with 10-character first name")
	public void testFirstName10() {
	Contact person1 = new Contact("001", "Patrickkkk", "Doe", "1234567890", "123 Ocean Street");
		assertEquals("Patrickkkk", person1.getFirstName());
	}
	
	@Test
	@DisplayName("Create contact with 9-character first name")
	public void testFirstName9() {
	Contact person1 = new Contact("001", "Patrickkk", "Doe", "1234567890", "123 Ocean Street");
		assertEquals("Patrickkk", person1.getFirstName());
	}
	
	// check last name
	@Test
	@DisplayName("Throw exception when last name is null")
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrick", null, "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Throw exception when last name is 11 characters")
	public void testLastName11() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("001", "Patrick", "Johnsonnnnn", "1234567890", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Create contact with 10-character last name")
	public void testLastName10() {
		Contact person1 = new Contact("001", "Patrick", "Johnsonnnn", "1234567890", "123 Ocean Street");
		assertEquals("Johnsonnnn", person1.getLastName());
	}
	
	@Test
	@DisplayName("Create contact with 9-character last name")
	public void testLastName9() {
		Contact person1 = new Contact("001", "Patrick", "Johnsonnn", "1234567890", "123 Ocean Street");
		assertEquals("Johnsonnn", person1.getLastName());
	}
	
	// check phone number
	@Test
	@DisplayName("Throw exception when phone number is null")
	public void testPhoneNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrick", "Doe", null, "123 Ocean Street");
		});
	}
	
	
	@Test
	@DisplayName("Throw exception when phone number is 9 digits")
	public void testPhone9() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrick", "Doe", "123456789", "123 Ocean Street");
		});
	}
	
	@Test
	@DisplayName("Create contact with 10 digit phone number")
	public void testPhone10() {
		Contact person1 = new Contact("001", "Patrick", "Doe", "1234567890", "123 Ocean Street");
		assertEquals("1234567890", person1.getPhone());
	}
	
	@Test
	@DisplayName("Throw exception when phone number is 11 digits")
	public void testPhone11() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrick", "Doe", "12345678901", "123 Ocean Street");
		});
	}
	
	// check address
	@Test
	@DisplayName("Throw exception when address is null")
	public void testAddressNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Patrick", "Doe", "1234567890", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when address is 31 characters")
	public void testAddress31() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("001", "Patrick", "Doe", "1234567890", "123456789 Ocean Street, apt 12,");
		});
	}
	
	@Test
	@DisplayName("Create Contact with 30-character address")
	public void testAddress30() {
    Contact person1 = new Contact("001", "Patrick", "Doe", "1234567890", "123456789 Ocean Street, apt 12");
		assertEquals("123456789 Ocean Street, apt 12", person1.getAddress());
		}
	
	
	@Test
	@DisplayName("Create Contact with 29-character address") 
	public void testAddress29() {
	    Contact person1 = new Contact("001", "Patrick", "Doe", "1234567890", "123456789 Ocean Street, apt 1");
	    assertEquals("123456789 Ocean Street, apt 1", person1.getAddress());
	}
}

