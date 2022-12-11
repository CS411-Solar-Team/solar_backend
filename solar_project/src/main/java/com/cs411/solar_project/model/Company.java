package com.cs411.solar_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
@JsonDeserialize(builder = Company.Builder.class)
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyID;

//    @ManyToOne
//    @JoinColumn(name = "order_ID")
//    private Order orderID;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("company_address")
    private String companyAddress;

    @JsonProperty("company_website")
    private String companyWebsite;

    @JsonProperty("company_phone_number")
    private String companyPhoneNumber;

    @JsonProperty("company_rating")
    private String companyRating;

    public Company(){}

    public Company(Builder builder) {
//        this.orderID = builder.orderID;
        this.companyID = builder.companyID;
        this.companyName = builder.companyName;
        this.companyAddress = builder.companyAddress;
        this.companyWebsite = builder.companyWebsite;
        this.companyPhoneNumber = builder.companyPhoneNumber;
        this.companyRating = builder.companyRating;
    }

    public int getCompanyID() {
        return companyID;
    }

//    public Order getOrderID() {
//        return orderID;
//    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public String getCompanyRating() {
        return companyRating;
    }

//    public void setOrderID(Order orderID) {
//        this.orderID = orderID;
//    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public static class Builder{
        @JsonProperty("company_ID")
        private int companyID;

//        @JsonProperty("order_ID")
//        private Order orderID;

        @JsonProperty("company_name")
        private String companyName;

        @JsonProperty("company_address")
        private String companyAddress;

        @JsonProperty("company_website")
        private String companyWebsite;

        @JsonProperty("company_phone_number")
        private String companyPhoneNumber;

        @JsonProperty("company_rating")
        private String companyRating;

        public Builder setCompanyID(int companyID) {
            this.companyID = companyID;
            return this;
        }

//        public Builder setOrderID(Order orderID) {
//            this.orderID = orderID;
//            return this;
//        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
            return this;
        }

        public Builder setCompanyPhoneNumber(String companyPhoneNumber) {
            this.companyPhoneNumber = companyPhoneNumber;
            return this;
        }

        public Builder setCompanyWebsite(String companyWebsite) {
            this.companyWebsite = companyWebsite;
            return this;
        }

        public Builder setCompanyRating(String companyRating) {
            this.companyRating = companyRating;
            return this;
        }

        public Company build() {
            return new Company(this);
        }


    }
}
