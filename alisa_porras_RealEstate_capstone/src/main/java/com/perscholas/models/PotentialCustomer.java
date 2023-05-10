package com.perscholas.models;

public class PotentialCustomer extends Customer {//class beg

    //---------------------------------------------VARIABLE-------------------------------------------

    private boolean applicationApply;
//    private boolean depositPd;
//    private String addressAppliedFor;


    //---------------------------------------------CONSTRUCTORS-------------------------------------------

    public PotentialCustomer() {
    }

    public PotentialCustomer(int customerId, String customerName,
                             String customerAddress, String customerPhone,
                             boolean applicationApply) {
        super(customerId, customerName, customerAddress, customerPhone);
        this.applicationApply = applicationApply;
    }


//    public PotentialCustomer(boolean applicationApply, boolean depositPd, String addressAppliedFor) {
//        this.applicationApply = applicationApply;
//        this.depositPd = depositPd;
//        this.addressAppliedFor = addressAppliedFor;
//    }

//    public PotentialCustomer(int customerId, String customerName, String customerAddress, String customerPhone,
//                             boolean applicationApply, boolean depositPd,
//                             String addressAppliedFor) {
//        super(customerId, customerName, customerAddress, customerPhone);
//        this.applicationApply = applicationApply;
//        this.depositPd = depositPd;
//        this.addressAppliedFor = addressAppliedFor;
//    }
//---------------------------------------------BUSINESS LOGIC/METHODS---------------------------------

    @Override
    public String getCustomerInfo() {
        String customerInfo = ("Customer in POTENTIAL: "
                + " " + getCustomerId() + " " + getCustomerName()
                + " " + getCustomerAddress()
                + " " + customerPhone
                + " " + applicationApply + " ");
//                 + " " + applicationApply + " " + depositPd + " " + addressAppliedFor);


        return customerInfo;
    }

    //---------------------------------------------GETTER/SETTER-------------------------------------------

    public boolean isApplicationApply() {
        return applicationApply;
    }

    public void setApplicationApply(boolean applicationApply) {
        this.applicationApply = applicationApply;
    }

//    public boolean isDepositPd() {
//        return depositPd;
//    }
//
//    public void setDepositPd(boolean depositPd) {
//        this.depositPd = depositPd;
//    }
//
//    public String getAddressAppliedFor() {
//        return addressAppliedFor;
//    }
//
//    public void setAddressAppliedFor(String addressAppliedFor) {
//        this.addressAppliedFor = addressAppliedFor;
//    }


}//class end
