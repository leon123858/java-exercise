package TextView;

import java.util.ArrayList;

public class TextView {
    private Element[] elements;
    public final String name;
    public final String text;

    public TextView(String name, String text) {
        this.name = name;
        this.text = text;
        this.elements = new Element[0];
    }

    public void addElement(Element element) {
        // check if element name already exists
        for (Element existingElement : this.elements) {
            if (existingElement.getName().equals(element.getName())) {
                throw new IllegalArgumentException("Element name already exists");
            }
        }
        Element[] newElements = new Element[this.elements.length + 1];
        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        newElements[this.elements.length] = element;
        this.elements = newElements;
    }

    public void draw() {
        ArrayList<String> outputStrings = new ArrayList<String>();
        outputStrings.add(this.text);
        for (Element element : this.elements) {
            outputStrings.add(element.getName());
        }
        System.out.println(String.join(" ", outputStrings));
    }
}
