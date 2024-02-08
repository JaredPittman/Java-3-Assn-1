package Assn1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseTester {

    public static void main(String[] args) {
        System.out.println("Fun with testing our Books DB");
        try (Connection conn = DriverManager.getConnection(DatabaseManager.JAVA_BOOKS_DB_URL);
        ) {
            ArrayList<Book> books = DatabaseManager.getBooks(conn);
            ArrayList<Author> authors = DatabaseManager.getAuthors(conn);
            System.out.println("Print Authors Table");
            for (Author author : authors) {
                System.out.printf("%s %s %s\n", author.getAuthorID(), author.getAuthorFirstName(), author.getAuthorLastName());
            }
            DatabaseManager.createBooksAuthorList(conn, books, authors, DatabaseManager.getAuthorISBN(conn));
            System.out.println("Print Titles Table");
            for (Book book : books) {
                System.out.printf("%s %s %d \n", book.getIsbn(), book.getTitle(), book.getEdNumber());
                for (Author author : book.getAuthors()) {
                    System.out.printf("%d %s %s\n", author.getAuthorID(), author.getAuthorFirstName(), author.getAuthorLastName());
                }
            }

            Book book1 = new Book();
            book1.setIsbn("1234567895");
            book1.setTitle("Test Book 2");
            book1.setEdNumber(1);
            book1.setCopyright("2021");
            book1.setAuthors(new ArrayList<>());
            Author author1 = new Author();
            author1.setAuthorID(10);
            author1.setAuthorFirstName("Test");
            author1.setAuthorLastName("Author");
            book1.getAuthors().add(author1);
            DatabaseManager.addBook(conn, book1);
            DatabaseManager.addAuthor(conn, author1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
