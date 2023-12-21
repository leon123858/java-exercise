import java.util.List;

public class AuthorityDecorator extends LibrarySystemDecorator {
    private final UserService userService;

    public AuthorityDecorator(ILibrarySystem librarySystem, UserService userService) {
        super(librarySystem);
        this.userService = userService;
    }

    @Override
    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception {
        var staff = userService.getUserByName(staffName);
        var borrower = userService.getUserByName(borrowerName);

        if (borrower instanceof Staff)
            throw new Exception("Error");

        if (staff instanceof Borrower)
            throw new Exception("Borrower can not check out the books");

        inner.CheckOut(staffName, borrowerName, bookIds);
    }

    @Override
    public void Return(String staffName, int bookId) throws Exception {
        var staff = userService.getUserByName(staffName);

        if (staff instanceof Borrower)
            throw new Exception("Borrower can not return book");

        inner.Return(staffName, bookId);
    }

    @Override
    public void AddBook(String staffName, String author, String subject) throws Exception {
        var staff = userService.getUserByName(staffName);

        if (staff instanceof Borrower)
            throw new Exception("Borrower can not add book");

        inner.AddBook(staffName, author, subject);
    }

    @Override
    public void RemoveBook(String staffName, int bookId) throws Exception {
        var staff = userService.getUserByName(staffName);

        if (staff instanceof Borrower)
            throw new Exception("Borrower can not remove book");

        inner.RemoveBook(staffName, bookId);
    }

    @Override
    public void GetBooksByAuthor(String authorName) {
        inner.GetBooksByAuthor(authorName);
    }

    @Override
    public void GetBooksBySubject(String subjectName) {
        inner.GetBooksBySubject(subjectName);
    }

    @Override
    public void FindChecked(String userName, String findName) throws Exception {
        var user = userService.getUserByName(userName);
        var findUser = userService.getUserByName(findName);

        if (user instanceof Borrower && !user.getName().equals(findUser.getName()))
            throw new Exception("Borrower can not find books checked out by other users");

        inner.FindChecked(userName, findName);
    }

    @Override
    public void GetBorrower(String staffName, int bookId) throws Exception {
        var staff = userService.getUserByName(staffName);

        if (staff instanceof Borrower)
            throw new Exception("Borrower can not find borrower");

        inner.GetBorrower(staffName, bookId);
    }
}
