package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SalesTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<SalesPerson> salesPeople = new ArrayList<>();

    public static void main(String[] args) {
        // Ask user to enter salespeople information
        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter sales person name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter your sales person title: ");
            String title = scanner.nextLine();

            System.out.print("How many sales values will you enter for this sales person? ");
            int salesCount = Integer.parseInt(scanner.nextLine());

            SalesPerson salesPerson = new SalesPerson(name, title);
            for (int j = 0; j < salesCount; j++) {
                System.out.print("Please enter sales figure for " + name + ": ");
                double sale = Double.parseDouble(scanner.nextLine());
                salesPerson.addSale(sale);
            }

            salesPeople.add(salesPerson);
        }

        // Generate the sales report
        generateSalesReport();
    }

    private static void generateSalesReport() {
        double companyTotalSales = 0;
        for (SalesPerson person : salesPeople) {
            Iterator<Double> salesIterator = person.iterSales();
            double totalSales = 0;
            double minSale = Double.MAX_VALUE;
            double maxSale = Double.MIN_VALUE;
            int numberOfSales = 0;

            while (salesIterator.hasNext()) {
                double sale = salesIterator.next();
                totalSales += sale;
                minSale = Math.min(minSale, sale);
                maxSale = Math.max(maxSale, sale);
                numberOfSales++;
            }

            double averageSales = totalSales / numberOfSales;
            companyTotalSales += totalSales;

            // Print individual sales report
            System.out.println("Sales person: " + person.getName());
            System.out.printf("Total Sales: $%.2f\n", totalSales);
            System.out.printf("Min Sales: $%.2f\n", minSale);
            System.out.printf("Max Sales: $%.2f\n", maxSale);
            System.out.printf("Average Sales: $%.2f\n", averageSales);
            System.out.println("----------------------------------------------------\n");
        }

        // Print company total sales
        System.out.printf("Company total sales: $%.2f\n", companyTotalSales);
    }
}
