package Assn1;

import java.util.ArrayList;

/**
 * This class represents a Book object
 */
public class Book {
    private String isbn;
    private String title;
    private int edNumber;
    private String copyright;
    private ArrayList<Author> authors;

    /**
     * This method returns the ISBN
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method sets the ISBN
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * This method returns the title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the edition number
     * @return edNumber
     */
    public int getEdNumber() {
        return edNumber;
    }

    /**
     * This method sets the edition number
     * @param edNumber
     */
    public void setEdNumber(int edNumber) {
        this.edNumber = edNumber;
    }

    /**
     * This method returns the copyright
     * @return copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * This method sets the copyright
     * @param copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * This method returns the list of authors
     * @return authors
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    /**
     * This method sets the list of authors
     * @param authors
     */
    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
}

