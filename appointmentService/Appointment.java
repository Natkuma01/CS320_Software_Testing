package appointmentService;

import java.util.Date;



public class Appointment {
	
	private final String apptId;
	private Date apptDate;
	private String description;
	
	public Appointment(String apptId, Date apptDate, String description) {
		validateAppointmentId(apptId);
		validateDate(apptDate);
		validateDescription(description);
		
		this.apptId = apptId;
		this.apptDate = apptDate;
		this.description = description;
	}
	
	public String getAppointmentId() { return apptId; }
	public Date getDate() { return apptDate; }
	public String getDescription() { return description; }
	
	public void setDate(Date apptDate) {
		validateDate(apptDate);
		this.apptDate = apptDate;
	}
	
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}
	
	
	private void validateAppointmentId(String apptId) {
		if (apptId == null || apptId.length() >= 11) {
			throw new IllegalArgumentException("Invalid appointment ID.");
		}
	}
	
	private void validateDate(Date apptDate) {
		Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		if (apptDate == null || apptDate.before(yesterday)) {
			throw new IllegalArgumentException("Appointment date cannot be empty or in the past.");
		}
	}
	
	private void validateDescription(String description) {
		if (description == null || description.length() >= 51) {
			throw new IllegalArgumentException("Description is too long or cannot be empty.");
		}
	}

}
