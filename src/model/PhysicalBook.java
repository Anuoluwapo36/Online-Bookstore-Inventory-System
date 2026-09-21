package model;

import annotaion.InventoryItem;
import type.BookType;

@InventoryItem
public class PhysicalBook extends Book {

    private int stockQuantity;
    private double weight;


    public PhysicalBook(String title, String isbn, double price, int stockQuantity, double weight, BookType bookType) {
        super(title, isbn, price, bookType);
        this.stockQuantity = stockQuantity;
        this.weight= weight;

    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
