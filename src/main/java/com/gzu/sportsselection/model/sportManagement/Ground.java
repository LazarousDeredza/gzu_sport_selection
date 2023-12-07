//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.sportManagement;

import com.gzu.sportsselection.model.studentManagement.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Ground {
    @Id
    @SequenceGenerator(
            name = "compartment_sequence",
            sequenceName = "compartment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "compartment_sequence"
    )
    private Long id;
    private Long property;
    private String floorNumber;
    private int floorArea;
    private double rentalRate;
    private String status;
    private String compartmentNumber;
    private String description;
    @Transient
    private Student studentObject;
    private Long tenant;

    public Ground(Long property, String floorNumber, int floorArea, double rentalRate, String status, String compartmentNumber, Student studentObject, Long tenant) {
        this.property = property;
        this.floorNumber = floorNumber;
        this.floorArea = floorArea;
        this.rentalRate = rentalRate;
        this.status = "0";
        this.compartmentNumber = compartmentNumber;
        this.studentObject = studentObject;
        this.tenant = tenant;
    }

    public Long getStudent() {
        return this.tenant;
    }

    public void setTenantObject(Student studentObject) {
        this.studentObject = studentObject;
    }

    public void setTenant(Long tenant) {
        this.tenant = tenant;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public Long getProperty() {
        return this.property;
    }

    public String getFloorNumber() {
        return this.floorNumber;
    }

    public int getFloorArea() {
        return this.floorArea;
    }

    public double getRentalRate() {
        return this.rentalRate;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCompartmentNumber() {
        return this.compartmentNumber;
    }

    public String getDescription() {
        return this.description;
    }

    public Student getStudentObject() {
        return this.studentObject;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setProperty(final Long property) {
        this.property = property;
    }

    public void setFloorNumber(final String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setFloorArea(final int floorArea) {
        this.floorArea = floorArea;
    }

    public void setRentalRate(final double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setCompartmentNumber(final String compartmentNumber) {
        this.compartmentNumber = compartmentNumber;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String toString() {
        return "Compartment(id=" + this.getId() + ", property=" + this.getProperty() + ", floorNumber=" + this.getFloorNumber() + ", floorArea=" + this.getFloorArea() + ", rentalRate=" + this.getRentalRate() + ", status=" + this.getStatus() + ", compartmentNumber=" + this.getCompartmentNumber() + ", description=" + this.getDescription() + ", tenantObject=" + this.getStudentObject() + ", tenant=" + this.getStudent() + ")";
    }

    public Ground(final Long id, final Long property, final String floorNumber, final int floorArea, final double rentalRate, final String status, final String compartmentNumber, final String description, final Student studentObject, final Long tenant) {
        this.id = id;
        this.property = property;
        this.floorNumber = floorNumber;
        this.floorArea = floorArea;
        this.rentalRate = rentalRate;
        this.status = status;
        this.compartmentNumber = compartmentNumber;
        this.description = description;
        this.studentObject = studentObject;
        this.tenant = tenant;
    }

    public Ground() {
    }
}
