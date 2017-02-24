package com.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Discipline {
    private Long disciplineId;
    private String name;
    private String scholarshipThreshold;
    private Profesor profesor;
    //Trebuie de uitat in proiectul vechi cum eu extrag datele din view
    private Collection<DisciplineAverage> disciplineAverages;
    private Collection<Mark> marks;

    @Id
    @Column(name = "discipline_id", nullable = false, insertable = false, updatable = false)
    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "scholarship_threshold", nullable = true, length = -1)
    public String getScholarshipThreshold() {
        return scholarshipThreshold;
    }

    public void setScholarshipThreshold(String scholarshipThreshold) {
        this.scholarshipThreshold = scholarshipThreshold;
    }


    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id", nullable = false)
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @OneToMany(mappedBy = "discipline")
    public Collection<DisciplineAverage> getDisciplineAverages() {
        return disciplineAverages;
    }

    public void setDisciplineAverages(Collection<DisciplineAverage> disciplineAverages) {
        this.disciplineAverages = disciplineAverages;
    }

    @OneToMany(mappedBy = "discipline")
    public Collection<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Mark> marks) {
        this.marks = marks;
    }
}
