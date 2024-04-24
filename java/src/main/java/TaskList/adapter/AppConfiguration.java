package TaskList.adapter;

import TaskList.entity.ToDoList;
import TaskList.entity.ToDoListId;
import TaskList.useCase.*;

public class AppConfiguration implements Configuration {
    private static final ToDoListId DEFAULT_TO_DO_LIST_ID = ToDoListId.of("001");
    private ToDoList toDoList = new ToDoList(DEFAULT_TO_DO_LIST_ID);

    public AddProjectUseCase getAddProjectUseCase() {
        AddProject addProject = new InMemoryDataSetter(toDoList);
        return new AddProjectUseCase(addProject);
    }

    public AddTaskUseCase getAddTaskUseCase() {
        AddTask addTask = new InMemoryDataSetter(toDoList);
        return new AddTaskUseCase(addTask);
    }

    public ShowUseCase getShowUseCase() {
        ShowList showList = new InMemoryDataLoader(toDoList);
        return new ShowUseCase(showList);
    }

    public CheckAndUnCheckUseCase getCheckAndUnCheckUseCase() {
        SetTaskDone setTaskDone = new InMemoryDataSetter(toDoList);
        return new CheckAndUnCheckUseCase(setTaskDone);
    }
}
