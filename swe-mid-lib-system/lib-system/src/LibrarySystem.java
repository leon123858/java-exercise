import java.util.*;

public class LibrarySystem implements ILibrarySystem {
    private final UserService userService;
    private final List<Book> bookList;
    private final List<CheckOut> checkOutList = new LinkedList<>();

    public LibrarySystem(List<Book> initialBooks, UserService userService) {
        bookList = initialBooks;
        this.userService = userService;
    }

    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception {
        var staff = userService.getUserByName(staffName);
        var borrower = userService.getUserByName(borrowerName);

        if (bookIds.size() > ((Borrower)borrower).getBorrowBookLimit())
            throw new Exception("Can not check out since the number of books exceed the limitation of user can check-out");

        var borrowBooks = new LinkedList<Book>();
        for (var id : bookIds) {
            var book = bookList.stream()
                    .filter(b -> b.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (book == null)
                throw new Exception("No such book");

            if (book.getStatus() == BookStatus.CheckedOut)
                throw new Exception("Can not check out since the book is checked out");

            borrowBooks.add(book);
        }

        for (var book : borrowBooks) {
            var checkout = new CheckOut((Staff) staff, (Borrower) borrower, book);
            checkOutList.add(checkout);
        }
    }

    public void Return(String staffName, int bookId) throws Exception {
        var book = bookList.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);

        if (book == null)
            throw new Exception("No such book");

        if (book.getStatus() == BookStatus.Avaliable)
            throw new Exception("Can not return since the book isn't checked out");

        book.returnBook();
        checkOutList.removeIf(c -> c.getBook().equals(book));
    }

    public void AddBook(String staffName, String author, String subject) {
        var newId = bookList.size();
        var newBook = new Book(newId, author, subject);
        bookList.add(newBook);
    }

    public void RemoveBook(String staffName, int bookId) {
        bookList.removeIf(b -> (b.getId() == bookId));
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

    public void findChecked(String userName, String findName) {

    }

    public void GetBorrower(String staffName, int bookId) {
        for(var c : checkOutList) {
            if (c.getBook().getId() == bookId) {
                System.out.println("User: " + c.getBorrower().getName());
            }
        }
    }

}
