package com.RouteOne;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StoreRegister ourStoreRegister = new StoreRegister();

        System.out.println("Please enter in the name (path if needed) of the file you want to use.");
        System.out.println("For your convenience you can type 1 for the inventory that was in the base project given by Route One," +
                " or 2 for the inventory that was outlined as a Test Case in the Instructions pdf");
        System.out.println();
        System.out.println();
        String fileName = scanner.nextLine();

        if(fileName.equals("1"))
            fileName = "sample-inventory.csv";
        if (fileName.equals("2"))
            fileName = "sample-inventory2.csv";

        File file = new File(fileName);
        try {
            ourStoreRegister.loadInventory(file);
        }
        catch (Exception e){
                System.out.println("File did not load properly or was not formatted correctly for this project");
        }


        System.out.println("Here is the stores inventory!");
        ourStoreRegister.printItemList();

        System.out.println();

        System.out.println("Time to make an order. Enter 1 to type in your items, 2 to use your own file, or any other key to use the default" +
                " test case from the pdf");
        System.out.println();

        String input = scanner.nextLine();
        String unSplitCheckOutString="";
        File testFile=null;

        if (input.equals("1")){
            System.out.println("Type the items you want to buy seperated by ONLY commas NO SPACES");
            unSplitCheckOutString = scanner.nextLine();


        }
        else if (input.equals("2")){
            System.out.println("Type the name (path if needed) of the file you want to test");
            testFile = new File(scanner.nextLine());

        }
        else {
            System.out.println("Great we'll use the default! ");
             testFile = new File("testCase1.csv");
        }

        if(testFile!=null){
            try{
                unSplitCheckOutString = StoreRegister.getInventoryCsvString(testFile);

            }catch (IOException e){
                System.out.println("Something went wrong opening the file, or the data was wrong");
            }

        }

        String [] checkoutStringArray = unSplitCheckOutString.split(",");
        ArrayList<String> checkOutStrings = new ArrayList<String> (Arrays.asList( checkoutStringArray));

        Receipt myReceipt = ourStoreRegister.checkoutOrder(checkOutStrings);
        List<String> orderedItems = myReceipt.getOrderedItems();

        System.out.println("Thank you for shopping with us, Here is your Receipt!");


        for (String orderItem : orderedItems){
            System.out.print(orderItem + ", ");
        }


      System.out.println(myReceipt.getFormattedTotal());


    }



}

