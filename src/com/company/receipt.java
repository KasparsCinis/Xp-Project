package com.company;

import java.util.ArrayList;

/**
 * Created by kasdi on 04.03.2016.
 */
//This class acts as a receipt after purchasing something from the kiosk. It has an arraylist of all the sold items and their quantity

public class receipt {
    ArrayList<soldItems> listOfItemsInReceipt = new ArrayList<soldItems>();
    private int totalPrice;
    private int date;

    public receipt() {
    }

    public receipt(int totalPrice, int date) {
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void addItemToTheReceipt(soldItems item)
    {
        listOfItemsInReceipt.add(item);
    }
}
