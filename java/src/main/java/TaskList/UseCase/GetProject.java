package TaskList.UseCase;

import TaskList.Entity.Project;

import java.util.List;

public interface GetProject {
    Project getProject(String name);

    List<Project> getAllProject();
}
