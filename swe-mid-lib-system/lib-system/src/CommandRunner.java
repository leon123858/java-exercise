import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandRunner {
    public static void run(String path) {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        ILibrarySystem librarySystem = new LibrarySystem(bookService, userService);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Mode mode = Mode.BOOKS_INIT;
            int numInputLine = 0;
            int curNumInputLine = -1;
            String User1 = "";
            String User2 = "";
            while ((line = br.readLine()) != null) {
                if (curNumInputLine == numInputLine) {
                    if (mode == Mode.BOOKS) {
                        mode = Mode.USERS_INIT;
                    } else if (mode == Mode.USERS) {
                        mode = Mode.FUNCTIONS;
                    }
                }
                String[] words = line.split(" ");
                if (words.length == 0) {
                    System.out.println("Empty line");
                }
                switch (mode) {
                    case BOOKS_INIT: {
                        if (words.length != 1) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        // parse number of it
                        int num;
                        try {
                            num = Integer.parseInt(words[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number input");
                            continue;
                        }
                        if (num <= 0) {
                            System.out.println("number should be positive");
                            num = 0;
                        }
                        if (num > 0) {
                            numInputLine = num;
                            curNumInputLine = 0;
                            mode = Mode.BOOKS;
                        }
                        break;
                    }
                    case BOOKS: {
                        if (words.length != 2) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        // add book
                        // [author] [subject]
                        String author = words[0];
                        String subject = words[1];
                        curNumInputLine++;
                        try {
                            bookService.AddBook(author, subject);
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                        break;
                    }
                    case USERS_INIT: {
                        if (words.length != 1) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        // parse number of it
                        int num;
                        try {
                            num = Integer.parseInt(words[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number input");
                            continue;
                        }
                        if (num <= 0) {
                            System.out.println("number should be positive");
                            num = 0;
                        }
                        if (num > 0) {
                            numInputLine = num;
                            curNumInputLine = 0;
                            mode = Mode.USERS;
                        }
                        break;
                    }
                    case USERS: {
                        if (words.length != 3 && words.length != 2) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        if (words.length == 2) {
                            // add user
                            // [user_type] [user_name]
                            String type = words[0];
                            String name = words[1];
                            if(!type.equals("Staff")){
                                System.out.println("Invalid input");
                                continue;
                            }
                            curNumInputLine++;
                            try {
                                userService.AddUser(type, name, 0);
                            } catch (Exception e) {
                                System.out.println("Invalid input");
                            }
                            break;
                        }
                        // add user
                        // [user_type] [user_name] [predefined_borrow_book_number(optional)]
                        String type = words[0];
                        String name = words[1];
                        int predefinedBorrowBookNumber;
                        try {
                            predefinedBorrowBookNumber = Integer.parseInt(words[2]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number input");
                            predefinedBorrowBookNumber = 0;
                        }
                        curNumInputLine++;
                        try {
                            userService.AddUser(type, name, predefinedBorrowBookNumber);
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                        break;
                    }
                    case FUNCTIONS: {
                        if (words.length < 2) {
                            System.out.println("Error");
                            continue;
                        }
                        String command = words[1];
                        switch (command) {
                            case "checkout": {
                                // [user_name1] checkout [user_name2]
                                if (words.length != 3) {
                                    System.out.println("Error");
                                    continue;
                                }
                                mode = Mode.FUNCTION_CALL_CHECKOUT;
                                User1 = words[0];
                                User2 = words[2];
                                break;
                            }
                            case "addBook": {
                                // [user_name1] addBook
                                if (words.length != 2) {
                                    System.out.println("Error");
                                    continue;
                                }
                                mode = Mode.FUNCTION_CALL_ADD_BOOK;
                                User1 = words[0];
                                break;
                            }
                            case "removeBook": {
                                // [user_name1] removeBook [book_id]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                int bookId;
                                try {
                                    bookId = Integer.parseInt(words[2]);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number input");
                                    continue;
                                }
                                try {
                                    librarySystem.RemoveBook(userName, bookId);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "return": {
                                // [user_name1] return [book_id]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                int bookId;
                                try {
                                    bookId = Integer.parseInt(words[2]);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number input");
                                    continue;
                                }
                                try {
                                    librarySystem.Return(userName, bookId);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "listAuthor": {
                                // [user_name1] listAuthor [book_author]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
//                                String userName = words[0];
                                String author = words[2];
                                try {
                                    librarySystem.GetBooksByAuthor(author);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "listSubject": {
                                // [user_name1] listSubject [book_subject]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
//                                String userName = words[0];
                                String subject = words[2];
                                try {
                                    librarySystem.GetBooksBySubject(subject);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "findChecked": {
                                // [user_name1] findChecked [user_name2]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                String borrowerName = words[2];
                                try {
                                    librarySystem.FindChecked(userName, borrowerName);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "Borrower": {
                                // [user_name1] Borrower [book_id]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                int bookId;
                                try {
                                    bookId = Integer.parseInt(words[2]);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number input");
                                    continue;
                                }
                                try {
                                    librarySystem.GetBorrower(userName, bookId);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            default: {
                                System.out.println("Error");
                                continue;
                            }
                        }
                        break;
                    }
                    case FUNCTION_CALL_CHECKOUT: {
                        ArrayList<Integer> bookIds = new ArrayList<>();
                        for (String word : words) {
                            try {
                                bookIds.add(Integer.parseInt(word));
                            } catch (NumberFormatException e) {
                                System.out.println("Borrower can not check out the books");
                            }
                        }
                        try {
                            librarySystem.CheckOut(User1, User2, bookIds);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        // back to function mode
                        mode = Mode.FUNCTIONS;
                        break;
                    }
                    case FUNCTION_CALL_ADD_BOOK: {
                        if (words.length != 2) {
                            System.out.println("Error");
                            continue;
                        }
                        String author = words[0];
                        String subject = words[1];
                        mode = Mode.FUNCTIONS;
                        try {
                            librarySystem.AddBook(User1, author, subject);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    enum Mode {
        BOOKS_INIT,
        BOOKS,
        USERS_INIT,
        USERS,
        FUNCTIONS,
        FUNCTION_CALL_CHECKOUT,
        FUNCTION_CALL_ADD_BOOK,
    }
}
