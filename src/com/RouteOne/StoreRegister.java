package com.RouteOne;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class StoreRegister {

    private List<Item> itemList;

    public StoreRegister() {
        itemList = new ArrayList<Item>();
    }


    public void loadInventory(File inventoryFile) throws IOException {
        String inventoryCsvString = getInventoryCsvString(inventoryFile);
        inventoryCsvString = inventoryCsvString.replaceAll("\r\n", ",");
        String [] unMappedItemData = inventoryCsvString.split(",");
        Item newItem=null;
        for (int i=0; i+2<unMappedItemData.length; i+=3){

            String itemName = unMappedItemData[i];
            double itemPrice = Double.parseDouble(unMappedItemData[i + 1]);
            String itemValue = unMappedItemData[i+2];
            newItem = new Item(itemName, itemPrice, itemValue);
            itemList.add(newItem);
        }

    }

    public Receipt checkoutOrder(List<String> items) {

        ArrayList<Item> checkOutItems = new ArrayList<Item>();
        for (String itemName : items){
            for (Item inventoryItem : itemList){
                if (itemName.toLowerCase().equals(inventoryItem.getItemName().toLowerCase())){
                    checkOutItems.add(inventoryItem);
                }
            }
        }

        Receipt orderReceipt = new NormalReceipt(checkOutItems);
        return orderReceipt;
    }

    protected static String getInventoryCsvString(File inventoryFile) throws IOException {
        String inventoryString = "";
        FileInputStream fileReader = new FileInputStream(inventoryFile);
        int i = -1;
        while ((i = fileReader.read())!=-1){
            inventoryString+= (char)(i);
        }
        return inventoryString;
    }




    public void printItemList(){
        for (int i =0 ; i<itemList.size(); i++){
            System.out.println(itemList.get(i));
        }
    }





}