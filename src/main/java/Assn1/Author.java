package Assn1;

import java.util.ArrayList;
//javadoc

/**
 * This class represents an Author object
 */
public class Author {
    private int authorID;
    private String authorFirstName;
    private String authorLastName;
    private ArrayList<Book> books;

    /**
     * This method returns the authorID
     * @return authorID
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * This method sets the authorID
     * @param authorID
     */
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    /**
     * This method returns the author's first name
     * @return authorFirstName
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * This method sets the author's first name
     * @param authorFirstName
     */
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    /**
     * This method returns the author's last name
     * @return authorLastName
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * This method sets the author's last name
     * @param authorLastName
     */
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    /**
     * This method returns the list of books the author has written
     * @return books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * This method sets the list of books the author has written
     * @param books
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
