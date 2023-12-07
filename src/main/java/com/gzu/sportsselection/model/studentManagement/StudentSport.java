//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.studentManagement;

import javax.persistence.Embeddable;

@Embeddable
public class StudentSport {
    private String sport_name;
    private String sport_type;
    private String services;
    private String number;

    public StudentSport() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StudentSport)) {
            return false;
        } else {
            StudentSport other = (StudentSport)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$business_name = this.getSport_name();
                    Object other$business_name = other.getSport_name();
                    if (this$business_name == null) {
                        if (other$business_name == null) {
                            break label59;
                        }
                    } else if (this$business_name.equals(other$business_name)) {
                        break label59;
                    }

                    return false;
                }

                Object this$business_type = this.getSport_type();
                Object other$business_type = other.getSport_type();
                if (this$business_type == null) {
                    if (other$business_type != null) {
                        return false;
                    }
                } else if (!this$business_type.equals(other$business_type)) {
                    return false;
                }

                Object this$services = this.getServices();
                Object other$services = other.getServices();
                if (this$services == null) {
                    if (other$services != null) {
                        return false;
                    }
                } else if (!this$services.equals(other$services)) {
                    return false;
                }

                Object this$shop_number = this.getNumber();
                Object other$shop_number = other.getNumber();
                if (this$shop_number == null) {
                    if (other$shop_number != null) {
                        return false;
                    }
                } else if (!this$shop_number.equals(other$shop_number)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StudentSport;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        Object $business_name = this.getSport_name();
        result = result * 59 + ($business_name == null ? 43 : $business_name.hashCode());
        Object $business_type = this.getSport_type();
        result = result * 59 + ($business_type == null ? 43 : $business_type.hashCode());
        Object $services = this.getServices();
        result = result * 59 + ($services == null ? 43 : $services.hashCode());
        Object $shop_number = this.getNumber();
        result = result * 59 + ($shop_number == null ? 43 : $shop_number.hashCode());
        return result;
    }

    public String toString() {
        return "TenantBusiness(business_name=" + this.getSport_name() + ", business_type=" + this.getSport_type() + ", services=" + this.getServices() + ", shop_number=" + this.getNumber() + ")";
    }

    public String getSport_name() {
        return this.sport_name;
    }

    public String getSport_type() {
        return this.sport_type;
    }

    public String getServices() {
        return this.services;
    }

    public String getNumber() {
        return this.number;
    }

    public void setSport_name(final String business_name) {
        this.sport_name = business_name;
    }

    public void setSport_type(final String business_type) {
        this.sport_type = business_type;
    }

    public void setServices(final String services) {
        this.services = services;
    }

    public void setNumber(final String shop_number) {
        this.number = shop_number;
    }
}
