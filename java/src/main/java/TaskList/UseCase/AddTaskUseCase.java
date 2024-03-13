package TaskList.UseCase;

import TaskList.Entity.Project;
import TaskList.Entity.Task;

public class AddTaskUseCase {
    private GetProject getProject;

    public AddTaskUseCase(GetProject getProject) {
        this.getProject = getProject;
    }

    public String execute(String projectName, String description, long id) {
        Project project = getProject.getProject(projectName);
        if (project == null) {
            return "Could not find a project with the name \"" + projectName + "\".";
        }

        project.addTask(id, new Task(id, description, false));
        return null;
    }
}
