package com.company;

/**
 * Created by kasdi on 04.03.2016.
 */
public class SoldItems {
    private String name;
    private int idKioskItem;
    private int Quantity;
    private int totalPrice;

    public SoldItems() {
    }

    public SoldItems(String name, int idKioskItem, int quantity, int totalPrice) {
        this.name = name;
        this.idKioskItem = idKioskItem;
        Quantity = quantity;
        this.totalPrice = totalPrice;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdKioskItem() {
        return idKioskItem;
    }

    public void setIdKioskItem(int idKioskItem) {
        this.idKioskItem = idKioskItem;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
