package TaskList.entity;

import java.util.HashMap;
import java.util.Map;

public class Project {
    private final ProjectName name;

    private Map<TaskId, Task> tasks = new HashMap<>();

    public Project(ProjectName name) {
        this.name = name;
    }

    public ProjectName getName() {
        return name;
    }

    public Map<TaskId, Task> getAllTask() {
        return tasks;
    }

    public Task getTask(TaskId id) {
        return tasks.get(id);
    }

    public boolean checkTaskExist(TaskId id) {
        return tasks.containsKey(id);
    }

    public void addTask(TaskId id, Task task) {
        tasks.put(id, task);
    }

    public void setTaskDone(TaskId id, boolean done) {
        Task task = tasks.get(id);
        task.setDone(done);
    }

    public long getTheNumberOfTask() {
        return tasks.size();
    }
}
