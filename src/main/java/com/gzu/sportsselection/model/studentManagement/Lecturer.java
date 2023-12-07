//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.studentManagement;

import com.gzu.sportsselection.model.leaseManagement.Lease;
import com.gzu.sportsselection.model.sportManagement.Ground;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Lecturer {
    @Id
    @SequenceGenerator(
            name = "lecturer_sequence",
            sequenceName = "lecturer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecturer_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private LocalDate register_Date = LocalDate.now();
    private String email;
    private String phone;
    private String id_passport;
    private String rentStatus;
    private String address;
    private String city;
    private String country;
    private String business_name;
    private String business_type;
    private String services;
    private String property;
    private String b_phone;
    private String b_email;
    private String b_tel;
    private String website;
    @Transient
    private List<Lease> leaseObjectlist;
    @Transient
    private List<Ground> groundObjectlist;

    public Lecturer(String name, String surname, String email, String phone, String id_passport, String property, String rentStatus, List<Ground> groundObjectlist, List<Lease> leaseObjectlist) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.id_passport = id_passport;
        this.property = property;
        this.rentStatus = rentStatus;
        this.leaseObjectlist = leaseObjectlist;
        this.groundObjectlist = groundObjectlist;
    }

    public List<Ground> getCompartmentObjectlist() {
        return this.groundObjectlist;
    }

    public void setCompartmentObjectlist(List<Ground> groundObjectlist) {
        this.groundObjectlist = groundObjectlist;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getRegister_Date() {
        return this.register_Date;
    }

    public void setRegister_Date(LocalDate register_Date) {
        this.register_Date = register_Date;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_passport() {
        return this.id_passport;
    }

    public void setId_passport(String id_passport) {
        this.id_passport = id_passport;
    }

    public String getRentStatus() {
        return this.rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getB_phone() {
        return this.b_phone;
    }

    public void setB_phone(String b_phone) {
        this.b_phone = b_phone;
    }

    public String getB_email() {
        return this.b_email;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public String getB_tel() {
        return this.b_tel;
    }

    public void setB_tel(String b_tel) {
        this.b_tel = b_tel;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBusiness_name() {
        return this.business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_type() {
        return this.business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getServices() {
        return this.services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public List<Lease> getLeaseObjectlist() {
        return this.leaseObjectlist;
    }

    public void setLeaseObjectlist(List<Lease> leaseObjectlist) {
        this.leaseObjectlist = leaseObjectlist;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Lecturer)) {
            return false;
        } else {
            Lecturer other = (Lecturer)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label263: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label263;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label263;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                label249: {
                    Object this$surname = this.getSurname();
                    Object other$surname = other.getSurname();
                    if (this$surname == null) {
                        if (other$surname == null) {
                            break label249;
                        }
                    } else if (this$surname.equals(other$surname)) {
                        break label249;
                    }

                    return false;
                }

                Object this$register_Date = this.getRegister_Date();
                Object other$register_Date = other.getRegister_Date();
                if (this$register_Date == null) {
                    if (other$register_Date != null) {
                        return false;
                    }
                } else if (!this$register_Date.equals(other$register_Date)) {
                    return false;
                }

                label235: {
                    Object this$email = this.getEmail();
                    Object other$email = other.getEmail();
                    if (this$email == null) {
                        if (other$email == null) {
                            break label235;
                        }
                    } else if (this$email.equals(other$email)) {
                        break label235;
                    }

                    return false;
                }

                Object this$phone = this.getPhone();
                Object other$phone = other.getPhone();
                if (this$phone == null) {
                    if (other$phone != null) {
                        return false;
                    }
                } else if (!this$phone.equals(other$phone)) {
                    return false;
                }

                label221: {
                    Object this$id_passport = this.getId_passport();
                    Object other$id_passport = other.getId_passport();
                    if (this$id_passport == null) {
                        if (other$id_passport == null) {
                            break label221;
                        }
                    } else if (this$id_passport.equals(other$id_passport)) {
                        break label221;
                    }

                    return false;
                }

                label214: {
                    Object this$rentStatus = this.getRentStatus();
                    Object other$rentStatus = other.getRentStatus();
                    if (this$rentStatus == null) {
                        if (other$rentStatus == null) {
                            break label214;
                        }
                    } else if (this$rentStatus.equals(other$rentStatus)) {
                        break label214;
                    }

                    return false;
                }

                Object this$address = this.getAddress();
                Object other$address = other.getAddress();
                if (this$address == null) {
                    if (other$address != null) {
                        return false;
                    }
                } else if (!this$address.equals(other$address)) {
                    return false;
                }

                label200: {
                    Object this$city = this.getCity();
                    Object other$city = other.getCity();
                    if (this$city == null) {
                        if (other$city == null) {
                            break label200;
                        }
                    } else if (this$city.equals(other$city)) {
                        break label200;
                    }

                    return false;
                }

                label193: {
                    Object this$country = this.getCountry();
                    Object other$country = other.getCountry();
                    if (this$country == null) {
                        if (other$country == null) {
                            break label193;
                        }
                    } else if (this$country.equals(other$country)) {
                        break label193;
                    }

                    return false;
                }

                Object this$business_name = this.getBusiness_name();
                Object other$business_name = other.getBusiness_name();
                if (this$business_name == null) {
                    if (other$business_name != null) {
                        return false;
                    }
                } else if (!this$business_name.equals(other$business_name)) {
                    return false;
                }

                Object this$business_type = this.getBusiness_type();
                Object other$business_type = other.getBusiness_type();
                if (this$business_type == null) {
                    if (other$business_type != null) {
                        return false;
                    }
                } else if (!this$business_type.equals(other$business_type)) {
                    return false;
                }

                label172: {
                    Object this$services = this.getServices();
                    Object other$services = other.getServices();
                    if (this$services == null) {
                        if (other$services == null) {
                            break label172;
                        }
                    } else if (this$services.equals(other$services)) {
                        break label172;
                    }

                    return false;
                }

                Object this$property = this.getProperty();
                Object other$property = other.getProperty();
                if (this$property == null) {
                    if (other$property != null) {
                        return false;
                    }
                } else if (!this$property.equals(other$property)) {
                    return false;
                }

                Object this$b_phone = this.getB_phone();
                Object other$b_phone = other.getB_phone();
                if (this$b_phone == null) {
                    if (other$b_phone != null) {
                        return false;
                    }
                } else if (!this$b_phone.equals(other$b_phone)) {
                    return false;
                }

                label151: {
                    Object this$b_email = this.getB_email();
                    Object other$b_email = other.getB_email();
                    if (this$b_email == null) {
                        if (other$b_email == null) {
                            break label151;
                        }
                    } else if (this$b_email.equals(other$b_email)) {
                        break label151;
                    }

                    return false;
                }

                Object this$b_tel = this.getB_tel();
                Object other$b_tel = other.getB_tel();
                if (this$b_tel == null) {
                    if (other$b_tel != null) {
                        return false;
                    }
                } else if (!this$b_tel.equals(other$b_tel)) {
                    return false;
                }

                label137: {
                    Object this$website = this.getWebsite();
                    Object other$website = other.getWebsite();
                    if (this$website == null) {
                        if (other$website == null) {
                            break label137;
                        }
                    } else if (this$website.equals(other$website)) {
                        break label137;
                    }

                    return false;
                }

                Object this$leaseObjectlist = this.getLeaseObjectlist();
                Object other$leaseObjectlist = other.getLeaseObjectlist();
                if (this$leaseObjectlist == null) {
                    if (other$leaseObjectlist != null) {
                        return false;
                    }
                } else if (!this$leaseObjectlist.equals(other$leaseObjectlist)) {
                    return false;
                }

                Object this$compartmentObjectlist = this.getCompartmentObjectlist();
                Object other$compartmentObjectlist = other.getCompartmentObjectlist();
                if (this$compartmentObjectlist == null) {
                    if (other$compartmentObjectlist == null) {
                        return true;
                    }
                } else if (this$compartmentObjectlist.equals(other$compartmentObjectlist)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Lecturer;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $surname = this.getSurname();
        result = result * 59 + ($surname == null ? 43 : $surname.hashCode());
        Object $register_Date = this.getRegister_Date();
        result = result * 59 + ($register_Date == null ? 43 : $register_Date.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $id_passport = this.getId_passport();
        result = result * 59 + ($id_passport == null ? 43 : $id_passport.hashCode());
        Object $rentStatus = this.getRentStatus();
        result = result * 59 + ($rentStatus == null ? 43 : $rentStatus.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $business_name = this.getBusiness_name();
        result = result * 59 + ($business_name == null ? 43 : $business_name.hashCode());
        Object $business_type = this.getBusiness_type();
        result = result * 59 + ($business_type == null ? 43 : $business_type.hashCode());
        Object $services = this.getServices();
        result = result * 59 + ($services == null ? 43 : $services.hashCode());
        Object $property = this.getProperty();
        result = result * 59 + ($property == null ? 43 : $property.hashCode());
        Object $b_phone = this.getB_phone();
        result = result * 59 + ($b_phone == null ? 43 : $b_phone.hashCode());
        Object $b_email = this.getB_email();
        result = result * 59 + ($b_email == null ? 43 : $b_email.hashCode());
        Object $b_tel = this.getB_tel();
        result = result * 59 + ($b_tel == null ? 43 : $b_tel.hashCode());
        Object $website = this.getWebsite();
        result = result * 59 + ($website == null ? 43 : $website.hashCode());
        Object $leaseObjectlist = this.getLeaseObjectlist();
        result = result * 59 + ($leaseObjectlist == null ? 43 : $leaseObjectlist.hashCode());
        Object $compartmentObjectlist = this.getCompartmentObjectlist();
        result = result * 59 + ($compartmentObjectlist == null ? 43 : $compartmentObjectlist.hashCode());
        return result;
    }

    public String toString() {
        return "Tenant(id=" + this.getId() + ", name=" + this.getName() + ", surname=" + this.getSurname() + ", register_Date=" + this.getRegister_Date() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", id_passport=" + this.getId_passport() + ", rentStatus=" + this.getRentStatus() + ", address=" + this.getAddress() + ", city=" + this.getCity() + ", country=" + this.getCountry() + ", business_name=" + this.getBusiness_name() + ", business_type=" + this.getBusiness_type() + ", services=" + this.getServices() + ", property=" + this.getProperty() + ", b_phone=" + this.getB_phone() + ", b_email=" + this.getB_email() + ", b_tel=" + this.getB_tel() + ", website=" + this.getWebsite() + ", leaseObjectlist=" + this.getLeaseObjectlist() + ", compartmentObjectlist=" + this.getCompartmentObjectlist() + ")";
    }

    public Lecturer() {
    }

    public Lecturer(final Long id, final String name, final String surname, final LocalDate register_Date, final String email, final String phone, final String id_passport, final String rentStatus, final String address, final String city, final String country, final String business_name, final String business_type, final String services, final String property, final String b_phone, final String b_email, final String b_tel, final String website, final List<Lease> leaseObjectlist, final List<Ground> groundObjectlist) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.register_Date = register_Date;
        this.email = email;
        this.phone = phone;
        this.id_passport = id_passport;
        this.rentStatus = rentStatus;
        this.address = address;
        this.city = city;
        this.country = country;
        this.business_name = business_name;
        this.business_type = business_type;
        this.services = services;
        this.property = property;
        this.b_phone = b_phone;
        this.b_email = b_email;
        this.b_tel = b_tel;
        this.website = website;
        this.leaseObjectlist = leaseObjectlist;
        this.groundObjectlist = groundObjectlist;
    }
}
