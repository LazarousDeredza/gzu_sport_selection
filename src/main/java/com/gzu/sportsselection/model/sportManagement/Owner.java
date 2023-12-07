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
import javax.persistence.Transient;

@Entity
@Table
public class Owner {
    @Id
    @SequenceGenerator(
            name = "owner_sequence",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_sequence"
    )
    private Long id;
    private String name;
    private String lastName;
    private Long address;
    @Transient
    private Address addressObject;
    private Long contactDetails;
    @Transient
    private ContactDetails contactDetailsObject;

    public Owner(String name, Long address, Address addressObject, Long contactDetails, ContactDetails contactDetailsObject) {
        this.name = name;
        this.address = address;
        this.addressObject = addressObject;
        this.contactDetails = contactDetails;
        this.contactDetailsObject = contactDetailsObject;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getAddress() {
        return this.address;
    }

    public Address getAddressObject() {
        return this.addressObject;
    }

    public Long getContactDetails() {
        return this.contactDetails;
    }

    public ContactDetails getContactDetailsObject() {
        return this.contactDetailsObject;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(final Long address) {
        this.address = address;
    }

    public void setAddressObject(final Address addressObject) {
        this.addressObject = addressObject;
    }

    public void setContactDetails(final Long contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setContactDetailsObject(final ContactDetails contactDetailsObject) {
        this.contactDetailsObject = contactDetailsObject;
    }

    public String toString() {
        return "Owner(id=" + this.getId() + ", name=" + this.getName() + ", lastName=" + this.getLastName() + ", address=" + this.getAddress() + ", addressObject=" + this.getAddressObject() + ", contactDetails=" + this.getContactDetails() + ", contactDetailsObject=" + this.getContactDetailsObject() + ")";
    }

    public Owner(final Long id, final String name, final String lastName, final Long address, final Address addressObject, final Long contactDetails, final ContactDetails contactDetailsObject) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.addressObject = addressObject;
        this.contactDetails = contactDetails;
        this.contactDetailsObject = contactDetailsObject;
    }

    public Owner() {
    }
}
