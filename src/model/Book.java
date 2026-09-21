package model;

import annotaion.InventoryItem;
import service.InventoryOperation;
import type.BookType;

import java.util.*;



@InventoryItem
public abstract class Book {

    private String title;
    private String Isbn;
    private  double price;
    private final BookType bookType;



    public Book(String title, String isbn, double price, BookType bookType) {
        this.title = title;
        Isbn = isbn;
        this.price = price;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }
}
