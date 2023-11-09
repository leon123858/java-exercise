import java.time.LocalDateTime;

public class CheckOut {
    private final Borrower borrower;
    private final Book book;
    private final LocalDateTime time;

    public CheckOut(Borrower borrower, Book book, LocalDateTime time) {
        this.borrower = borrower;
        this.book = book;
        this.time = time;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
