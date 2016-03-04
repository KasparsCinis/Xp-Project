package com.company;

/**
 * Created by kasdi on 04.03.2016.
 */
public class soldItems {
    private int idKioskItem;
    private int Quantity;
    private int totalPrice;

    public soldItems() {
    }

    public soldItems(int idKioskItem, int quantity, int totalPrice) {
        this.idKioskItem = idKioskItem;
        Quantity = quantity;
        this.totalPrice = totalPrice;
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
