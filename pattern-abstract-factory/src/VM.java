import widget.AbstractFactory;
import widget.FactoryProducer;
import widget.Widget;

import java.util.ArrayList;

public class VM {
    public static volatile String current_style = "Motif";
    public static volatile ArrayList<Widget> data = new ArrayList<>();

    private final AbstractFactory widgetFactory;
    private final AbstractFactory widgetStyleFactory;

    public VM() {
        widgetFactory = FactoryProducer.getFactory("Widget");
        widgetStyleFactory = FactoryProducer.getFactory("WidgetStyle");
    }

    public void create(String widgets_type, String widgets_name) {
        var widget = widgetFactory.createWidget(widgets_type);
        widget.setName(widgets_name);
        data.add(widget);
    }

    public void style(String widgets_style) {
        current_style = widgets_style;
    }

    public void present() {
        // use Abstract Factory pattern to create widget and which style
        String[] widgetsSeq = {"Window", "ScrollBar", "Button"};
        for (var w : widgetsSeq) {
            for (var widget : data) {
                if (widget.getClass().getSimpleName().equals(w)) {
                    widget.setStyle(widgetStyleFactory.createWidgetStyle(current_style));
                    widget.present();
                }
            }
        }
    }
}
