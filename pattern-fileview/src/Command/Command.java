package Command;

import Service.ViewService;

public interface Command {
    void execute(ViewService viewService);
}
