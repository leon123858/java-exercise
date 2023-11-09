import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BookService {
    private final List<Book> bookList = new LinkedList<>();

    public void AddBook(String author, String subject) {
        var newId = bookList.size();
        var newBook = new Book(newId, author, subject);
        bookList.add(newBook);
    }

    public void RemoveBook(int bookId) throws Exception {
        var book = bookList.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);

        if (book == null)
            throw new Exception("No such book");

        if (book.getIsCheckedOut())
            throw new Exception("Error");

        bookList.removeIf(b -> (b.getId() == bookId));
    }

    public Book GetBookById(int bookId) throws Exception {
        var book = bookList.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);

        if (book == null)
            throw new Exception("No such book");

        return book;
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
}
