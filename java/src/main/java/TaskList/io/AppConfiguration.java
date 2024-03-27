package TaskList.io;

import TaskList.entity.Project;
import TaskList.adapter.InMemoryDataLoader;
import TaskList.adapter.InMemoryDataSetter;
import TaskList.entity.ToDoList;
import TaskList.useCase.*;

import java.util.ArrayList;
import java.util.List;

public class AppConfiguration implements Configuration {
    private ToDoList toDoList = new ToDoList();

    public AddProjectUseCase getAddProjectUseCase() {
        AddProject addProject = new InMemoryDataSetter(toDoList);
        return new AddProjectUseCase(addProject);
    }

    public AddTaskUseCase getAddTaskUseCase() {
        GetProject getProject = new InMemoryDataLoader(toDoList);
        return new AddTaskUseCase(getProject);
    }

    public ShowUseCase getShowUseCase() {
        ShowList showList = new InMemoryDataLoader(toDoList);
        return new ShowUseCase(showList);
    }

    public CheckAndUnCheckUseCase getCheckAndUnCheckUseCase() {
        GetProject getAllProject = new InMemoryDataLoader(toDoList);
        return new CheckAndUnCheckUseCase(getAllProject);
    }
}
