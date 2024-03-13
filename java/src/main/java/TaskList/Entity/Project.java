package TaskList.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private final String name;

    private Map<Long, Task> tasks = new HashMap<>();

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Long, Task> getAllTask() {
        return tasks;
    }

    public Task getTask(long id) {
        return tasks.get(id);
    }

    public boolean checkTaskExist(long id) {
        return tasks.containsKey(id);
    }

    public void addTask(long id, Task task) {
        tasks.put(id, task);
    }

    public void setTaskDone(long id, boolean done) {
        Task task = tasks.get(id);
        task.setDone(done);
    }
}
