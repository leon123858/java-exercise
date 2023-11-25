import java.util.List;

public interface IComponent {
    void add(IComponent component);

    List<IComponent> getChildren();

    void dfs();
}
