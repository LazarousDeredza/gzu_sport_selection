//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.sportManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private Long property;

    public Long getProperty() {
        return this.property;
    }

    public void setProperty(Long property) {
        this.property = property;
    }

    public Address(String name, String address, String zipCode, String city, String country, Long property) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.property = property;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String toString() {
        return "Address(id=" + this.getId() + ", name=" + this.getName() + ", address=" + this.getAddress() + ", zipCode=" + this.getZipCode() + ", city=" + this.getCity() + ", country=" + this.getCountry() + ", property=" + this.getProperty() + ")";
    }

    public Address(final Long id, final String name, final String address, final String zipCode, final String city, final String country, final Long property) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.property = property;
    }

    public Address() {
    }
}
