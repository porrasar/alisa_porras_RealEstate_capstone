package com.perscholas.models;


import javax.persistence.*;

//----------------------------------------------------------------------------------------------------

@Entity
@Table
public class Customer
{

    //-------------------------------------variables------------------------------------------
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    //@Column(name = "Customer Id")
    private int customerId;

    //@Column(name = "Customer Name")
    private String customerName;

    //@Column(name = "Customer Zip Code")
    private String customerZip;

    //----------------------------------------CONSTRUCTOR ---------------------------------------

    public Customer()
    {
    }

    public Customer(int customerId, String customerName, String customerZip)
    {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerZip = customerZip;
    }

    //---------------------------------getter and setter----------------------------------

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

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerZip='" + customerZip + '\'' +
                '}';
    }

    //------------------------old logic as 5/10/23 at 10:53 pm----------------------
//
//    //---------------------------------------------VARIABLE-------------------------------------------
//
//    private int customerId;
//    private String customerName;
////    String customerAddress;
////    String customerPhone;
//
//
//    //---------------------------------------------CONSTRUCTORS-------------------------------------------
//
//    public Customer() {
//    }
//
////    public Customer(int customerId, String customerName,
////                    String customerAddress, String customerPhone) {
////        this.customerId = customerId;
////        this.customerName = customerName;
////        this.customerAddress = customerAddress;
////        this.customerPhone = customerPhone;
////    }
//
//    public Customer(String customerInput) {
//    }
//
//    public Customer(int customerId, String customerName) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//    }
//
////---------------------------------------------BUSINESS LOGIC/METHODS---------------------------------
//
//
//    public String getCustomerInfo() {
//        String customerInfo = ("im in customer class");
//
//        return customerInfo;
//    }
//
//    private void addNewCustomer(Customer customer) {
//
//
//    }
//
//
//    private void updateCustomer() {
//
//    }
//
//    private void deleteCustomer() {
//
//    }
//
//    //---------------------------------------------GETTER/SETTER-------------------------------------------
//
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
////    public String getCustomerAddress() {
////        return customerAddress;
////    }
////
////    public void setCustomerAddress(String customerAddress) {
////        this.customerAddress = customerAddress;
////    }
////
////    public String getCustomerPhone() {
////        return customerPhone;
////    }
////
////    public void setCustomerPhone(String customerPhone) {
////        this.customerPhone = customerPhone;
////    }
}
