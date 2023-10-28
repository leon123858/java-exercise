package editor;

import java.util.ArrayList;

public class ElementHandler implements CommandHandler{
    ArrayList<Element> dataArray;
    ElementHandler(ArrayList<Element> data) {
        dataArray = data;
    }
    public void handle(String[] args) {
        // args =>  [ComponentID] [NaturalSize] [Shrinkability] [Stretchability] [Content]
        Element.Builder builder = new Element.Builder();
        builder.componentId(args[0]);
        builder.naturalSize(Integer.parseInt(args[1]));
        builder.shrinkability(Integer.parseInt(args[2]));
        builder.stretchability(Integer.parseInt(args[3]));
        builder.content(args[4]);
        Element element = builder.build();
        dataArray.add(element);
    }
}
