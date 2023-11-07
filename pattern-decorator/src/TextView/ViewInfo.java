package TextView;

import java.util.ArrayList;

public class ViewInfo extends ViewDecorator {
    public ViewInfo(View view, String text, String name) {
        super(view, text, name);
    }

    public void draw(ArrayList<String> outputStrings) {
        outputStrings.add(this.text);
        this.view.draw(outputStrings);
    }
}
