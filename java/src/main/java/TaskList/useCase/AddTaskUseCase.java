package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;
import TaskList.entity.TaskId;

import static java.lang.System.lineSeparator;

public class AddTaskUseCase {
    private GetProject getProject;

    public AddTaskUseCase(GetProject getProject) {
        this.getProject = getProject;
    }

    public String execute(ProjectName projectName, String description) {
        Project project = getProject.getProject(projectName);
        if (project == null) {
            return "Could not find a project with the name \"" + projectName + "\"." + lineSeparator();
        }
        TaskId id = TaskId.of(getProject.getTheNumberOfAllProjectTasks() + 1);
        project.addTask(id, new Task(id, description, false));
        return null;
    }
}
