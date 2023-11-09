import java.util.*;

public class LibrarySystem {
    private List<User> userList;
    private List<Book> bookList;
    private List<CheckOut> checkOutList = new LinkedList<>();

    public LibrarySystem(List<Book> initialBooks, List<User> initialUsers) {
        userList = initialUsers;
        bookList = initialBooks;
    }

    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception {
        var staff = getUserByName(staffName);
        var borrower = getUserByName(borrowerName);

        if (staff instanceof Borrower)
            throw new Exception("");
    }

    public void Return(String staffName, int bookId) {

    }

    public void AddBook(String staffName, String author, String subject) {

    }

    public void RemoveBook(int bookId) {

    }

    public void GetBooksByAuthor(String authorName) {
        for (var b : bookList) {
            if (Objects.equals(b.getAuthor(), authorName))
                System.out.println(b);
        }
    }

    public void GetBooksBySubject(String subjectName) {
        for (var b : bookList) {
            if (Objects.equals(b.getSubject(), subjectName))
                System.out.println(b);
        }
    }

    public void LastCheckedOut(String staffName, String userName) {

    }

    public void GetBorrower(int bookId) {
        for(var c : checkOutList) {
            if (c.book.getId() == bookId) {
                System.out.println("User: " + c.borrower.getName());
            }
        }
    }

    private User getUserByName(String name) throws Exception {
        for (var u : userList) {
            if (u.getName().equals(name)) {
                return u;
            }
        }

        throw new Exception("No such user.");
    }
}
