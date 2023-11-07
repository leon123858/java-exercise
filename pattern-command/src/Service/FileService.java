package Service;
import Document.Document;

import java.util.ArrayList;
import java.util.Objects;

public class FileService {
    public ArrayList<Document> documents;
    public FileService() {
        this.documents = new ArrayList<>();
    }

    public void writeDocument(Document document) {
        this.documents.add(document);
    }

    public void presentDocument() {
        for (Document document : this.documents) {
            document.present();
        }
    }
}
