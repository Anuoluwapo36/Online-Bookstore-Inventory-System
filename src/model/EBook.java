package model;

import annotaion.InventoryItem;
import type.BookType;

@InventoryItem
public class EBook extends Book{

    private int licenceCount;

    public EBook(String title, String isbn, double price, int licenceCount, BookType bookType) {
        super(title, isbn, price, bookType);
        this.licenceCount=licenceCount;
    }

    public int getLicenceCount() {
        return licenceCount;
    }

    public void setLicenceCount(int licenceCount) {
        this.licenceCount = licenceCount;
    }


}
