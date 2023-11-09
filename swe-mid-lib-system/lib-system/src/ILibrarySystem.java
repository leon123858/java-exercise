import java.util.List;

public interface ILibrarySystem {
    public void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception;

    public void Return(String staffName, int bookId) throws Exception;

    public void AddBook(String staffName, String author, String subject) throws Exception;

    public void RemoveBook(String staffName, int bookId) throws Exception;

    public void GetBooksByAuthor(String authorName);

    public void GetBooksBySubject(String subjectName);

    public void FindChecked(String userName, String findName) throws Exception;

    public void GetBorrower(String staffName, int bookId) throws Exception;
}
