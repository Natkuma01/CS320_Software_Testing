package taskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	private TaskService service;
	
	@BeforeEach
	public void setup() {
		service = new TaskService();
	}
	
	// ensure ID is unique
	@Test
	@DisplayName("Add a task successfully with unique ID") 
	public void testAddTask() {
		Task task = new Task("1001", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertEquals("Clean Apt.", service.getTask("1001").getTaskName());
	}
	
	@Test
	@DisplayName("Throw exception when add a Task with existed Task ID")
	public void testDuplicatedTaskID() {
		Task task1 = new Task("1001", "Clean Apt.", "Clean bath tube and kitchen sink");
		Task task2 = new Task("1001", "Wash Clothes", "Wash bed sheet, wash pillow cases");
		service.addTask(task1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	// Delete task
	@Test
	public void deleteTask() {
		Task task = new Task("1002", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		service.deleteTask("1002");
		assertThrows(IllegalArgumentException.class, () -> {
			service.getTask("1002");
		});
	}

	@Test
	@DisplayName("Throw exception when deleting an non existed task")
	public void testDeleteNoTaskID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("9999");
		});
	}

	// update task name and description, but not task ID
	@Test
	@DisplayName("Update task name successfully")
	public void testUpdateTaskName() {
		Task task = new Task("1003", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		service.updateTaskName("1003", "Wash Clothes");
		assertEquals("Wash Clothes", service.getTask("1003").getTaskName());
	}
	
	@Test
	@DisplayName("Update task description successfully")
	public void testUpdateDescription() {
		Task task = new Task("1004", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		service.updateDescription("1004", "Wash Dishes, Wash Towels");
		assertEquals("Wash Dishes, Wash Towels", service.getTask("1004").getDescription());
	}
	
	// The following test cases validate that exceptions are thrown for operations violate defined constraints 
	@Test
	@DisplayName("Throw error when try to update task ID")
	public void testUpdateTaskId() {
		Task task = new Task("1001", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertThrows(UnsupportedOperationException.class, () -> {
			service.updateTaskId("1002");
		});
	}
	
	@Test
	@DisplayName("Throw exception when update task name with invalid Task ID")
	public void edgeCaseUpdateTaskName() {
		Task task = new Task ("1003", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("1170", "Wash Dishes, Wash Towels");
		});
	}
	
	@Test
	@DisplayName("Throw exception when update task description with invalid Task ID")
	public void edgeCaseUpdateDescription() {
		Task task = new Task ("1004", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateDescription("1030", "Wash Dishes, Wash Towels");
		});
	}
	
	@Test
	@DisplayName("Throw exception when update task name with null value")
	public void testUpdateNullName() {
		Task task = new Task ("1004", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("1004", null);
		});
	}
	
	@Test
	@DisplayName("Throw exception when update task description with null value")
	public void testUpdateNullDescription() {
		Task task = new Task ("1004", "Clean Apt.", "Clean bath tube and kitchen sink");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateDescription("1004", null);
		});
	}
	
	
	

	

}
