package Commands;

public class Check extends AbstractCheck {
    String subcommandLine;
    public Check(String args) {
        this.subcommandLine = args;
    }

    @Override
    public void execute() {
        setDone(subcommandLine, true);
    }
}
