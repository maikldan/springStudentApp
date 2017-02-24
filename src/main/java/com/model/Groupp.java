package com.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Groupp {
    private Long groupId;
    private String name;
    private Collection<Student> students;

    @Id
    @Column(name = "group_id", nullable = false, insertable = false, updatable = false)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "groupp")
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
