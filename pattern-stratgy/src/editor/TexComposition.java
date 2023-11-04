package editor;

import editor.Element;
import editor.ElementPrinter;
import editor.IBreakStrategy;

import java.util.ArrayList;

public class TexComposition implements IBreakStrategy {
    public void print(ArrayList<Element> arr) {
        ArrayList<Element> temp = new ArrayList<>();
        for (Element element : arr) {
            temp.add(element);
            if (element.content.equals("<ParagraphEnd>")) {
                ElementPrinter.printElements(temp);
            }
        }
        ElementPrinter.printLastElement(temp);
    }
}
