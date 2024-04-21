package org.example;
import java.util.ArrayList;
import java.util.Iterator;

public class SalesPerson {
    private String name;
    private String title;
    private ArrayList<Double> sales;

    public SalesPerson(String name, String title) {
        this.name = name;
        this.title = title;
        this.sales = new ArrayList<>();
    }

    // Add a sale
    public void addSale(double sale) {
        sales.add(sale);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Double> getSales() {
        return sales;
    }

    // Iterator for sales
    public Iterator<Double> iterSales() {
        return sales.iterator();
    }
}
