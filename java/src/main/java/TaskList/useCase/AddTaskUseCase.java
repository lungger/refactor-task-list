package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;
import TaskList.entity.TaskId;

import static java.lang.System.lineSeparator;

public class AddTaskUseCase {
    private AddTask addTask;

    public AddTaskUseCase(AddTask addTask) {
        this.addTask = addTask;
    }

    public String execute(ProjectName projectName, String description) {
        return addTask.addTask(projectName, description);
    }
}
