package Command;

import Service.ViewService;
import TextView.TextView;

public class DefineCommand implements Command{
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
        TextView textView = new TextView(ViewName, ViewText);
        viewService.addView(textView);
    }
}
