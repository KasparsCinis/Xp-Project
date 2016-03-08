package com.company;

/**
 * Created by kasdi on 03.03.2016.
 */
public class Customer {

    public Customer(int idCustomer, String customerName, String customerPhone) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    private int idCustomer;
    private String customerName;
    private String customerPhone;

    public String getCustomerName() {
        return customerName;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }



    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
