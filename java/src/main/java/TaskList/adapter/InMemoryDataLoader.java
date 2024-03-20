package TaskList.adapter;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;
import TaskList.useCase.GetProject;
import TaskList.useCase.ShowList;

import java.util.List;

import static java.lang.System.lineSeparator;

public class InMemoryDataLoader implements GetProject, ShowList {
    private List<Project> projects;

    public InMemoryDataLoader(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public Project getProject(ProjectName name) {
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
    public long getTheNumberOfAllProjectTasks() {
        long result = 0;
        for (Project project: projects) {
            result += project.getTheNumberOfTask();
        }
        return result;
    }

    @Override
    public String showList() {
        String result = "";
        for (Project project: projects) {
            result += project.getName().toString() + lineSeparator();
            for (Task task: project.getAllTask().values()) {
                result += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            result += lineSeparator();
        }
        return result;
    }
}
