import java.time.LocalDateTime;

public class CheckOut {
    private Staff staff;
    private Borrower borrower;
    private Book book;
    private LocalDateTime time;

    public CheckOut(Staff staff, Borrower borrower, Book book, LocalDateTime time) {
        this.staff = staff;
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

    public Staff getStaff() {
        return staff;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
