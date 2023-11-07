package Command;

import Document.DrawDocument;
import Service.FileService;

public class DrawCommand implements Command {
    @Override
    public void execute(FileService fileService) {
        fileService.writeDocument(new DrawDocument());
    }
}
