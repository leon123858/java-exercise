import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public void AddUser(String type, String name, int borrowLimit) throws Exception {
        if (userMap.containsKey(name))
            throw new Exception("Error");

        var newUser = switch (type) {
            case "Staff" -> new Staff(name);
            case "Borrower" -> new Borrower(name, borrowLimit);
            default -> throw new Exception("Error");
        };

        userMap.put(name, newUser);
    }

    public User getUserByName(String name) throws Exception {
        var targetUser = userMap.getOrDefault(name, null);

        if (targetUser == null)
            throw new Exception("Error");

        return targetUser;
    }
}
