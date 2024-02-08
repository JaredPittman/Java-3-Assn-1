package Assn1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        try (Connection conn = DriverManager.getConnection(DatabaseManager.JAVA_BOOKS_DB_URL)) {
            do {
                System.out.println("-------------------------");
                System.out.println("Select an option:");
                System.out.println("1. Print all books from the database (showing authors)");
                System.out.println("2. Print all authors from the database (showing books)");
                System.out.println("3. Add a book to the database for an existing author");
                System.out.println("4. Add a new author");
                System.out.println("5. Quit");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                ArrayList<Book> books = DatabaseManager.getBooks(conn);
                ArrayList<Author> authors = DatabaseManager.getAuthors(conn);

                switch (choice) {
                    case 1:
                        DatabaseManager.createBooksAuthorList(conn, books, authors, DatabaseManager.getAuthorISBN(conn));
                        for (Book book : books) {
                            System.out.printf("%s %s %d\n", book.getIsbn(), book.getTitle(), book.getEdNumber());
                            for (Author author : book.getAuthors()) {
                                System.out.printf("%d %s %s\n", author.getAuthorID(), author.getAuthorFirstName(), author.getAuthorLastName());
                            }
                        }
                        break;
                    case 2:
                        DatabaseManager.createAuthorsBookList(conn, books, authors, DatabaseManager.getAuthorISBN(conn));
                        for (Author author : authors) {
                            System.out.printf("%s %s %s\n", author.getAuthorID(), author.getAuthorFirstName(), author.getAuthorLastName());
                            System.out.println("-------------------------");
                            for (Book book : author.getBooks()) {
//                              System.out.printf("%s %s %d\n", book.getIsbn(), book.getTitle(), book.getEdNumber());
                                System.out.println(book.getTitle());
                            }
                        }
                        break;
                    case 3:
                        Book book = new Book();

                        System.out.println("Enter the ISBN of the book:");
                        book.setIsbn(scanner.nextLine());
                        System.out.println("Enter the title of the book:");
                        book.setTitle(scanner.nextLine());
                        System.out.println("Enter the edition number of the book:");
                        book.setEdNumber(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Enter the copyright of the book:");
                        book.setCopyright(scanner.nextLine());
                        System.out.println("Enter the author ID of the book:");
                        for (Author author : authors) {
                            System.out.printf("%s %s %s %s\n", author.getAuthorID(), author.getAuthorFirstName(), author.getAuthorLastName(), author.getBooks());
                        }
                        int authorID = scanner.nextInt();
                        DatabaseManager.addBook(conn, book);
                        DatabaseManager.addAuthorISBN(conn, book.getIsbn(), authorID);

                        break;
                    case 4:
                        Author author = new Author();
                        System.out.println("Enter the author ID:");
                        author.setAuthorID(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline character
                        System.out.println("Enter the first name of the author:");
                        author.setAuthorFirstName(scanner.nextLine());
                        System.out.println("Enter the last name of the author:");
                        author.setAuthorLastName(scanner.nextLine());
                        DatabaseManager.addAuthor(conn, author);
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}