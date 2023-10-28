package editor;

import java.util.ArrayList;
import java.util.Objects;

public class EditHandler implements CommandHandler{
    ArrayList<Element> dataArray;
    EditHandler(ArrayList<Element> data) {
        dataArray = data;
    }
    public void handle(String[] args) {
        // args => [ComponentID] [NewSize]
        assert args.length == 2;
        int newSize = Integer.parseInt(args[1]);
        assert newSize >= 0;
        for (Element element : dataArray){
            if (Objects.equals(element.componentId, args[0])){
                element.updateSize(newSize);
                return;
            }
        }
        throw new IllegalStateException("Not Found editor.Element with ComponentID: " + args[0] + " in database");
    }
}
