package com.perscholas.models;

import java.time.LocalDate;

public class Payments {//class beg
    //This is for any payments to our company

    //---------------------------------VARIABLES--------------------------------
    private String paymentType;
    private double paymentAmount;
    private LocalDate localDate;
    //private Time timeOfReservation;

    //--------------------------------CONSTRUCTORS--------------------------------

    public Payments() {
    }

    public Payments(String paymentType, double paymentAmount, LocalDate localDate) {
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.localDate = localDate;
    }

    //--------------------------------BUSINESS LOGIC-------------------------------


    //--------------------------------GETTER/SETTER--------------------------------


    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}//class end
