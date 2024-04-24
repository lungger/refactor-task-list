package TaskList.useCase;

import TaskList.entity.Project;
import TaskList.entity.TaskId;

import static java.lang.System.lineSeparator;

public class CheckAndUnCheckUseCase {
    private SetTaskDone setTaskDone;

    public CheckAndUnCheckUseCase(SetTaskDone setTaskDone) {
        this.setTaskDone = setTaskDone;
    }

    public String execute(String id, boolean done) {
        return setTaskDone.setTaskDone(id, done);
    }
}
