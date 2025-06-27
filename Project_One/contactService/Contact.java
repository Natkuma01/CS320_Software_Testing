package contactService;

public class Contact {

	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		validateContactId(contactId);
		validateFirstName(firstName);
		validateLastName(lastName);
		validatePhone(phone);
		validateAddress(address);

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }


	public void setFirstName(String firstName) {
		validateFirstName(firstName); 
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		validateLastName(lastName); 
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		validatePhone(phone); 
		this.phone = phone;
	}
	public void setAddress(String address) {
		validateAddress(address); 
		this.address = address;
	}


	private void validateContactId(String contactId) {
		if (contactId == null || contactId.length() >= 11) {
			throw new IllegalArgumentException("Invalid Contact ID.");
		}
	}

	private void validateFirstName(String firstName) {
		if (firstName == null || firstName.length() >= 11) {
			throw new IllegalArgumentException("Invalid First Name.");
		}
	}

	private void validateLastName(String lastName) {
		if (lastName == null || lastName.length() >= 11) {
			throw new IllegalArgumentException("Invalid Last Name.");
		}
	}

	private void validatePhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid Phone number.");
		}
	}

	private void validateAddress(String address) {
		if (address == null || address.length() >= 31) { 
			throw new IllegalArgumentException("Invalid Address.");
		}
	}
}