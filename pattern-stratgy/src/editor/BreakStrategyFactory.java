package editor;

public class BreakStrategyFactory {
    public static IBreakStrategy getBreakStrategy(BreakStrategy strategy) {
        return switch (strategy) {
            case SimpleComposition -> new SimpleComposition();
            case TexComposition -> new TexComposition();
            case ArrayComposition -> new ArrayComposition();
            default -> throw new IllegalStateException("Unexpected value: " + strategy);
        };
    }
}

