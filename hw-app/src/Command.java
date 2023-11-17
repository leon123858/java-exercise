import java.util.Objects;

public class Command {
    public type command_type;
    public String widgets_type;
    public String widgets_name;
    public String widgets_style;

    public Command(String str) {
        // split str into array of strings
        var arr = str.split(" ");
        if (arr.length > 2 || arr.length < 1) {
            throw new IllegalArgumentException("wrong number arguments");
        }
        if (arr.length == 2) {
            // create
            command_type = type.CREATE;
            widgets_type = arr[0];
            widgets_name = arr[1];
            return;
        }
        String tmp = arr[0];
        if (Objects.equals(tmp, "Present")) {
            command_type = type.PRESENT;
            return;
        }
        // style
        command_type = type.STYLE;
        widgets_style = arr[0];
    }

    public void execute(VM vm) {
        switch (command_type) {
            case CREATE:
                vm.create(widgets_type, widgets_name);
                break;
            case STYLE:
                vm.style(widgets_style);
                break;
            case PRESENT:
                vm.present();
                break;
        }
    }

    public enum type {
        CREATE,
        STYLE,
        PRESENT
    }
}
