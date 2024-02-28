package Commands;

public class Uncheck extends AbstractCheck {
    String subcommandLine;
    public Uncheck(String args) {
        this.subcommandLine = args;
    }

    @Override
    public void execute() {
        setDone(subcommandLine, false);
    }
}
