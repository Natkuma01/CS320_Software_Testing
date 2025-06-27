package taskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	@DisplayName("Create Task Sucessfully")
	public void testValidateTaskCreation() {
		Task task = new Task("1001", "Clean Apt.", "Clean bath tube and kitchen sink");
		assertEquals("1001", task.getTaskId());
		assertEquals("Clean Apt.", task.getTaskName());
		assertEquals("Clean bath tube and kitchen sink", task.getDescription());
	}

	// check Task ID
	@Test
	@DisplayName("Throw exception when task ID is null")
	public void testTaskIDNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Clean Apt.", "Clean bath tube and kitchen sink");
		});
	}
	
	@Test
	@DisplayName("Create Task ID with 10 digit limit")
	public void testTaskID10() {
		Task task = new Task ("1234567890", "Clean Apt.", "Clean bath tube and kitchen sink");
		assertEquals("1234567890", task.getTaskId());
	}
	@Test
	@DisplayName("Throw exception when task ID is 11 digits")
	public void testTaskID11() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Clean Apt.", "Clean bath tube and kitchen sink");
		});
	}
	
	@Test
	@DisplayName("Create Task with 9 digit task ID")
	public void testTaskID9() {
		Task task = new Task("123456789", "Clean Apt.", "Clean bath tube and kitchen sink");
		assertEquals("123456789", task.getTaskId());
	}
	
	// check Task Name	
	@Test
	@DisplayName("Throw exception when Task Name is null")
	public void testTaskNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1001", null, "Clean bath tube and kitchen sink");
		});
	}
	
	@Test
	@DisplayName("Create Task Name successfully with 20 chacaters limit")
	public void testTaskName20() {
		Task task = new Task("1001", "Clean clean clean cl", "Clean bath tube and kitchen sink");
		assertEquals("Clean clean clean cl", task.getTaskName());
	}
	
	@Test
	@DisplayName("Create Task Name successfully with 19 chacaters limit")
	public void testTaskName19() {
		Task task = new Task("1001", "Clean clean clean c", "Clean bath tube and kitchen sink");
		assertEquals("Clean clean clean c", task.getTaskName());
	}
		
	@Test
	@DisplayName("Throw exception when Task Name is 21 characters") 
	public void testTaskName21() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1001", "Clean the entire apar", "Clean bath tube and kitchen sink");
		});
	}
	
	// check Task Description	
	@Test
	@DisplayName("Throw exception when description is null")
	public void testDescriptionNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1001", "Clean Apt.", null);
		});
	}

	@Test
	@DisplayName("Create Description successfully with 49 characters")
	public void testTaskName49() {
		Task task = new Task("1001", "Clean Apt.", 
				"Bacon ipsum dolor amet ham hock biltong pork chop");
		assertEquals("Bacon ipsum dolor amet ham hock biltong pork chop", task.getDescription());
	}
	
	
	@Test
	@DisplayName("Create Description successfully with 50 characters limit")
	public void testTaskName50() {
		Task task = new Task("1001", "Clean Apt.", 
				"Bacon ipsum dolor amet ham hock biltong pork chop ");
		assertEquals("Bacon ipsum dolor amet ham hock biltong pork chop ", task.getDescription());
	}
	
	@Test
	@DisplayName("Throw exception when description is 51 characters")
	public void testTaskName51() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1001", "Clean Apt.", 
					"Bacon ipsum dolor amet ham hock biltong pork chop u");
		});
	}
	

	
	
}
