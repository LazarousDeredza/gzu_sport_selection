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
public class Sport {
    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "property_sequence"
    )
    private Long id;
    private String name;
    @Transient
    private Address addressObject;
    private Long address;
    private String tenant;
    private Long insurance;
    private String description;
    private String propertyType;
    @Transient
    private Owner ownerObject;
    private Long owner;
    private String status;
    private double assetValue;
    @Transient
    private ContactDetails propertyContactObject;
    private Long contact;
    private String dateAdded;
    private String dateRegistered;
    private int numberOfCompartments;
    private int numberOfFloors;

    public Sport(String name, Address addressObject, Long address, String tenant, Long insurance, String description, String propertyType, Owner ownerObject, Long owner, String status, double assetValue, ContactDetails propertyContactObject, Long contact, String dateAdded, String dateRegistered, int numberOfCompartments, int numberOfFloors) {
        this.name = name;
        this.addressObject = addressObject;
        this.address = address;
        this.tenant = tenant;
        this.insurance = insurance;
        this.description = description;
        this.propertyType = propertyType;
        this.ownerObject = ownerObject;
        this.owner = owner;
        this.status = status;
        this.assetValue = assetValue;
        this.propertyContactObject = propertyContactObject;
        this.contact = contact;
        this.dateAdded = dateAdded;
        this.dateRegistered = dateRegistered;
        this.numberOfCompartments = numberOfCompartments;
        this.numberOfFloors = numberOfFloors;
    }

    public Sport(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Address getAddressObject() {
        return this.addressObject;
    }

    public Long getAddress() {
        return this.address;
    }

    public String getStudent() {
        return this.tenant;
    }

    public Long getInsurance() {
        return this.insurance;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    public Owner getOwnerObject() {
        return this.ownerObject;
    }

    public Long getOwner() {
        return this.owner;
    }

    public String getStatus() {
        return this.status;
    }

    public double getAssetValue() {
        return this.assetValue;
    }

    public ContactDetails getPropertyContactObject() {
        return this.propertyContactObject;
    }

    public Long getContact() {
        return this.contact;
    }

    public String getDateAdded() {
        return this.dateAdded;
    }

    public String getDateRegistered() {
        return this.dateRegistered;
    }

    public int getNumberOfCompartments() {
        return this.numberOfCompartments;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddressObject(final Address addressObject) {
        this.addressObject = addressObject;
    }

    public void setAddress(final Long address) {
        this.address = address;
    }

    public void setTenant(final String tenant) {
        this.tenant = tenant;
    }

    public void setInsurance(final Long insurance) {
        this.insurance = insurance;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPropertyType(final String propertyType) {
        this.propertyType = propertyType;
    }

    public void setOwnerObject(final Owner ownerObject) {
        this.ownerObject = ownerObject;
    }

    public void setOwner(final Long owner) {
        this.owner = owner;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setAssetValue(final double assetValue) {
        this.assetValue = assetValue;
    }

    public void setPropertyContactObject(final ContactDetails propertyContactObject) {
        this.propertyContactObject = propertyContactObject;
    }

    public void setContact(final Long contact) {
        this.contact = contact;
    }

    public void setDateAdded(final String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDateRegistered(final String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public void setNumberOfCompartments(final int numberOfCompartments) {
        this.numberOfCompartments = numberOfCompartments;
    }

    public void setNumberOfFloors(final int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String toString() {
        return "Property(id=" + this.getId() + ", name=" + this.getName() + ", addressObject=" + this.getAddressObject() + ", address=" + this.getAddress() + ", tenant=" + this.getStudent() + ", insurance=" + this.getInsurance() + ", description=" + this.getDescription() + ", propertyType=" + this.getPropertyType() + ", ownerObject=" + this.getOwnerObject() + ", owner=" + this.getOwner() + ", status=" + this.getStatus() + ", assetValue=" + this.getAssetValue() + ", propertyContactObject=" + this.getPropertyContactObject() + ", contact=" + this.getContact() + ", dateAdded=" + this.getDateAdded() + ", dateRegistered=" + this.getDateRegistered() + ", numberOfCompartments=" + this.getNumberOfCompartments() + ", numberOfFloors=" + this.getNumberOfFloors() + ")";
    }

    public Sport(final Long id, final String name, final Address addressObject, final Long address, final String tenant, final Long insurance, final String description, final String propertyType, final Owner ownerObject, final Long owner, final String status, final double assetValue, final ContactDetails propertyContactObject, final Long contact, final String dateAdded, final String dateRegistered, final int numberOfCompartments, final int numberOfFloors) {
        this.id = id;
        this.name = name;
        this.addressObject = addressObject;
        this.address = address;
        this.tenant = tenant;
        this.insurance = insurance;
        this.description = description;
        this.propertyType = propertyType;
        this.ownerObject = ownerObject;
        this.owner = owner;
        this.status = status;
        this.assetValue = assetValue;
        this.propertyContactObject = propertyContactObject;
        this.contact = contact;
        this.dateAdded = dateAdded;
        this.dateRegistered = dateRegistered;
        this.numberOfCompartments = numberOfCompartments;
        this.numberOfFloors = numberOfFloors;
    }

    public Sport() {
    }
}
