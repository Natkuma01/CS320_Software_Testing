package appointmentService;

import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	private Date futureDate;
	private Date todayDate;
	private Date pastDate;
	
	
	@BeforeEach
	void setup() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2037, Calendar.MAY, 12);
		futureDate = cal1.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -2);
		pastDate = cal2.getTime();
		
		Calendar cal3 = Calendar.getInstance();
		todayDate = cal3.getTime();
	}

	// Check Appointment Date
	@Test
	@DisplayName("Create Appointment Successfully with future date")
	public void testApptCreationDate1() {
		Appointment appt = new Appointment("2001", futureDate, "Doctor appointment at ABC Building");
		assertEquals("2001", appt.getAppointmentId());
		assertEquals(futureDate, appt.getDate());
		assertEquals("Doctor appointment at ABC Building", appt.getDescription());
	}
	
	@Test
	@DisplayName("Create Appointment on today's date")
	public void testApptCreationDate2() {
		Appointment appt = new Appointment("2001", todayDate, "Doctor appointment at ABC Building");
		assertEquals("2001", appt.getAppointmentId());
		assertEquals(todayDate, appt.getDate());
		assertEquals("Doctor appointment at ABC Building", appt.getDescription());
	}
	
	@Test
	@DisplayName("Throw exception when create appointment with past date")
	public void testApptCreationDate3() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("2001", pastDate, "Doctor appointment at ABC Building");
		});
	}
	
	
	// Check Appointment ID
	@Test
	@DisplayName("Create Appointment ID with 10 digit limit")
	public void testApptID10() {
			Appointment appt = new Appointment("1234567890", futureDate, "Doctor appointment at ABC Building");
			assertEquals("1234567890", appt.getAppointmentId());
	}
	
	@Test
	@DisplayName("Create Appointment ID with 9 digit")
	public void testApptID9() {
			Appointment appt = new Appointment("123456789", futureDate, "Doctor appointment at ABC Building");
			assertEquals("123456789", appt.getAppointmentId());
	}
	
	@Test
	@DisplayName("Throw exception when appointment ID is null")
	public void testApptIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "Doctor appointment at ABC Building");
		});
	}
	
	@Test
	@DisplayName("Throw exception when appointment ID is 11 digit")
	public void testApptIDLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123445678901", futureDate, "Doctor appointment at ABC Building");
		});
	}
	
	// Check Appointment Description
	@Test
	@DisplayName("Create Appointment description with 50 character limit")
	public void testdescription50() {
		Appointment appt = new Appointment("2002", futureDate, "Doctor appointment at ABCDE Building, 13784rd room");
		assertEquals("Doctor appointment at ABCDE Building, 13784rd room", appt.getDescription());
	}
	
	@Test
	@DisplayName("Create Appointment description with 49 characters")
	public void testdescription49() {
		Appointment appt = new Appointment("2002", futureDate, "Doctor appointment at ABCDE Building, 13784rd roo");
		assertEquals("Doctor appointment at ABCDE Building, 13784rd roo", appt.getDescription());
	}
	
	@Test
	@DisplayName("Throw exception when description is null")
	public void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("2002", futureDate, null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when description is 51 characters")
	public void testDescription51() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("2002", futureDate, "Doctor appointment at ABCDE Building, 13784rd room!");
		});
	}
	

	
	
	
	
}
