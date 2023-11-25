import java.util.ArrayList;
import java.util.List;


public class Component {
    private final ArrayList<Component> children;
    private final String type;

    public Component(String type) {
        this.type = type;
        children = new ArrayList<>();
    }

    public Boolean isGroup() {
        return this.type.equals("Group");
    }

    public void add(Component component) {
        children.add(component);
    }

    public List<Component> getChildren() {
       return children;
    }

    public void dfs() {
        this.print();
        if(!this.isGroup()) {
            return;
        }
        this.biPrint(0);
        for (Component child : this.getChildren()) {
            child.dfs();
            this.biPrint(2);
        }
        this.biPrint(1);
    }

    private void print() {
        System.out.print(type);
    }

    private void biPrint(int stage) {
        switch (stage) {
            case 0:
                System.out.print(":{");
                break;
            case 1:
                System.out.print("}");
                break;
            case 2:
                System.out.print(" ");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + stage);
        }
    }
}
