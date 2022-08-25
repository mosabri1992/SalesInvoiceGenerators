/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sales.model;

/**
 *
 * @author CompuFast
 */
public class Line {
    
    private int index;
    private String itemname;
    private double price;
    private int ammount;
    private Invoice invoice ;

    public Line() {
    }
    public Line(int index, String itemname, double price, int ammount, Invoice invoice) {
        this.index = index;
        this.itemname = itemname;
        this.price = price;
        this.ammount = ammount;
        this.invoice = invoice;
    }
     public double getlinetotal(){
    
    return price * ammount;
    
}
    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Line{" + "index=" + index + ", itemname=" + itemname + ", price=" + price + ", ammount=" + ammount + '}';
    }
    
    
    
}
