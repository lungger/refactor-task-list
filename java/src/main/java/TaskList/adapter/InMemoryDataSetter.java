package TaskList.adapter;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;
import TaskList.entity.ToDoList;
import TaskList.useCase.AddProject;
import TaskList.useCase.AddTask;
import TaskList.useCase.SetTaskDone;

public class InMemoryDataSetter implements AddProject, AddTask, SetTaskDone {

    private ToDoList toDoList;

    public InMemoryDataSetter(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
    @Override
    public void addProject(Project project) {
        toDoList.addProject(project);
    }

    @Override
    public String addTask(ProjectName projectName, String description) {
        return toDoList.addTask(projectName, description);
    }

    @Override
    public String setTaskDone(String id, boolean done) {
        return toDoList.setTaskDone(id, done);
    }
}
