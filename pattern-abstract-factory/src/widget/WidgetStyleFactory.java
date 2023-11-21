package widget;

public class WidgetStyleFactory extends AbstractFactory {

    @Override
    public WidgetStyle createWidgetStyle(String style) {
        return switch (style) {
            case "Motif" -> new Motif();
            case "PM" -> new PM();
            default -> throw new IllegalArgumentException("Invalid style");
        };
    }

    @Override
    public Widget createWidget(String type) {
        return null;
    }
}
