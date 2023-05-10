package com.perscholas.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;

//--------------------------code from hibernate demo---------------------------------------------------
import javax.persistence.*;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//--------------------------code from hibernate demo---------------------------------------------------

//@Entity
//@Table
public class Department {
    //---------------------------------------------VARIABLE---------------------------------

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String department;
    private String departmentLocation;

    private ArrayList<Customer> customerArray
            = new ArrayList<Customer>();
    //private ArrayList<DupCustomerArray> dupCustomerArray
    //        = new ArrayList<DupCustomerArray>();

    //---------------------------------------------CONSTRUCTORS-------------------------------------------


    public Department() {
    }

    public Department(String department, String departmentLocation) {
        this.department = department;
        this.departmentLocation = departmentLocation;
    }

    public Department(String department, String departmentLocation,
                      ArrayList<Customer> customerArray) {
        this.department = department;
        this.departmentLocation = departmentLocation;
        this.customerArray = customerArray;
    }


    //---------------------------------------------BUSINESS LOGIC/METHODS-----------------------

    //add new customer
    //public void addCustomer(Customer customer)
    //public void addCustomer(String customer)
    public ArrayList<Customer> addCustomer(Customer customer) {
        //System.out.println("ADDED:  " + customer.getCustomerInfo());
        customerArray.add(customer);

        //System.out.println("ADDED:  " + customerArray.add(customer));

        return customerArray;
    }


    // get a specific existing customer
    public ArrayList<Customer> getASpecificCustomerArray(int customerId) {
        for (int i = 0; i < customerArray.size(); i++) {
            if (customerId == customerArray.get(i).getCustomerId()) {
                System.out.println(customerArray.get(i).getCustomerInfo());
            }
        }
        return customerArray;


//    public ArrayList<Customer> getASpecificCustomerArray(Customer customer) {
//        for (int i = 0; i < customerArray.size(); i++) {
//            if (customer.getCustomerId() == customerArray.get(i).getCustomerId()) {
//                System.out.println(customerArray.get(i).getCustomerInfo());
//            }
//        }
//        return customerArray;
    }

    // get ALL existing customer
    public ArrayList<Customer> getCustomerArray() {
        for (int i = 0; i < customerArray.size(); i++) {
            System.out.println("customer info: "
                    + customerArray.get(i).getCustomerInfo());
        }
        return customerArray;
    }


    // update existing customer
//    public ArrayList<Customer> updateSpecifCustomerArray(Customer customer, String address) {

    //    public String updateSpecifCustomerArray
//            (int customerId, Customer customer) {
    public String updateSpecifCustomerArray
    (int customerId, String customerField, String newInfoToUpdateField) {

        for (int i = 0; i < customerArray.size(); i++) {
            if (customerId == customerArray.get(i).getCustomerId()) {
                System.out.println("BEFORE UPDATE: "
                        + customerArray.get(i).getCustomerInfo());
                Customer customer = customerArray.get(i);
                if (customerField.equals("name")) {
                    System.out.println("customerField: " + customerField);
                    customer.setCustomerName(newInfoToUpdateField);
                } else
                    customer.setCustomerAddress(newInfoToUpdateField);

                customerArray.set(i, customer);
                System.out.println("AFTER UPDATE: "
                        + customerArray.get(i).getCustomerInfo());
                System.out.println(" ");
            }
        }
        return customerField;
    }


    // delete existing customer
//    public ArrayList<Customer> deleteSpecificCustomerArray(Customer customer, int customerId) {
//
//        for (int i = 0; i < customerArray.size() - 1; i++) {
//            if (customer.getCustomerId() == customerArray.get(i).getCustomerId()) {
//                customerArray.remove(customer);
//            } else {
//                System.out.println("records still in existing:  "
//                        + customerArray.get(i).getCustomerInfo());
//            }
//        }
//        return customerArray;
//    }


    public int deleteSpecificCustomerArray(int customerId) {

        for (int i = 0; i < customerArray.size(); i++) {
            if (customerId == customerArray.get(i).getCustomerId()) {
                customerArray.remove(customerArray);
                System.out.println("record removed:  "
                        + customerArray.get(i).getCustomerInfo());
            }
        }
        return customerId;
    }


    //---------------------------------------------GETTER/SETTER-----------------------------------------

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }


    public void setCustomerArray(ArrayList<Customer> customerArray) {
        this.customerArray = customerArray;
    }

//    public ArrayList<DupCustomerArray> getDupCustomerArray() {
//        return dupCustomerArray;
//    }
//
//    public void setDupCustomerArray(ArrayList<DupCustomerArray> dupCustomerArray) {
//        this.dupCustomerArray = dupCustomerArray;
//    }
}
