package Command;

import Service.ViewService;
import TextView.TextView;
import TextView.View;
import TextView.ViewDecorator;
import TextView.ViewInfo;

public class DefineCommand implements Command {
    String ViewName;
    String ViewText;

    DefineCommand(String[] args) {
        if (args.length != 2) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        ViewName = args[0];
        ViewText = args[1];
    }

    @Override
    public void execute(ViewService viewService) {
        View view = new TextView();
        ViewDecorator textView = new ViewInfo(view, ViewText, ViewName);
        viewService.addView(textView);
    }
}
