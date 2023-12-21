import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelMapDescription {
    private final Map<String, String> map = new HashMap<String, String>();

    public void put(String level, String description) {
        map.put(level, description);
    }

    public String get(String level) {
        return map.get(level);
    }

    public ArrayList<String> getLevels() {
        return new ArrayList<>(map.keySet());
    }
}
