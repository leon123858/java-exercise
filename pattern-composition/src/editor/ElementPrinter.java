package editor;

import java.util.ArrayList;

public class ElementPrinter {
    public static void printElements(ArrayList<Element> arr){
        ArrayList<String> output = new ArrayList<>();
        for (Element innerElement : arr) {
            output.add(String.format("[%d]%s", innerElement.naturalSize, innerElement.content));
        }
        System.out.println(String.join(" ", output));
        arr.clear();
    }

    public static void printLastElement(ArrayList<Element> arr){
        if(!arr.isEmpty()){
            printElements(arr);
        }
    }
}
