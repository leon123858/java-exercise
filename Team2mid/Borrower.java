public class Borrower extends User {
    private final int borrowBookLimit;

    public Borrower(String name, int borrowBookLimit) {
        super(name);
        this.borrowBookLimit = borrowBookLimit;
    }

    public int getBorrowBookLimit() {
        return borrowBookLimit;
    }
}
