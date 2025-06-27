package appointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AppointmentServiceTest {

	private AppointmentService service;
	private Date date1;
	private Date date2;
	private Date date3;
	
	@BeforeEach
	public void setup() {
		service = new AppointmentService();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2037, Calendar.MAY, 12);
		date1 = cal1.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2046, Calendar.JULY, 28);
		date2 = cal2.getTime();
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(1999, Calendar.MAY, 3);
		date3 = cal3.getTime();
	}
	
	// ensure ID is unique
	@Test
	@DisplayName("Add an appointment successfully with unique ID")
	public void testAddAppt() {
		Appointment appt = new Appointment("2002", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertEquals("2002", service.getAppointment("2002").getAppointmentId());
	}
	
	@Test
	@DisplayName("Throw exception when add an appointment with existed ID")
	public void testDuplicationApptID() {
		Appointment appt1 = new Appointment("2003", date1, "Doctor appointment in ABC Building");
		Appointment appt2 = new Appointment("2003", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appt2);
		});
	}
	
	// delete appointment
	@Test
	@DisplayName("Delete appointment successfully")
	public void testDeleteAppt() {
		Appointment appt = new Appointment("2005", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		service.deletAppointment("2005");
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("2005");
		});
	}
	
	@Test
	@DisplayName("Throw exception when deleting an non existed appointment")
	public void testDeleteNoApptID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deletAppointment("4546745");
		});
	}
	
	// update date and description, but not the ID
	@Test
	@DisplayName("Update the appointment date")
	public void testUpdateDate() {
		Appointment appt = new Appointment("2001", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		service.updateAppointmentDate("2001", date2);
		assertEquals(date2, service.getAppointment("2001").getDate());
	}
	
	@Test
	@DisplayName("Update the description")
	public void testUpdateDescription() {
		Appointment appt = new Appointment("2001", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		service.updateDescription("2001", "Dental appointment in XYZ Building");
		assertEquals("Dental appointment in XYZ Building", service.getAppointment("2001").getDescription());
	}
	
	// The following test cases validate that exceptions are thrown for operations violate defined constraints
	@Test
	@DisplayName("Throw error when try to update appointment ID")
	public void testUpdateApptId() {
		Appointment appt = new Appointment("2001", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertThrows(UnsupportedOperationException.class, () -> {
			service.updateAppointmentId("200");
		});
	}
		
	@Test
	@DisplayName("Throw exception when updating date of invalid appointment ID")
	public void testUpdateNonExistAppt() {
		Appointment appt = new Appointment("2001", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAppointmentDate("99", date2);
		});
	}
	
	@Test
	@DisplayName("Throw exception when updating a past date")
	public void testeUpdatePastDate() {
		Appointment appt = new Appointment("2006", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAppointmentDate("2006", date3);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update with empty description")
	public void testUpdateNullDescription() {
		Appointment appt = new Appointment("2006", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateDescription("2006", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update with no date input")
	public void testUpdateNullDate() {
		Appointment appt = new Appointment("2006", date1, "Doctor appointment in ABC Building");
		service.addAppointment(appt);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateDescription("2006", null);
		});
	}
}
