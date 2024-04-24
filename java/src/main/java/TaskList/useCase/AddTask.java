package TaskList.useCase;

import TaskList.entity.ProjectName;

public interface AddTask {
    String addTask(ProjectName projectName, String description);
}
