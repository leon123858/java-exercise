package widget;

public class ScrollBar implements Widget {
    WidgetStyle style;
    String name;

    @Override
    public void setStyle(WidgetStyle style) {
        this.style = style;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void present() {
        System.out.println(style.getStyle() + "ScrollBar " + name);
    }
}
