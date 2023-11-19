import java.util.HashMap;
import java.util.Map;

public class TexInterpreter implements Interpreter {
    private static final Map<Character, String> texRules = new HashMap<>();

    static {
        // Define conversion rules for TeX
        texRules.put('C', "c");
        texRules.put('F', "_");
        texRules.put('P', "|");
    }

    @Override
    public String interpret(String rtfTokens) {
        String convertedTokens = "";
        for (int i = 0; i < rtfTokens.length(); i++) {
            convertedTokens = convertedTokens.concat(texRules.get(rtfTokens.charAt(i)));
        }

        return convertedTokens;
    }
}
