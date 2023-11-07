package Command;

import Document.TextDocument;
import Service.FileService;

public class TextCommand implements Command {
    @Override
    public void execute(FileService fileService) {
        fileService.writeDocument(new TextDocument());
    }
}
