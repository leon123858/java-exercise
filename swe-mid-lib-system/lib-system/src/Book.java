import java.util.UUID;

public class Book {
    private int id;
    private String author;
    private String subject;
    private BookStatus status;

    public Book(int id, String author, String subject) {
        this.id = id;
        this.author = author;
        this.subject = subject;
        status = BookStatus.Avaliable;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public void checkOut() {
        status = BookStatus.CheckedOut;
    }

    public void returnBook() {
        status = BookStatus.Avaliable;
    }

    @Override
    public String toString() {
        return id + " Author: " + author + " Subject: " + subject;
    }

    public BookStatus getStatus() {
        return status;
    }
}
