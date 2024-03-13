package TaskList.UseCase;

import TaskList.Entity.Project;

public class AddProjectUseCase {
    private AddProject addProject;

    public AddProjectUseCase(AddProject addProject) {
        this.addProject = addProject;
    }

    public void execute(String name) {
        addProject.addProject(new Project(name));
    }
}
