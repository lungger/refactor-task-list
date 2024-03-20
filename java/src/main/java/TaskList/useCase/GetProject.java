package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.ProjectName;

import java.util.List;

public interface GetProject {
    Project getProject(ProjectName name);

    List<Project> getAllProject();

    long getTheNumberOfAllProjectTasks();
}
