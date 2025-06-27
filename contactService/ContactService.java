package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Create
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId()))
			throw new IllegalArgumentException("Contact ID already exists.");
		contacts.put(contact.getContactId(), contact);	
	}
	
	// Get contact through contact ID
	public Contact getContact(String contactId) {
		if (!contacts.containsKey(contactId))
			throw new IllegalArgumentException("Contact ID not found.");
		return contacts.get(contactId);
	}
	
	// update
	public void updateFirstName(String contactId, String firstName) {
		getContact(contactId).setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		getContact(contactId).setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		getContact(contactId).setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		getContact(contactId).setAddress(address);
	}
	
	public void updateContacttId(String taskId) {
		throw new UnsupportedOperationException("Contact ID is immutable.");
	}
	
	// delete
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId))
			throw new IllegalArgumentException("Contact ID not found.");
		contacts.remove(contactId);
	}
}
