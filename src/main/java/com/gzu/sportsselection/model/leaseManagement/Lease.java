//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.leaseManagement;

import com.gzu.sportsselection.model.studentManagement.Student;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@JsonAutoDetect
@Entity
@Table
public class Lease {
    @Id
    @SequenceGenerator(
            name = "lease_sequence",
            sequenceName = "lease_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lease_sequence"
    )
    private Long id;
    private int tenant_id;
    @JsonDeserialize(
            using = LocalDateDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateSerializer.class
    )
    private LocalDate startDate;
    private String terms;
    private int duration;
    private LocalDate endDate;
    private int timeLeft;
    private String status;
    @Transient
    private Student student;

    public Lease(int tenant_id, LocalDate startDate, String terms, int duration, LocalDate endDate, int timeLeft, String status, Student student) {
        this.tenant_id = tenant_id;
        this.startDate = startDate;
        this.terms = terms;
        this.duration = duration;
        this.endDate = endDate;
        this.timeLeft = timeLeft;
        this.status = status;
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setTenant(Student student) {
        this.student = student;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getStatus() {
        return this.status;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public String getTerms() {
        return this.terms;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEndDate(LocalDate endDate) {
        endDate = this.startDate.plusMonths((long)this.duration);
        this.endDate = endDate;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStudent_id() {
        return this.tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Lease(final Long id, final int tenant_id, final LocalDate startDate, final String terms, final int duration, final LocalDate endDate, final int timeLeft, final String status, final Student student) {
        this.id = id;
        this.tenant_id = tenant_id;
        this.startDate = startDate;
        this.terms = terms;
        this.duration = duration;
        this.endDate = endDate;
        this.timeLeft = timeLeft;
        this.status = status;
        this.student = student;
    }

    public Lease() {
    }

    public String toString() {
        return "Lease(id=" + this.getId() + ", tenant_id=" + this.getStudent_id() + ", startDate=" + this.getStartDate() + ", terms=" + this.getTerms() + ", duration=" + this.getDuration() + ", endDate=" + this.getEndDate() + ", timeLeft=" + this.getTimeLeft() + ", status=" + this.getStatus() + ", tenant=" + this.getStudent() + ")";
    }
}
