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
import java.time.LocalDateTime;
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
public class LeaseHistory {
    @Id
    @SequenceGenerator(
            name = "leaseHistory_sequence",
            sequenceName = "leaseHistory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "leaseHistory_sequence"
    )
    private Long id;
    private int lease_id;
    private int tenant_id;
    @JsonDeserialize(
            using = LocalDateDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateSerializer.class
    )
    private LocalDate startDate;
    private String terms;
    @Transient
    private int duration;
    private LocalDate endDate;
    private String action;
    private LocalDateTime actionDate;
    @Transient
    private Student student;

    public void setAction(String action) {
        this.action = action;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    public Long getId() {
        return this.id;
    }

    public int getStudent_id() {
        return this.tenant_id;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public String getTerms() {
        return this.terms;
    }

    public int getDuration() {
        return this.duration;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public String getAction() {
        return this.action;
    }

    public LocalDateTime getActionDate() {
        return this.actionDate;
    }

    public int getLease_id() {
        return this.lease_id;
    }

    public void setLease_id(int lease_id) {
        this.lease_id = lease_id;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setTenant(Student student) {
        this.student = student;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LeaseHistory)) {
            return false;
        } else {
            LeaseHistory other = (LeaseHistory)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getLease_id() != other.getLease_id()) {
                return false;
            } else if (this.getStudent_id() != other.getStudent_id()) {
                return false;
            } else if (this.getDuration() != other.getDuration()) {
                return false;
            } else {
                label102: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label102;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label102;
                    }

                    return false;
                }

                Object this$startDate = this.getStartDate();
                Object other$startDate = other.getStartDate();
                if (this$startDate == null) {
                    if (other$startDate != null) {
                        return false;
                    }
                } else if (!this$startDate.equals(other$startDate)) {
                    return false;
                }

                label88: {
                    Object this$terms = this.getTerms();
                    Object other$terms = other.getTerms();
                    if (this$terms == null) {
                        if (other$terms == null) {
                            break label88;
                        }
                    } else if (this$terms.equals(other$terms)) {
                        break label88;
                    }

                    return false;
                }

                Object this$endDate = this.getEndDate();
                Object other$endDate = other.getEndDate();
                if (this$endDate == null) {
                    if (other$endDate != null) {
                        return false;
                    }
                } else if (!this$endDate.equals(other$endDate)) {
                    return false;
                }

                label74: {
                    Object this$action = this.getAction();
                    Object other$action = other.getAction();
                    if (this$action == null) {
                        if (other$action == null) {
                            break label74;
                        }
                    } else if (this$action.equals(other$action)) {
                        break label74;
                    }

                    return false;
                }

                Object this$actionDate = this.getActionDate();
                Object other$actionDate = other.getActionDate();
                if (this$actionDate == null) {
                    if (other$actionDate != null) {
                        return false;
                    }
                } else if (!this$actionDate.equals(other$actionDate)) {
                    return false;
                }

                Object this$tenant = this.getStudent();
                Object other$tenant = other.getStudent();
                if (this$tenant == null) {
                    if (other$tenant == null) {
                        return true;
                    }
                } else if (this$tenant.equals(other$tenant)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LeaseHistory;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        result = result * 59 + this.getLease_id();
        result = result * 59 + this.getStudent_id();
        result = result * 59 + this.getDuration();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
        Object $terms = this.getTerms();
        result = result * 59 + ($terms == null ? 43 : $terms.hashCode());
        Object $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
        Object $action = this.getAction();
        result = result * 59 + ($action == null ? 43 : $action.hashCode());
        Object $actionDate = this.getActionDate();
        result = result * 59 + ($actionDate == null ? 43 : $actionDate.hashCode());
        Object $tenant = this.getStudent();
        result = result * 59 + ($tenant == null ? 43 : $tenant.hashCode());
        return result;
    }

    public LeaseHistory(final Long id, final int lease_id, final int tenant_id, final LocalDate startDate, final String terms, final int duration, final LocalDate endDate, final String action, final LocalDateTime actionDate, final Student student) {
        this.id = id;
        this.lease_id = lease_id;
        this.tenant_id = tenant_id;
        this.startDate = startDate;
        this.terms = terms;
        this.duration = duration;
        this.endDate = endDate;
        this.action = action;
        this.actionDate = actionDate;
        this.student = student;
    }

    public LeaseHistory() {
    }

    public String toString() {
        return "LeaseHistory(id=" + this.getId() + ", lease_id=" + this.getLease_id() + ", tenant_id=" + this.getStudent_id() + ", startDate=" + this.getStartDate() + ", terms=" + this.getTerms() + ", duration=" + this.getDuration() + ", endDate=" + this.getEndDate() + ", action=" + this.getAction() + ", actionDate=" + this.getActionDate() + ", tenant=" + this.getStudent() + ")";
    }
}
