# README.md

# Online Bookstore Inventory System

## Project Overview

This is a simple console based java project. It does not use any framework or database. All data is stored inside an arraylist in memory. This project simulates inventory management for an online bookstore. The system has two types of books which are physical book and ebook.

## Concepts practiced in this project

This project helps practice many core java and object oriented programming ideas.
Abstraction is used with an abstract Book class to keep all shared properties and methods for every type of book.
Inheritance is used so PhysicalBook and EBook can extend from the abstract Book class.
Encapsulation is applied by making all class fields private. We only read or change values by getter and setter methods.
Polymorphism lets us use Book as reference type while working with different subclass objects.
Enum BookType stores the two fixed values PHYSICAL_BOOK and EBOOK to mark what type a book is.
We create an interface called InventoryOperation. This interface sets the rules for inventory operations. InventoryManager class implements this interface, following the idea of programming to interface.
Custom marker annotation InventoryItem is created. We use simple reflection code to check during runtime if a model class has this annotation.
Custom unchecked exceptions are created for business validation. InvalidPriceException is thrown when book price is negative. DuplicateIsbnException is thrown when adding a book with an isbn that already exists.
Optional is used for find by isbn method so we avoid null pointer exception.
Lambda and stream api are used for filtering, sorting and printing book data.
ArrayList collection stores all book records inside InventoryManager.

## Business Requirements

The bookstore inventory has two book types defined inside BookType enum, PHYSICAL_BOOK and EBOOK.
PhysicalBook has isbn, title, price, stockQuantity, weight and bookType.
EBook has isbn, title, price, licenseCount and bookType.

Business Rules
ISBN must be unique in the whole inventory. Adding duplicate ISBN throws DuplicateIsbnException.
Book price cannot be negative, this will throw InvalidPriceException.
PhysicalBook stockQuantity cannot be negative.
EBook licenseCount cannot be negative.
When searching book by ISBN the method returns Optional, empty optional if no matching ISBN found.
Book, PhysicalBook and EBook model classes are marked with InventoryItem custom annotation.
Stream and lambda are used for filtering and sorting operations.

## Components and package structure

src
annotation folder contains InventoryItem.java which is custom marker annotation
exception folder contains InvalidPriceException.java and DuplicateIsbnException.java
model folder contains BookType.java enum, Book.java abstract class, PhysicalBook.java, EBook.java
service folder contains InventoryOperation.java interface and InventoryManager.java which implements InventoryOperation and stores book data
Main.java is the entry point to run and test all features

## Methods declared inside InventoryOperation interface

addBook(Book book)
This method adds new book into inventory. It checks all business rules and throws custom exceptions when validation fails.

findBookByIsbn(String isbn)
This method searches book by isbn and returns Optional.

findBooksCheaperThan(double price)
This method returns list of books with price less than input value. Stream filter and lambda used.

findPhysicalBooksInStock()
This method returns only physical books that have stockQuantity greater than zero. Stream filter and lambda used.

sortBooksByPriceAsc()
This method returns new list sorted from low price to high price. Stream sorted and lambda comparator used.

printAllBooks()
This method prints all book details to console, stream forEach used.

## Test cases implemented in Main class

Create valid PhysicalBook and EBook objects and add them to inventory.
Try add book with negative price to trigger InvalidPriceException.
Try add book with duplicate ISBN to trigger DuplicateIsbnException.
Test findBookByIsbn for existing isbn and non existing isbn to show Optional usage.
Run findBooksCheaperThan and findPhysicalBooksInStock filter methods.
Run sortBooksByPriceAsc and print sorted list.
Run printAllBooks to print all books.
Run annotation helper method to check if PhysicalBook and EBook have InventoryItem annotation using reflection.

## How to run

Clone the repository to your local machine.
Open project with IntelliJ IDEA or Eclipse.
Run Main.java file.
Console will print test outputs and exception messages.



