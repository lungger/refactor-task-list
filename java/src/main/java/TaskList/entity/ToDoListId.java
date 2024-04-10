package TaskList.entity;

public record ToDoListId(String value) {
    public static ToDoListId of(String id) {
        return new ToDoListId(id);
    }
}
