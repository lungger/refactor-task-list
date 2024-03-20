package TaskList.io;

import TaskList.entity.Project;
import TaskList.adapter.InMemoryDataLoader;
import TaskList.adapter.InMemoryDataSetter;
import TaskList.useCase.*;

import java.util.ArrayList;
import java.util.List;

public class AppConfiguration implements Configuration {
    private List<Project> projects = new ArrayList<>();

    public AddProjectUseCase getAddProjectUseCase() {
        AddProject addProject = new InMemoryDataSetter(projects);
        return new AddProjectUseCase(addProject);
    }

    public AddTaskUseCase getAddTaskUseCase() {
        GetProject getProject = new InMemoryDataLoader(projects);
        return new AddTaskUseCase(getProject);
    }

    public ShowUseCase getShowUseCase() {
        ShowList showList = new InMemoryDataLoader(projects);
        return new ShowUseCase(showList);
    }

    public CheckAndUnCheckUseCase getCheckAndUnCheckUseCase() {
        GetProject getAllProject = new InMemoryDataLoader(projects);
        return new CheckAndUnCheckUseCase(getAllProject);
    }
}
