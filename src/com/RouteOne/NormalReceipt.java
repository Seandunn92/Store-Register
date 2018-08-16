package com.RouteOne;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by seandunn92 on 8/15/18.
 */
public  class NormalReceipt implements  Receipt {

    private double total;
    private List<Item> receiptItemList;


    public NormalReceipt(){
        total = 0.00;

    }
    public NormalReceipt(List<Item> receiptItemList) {
        this.receiptItemList = receiptItemList;
    }

    @Override
    public  void printReceipt(){
        for (Item i : receiptItemList){
            System.out.println(i);
        }
    }

    private double getNonFormattedTotal(){
        double total = 0.00;
        for (Item i : receiptItemList){
            total += i.getItemPrice();
        }
        return total;
    }

    @Override
    public String getFormattedTotal() {
        return "$" + String.format("%.2f", getNonFormattedTotal());
    }

    @Override
    public List<String> getOrderedItems() {
        ArrayList<String> orderedItems =  new ArrayList<String>();
        sortCheckOutItemsPriceDescending();

        for ( Item i : receiptItemList){
            orderedItems.add(i.getItemName());
        }

        return orderedItems;
    }

    private void sortCheckOutItemsPriceDescending() {
        Collections.sort(receiptItemList, new Comparator<Item>() {
            public int compare(Item i1, Item i2){

                return Double.valueOf(i2.getItemPrice()).compareTo(i1.getItemPrice());
            }

        });
    }

}
