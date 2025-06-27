package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Create
	public void addTask(Task task) {
		if (tasks.containsKey(task.getTaskId()))
			throw new IllegalArgumentException("Task ID already exists");
		tasks.put(task.getTaskId(), task);
	}
	
	// Delete
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId))
			throw new IllegalArgumentException("Task ID does not exists");
		tasks.remove(taskId);
	}
	
	// Get Task through Task ID
	public Task getTask(String taskId) {
		if (!tasks.containsKey(taskId))
			throw new IllegalArgumentException("Task does not exists");
		return tasks.get(taskId);
	}
	
	// Update
	public void updateTaskName(String taskId, String taskName) {
		getTask(taskId).setTaskName(taskName);
	}
	
	public void updateDescription(String taskId, String description) {
		getTask(taskId).setDescription(description);
	}
	
	public void updateTaskId(String taskId) {
		throw new UnsupportedOperationException("Task ID is immutable.");
	}
	
}