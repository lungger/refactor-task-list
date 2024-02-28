package Commands;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Show extends Command{

    public Show(String args) {

    }
    @Override
    public void execute() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
