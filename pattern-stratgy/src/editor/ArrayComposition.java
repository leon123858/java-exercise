package editor;

import java.util.ArrayList;

public class ArrayComposition implements IBreakStrategy{
    public void print(ArrayList<Element> arr) {
        ArrayList<Element> temp = new ArrayList<>();
        for (Element element : arr) {
            temp.add(element);
            if (temp.size() == 3) {
                ElementPrinter.printElements(temp);
            }
        }
        ElementPrinter.printLastElement(temp);
    }
}
