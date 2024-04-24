package TaskList.entity;

import java.util.Map;

public class ReadOnlyProject extends Project {
    private final Map<TaskId, Task> tasks;
    public ReadOnlyProject(ProjectName name, Map<TaskId, Task> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void setTaskDone(TaskId id, boolean done) {
        throw new RuntimeException("Cannot modify task because it is readonly");
    }

    @Override
    public Map<TaskId, Task> getAllTask() {
        return tasks;
    }
}
