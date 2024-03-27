package TaskList.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList {
    private List<Project> projects = null;

    public ToDoList() {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

}
