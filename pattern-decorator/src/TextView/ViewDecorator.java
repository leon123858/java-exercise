package TextView;

import java.util.ArrayList;

public abstract class ViewDecorator implements View {
    public View view;
    public String name;
    public String text;

    public ViewDecorator(View view, String text, String name) {
        this.view = view;
        this.name = name;
        this.text = text;
    }

    @Override
    public void addElement(Element element) {
        this.view.addElement(element);
    }

    @Override
    public void draw(ArrayList<String> outputStrings) {
        this.view.draw(outputStrings);
    }
}
