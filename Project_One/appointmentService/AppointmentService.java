package appointmentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	// Create
	public void addAppointment(Appointment appt) {
		if(appointments.containsKey(appt.getAppointmentId()))
			throw new IllegalArgumentException("Appointment ID already exist.");
		appointments.put(appt.getAppointmentId(), appt);
	}
	
	// Get Appointment through Appointment ID
	public Appointment getAppointment(String apptId) {
		if (!appointments.containsKey(apptId))
			throw new IllegalArgumentException("The appointment ID does not exist.");
		return appointments.get(apptId);
	}
	
	// Update
	public void updateAppointmentDate(String apptId,Date apptDate) {
		getAppointment(apptId).setDate(apptDate);
	}
	
	public void updateDescription(String apptId, String description) {
		getAppointment(apptId).setDescription(description);
	}
		
	public void updateAppointmentId(String taskId) {
		throw new UnsupportedOperationException("Appointment ID is immutable.");
	}	
	
	// delete
	public void deletAppointment(String apptId) {
		if(!appointments.containsKey(apptId))
			throw new IllegalArgumentException("The appointment does not exist.");
		appointments.remove(apptId);
	}
}
