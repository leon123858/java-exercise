package Command;

import Service.FileService;

public interface Command {
    void execute(FileService fileService);
}
