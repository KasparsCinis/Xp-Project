package com.company;

/**
 * Created by kasdi on 04.03.2016.
 */
public class kioskItem {


    private int idKioskItem;
    private String name;
    private int price;

    public kioskItem() {
    }

    public kioskItem(int idKioskItem, String name, int price) {
        this.idKioskItem = idKioskItem;
        this.name = name;
        this.price = price;
    }

    public int getIdKioskItem() {
        return idKioskItem;
    }

    public void setIdKioskItem(int idKioskItem) {
        this.idKioskItem = idKioskItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
