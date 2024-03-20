package TaskList.io;

import TaskList.adapter.Controller;
import TaskList.entity.ProjectName;
import TaskList.entity.Task;
import TaskList.useCase.AddProjectUseCase;
import TaskList.useCase.AddTaskUseCase;
import TaskList.useCase.CheckAndUnCheckUseCase;
import TaskList.useCase.ShowUseCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;

    private AppConfiguration configuration;

    private Controller controller;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        this.configuration = new AppConfiguration();
        this.controller = new Controller(configuration);
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            String result = controller.execute(command);
            if (result != null) {
                out.print(result);
            }
        }
    }
}
