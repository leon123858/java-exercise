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
        document.write();
        for (Document doc : this.documents) {
            if (Objects.equals(doc.type, document.type)) {
//                System.out.println("Document already exists");
                return;
            }
        }
        this.documents.add(document);
    }

    public void presentDocument() {
        for (Document document : this.documents) {
            document.present();
        }
    }
}
