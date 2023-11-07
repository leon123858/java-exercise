package TextView;

import java.util.ArrayList;

public class TextView implements View {
    private final ArrayList<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        for (Element existingElement : this.elements) {
            if (existingElement.getName().equals(element.getName())) {
                throw new IllegalArgumentException("Element name already exists");
            }
        }
        this.elements.add(element);
    }

    public void draw(ArrayList<String> outputStrings) {
        for (Element element : this.elements) {
            outputStrings.add(element.getName());
        }
        System.out.println(String.join(" ", outputStrings));
    }
}
