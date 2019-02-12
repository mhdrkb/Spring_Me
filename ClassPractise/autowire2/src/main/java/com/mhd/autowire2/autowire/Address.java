package com.mhd.autowire2.autowire;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String houseNo;
    private String country;

    public Address() {
        System.out.println("Object created......");
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void show(){
        System.out.println("Showwwwwwwwwww....................");
    }
}
