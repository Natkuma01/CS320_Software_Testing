package taskService;

public class Task{
	
	private final String taskId;
	private String taskName;
	private String description;
	
	public Task(String taskId, String taskName, String description) {
		validateTaskId(taskId);
		validateTaskName(taskName);
		validateDescription(description);
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
	}
	
	public String getTaskId() {return taskId; }
	public String getTaskName() { return taskName; }
	public String getDescription() {return description; }
	
	public void setTaskName(String taskName) {
		validateTaskName(taskName);
		this.taskName = taskName;
	}
	
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}
	
	public void validateTaskId(String taskId) {
		if (taskId == null || taskId.length() >= 11) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
	}
	
	public void validateTaskName(String taskName) {
		if (taskName == null || taskName.length() >= 21) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
	}
	
	public void validateDescription(String description) {
		if (description == null || description.length() >= 51) {
			throw new IllegalArgumentException("Description cannot be empty or more than 50 characters");
		}
	}
}