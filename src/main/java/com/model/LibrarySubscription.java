package com.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
@Table(name = "library_subscription", schema = "public", catalog = "mariusdb")
public class LibrarySubscription {
    private Long libsubscriptionId;
    private String status;
    private Timestamp startdate;
    private Timestamp enddate;
    private Collection<Person> people;

    @Id
    @GeneratedValue
    @Column(name = "libsubscription_id", nullable = false, insertable = false, updatable = false)
    public Long getLibsubscriptionId() {
        return libsubscriptionId;
    }

    public void setLibsubscriptionId(Long libsubscriptionId) {
        this.libsubscriptionId = libsubscriptionId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 32)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "startdate", nullable = true)
    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate", nullable = true)
    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @OneToMany(mappedBy = "librarySubscription")
    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }
}
