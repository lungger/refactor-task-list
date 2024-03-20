package TaskList.adapter;

import TaskList.entity.Project;
import TaskList.useCase.AddProject;

import java.util.List;

public class InMemoryDataSetter implements AddProject {

    private List<Project> projects;

    public InMemoryDataSetter(List<Project> projects) {
        this.projects = projects;
    }
    @Override
    public void addProject(Project project) {
        projects.add(project);
    }
}
