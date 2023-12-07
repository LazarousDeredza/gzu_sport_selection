//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.studentManagement;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String house_no;
    private String street;
    private String city;
    private String country;

    public Address() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Address)) {
            return false;
        } else {
            Address other = (Address)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$house_no = this.getHouse_no();
                    Object other$house_no = other.getHouse_no();
                    if (this$house_no == null) {
                        if (other$house_no == null) {
                            break label59;
                        }
                    } else if (this$house_no.equals(other$house_no)) {
                        break label59;
                    }

                    return false;
                }

                Object this$street = this.getStreet();
                Object other$street = other.getStreet();
                if (this$street == null) {
                    if (other$street != null) {
                        return false;
                    }
                } else if (!this$street.equals(other$street)) {
                    return false;
                }

                Object this$city = this.getCity();
                Object other$city = other.getCity();
                if (this$city == null) {
                    if (other$city != null) {
                        return false;
                    }
                } else if (!this$city.equals(other$city)) {
                    return false;
                }

                Object this$country = this.getCountry();
                Object other$country = other.getCountry();
                if (this$country == null) {
                    if (other$country != null) {
                        return false;
                    }
                } else if (!this$country.equals(other$country)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        Object $house_no = this.getHouse_no();
        result = result * 59 + ($house_no == null ? 43 : $house_no.hashCode());
        Object $street = this.getStreet();
        result = result * 59 + ($street == null ? 43 : $street.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        return result;
    }

    public String toString() {
        return "Address(house_no=" + this.getHouse_no() + ", street=" + this.getStreet() + ", city=" + this.getCity() + ", country=" + this.getCountry() + ")";
    }

    public String getHouse_no() {
        return this.house_no;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setHouse_no(final String house_no) {
        this.house_no = house_no;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setCountry(final String country) {
        this.country = country;
    }
}
