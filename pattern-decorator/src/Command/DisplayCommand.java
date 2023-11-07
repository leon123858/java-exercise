package Command;

import Service.ViewService;

public class DisplayCommand implements Command {
    String ViewName;

    DisplayCommand(String[] args) {
        this.ViewName = args[0];
    }

    @Override
    public void execute(ViewService viewService) {
        viewService.display(ViewName);
    }
}
