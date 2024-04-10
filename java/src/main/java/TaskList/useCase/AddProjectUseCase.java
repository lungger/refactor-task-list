package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;

public class AddProjectUseCase {
    private AddProject addProject;

    public AddProjectUseCase(AddProject addProject) {
        this.addProject = addProject;
    }

    public void execute(String name) {
        addProject.addProject(new Project(ProjectName.of(name)));
    }
}
