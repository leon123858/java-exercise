import java.util.UUID;

public class Book {
    private int id;
    private String author;
    private String subject;
    private BookStatus status;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return id + " Author: " + author + " Subject: " + subject;
    }
}
