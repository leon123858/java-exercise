import java.util.ArrayList;
import java.util.List;


public class Component implements IComponent {
    private final ArrayList<IComponent> children;
    private final String type;

    public Component(String type) {
        this.type = type;
        children = new ArrayList<>();
    }

    public void add(IComponent component) {
        children.add(component);
    }

    public List<IComponent> getChildren() {
        return children;
    }

    public void dfs() {
        System.out.print(type);
        System.out.print(":{");
        for (IComponent child : this.getChildren()) {
            child.dfs();
            System.out.print(" ");
        }
        System.out.print("}");
    }
}
