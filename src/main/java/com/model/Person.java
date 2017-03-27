package com.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "Prenumele trebuie sa contina mai mult de 3 litere")
    private String firstname;
    @NotNull
    @Size(min=2, max=30, message = "Numele trebuie sa contina mai mult de 3 litere")
    private String lasttname;
    @NotNull(message = "Alegeti data nasterei studentului")
    @Past(message = "Ziua de nastere poate fi numai din trecut")
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date dob;
    @NotNull(message = "Alegeti genul persoanei")
    private String gender;
    private String picturePath;
    @Valid
    private Address address;
    private LibrarySubscription librarySubscription;
    @Valid
    private Collection<Phone> phones;
//    @NotNull(message = "Alegeti fotografia studentului")
    @Transient
    private MultipartFile imageMultipart;
    @Transient
    public MultipartFile getImageMultipart() {
        return imageMultipart;
    }
    @Transient
    public void setImageMultipart(MultipartFile imageMultipart) {
        this.imageMultipart = imageMultipart;
    }



    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 34)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lasttname", nullable = true, length = 34)
    public String getLasttname() {
        return lasttname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    @Basic
    @Column(name = "dob", nullable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 34)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "picture_path", nullable = true, length = 50)
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "libsubscription_id", referencedColumnName = "libsubscription_id")
    public LibrarySubscription getLibrarySubscription() {
        return librarySubscription;
    }

    public void setLibrarySubscription(LibrarySubscription librarySubscription) {
        this.librarySubscription = librarySubscription;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public Collection<Phone> getPhones() {

        if(phones == null){
            phones = new ArrayList<Phone>();
        }

        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }
}
