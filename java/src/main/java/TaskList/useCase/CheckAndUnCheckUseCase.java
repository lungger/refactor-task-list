package TaskList.useCase;

import TaskList.entity.Project;

import static java.lang.System.lineSeparator;

public class CheckAndUnCheckUseCase {
    private GetProject getAllProject;

    public CheckAndUnCheckUseCase(GetProject getAllProject) {
        this.getAllProject = getAllProject;
    }

    public String execute(long id, boolean done) {
        for (Project project: getAllProject.getAllProject()) {
            if (project.checkTaskExist(id)) {
                project.setTaskDone(id, done);
                return null;
            }
        }
        return "Could not find a task with an ID of " + id + "." + lineSeparator();
    }
}
