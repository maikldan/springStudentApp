package com.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
@Table(name = "phone_type", schema = "public", catalog = "mariusdb")
public class PhoneType {
    private Long phonetypeId;
    private String name;
    private Collection<Phone> phones;

    @Id
    @Column(name = "phonetype_id", nullable = false, insertable = false, updatable = false)
    public Long getPhonetypeId() {
        return phonetypeId;
    }

    public void setPhonetypeId(Long phonetypeId) {
        this.phonetypeId = phonetypeId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "phoneType")
    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }
}
