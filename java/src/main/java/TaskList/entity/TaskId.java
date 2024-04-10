package TaskList.entity;

public record TaskId(String value) {
    public static TaskId of(long id) {
        return new TaskId(String.valueOf(id));
    }

    public static TaskId of(String id) {
        return new TaskId(id);
    }

    @Override
    public String toString(){
        return value;
    }

    public Integer toInteger() {
        return Integer.getInteger(value);
    }
}
