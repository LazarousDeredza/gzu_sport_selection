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
public class ContactDetails {
    @Id
    @SequenceGenerator(
            name = "contactDetails_sequence",
            sequenceName = "contactDetails_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactDetails_sequence"
    )
    private Long id;
    private String phone;
    private String mobileNumber;
    private String email;

    public Long getId() {
        return this.id;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String toString() {
        return "ContactDetails(id=" + this.getId() + ", phone=" + this.getPhone() + ", mobileNumber=" + this.getMobileNumber() + ", email=" + this.getEmail() + ")";
    }

    public ContactDetails(final Long id, final String phone, final String mobileNumber, final String email) {
        this.id = id;
        this.phone = phone;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public ContactDetails() {
    }
}
