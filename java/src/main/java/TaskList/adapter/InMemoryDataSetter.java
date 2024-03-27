package TaskList.adapter;

import TaskList.entity.Project;
import TaskList.entity.ToDoList;
import TaskList.useCase.AddProject;

import java.util.List;

public class InMemoryDataSetter implements AddProject {

    private ToDoList toDoList;

    public InMemoryDataSetter(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
    @Override
    public void addProject(Project project) {
        toDoList.addProject(project);
    }
}
