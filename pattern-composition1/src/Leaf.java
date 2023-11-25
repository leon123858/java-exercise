import java.util.List;

public class Leaf implements IComponent {
    private final String type;

    public Leaf(String type) {
        this.type = type;
    }

    public void add(IComponent component) {
        throw new UnsupportedOperationException();
    }

    public List<IComponent> getChildren() {
        throw new UnsupportedOperationException();
    }

    public void dfs() {
        System.out.print(type);
    }
}
