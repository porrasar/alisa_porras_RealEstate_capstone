package com.perscholas.models;

public class Customer {

    //---------------------------------------------VARIABLE-------------------------------------------

    private int customerId;
    private String customerName;
    String customerAddress;
    String customerPhone;


    //---------------------------------------------CONSTRUCTORS-------------------------------------------

    public Customer() {
    }

    public Customer(int customerId, String customerName,
                    String customerAddress, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public Customer(String customerInput) {
    }


    //---------------------------------------------BUSINESS LOGIC/METHODS---------------------------------


    public String getCustomerInfo() {
        String customerInfo = ("im in customer class");

        return customerInfo;
    }

    private void addNewCustomer(Customer customer) {


    }


    private void updateCustomer() {

    }

    private void deleteCustomer() {

    }

    //---------------------------------------------GETTER/SETTER-------------------------------------------


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
