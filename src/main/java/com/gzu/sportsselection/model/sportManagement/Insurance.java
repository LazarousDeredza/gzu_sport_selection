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
public class Insurance {
    @Id
    @SequenceGenerator(
            name = "insurance_sequence",
            sequenceName = "insurance_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "insurance_sequence"
    )
    private Long id;
    private String name;
    private String policy;
    @Transient
    private ContactDetails contactDetailsObject;
    private Long contact;
    @Transient
    private Address addressObject;
    private Long address;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPolicy() {
        return this.policy;
    }

    public ContactDetails getContactDetailsObject() {
        return this.contactDetailsObject;
    }

    public Long getContact() {
        return this.contact;
    }

    public Address getAddressObject() {
        return this.addressObject;
    }

    public Long getAddress() {
        return this.address;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPolicy(final String policy) {
        this.policy = policy;
    }

    public void setContactDetailsObject(final ContactDetails contactDetailsObject) {
        this.contactDetailsObject = contactDetailsObject;
    }

    public void setContact(final Long contact) {
        this.contact = contact;
    }

    public void setAddressObject(final Address addressObject) {
        this.addressObject = addressObject;
    }

    public void setAddress(final Long address) {
        this.address = address;
    }

    public String toString() {
        return "Insurance(id=" + this.getId() + ", name=" + this.getName() + ", policy=" + this.getPolicy() + ", contactDetailsObject=" + this.getContactDetailsObject() + ", contact=" + this.getContact() + ", addressObject=" + this.getAddressObject() + ", address=" + this.getAddress() + ")";
    }

    public Insurance() {
    }

    public Insurance(final Long id, final String name, final String policy, final ContactDetails contactDetailsObject, final Long contact, final Address addressObject, final Long address) {
        this.id = id;
        this.name = name;
        this.policy = policy;
        this.contactDetailsObject = contactDetailsObject;
        this.contact = contact;
        this.addressObject = addressObject;
        this.address = address;
    }
}
