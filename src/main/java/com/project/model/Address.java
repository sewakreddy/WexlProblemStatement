package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Address")
public class Address implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Address_Id")
    private int addressId;

    @Column(name = "Street")
    private String street;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    @Column(name = "Postcode")
    private String postCode;

//    public String getStreet() {
//        return street;
//    }
//
////    public void setStreet(String street) {
////        this.street = data.getResults().get(0).getLocation().getStreet().getName() +
////                data.getResults().get(0).getLocation().getStreet().getNumber();
////    }
//
//    public String getCity() {
//        return city;
//    }
//
////    public void setCity(String city) {
////        this.city = data.getResults().get(0).getLocation().getCity();
////    }
//
//    public String getState() {
//        return state;
//    }
//
////    public void setState(String state) {
////        this.state = data.getResults().get(0).getLocation().getState();
////    }
//
//    public String getCountry() {
//        return country;
//    }
//
////    public void setCountry(String country) {
////        this.country = data.getResults().get(0).getLocation().getCountry();
////    }
//
//    public String getPostCode() {
//        return postCode;
//    }
//
////    public void setPostCode(String postCode) {
////        this.postCode = data.getResults().get(0).getLocation().getPostcode();
////    }
//
////    @Override
////    public String toString() {
////
////        StringBuilder builder = new StringBuilder();
////
////        builder.append(String.valueOf(addressId));
////        builder.append(", ");
////        builder.append(street);
////        builder.append(", ");
////        builder.append(city);
////        builder.append(", ");
////        builder.append(state);
////        builder.append(", ");
////        builder.append(country);
////        builder.append(", ");
////        builder.append(postCode);
////
////        return builder.toString();
////    }

}