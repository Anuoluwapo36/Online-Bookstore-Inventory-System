package service;

import model.Book;

import java.util.List;
import java.util.Optional;

public interface InventoryOperation {
    void addBook(Book book);
    Optional<Book> findBookById(String isbn);
    List<Book> findCheaperBook( double price);
    List<Book> sortBookByPriceAsc();
    List<Book> findPhysicalBookInStock();
    void printAllBooks();



    static boolean validatePrice(double amount){


        return amount> 0;

    }
}
