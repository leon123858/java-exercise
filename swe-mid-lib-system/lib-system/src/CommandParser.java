import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandParser {
    public static void parse(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Mode mode = Mode.BOOKS_INIT;
            int numInputLine = 0;
            int curNumInputLine = -1;
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
                            num = 0;
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
                        // TODO: call add book function
                        curNumInputLine++;
                        System.out.println("add book");
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
                            num = 0;
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
                            // TODO: call add user function
                            curNumInputLine++;
                            System.out.println("add user");
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
                        // TODO: call add user function
                        curNumInputLine++;
                        System.out.println("add user");
                        break;
                    }
                    case FUNCTIONS: {
                        if (words.length < 2) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        String command = words[1];
                        switch (command) {
                            case "checkout": {
                                mode = Mode.FUNCTION_CALL_CHECKOUT;
                                System.out.println("call function checkout");
                                break;
                            }
                            case "addBook": {
                                mode = Mode.FUNCTION_CALL_ADD_BOOK;
                                System.out.println("call function addBook");
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
                                System.out.println("call function removeBook");
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
                                System.out.println("call function return");
                                break;
                            }
                            case "listAuthor": {
                                // [user_name1] listAuthor [book_author]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                String author = words[2];
                                System.out.println("call function listAuthor");
                                break;
                            }
                            case "listSubject": {
                                // [user_name1] listSubject [book_subject]
                                if (words.length != 3) {
                                    System.out.println("Invalid input");
                                    continue;
                                }
                                String userName = words[0];
                                String subject = words[2];
                                System.out.println("call function listSubject");
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
                                System.out.println("call function findChecked");
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
                                System.out.println("call function Borrower");
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
                                System.out.println("Invalid number input");
                            }
                        }
                        // TODO: call checkout function
                        System.out.println("checkout real add books start");
                        // print array list
                        for (int i = 0; i < bookIds.size(); i++) {
                            System.out.println(bookIds.get(i));
                        }
                        System.out.println("checkout real add books end");
                        // back to function mode
                        mode = Mode.FUNCTIONS;
                        break;
                    }
                    case FUNCTION_CALL_ADD_BOOK: {
                        if (words.length != 2) {
                            System.out.println("Invalid input");
                            continue;
                        }
                        String author = words[0];
                        String subject = words[1];
                        mode = Mode.FUNCTIONS;
                        System.out.println("add book " + author + " " + subject);
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
