package com.osjobu.code;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 29/06/12
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    private long id;
    private String isbn;
    private String title;
    private String publisher;
    byte[] image;

    public Book(long id, String isbn, String title, String publisher, byte[] image) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.image=image;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return title+"-"+publisher;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
