package editor;

import editor.Element;
import editor.IBreakStrategy;

import java.util.ArrayList;

public class SimpleComposition implements IBreakStrategy {
    public void print(ArrayList<Element> arr) {
        for (Element element : arr) {
            System.out.printf("[%d]%s%n", element.naturalSize, element.content);
        }
    }
}
