package TaskList.adapter;

import TaskList.entity.ProjectName;
import TaskList.io.Configuration;
import TaskList.useCase.AddProjectUseCase;
import TaskList.useCase.AddTaskUseCase;
import TaskList.useCase.CheckAndUnCheckUseCase;
import TaskList.useCase.ShowUseCase;

public class Controller {
    private final Configuration configuration;
    public Controller(Configuration configuration) {
        this.configuration = configuration;
    }

    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        return switch (command) {
            case "show" -> show();
            case "add" -> add(commandRest[1]);
            case "check" -> check(commandRest[1]);
            case "uncheck" -> uncheck(commandRest[1]);
            case "help" -> help();
            default -> error(command);
        };
    }

    private String show() {
        ShowUseCase useCase = configuration.getShowUseCase();
        return useCase.execute();
    }

    private String add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            return addTask(projectTask[0], projectTask[1]);
        }
        return null;
    }

    private void addProject(String name) {
        AddProjectUseCase useCase = configuration.getAddProjectUseCase();
        useCase.execute(name);
    }

    private String addTask(String project, String description) {
        AddTaskUseCase useCase = configuration.getAddTaskUseCase();
        return useCase.execute(ProjectName.of(project), description);
    }

    private String check(String idString) {
        CheckAndUnCheckUseCase useCase = configuration.getCheckAndUnCheckUseCase();
        return useCase.execute(idString, true);
    }

    private String uncheck(String idString) {
        CheckAndUnCheckUseCase useCase = configuration.getCheckAndUnCheckUseCase();
        return useCase.execute(idString, false);
    }

    private String help() {
        String message = "Commands:" +
                System.lineSeparator() +
                "  show" +
                System.lineSeparator() +
                "  add project <project name>" +
                System.lineSeparator() +
                "  add task <project name> <task description>" +
                System.lineSeparator() +
                "  check <task ID>" +
                System.lineSeparator() +
                "  uncheck <task ID>" +
                System.lineSeparator() +
                System.lineSeparator();
        return message;
    }

    private String error(String command) {
        return "I don't know what the command \"" + command + "\" is." +
                System.lineSeparator();
    }
}
