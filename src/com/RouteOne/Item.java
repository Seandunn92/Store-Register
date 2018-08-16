package com.RouteOne;

/**
 * Created by seandunn92 on 8/15/18.
 */
public class Item {
    private String itemName;
    private double itemPrice;
    private String itemType;

    public Item(String itemName, double itemPrice, String itemType) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }

    //Getters
    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public String getItemType() {
        return itemType;
    }

    //Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    @Override
    public String toString() {
        return
                String.format("%-25s%-20s%-25s" , itemName, itemPrice, itemType );
    }
}
