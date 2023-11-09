import java.util.UUID;

public class Book {
    private int id;
    private String author;
    private String subject;
    private boolean isCheckedOut;

    public Book(int id, String author, String subject) {
        this.id = id;
        this.author = author;
        this.subject = subject;
        isCheckedOut = false;
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
        isCheckedOut = true;
    }

    public void returnBook() {
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return id + " Author: " + author + " Subject: " + subject;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }
}
