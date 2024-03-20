package TaskList.io;

import TaskList.useCase.AddProjectUseCase;
import TaskList.useCase.AddTaskUseCase;
import TaskList.useCase.CheckAndUnCheckUseCase;
import TaskList.useCase.ShowUseCase;

public interface Configuration {
    AddProjectUseCase getAddProjectUseCase();
    AddTaskUseCase getAddTaskUseCase();
    ShowUseCase getShowUseCase();
    CheckAndUnCheckUseCase getCheckAndUnCheckUseCase();
}
