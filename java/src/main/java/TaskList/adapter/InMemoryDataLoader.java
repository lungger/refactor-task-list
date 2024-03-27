package TaskList.adapter;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;
import TaskList.entity.ToDoList;
import TaskList.useCase.GetProject;
import TaskList.useCase.ShowList;

import java.util.List;

import static java.lang.System.lineSeparator;

public class InMemoryDataLoader implements GetProject, ShowList {
    private ToDoList toDoList;

    public InMemoryDataLoader(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public Project getProject(ProjectName name) {
        for (Project project: toDoList.getProjects()) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProject() {
        return toDoList.getProjects();
    }

    @Override
    public long getTheNumberOfAllProjectTasks() {
        long result = 0;
        for (Project project: toDoList.getProjects()) {
            result += project.getTheNumberOfTask();
        }
        return result;
    }

    @Override
    public String showList() {
        String result = "";
        for (Project project: toDoList.getProjects()) {
            result += project.getName() + lineSeparator();
            for (Task task: project.getAllTask().values()) {
                result += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            result += lineSeparator();
        }
        return result;
    }
}
