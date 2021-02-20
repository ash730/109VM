package com.company;

public class Snack {
    private String name;
    private double price;
    private int qty;
    private String desc;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Snack(String name, double price, int qty, String desc) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.desc = desc;
    }

    public Snack() {
        this("",0.00,0,"");

    }

    public Snack(String csv) {
        String[] values = csv.split(",");

        this.name = values[0];
        this.price = Double.parseDouble(values[1]);
        this.qty = Integer.parseInt(values[2]);
        this.desc = values[3];
    }
}
