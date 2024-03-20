package TaskList.entity;

public record ProjectName(String value) {
    public static ProjectName of(String name) {
        return new ProjectName(name);
    }

    @Override
    public String toString(){
        return value;
    }

    public boolean equals(ProjectName name) {
        return value.equals(name.toString());
    }
}
