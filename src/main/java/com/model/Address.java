package com.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Address {
    private Long addressId;
    @NotEmpty(message = "Introduceti Tara")
    private String country;
    @NotEmpty(message = "Introduceti Orasul")
    private String city;
    @NotEmpty(message = "Introduceti Adresa")
    private String address;
    private Collection<Person> peopleByAddressId;

    @Id
    @GeneratedValue
    @Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "country", nullable = true, length = -1)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = true, length = -1)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @OneToMany(mappedBy = "address")
    public Collection<Person> getPeopleByAddressId() {
        return peopleByAddressId;
    }

    public void setPeopleByAddressId(Collection<Person> peopleByAddressId) {
        this.peopleByAddressId = peopleByAddressId;
    }
}
