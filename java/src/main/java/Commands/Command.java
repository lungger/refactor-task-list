package Commands;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Command {
    protected PrintWriter out;
    protected Map<String, List<Task>> tasks;

    public void set(PrintWriter out) {
        this.out = out;
    }

    public void set(Map<String, List<Task>> tasks) {
        this.tasks = tasks;
    }

    public void execute() {

    }
}
