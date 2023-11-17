import java.util.ArrayList;

public class VM {
    public static volatile String current_style = "Motif";
    public static volatile ArrayList<Item> data = new ArrayList<>();

    public void create(String widgets_type, String widgets_name){
        data.add(new Item(widgets_name, widgets_type));
    }

    public void style(String widgets_style){
        current_style = widgets_style;
    }

    public void present(){
        System.out.println("present");
    }
}
