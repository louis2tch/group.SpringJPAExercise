package com.example.group.SpringJPAExercise.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressOne;
    private String addressTwo;
    private String aptNum;
    private String city;
    private String state;
    private String zip;
    private String zipFour;
    private String county;
    private String country;
    @OneToMany(mappedBy = "addresses")
    private Collection<Employee> employees;


    public Address(String addressOne, String addressTwo, String aptNum, String city, String state,
                   String zip, String zipFour, String county, String country) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.zipFour = zipFour;
        this.county = county;
        this.country = country;
    }

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getAptNum() {
        return aptNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getZipFour() {
        return zipFour;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public Collection<Employee> getEmployee(){
        return employees;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", addressOne='" + addressOne + '\'' +
                ", addressTwo=" + addressTwo +
                ", aptNum='" + aptNum + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", zipFour='" + zipFour + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(addressOne, address.addressOne)
                && Objects.equals(addressTwo, address.addressTwo) && Objects.equals(aptNum, address.aptNum)
                && Objects.equals(city, address.city) && Objects.equals(state, address.state)
                && Objects.equals(zip, address.zip) && Objects.equals(zipFour, address.zipFour)
                && Objects.equals(county, address.county)&& Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressOne, addressTwo, aptNum, city, state,
                zip, zipFour, county, country);
    }

    public void setId(){
        this.id = 100L;
    }

}
