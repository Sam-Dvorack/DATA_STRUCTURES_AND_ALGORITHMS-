package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

        Queue salesProducts = new LinkedList();
        Queue expDate = new LinkedList();
        ArrayList expStock = new ArrayList();
        ArrayList expStockDate = new ArrayList();
        Queue soldProducts = new LinkedList();

        Queue expDateTemp = new LinkedList();

        // Adding batches.
        salesProducts.add("Croissant batch 001");
        salesProducts.add("Croissant batch 002");
        salesProducts.add("Croissant batch 003");
        salesProducts.add("Croissant batch 004");
        salesProducts.add("Croissant batch 005");
        salesProducts.add("Croissant batch 006");
        salesProducts.add("Croissant batch 007");
        salesProducts.add("Croissant batch 008");
        salesProducts.add("Croissant batch 009");
        salesProducts.add("Croissant batch 010");

        // Display.
        System.out.println(salesProducts);

        // Adding Expiry date.
        expDate.add("2022-12-31");
        expDate.add("2023-01-31");
        expDate.add("2023-02-28");
        expDate.add("2023-03-31");
        expDate.add("2023-04-30");
        expDate.add("2023-05-31");
        expDate.add("2023-06-30");
        expDate.add("2023-07-31");
        expDate.add("2023-08-31");
        expDate.add("2023-09-30");

        // Display.
        System.out.println(expDate);

        // Check dates.
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < salesProducts.size(); i++) {
            // Get batch expiry.
            String expiryDate = expDate.peek().toString();
            // Convert to date.
            Date batchExpiry = sdformat.parse(expiryDate);
            // Get current date.
            Date currentDate = new Date();

            // Check if batch has expired.
            if (batchExpiry.compareTo(currentDate) >= 0) {
                soldProducts.add(salesProducts.peek());
                expDate.poll();
                salesProducts.poll();
                break;
            } else if (batchExpiry.compareTo(currentDate) < 0) {
                expStock.add(salesProducts.peek());
                expStockDate.add(expDate.peek());
                expDate.poll();
                salesProducts.poll();
            }

        }

        System.out.print("\n\nCroissant batches: \n");
        System.out.print(salesProducts + "\n");
        System.out.print("Expiration Dates: \n");
        System.out.print(expDate + "\n");
        System.out.print("Expired Croissant batches: \n");
        System.out.print(expStock + "\n");
        System.out.print("Expired Croissant batches expiry dates: \n");
        System.out.print(expStockDate + "\n");
        System.out.print("Sold Croissant batches: \n");
        System.out.print(soldProducts + "\n");

        // expDateTemp
        for (int i = 0; i < expDate.size(); i++) {
            // Get batch expiry.
            LocalDate expiryDate = LocalDate.parse(expDate.poll().toString());

            // Add adjusted date to temp variable.
            expDateTemp.add(expiryDate.minusDays(1));
        }

        // Assign dates.
        expDate = expDateTemp;
        System.out.println("Adjusted dates due to loadshedding \n" + expDate);

    }

}