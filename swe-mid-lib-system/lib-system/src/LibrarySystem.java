import java.time.LocalDateTime;
import java.util.*;

public class LibrarySystem implements ILibrarySystem {
    private final UserService userService;
    private final BookService bookService;
    private final List<CheckOut> checkOutList = new LinkedList<>();
    private final List<CheckOut> checkOutHistory = new LinkedList<>();

    public LibrarySystem(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception {
        var borrower = userService.getUserByName(borrowerName);

        if (bookIds.size() > ((Borrower) borrower).getBorrowBookLimit())
            throw new Exception("Can not check out since the number of books exceed the limitation of user can check-out");

        var borrowBooks = new HashSet<Book>();
        for (var id : bookIds) {
            var book = bookService.GetBookById(id);

            if (book.getIsCheckedOut())
                throw new Exception("Can not check out since the book is checked out");

            if (borrowBooks.contains(book))
                throw new Exception("Error");

            borrowBooks.add(book);
        }

        var borrowTime = LocalDateTime.now();

        for (var book : borrowBooks) {
            book.checkOut();
            var checkout = new CheckOut((Borrower) borrower, book, borrowTime);
            checkOutList.add(checkout);
        }
    }

    public void Return(String staffName, int bookId) throws Exception {
        var book = bookService.GetBookById(bookId);

        if (!book.getIsCheckedOut())
            throw new Exception("Can not return since the book isn't checked out");

        var checkout = checkOutList.stream()
                .filter(c -> c.getBook().equals(book))
                .findFirst()
                .orElse(null);

        book.returnBook();
        checkOutHistory.add(checkout);
        checkOutList.remove(checkout);
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

        var borrowedBook = new LinkedList<Book>();

        for (var c : checkOutList) {
            if (c.getBorrower().equals(findUser))
                borrowedBook.add(c.getBook());
        }

        var idComparator = Comparator.comparingInt(Book::getId);
        borrowedBook.sort(idComparator);

        for (var b : borrowedBook) {
            System.out.println(b);
        }
    }

    public void GetBorrower(String staffName, int bookId) throws Exception {
        var book = bookService.GetBookById(bookId);
        var checkout = checkOutList.stream()
                .filter(c -> c.getBook().equals(book))
                .findFirst()
                .orElse(null);

        if (checkout != null)
            System.out.println("User: " + checkout.getBorrower().getName());
        else {
            var history = new ArrayList<>(checkOutHistory.stream()
                    .filter(c -> c.getBook().equals(book))
                    .toList());

            if (history.isEmpty()) {
                System.out.println("User: ");
                return;
            }

            var dateTimeComparator = new Comparator<CheckOut>() {
                @Override
                public int compare(CheckOut checkOut1, CheckOut checkOut2) {
                    return checkOut1.getTime().compareTo(checkOut2.getTime());
                }
            };

            history.sort(dateTimeComparator);

            System.out.println("User: " + history.get(history.size() - 1).getBorrower().getName());
        }
    }

}
