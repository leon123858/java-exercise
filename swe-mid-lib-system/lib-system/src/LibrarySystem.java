import java.time.LocalDateTime;
import java.util.*;

public class LibrarySystem implements ILibrarySystem {
    private final UserService userService;
    private final BookService bookService;
    private final List<CheckOut> checkOutList = new LinkedList<>();

    public LibrarySystem(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception {
        var staff = userService.getUserByName(staffName);
        var borrower = userService.getUserByName(borrowerName);

        if (bookIds.size() > ((Borrower)borrower).getBorrowBookLimit())
            throw new Exception("Can not check out since the number of books exceed the limitation of user can check-out");

        var borrowBooks = new LinkedList<Book>();
        for (var id : bookIds) {
            var book = bookService.GetBookById(id);

            if (book.getIsCheckedOut())
                throw new Exception("Can not check out since the book is checked out");

            borrowBooks.add(book);
        }

        var borrowTime = LocalDateTime.now();

        for (var book : borrowBooks) {
            var checkout = new CheckOut((Staff) staff, (Borrower) borrower, book, borrowTime);
            checkOutList.add(checkout);
        }
    }

    public void Return(String staffName, int bookId) throws Exception {
        var book = bookService.GetBookById(bookId);

        if (!book.getIsCheckedOut())
            throw new Exception("Can not return since the book isn't checked out");

        book.returnBook();
        checkOutList.removeIf(c -> c.getBook().equals(book));
    }

    public void AddBook(String staffName, String author, String subject) {
        bookService.AddBook(author, subject);
    }

    public void RemoveBook(String staffName, int bookId) throws Exception {
        bookService.RemoveBook(bookId);
    }

    public void GetBooksByAuthor(String authorName) {
        bookService.GetBooksByAuthor(authorName);
    }

    public void GetBooksBySubject(String subjectName) {
        bookService.GetBooksBySubject(subjectName);
    }

    public void FindChecked(String userName, String findName) throws Exception {
        var findUser = userService.getUserByName(findName);

        for (var c : checkOutList) {
            if (c.getBorrower().equals(findUser))
                System.out.println(c.getBook());
        }
    }

    public void GetBorrower(String staffName, int bookId) {
        for(var c : checkOutList) {
            if (c.getBook().getId() == bookId) {
                System.out.println("User: " + c.getBorrower().getName());
            }
        }
    }

}
