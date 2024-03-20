package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;

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
        long id = getProject.getTheNumberOfAllProjectTasks() + 1;
        project.addTask(id, new Task(id, description, false));
        return null;
    }
}
