package TextView;

import java.util.ArrayList;

public interface View {
    void addElement(Element element);

    void draw(ArrayList<String> outputStrings);
}
