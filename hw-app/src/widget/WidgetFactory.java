package widget;

public class WidgetFactory extends AbstractFactory {
    @Override
    public WidgetStyle createWidgetStyle(String style) {
        return null;
    }

    public Widget createWidget(String type) {
        return switch (type) {
            case "Window" -> new Window();
            case "ScrollBar" -> new ScrollBar();
            case "Button" -> new Button();
            default -> throw new IllegalArgumentException("Invalid widget type");
        };
    }
}
