package service;

import annotaion.InventoryItem;
import exception.DuplicateIsbnException;
import exception.InvalidPriceException;
import model.Book;
import model.EBook;
import model.PhysicalBook;

import java.util.*;
import java.util.stream.Collectors;


public class InventoryManager implements InventoryOperation{

    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if (book == null){
            throw new NullPointerException("Invalid!! input cant be null.");
        }

        if (!InventoryOperation.validatePrice(book.getPrice())){
            throw new InvalidPriceException("Invalid price. please input a valid price must be greater than 0!!");
        }

        boolean isDuplicated = books.stream().anyMatch(existingbook -> Objects.equals(existingbook.getIsbn(), book.getIsbn()));

        if (isDuplicated){
            throw new DuplicateIsbnException("Duplicated Detected: Book Already Exist in the inventory ");
        }


        books.add(book);

    }

    @Override
    public Optional<Book> findBookById(String isbn) {


        if (isbn == null || isbn.isEmpty()){
            throw new NullPointerException("ISBN cant be null, or empty");
        }


        return books.stream().filter(searchBook ->Objects.equals(searchBook.getIsbn(),isbn)).findFirst();
    }

    @Override
    public List<Book> findCheaperBook(double price) {

        if (!InventoryOperation.validatePrice(price)){
            throw  new InvalidPriceException("Invalid price must be greater than 0");
        }

        return books.stream().filter(searchCheaperBook -> searchCheaperBook.getPrice() <= price).toList();
    }

    @Override
    public List<Book> sortBookByPriceAsc() {
        return books.stream().sorted(Comparator.comparing(Book::getPrice)).toList();
    }

    @Override
    public List<Book> findPhysicalBookInStock() {
        List<Book> inStockResult = new ArrayList<>();
        for (Book bp : books){
            if (bp instanceof PhysicalBook){
                PhysicalBook physicalBook = (PhysicalBook) bp;

                if (physicalBook.getStockQuantity() > 0){
                    inStockResult.add(bp);
                }

            }
        }
        return inStockResult;
    }

    @Override
    public void printAllBooks() {
        if (books.isEmpty()){
            System.out.println("Inventory is empty");
            return;
        }

        books.forEach(bookDetails -> {
            String outPut = "ISBM: " + bookDetails.getIsbn() +
                    ", Title: " + bookDetails.getTitle() +
                    ", Price: " + bookDetails.getPrice() +
                    ", Type: " + bookDetails.getBookType();



            if (bookDetails instanceof  PhysicalBook){
                PhysicalBook physicalBook = (PhysicalBook) bookDetails;
                outPut += ", Stock Quantity: " + physicalBook.getStockQuantity() + ", weight: " + physicalBook.getWeight();
            }
            else {
                if (bookDetails instanceof EBook eBook){
                    outPut += ", LicenceCount: " + eBook.getLicenceCount();
                }
            }
            System.out.println(outPut);
        });
    }



    public boolean checkAnnotation(Book book){

        return book.getClass().isAnnotationPresent(InventoryItem.class);

    }
}
