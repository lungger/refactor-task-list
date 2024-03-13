package TaskList.Repository;

import TaskList.Entity.Project;
import TaskList.Entity.Task;
import TaskList.UseCase.GetProject;
import TaskList.UseCase.ShowList;

import java.util.List;
import java.util.Map;

import static java.lang.System.lineSeparator;

public class InMemoryDataLoader implements GetProject, ShowList {
    private List<Project> projects;

    public InMemoryDataLoader(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public Project getProject(String name) {
        for (Project project: projects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProject() {
        return projects;
    }

    @Override
    public String showList() {
        String result = "";
        for (Project project: projects) {
            result += project.getName() + lineSeparator();
            for (Task task: project.getAllTask().values()) {
                result += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            result += lineSeparator();
        }
        return result;
    }
}
