package widget;

public abstract class AbstractFactory {
    public abstract WidgetStyle createWidgetStyle(String style);

    public abstract Widget createWidget(String type);
}
