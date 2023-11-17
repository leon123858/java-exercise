package widget;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Widget")) {
            return new WidgetFactory();
        } else if (choice.equalsIgnoreCase("WidgetStyle")) {
            return new WidgetStyleFactory();
        }
        throw new IllegalArgumentException("Invalid choice");
    }
}
