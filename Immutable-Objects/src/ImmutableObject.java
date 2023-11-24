import java.util.List;

public class ImmutableObject {
    private final int id;
    private final String name;
    private final List<String> list;

    private ImmutableObject(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.list = builder.list;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }

    public static class Builder {
        private int id;
        private String name;
        private List<String> list;

        public Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        @SuppressWarnings("UnusedReturnValue")
        public Builder setList(List<String> list) {
            this.list = list;
            return this;
        }

        public ImmutableObject build() {
            return new ImmutableObject(this);
        }
    }
}