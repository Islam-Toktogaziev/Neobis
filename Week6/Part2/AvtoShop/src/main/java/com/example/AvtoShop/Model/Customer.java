package com.example.AvtoShop.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private long customerID;
    private String customerName;
    private long reputationID;
    private String address;
    private String email;
    private String number;

    public Customer() {
    }

    public Customer(long customerID, String customerName, long reputationID, String address, String email, String number) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.reputationID = reputationID;
        this.address = address;
        this.email = email;
        this.number = number;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getReputationID() {
        return reputationID;
    }

    public void setReputationID(long reputationID) {
        this.reputationID = reputationID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
