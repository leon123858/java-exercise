package Command;

import Service.ViewService;
import TextView.Element;
import TextView.ElementType;
import TextView.ScrollBar;
import TextView.ThickBlackBorder;

public class AddCommand implements Command{
    String[] args;
    String ViewName;

    AddCommand(String[] args) {
        this.ViewName = args[0];
        this.args = new String[args.length - 2];
        System.arraycopy(args, 2, this.args, 0, args.length - 2);
    }
    @Override
    public void execute(ViewService viewService) {
        for (String arg : this.args) {
            switch (ElementType.valueOf(arg)) {
                case ElementType.scrollBar:
                    viewService.addViewElement(ViewName, new ScrollBar());
                    break;
                case ElementType.thickBlackBorder:
                    viewService.addViewElement(ViewName, new ThickBlackBorder());
                    break;
            }
        }
    }
}
