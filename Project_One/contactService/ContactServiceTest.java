package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

import org.junit.jupiter.api.DisplayName;

class ContactServiceTest {

	private ContactService service;
	
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}
	
	// ensure contact ID is unique
	@Test
	@DisplayName("Add a contact successfully with unique ID")
	public void testAddContactSuccess() {
		Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Ocean St");
        service.addContact(contact);
        assertEquals("John", service.getContact("001").getFirstName());
    }
	
	@Test
	@DisplayName("Throw exception when add a contact with existed contact ID")
	public void testDuplicatedContactID() {
		Contact contact1 = new Contact("002", "Patrick", "Doe", "1234567890", "123 Ocean Street");		
		Contact contact2 = new Contact("002", "Janet", "Bowen", "1234567890", "456 Water Street");
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
	}
	
	// delete contact
	@Test
	@DisplayName("Delete contact successfully by contact ID")
	public void testDeleteContact() {
		Contact contact = new Contact("004", "Patrick", "Doe", "1234567890", "123 Ocean Street");
		service.addContact(contact);
		service.deleteContact("004");
		assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("004");
		});
	}
	
	@Test
	@DisplayName("Throw exception when deleting an non existed contact ID")
	public void testDeleteNoContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
	        service.deleteContact("90348");
	    });
	}
	
	// update first name, last name, phone no., and address, but not the ID
	@Test
	public void testUpdateFirstName() {
		Contact contact = new Contact("005", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(contact);
		service.updateFirstName("005", "Harry");
		assertEquals("Harry", service.getContact("005").getFirstName());
	}
	
	@Test
	public void testUpdateLastName() {
		Contact contact = new Contact("006", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(contact);
		service.updateLastName("006", "Benton");
		assertEquals("Benton", service.getContact("006").getLastName());
	}

	@Test
	public void testUpdatePhone() {
		Contact contact = new Contact("007", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(contact);
		service.updatePhone("007", "3456789012");
		assertEquals("3456789012", service.getContact("007").getPhone());
	}
	
	@Test
	public void testUpdateAddress() {
		Contact contact = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(contact);
		service.updateAddress("008", "4785 Main Ave");
		assertEquals("4785 Main Ave", service.getContact("008").getAddress());
	}
	
	// The following test cases validate that exceptions are thrown for operations violate defined constraints
	@Test
	@DisplayName("Throw error when try to update contact ID")
	public void testUpdateApptId() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(UnsupportedOperationException.class, () -> {
			service.updateContacttId("008");
		});
	}
	
	@Test
	@DisplayName("Throw exception when update last name with invalid contact ID")
	public void testUpdateNonExistContact() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("99999", "Johnson");
		});
	}
	
	@Test
	@DisplayName("Throw exception when update last name with null value")
	public void testUpdateLastNameNull() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("008", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update first name with null value")
	public void testUpdateFirstNameNull() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("008", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update phone no. with null value")
	public void testUpdatePhoneNull() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("008", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update address with null value")
	public void testUpdateAddressNull() {
		Contact person1 = new Contact("008", "Patrick", "Doe", "1234567890", "789 Ocean Street");
		service.addContact(person1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("008", null);
		});
	}
}
