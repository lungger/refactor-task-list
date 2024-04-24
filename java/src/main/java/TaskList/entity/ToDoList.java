package TaskList.entity;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.lineSeparator;

public class ToDoList {
    private List<Project> projects = null;

    private final ToDoListId id;

    private long lastId = 0;

    public ToDoList(ToDoListId id) {
        this.id = id;
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        List<Project> readOnlyProjects = new ArrayList<>();
        for (Project project : projects) {
            readOnlyProjects.add(new ReadOnlyProject(project.getName(), project.getAllTask()));
        }
        return readOnlyProjects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public String addTask(ProjectName projectName, String description) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                TaskId id = TaskId.of(++lastId);
                project.addTask(id, new Task(id, description, false));
                return null;
            }
        }
        return "Could not find a project with the name \"" + projectName + "\"." + lineSeparator();
    }

    public String setTaskDone(String id, boolean done) {
        for (Project project: projects) {
            if (project.checkTaskExist(TaskId.of(id))) {
                project.setTaskDone(TaskId.of(id), done);
                return null;
            }
        }
        return "Could not find a task with an ID of " + id + "." + lineSeparator();
    }

}
