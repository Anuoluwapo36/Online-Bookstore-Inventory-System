import exception.DuplicateIsbnException;
import exception.InvalidPriceException;
import model.Book;
import model.EBook;
import model.PhysicalBook;
import service.InventoryManager;
import type.BookType;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static  void main(String[] args){
        InventoryManager inventoryManager = new InventoryManager();
        PhysicalBook book = new PhysicalBook("Book of halo","Bkw",20, 10,1.9, BookType.PHYSICAL_BOOK);
        PhysicalBook book1 = new PhysicalBook("Book of owl","Bsw",10, 5,2.0, BookType.PHYSICAL_BOOK);
        EBook digitalBook = new EBook("Two Friend","BKw", 10,50,BookType.EBOOK);




        try {
            inventoryManager.addBook(digitalBook);
            inventoryManager.addBook(book);
            inventoryManager.addBook(book1);
            //find physical book in stock and return list of it
            List<Book> bookStock = inventoryManager.findPhysicalBookInStock();

            bookStock.forEach(bookInStock->{
                String result = bookInStock.getTitle() +
                        ", Type: " + bookInStock.getBookType();

                if (bookInStock instanceof PhysicalBook){
                    PhysicalBook physicalBook = (PhysicalBook) bookInStock;
                    result += ", StockQuantity: " + physicalBook.getStockQuantity();
                }

                System.out.println(result);
            });


            //search a book by it id and return single list
            Optional<Book> findByIsbm = inventoryManager.findBookById("Bkw");
            if (findByIsbm.isPresent()){
                Book findBook = findByIsbm.get();
                System.out.println("Search Book: by ISBN: " + findBook.getIsbn() + " title: " + findBook.getTitle());
            }else {
                System.out.println("null");
            }

            //find the cheaper book in the storage less than or equal 20 and we get teh return list of it
            List<Book> findCheaper = inventoryManager.findCheaperBook(20);
            findCheaper.forEach(cheapBookResult -> System.out.println( "Title: " +cheapBookResult.getTitle()));

            //sorted book by price in ascending order
            List<Book> sorted = inventoryManager.sortBookByPriceAsc();
            sorted.forEach(sortByPrice -> System.out.println("Title: " + sortByPrice.getTitle() + "Price: " + sortByPrice.getPrice()));


            //print all book in storage
            inventoryManager.printAllBooks();

            boolean isAnnotated = inventoryManager.checkAnnotation(book);

            if (!isAnnotated){
                System.out.println("Class have no annotation");
            }else {
                System.out.println("Annotation is added");
            }
        }catch (InvalidPriceException e){
            throw  new InvalidPriceException(e.getMessage());
        }
        catch (DuplicateIsbnException e){
            throw  new DuplicateIsbnException( e.getMessage());
        }catch (NullPointerException e){
            throw  new NullPointerException(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}