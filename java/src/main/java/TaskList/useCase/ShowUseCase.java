package TaskList.useCase;

public class ShowUseCase {
    private ShowList showList;

    public ShowUseCase(ShowList showList) {
        this.showList = showList;
    }

    public String execute() {
        return showList.showList();
    }
}
