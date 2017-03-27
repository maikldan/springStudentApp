package com.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Phone {
    private Long phoneId;
    @NotEmpty(message = "Introduceti telefonul")
    private String number;
    private PhoneType phoneType;
    private Person person;

    @Id
    @GeneratedValue
    @Column(name = "phone_id", nullable = false, insertable = false, updatable = false)
    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "number", nullable = true, length = -1)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @ManyToOne
    @JoinColumn(name = "phonetype_id", referencedColumnName = "phonetype_id", nullable = false)
    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
