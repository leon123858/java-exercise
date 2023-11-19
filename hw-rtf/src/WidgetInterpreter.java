import java.util.HashMap;
import java.util.Map;

public class WidgetInterpreter implements Interpreter {
    static private final Map<Character, String> textWidgetRules = new HashMap<>();

    static {
        textWidgetRules.put('C', "<Char>");
        textWidgetRules.put('F', "<Font>");
        textWidgetRules.put('P', "<Paragraph>");
    }

    @Override
    public String interpret(String rtfTokens) {
        String convertedTokens = "";
        for (int i = 0; i < rtfTokens.length(); i++) {
            convertedTokens = convertedTokens.concat(textWidgetRules.get(rtfTokens.charAt(i)));
        }
        return convertedTokens;
    }
}
