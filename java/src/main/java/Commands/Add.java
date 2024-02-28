package Commands;

import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Add extends Command {
    String subcommandLine;

    static long lastId = 0;

    public Add(String args) {
        this.subcommandLine = args;
    }

    @Override
    public void execute() {
        String[] subcommandRest = subcommandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(++lastId, description, false));
    }

    public static void resetLastId() {
        lastId = 0;
    }
}
