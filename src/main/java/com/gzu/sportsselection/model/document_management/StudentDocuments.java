//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.document_management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "studentDocuments"
)
public class StudentDocuments {
    @Id
    @SequenceGenerator(
            name = "studentDocuments_sequence",
            sequenceName = "studentDocuments_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentDocuments_sequence"
    )
    private Long id;
    private String tenantId;
    private String nationalID;
    private String academicEligibility;
    private String consentForm;
    private String physcicalExamination;
    private String applicationLetter;


    public StudentDocuments(String tenantId, String nationalID, String academicEligibility, String consentForm, String physcicalExamination, String applicationLetter) {
        this.tenantId = tenantId;
        this.nationalID = nationalID;
        this.academicEligibility = academicEligibility;
        this.consentForm = consentForm;
        this.physcicalExamination = physcicalExamination;
        this.applicationLetter = applicationLetter;
    }

    public StudentDocuments(Long id, String tenantId, String nationalID, String academicEligibility, String consentForm, String physcicalExamination, String applicationLetter) {
        this.id = id;
        this.tenantId = tenantId;
        this.nationalID = nationalID;
        this.academicEligibility = academicEligibility;
        this.consentForm = consentForm;
        this.physcicalExamination = physcicalExamination;
        this.applicationLetter = applicationLetter;
    }

    public StudentDocuments() {
    }

    public StudentDocuments(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getAcademicEligibility() {
        return academicEligibility;
    }

    public void setAcademicEligibility(String academicEligibility) {
        this.academicEligibility = academicEligibility;
    }

    public String getConsentForm() {
        return consentForm;
    }

    public void setConsentForm(String consentForm) {
        this.consentForm = consentForm;
    }

    public String getPhyscicalExamination() {
        return physcicalExamination;
    }

    public void setPhyscicalExamination(String physcicalExamination) {
        this.physcicalExamination = physcicalExamination;
    }

    public String getApplicationLetter() {
        return applicationLetter;
    }

    public void setApplicationLetter(String applicationLetter) {
        this.applicationLetter = applicationLetter;
    }
}
