package com.cs411.solar_project.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonDeserialize(builder = Order.Builder.class)
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User guest;

    @JsonProperty("user_address")
    private String userAddress;

    @JsonProperty("bill_number")
    private double billNumber;

    @JsonProperty("saving")
    private double saving;

    @OneToMany
    @JoinColumn(name = "company")
    private List<Company> companies;

    public Order() {}

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.guest = builder.guest;
        this.userAddress = builder.userAddress;
        this.billNumber = builder.billNumber;
        this.saving = builder.saving;
        this.companies = builder.companies;
    }

    public Long getOrderID(){ return orderID; }

    public User getGuest() {
        return guest;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public double getBillNumber() { return billNumber; }

    public double getSaving() { return saving; }

    public List<Company> getCompanies(){ return companies; }

    public Order setGuest(User guest) {
        this.guest = guest;
        return this;
    }

    public Order setCompanies(List<Company> companies){
        this.companies = companies;
        return this;
    }

    public static class Builder {
        @JsonProperty("order_ID")
        private Long orderID;

        @JsonProperty("saving")
        private double saving;

        @JsonProperty("company")
        private List<Company> companies;

        @JsonProperty("guest")
        private User guest;

        @JsonProperty("user_address")
        private String userAddress;

        @JsonProperty("bill_number")
        private double billNumber;

        public Builder setOrderID(Long orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setGuest(User guest) {
            this.guest = guest;
            return this;
        }

        public Builder setUserAddress(String userAddress) {
            this.userAddress = userAddress;
            return this;
        }

        public Builder setBillNumber(double billNumber) {
            this.billNumber = billNumber;
            return this;
        }

        public Builder setSaving(double saving) {
            this.saving = saving;
            return this;
        }

        public Builder setCompanies(List<Company> companies){
            this.companies = companies;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

}
