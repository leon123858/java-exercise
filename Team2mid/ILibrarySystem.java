import java.util.List;

public interface ILibrarySystem {
    void CheckOut(String staffName, String borrowerName, List<Integer> bookIds) throws Exception;

    void Return(String staffName, int bookId) throws Exception;

    void AddBook(String staffName, String author, String subject) throws Exception;

    void RemoveBook(String staffName, int bookId) throws Exception;

    void GetBooksByAuthor(String authorName);

    void GetBooksBySubject(String subjectName);

    void FindChecked(String userName, String findName) throws Exception;

    void GetBorrower(String staffName, int bookId) throws Exception;
}
