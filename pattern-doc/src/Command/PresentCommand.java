package Command;

import Service.FileService;

public class PresentCommand implements Command {
    @Override
    public void execute(FileService fileService) {
        fileService.presentDocument();
    }
}
