package com.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
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
    private Date startdate;
    private Date enddate;
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
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate", nullable = true)
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
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
