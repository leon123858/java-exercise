import java.sql.Timestamp;

public class CheckOut {
    private Staff staff;
    private Borrower borrower;
    private Book book;
    private Timestamp timestamp;

    public CheckOut(Staff staff, Borrower borrower, Book book) {
        this.staff = staff;
        this.borrower = borrower;
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Staff getStaff() {
        return staff;
    }
}
